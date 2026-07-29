package objetos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.HashMap;

public class GerenciamentoArquivos {

    private final Path pastaDados = Paths.get("ControleZoologico/arquivosTexto");
    private final Path caminhoFuncionarios = pastaDados.resolve("funcionarios.txt");
    private final Path caminhoDemandas = pastaDados.resolve("demandas.txt");

    public Path getCaminhoFuncionarios() {
        return caminhoFuncionarios;
    }

    public Path getCaminhoDemandas() {
        return caminhoDemandas;
    }

    public Path getPastaDados() {
        return pastaDados;
    }

    // ---------- CARREGAR ----------

    private void garantirPastaExiste() throws IOException {
        if (!Files.exists(pastaDados)) {
            Files.createDirectories(pastaDados);
        }
    }

    public HashMap<Integer, Funcionario> carregarFuncionarios() throws IOException {
        garantirPastaExiste();
        HashMap<Integer, Funcionario> funcionarios = new HashMap<>();

        if (!Files.exists(caminhoFuncionarios)) {
            Files.createFile(caminhoFuncionarios);
            return funcionarios; // arquivo novo, não há nada pra carregar
        }

        try (BufferedReader br = Files.newBufferedReader(caminhoFuncionarios, StandardCharsets.UTF_8)) {
            String linha;
            while ((linha = br.readLine()) != null) {
                if (linha.isBlank()) continue;

                String[] campos = linha.split(";");

                Integer usuario   = Integer.parseInt(campos[0]);
                String senha      = campos[1];
                String nome       = campos[2];
                int idade         = Integer.parseInt(campos[3]);
                String formacao   = campos[4];
                String telefone   = campos[5];
                double salario    = Double.parseDouble(campos[6]);
                int tipo          = Integer.parseInt(campos[7]);

                Funcionario funcionario = instanciarPorTipo(tipo, nome, idade, formacao, telefone, salario, campos);

                funcionario.setUsuario(usuario);
                funcionario.setSenha(senha);

                funcionarios.put(usuario, funcionario);
            }
        }

        return funcionarios;
    }

    public void carregarDemandas(HashMap<Integer, Funcionario> funcionarios) throws IOException {
        garantirPastaExiste();
        if (!Files.exists(caminhoDemandas)) {
            Files.createFile(caminhoDemandas);
            return;
        }

        try (BufferedReader br = Files.newBufferedReader(caminhoDemandas, StandardCharsets.UTF_8)) {
            String linha;
            while ((linha = br.readLine()) != null) {
                if (linha.isBlank()) continue;

                String[] campos = linha.split(";", 2); // limite 2: demanda pode ter ";" dentro
                Integer usuario = Integer.parseInt(campos[0]);
                String demanda  = campos[1];

                Funcionario funcionario = funcionarios.get(usuario);
                funcionario.receberDemandas(demanda);

            }
        }
    }

    // ---------- SALVAR ----------

    public void salvarFuncionarios(HashMap<Integer, Funcionario> funcionarios) throws IOException {
        garantirPastaExiste();
        try (BufferedWriter bw = Files.newBufferedWriter(
                caminhoFuncionarios,
                StandardCharsets.UTF_8,
                StandardOpenOption.CREATE,
                StandardOpenOption.TRUNCATE_EXISTING)) {

            for (Funcionario f : funcionarios.values()) {
                bw.write(montarLinha(f));
                bw.newLine();
            }
        }
    }

    public void salvarDemandas(HashMap<Integer, Funcionario> funcionarios) throws IOException {
        garantirPastaExiste();
        try (BufferedWriter bw = Files.newBufferedWriter(
                caminhoDemandas,
                StandardCharsets.UTF_8,
                StandardOpenOption.CREATE,
                StandardOpenOption.TRUNCATE_EXISTING)) {

            for (Funcionario f : funcionarios.values()) {
                for (String demanda : f.getListaDemandas()) {
                    bw.write(f.getUsuario() + ";" + demanda);
                    bw.newLine();
                }
            }
        }
    }

    // ---------- AUXILIARES ----------

    private Funcionario instanciarPorTipo(int tipo, String nome, int idade, String formacao, String telefone, double salario, String[] campos) {

        switch (tipo) {
            case 0:
                return new AdmistradorDoSistema(nome, idade, formacao, telefone, salario);
            case 1:
                return new Gerente(nome, idade, formacao, telefone, salario);
            case 2:
                return new TratadorAnimais(nome, idade, formacao, telefone, salario);
            case 3:
                return new Zootecnista(nome, idade, formacao, telefone, salario, campos[8]);
            case 4:
                return new MedicoVeterinario(nome, idade, formacao, telefone, salario, campos[8]);
            case 5:
                return new Biologo(nome, idade, formacao, telefone, salario, campos[8], campos[9]);
            case 6:
                return new Manutecao(nome, idade, formacao, telefone, salario, campos[8]);
            case 7:
                return new AuxiliardeLimpeza(nome, idade, formacao, telefone, salario);
            default:
                throw new IllegalArgumentException("Tipo de funcionário inválido: " + tipo);
        }
    }

    private String montarLinha(Funcionario f) {
        int tipo = descobrirTipo(f);
        String base = f.getUsuario() + ";" + f.getSenha() + ";" + f.getNome() + ";"
                + f.getIdade() + ";" + f.getFormacao() + ";" + f.getTelefone() + ";"
                + f.getSalario() + ";" + tipo;

        if (f instanceof Zootecnista zoo) {
            base += ";" + zoo.getAreaAtuacao();
        } else if (f instanceof MedicoVeterinario mv) {
            base += ";" + mv.getCrmv();
        } else if (f instanceof Biologo bio) {
            base += ";" + bio.getAreaPesquisa() + ";" + bio.getRegistroAmbiental();
        } else if (f instanceof Manutecao manut) {
            base += ";" + manut.getEspecialidade();
        }

        return base;
    }

    private int descobrirTipo(Funcionario f) {
        if (f instanceof AdmistradorDoSistema) return 0;
        if (f instanceof Gerente) return 1;
        if (f instanceof TratadorAnimais) return 2;
        if (f instanceof Zootecnista) return 3;
        if (f instanceof MedicoVeterinario) return 4;
        if (f instanceof Biologo) return 5;
        if (f instanceof Manutecao) return 6;
        if (f instanceof AuxiliardeLimpeza) return 7;
        throw new IllegalStateException("Tipo de funcionário desconhecido.");
    }
}
