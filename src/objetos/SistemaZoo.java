package objetos;

import java.io.IOException;
import java.util.*;
import java.util.UUID;

public class SistemaZoo {
    Random random = new Random();
    Scanner SC = new Scanner(System.in);

    protected HashMap<Integer, Funcionario> funcionarios = new HashMap<>();
    private GerenciamentoArquivos gerenciadorArquivo = new GerenciamentoArquivos();

    public HashMap<Integer, Funcionario>  getFuncionarios(){
        return funcionarios;  // retorna o hast map de funcrionario
    }

    public void iniciarSistema(){
        try {
            funcionarios = gerenciadorArquivo.carregarFuncionarios();
            gerenciadorArquivo.carregarDemandas(funcionarios);
        } catch (IOException e) {
            System.out.println("Erro ao carregar dados: " + e.getMessage());
        }

        System.out.println("-- Bem Vindo(a) ao Sistema de Gerenciamento de Demandas Zoológico Parahyba -- ");

        if(funcionarios.isEmpty()){
            crieUser();
            login();
        }else{
            login();
        }
    }

    public void criarUsuario(Funcionario funcionario){
        Integer usuario = random.nextInt(90000) + 10000;  // Criando User Aleatorio com 5 numeros entre 10000 - 99999
        // verifica se ja existi, so sai do while, quando for exclusivo
        while (funcionarios.containsKey(usuario)){
            usuario = random.nextInt(90000) + 10000;
        }
        funcionario.setUsuario(usuario);
    }

    public void criarSenha(Funcionario funcionario){
        String primeiraSenha = UUID.randomUUID().toString().substring(0,8); // cria senha aleatoria, o plano é que depois do primeiro acesso, o user a troque
        funcionario.setSenha(primeiraSenha);
    }

    public void crieUser(){
        int escolha;
        if(funcionarios.isEmpty()){
            System.out.println("Crie o Admistrador do Sistema!");
            escolha = 0;
        } else{
            System.out.print(" Escolha o Cargo: ");
            System.out.println(" Indice | Cargo | Função Relacionada. ");
            System.out.println(" 0 | Admistrador do Sistema | Gerenciamento Sistema. ");
            System.out.println(" 1 | Gerente | Gerenciamento Finaceiro. ");
            System.out.println(" 2 | Tratador de Animais | Cuidados Basicos aos Animais.");
            System.out.println(" 3 | Zootecnista | Cuidados Tecnicos aos Animais.");
            System.out.println(" 4 | Medico Veterinario | Cuidados Clinicos aos Animais.");
            System.out.println(" 5 | Biologo | Cuidados relacionados ao Ecossistema. ");
            System.out.println(" 6 | Auxiliar de Manutenção | Manuntenção do Zoologico. ");
            System.out.println(" 7 | Profissionais de Limpeza | Limpeza do Zoologico");
            System.out.println();

            System.out.println("Selecione qual o indice: ");
            escolha = SC.nextInt();
        }

        System.out.print("Nome: ");
        String nome = SC.nextLine();
        System.out.print("Idade: ");
        int idade = SC.nextInt();
        SC.nextLine();
        System.out.print("Formação: ");
        String formacao = SC.nextLine();
        System.out.print("Telefone: ");
        String telefone = SC.next();
        System.out.print("Salario: ");
        double salario = SC.nextDouble();

        instaciarFuncionario(nome, idade, formacao, telefone, salario, escolha);

    }

    public void instaciarFuncionario(String nome, int idade, String formacao, String telefone, double salario, int escolha){
        if(salario > 0 && idade >= 18) {
             if (escolha == 0) {
                Funcionario Adm0 = new AdmistradorDoSistema(nome, idade, formacao, telefone, salario);
                criarUsuario(Adm0);
                criarSenha(Adm0);
                funcionarios.put(Adm0.getUsuario(), Adm0);
                System.out.println("Administrador do Sistema criado com sucesso!");
                System.out.println("Usuario: " + Adm0.getUsuario());
                System.out.println("Senha: " + Adm0.getSenha());

             } else if (escolha == 1) {
                 Gerente Gerente = new Gerente(nome, idade, formacao, telefone, salario);
                 criarUsuario(Gerente);
                 criarSenha(Gerente);
                 funcionarios.put(Gerente.getUsuario(), Gerente);
                 System.out.println("Gerente Criado!");
                 System.out.println("Usuario: " + Gerente.getUsuario());
                 System.out.println("Senha: " + Gerente.getSenha());
             } else if (escolha == 2){
                 TratadorAnimais TA = new TratadorAnimais(nome, idade, formacao, telefone, salario);
                 criarUsuario(TA);
                 criarSenha(TA);
                 funcionarios.put(TA.getUsuario(), TA);
                 System.out.println("Gerente Criado!");
                 System.out.println("Usuario: " + TA.getUsuario());
                 System.out.println("Senha: " + TA.getSenha());
             } else if(escolha == 3){
                 System.out.print("Área de Atuação: ");
                 String areaAtuacao = SC.nextLine();
                 Zootecnista Zoot = new Zootecnista(nome, idade, formacao, telefone, salario,areaAtuacao);
                 criarUsuario(Zoot);
                 criarSenha(Zoot);
                 funcionarios.put(Zoot.getUsuario(), Zoot);
                 System.out.println("Medico Veterinario Criado!");
                 System.out.println("Usuario: " + Zoot.getUsuario());
                 System.out.println("Senha: " + Zoot.getSenha());
             } else if(escolha == 4){
                 System.out.print("CRVM: ");
                 String crvm = SC.nextLine();
                 MedicoVeterinario MV = new MedicoVeterinario(nome, idade, formacao, telefone, salario,crvm);
                 criarUsuario(MV);
                 criarSenha(MV);
                 funcionarios.put(MV.getUsuario(), MV);
                 System.out.println("Medico Veterinario Criado!");
                 System.out.println("Usuario: " + MV.getUsuario());
                 System.out.println("Senha: " + MV.getSenha());
             } else if(escolha == 5){
                 System.out.print("Especialidade: ");
                 String areaDpesquisa = SC.nextLine();
                 System.out.print("Registro Ambiental: ");
                 String registroAmbiental = SC.nextLine();
                 Biologo Bio = new Biologo(nome, idade, formacao, telefone, salario, areaDpesquisa, registroAmbiental);
                 criarUsuario(Bio);
                 criarSenha(Bio);
                 funcionarios.put(Bio.getUsuario(), Bio);
                 System.out.println("Biologo Criado!");
                 System.out.println("Usuario: " + Bio.getUsuario());
                 System.out.println("Senha: " + Bio.getSenha());

             } else if(escolha == 6 ){
                 System.out.print("Especialidade: ");
                 String especialidade = SC.nextLine();
                 Manutecao Manut = new Manutecao(nome, idade, formacao, telefone, salario, especialidade);
                 criarUsuario(Manut);
                 criarSenha(Manut);
                 funcionarios.put(Manut.getUsuario(), Manut);
                 System.out.println("Auxiliar de Manunteção Criado!");
                 System.out.println("Usuario: " + Manut.getUsuario());
                 System.out.println("Senha: " + Manut.getSenha());
             } else if(escolha == 7){
                 AuxiliardeLimpeza AxL = new AuxiliardeLimpeza(nome, idade, formacao, telefone, salario);
                 criarUsuario(AxL);
                 criarSenha(AxL);
                 funcionarios.put(AxL.getUsuario(), AxL);
                 System.out.println("Auxiliar de Limpeza Criado!");
                 System.out.println("Usuario: " + AxL.getUsuario());
                 System.out.println("Senha: " + AxL.getSenha());

             } else{
                 System.out.println("Escolha fora do limite!");
             }
        }  else {
            System.out.println("Volte ao Menu!");
        }

        try {
            gerenciadorArquivo.salvarFuncionarios(funcionarios);
        } catch (IOException e) {
            System.out.println("Erro ao salvar dados: " + e.getMessage());
        }
    }

    public void informarDemanda(){
        System.out.println();
        System.out.print("Demanda: ");
        String demanda = SC.nextLine();
        SC.nextLine();

        System.out.print("\nCargo responsavel: ");
        System.out.println(" Indice | Cargo | Função Relacionada. ");
        System.out.println(" 1 | Gerente | Gerenciamento Finaceiro. ");
        System.out.println(" 2 | Tratador de Animais | Cuidados Basicos aos Animais.");
        System.out.println(" 3 | Zootecnista | Cuidados Tecnicos aos Animais.");
        System.out.println(" 4 | Medico Veterinario | Cuidados Clinicos aos Animais.");
        System.out.println(" 5 | Biologo | Cuidados relacionados ao Ecossistema. ");
        System.out.println(" 6 | Auxiliar de Manutenção | Manuntenção do Zoologico. ");
        System.out.println(" 7 | Profissionais de Limpeza | Limpeza do Zoologico");
        System.out.println();

        System.out.print("Opção: ");
        int tipoFuncionario = SC.nextInt();
        Demanda demandaInformada = new Demanda(demanda, tipoFuncionario);
        enviarDemanda(demandaInformada);

        try {
            gerenciadorArquivo.salvarFuncionarios(funcionarios);
            gerenciadorArquivo.salvarDemandas(funcionarios);
        } catch (IOException e) {
            System.out.println("Erro ao salvar dados: " + e.getMessage());
        }
    }

    public ArrayList<Funcionario> buscarFuncionariosPorCargo(int tipoFuncionario){
        ArrayList<Funcionario> lista = new ArrayList<>();

        for(Funcionario funcionario : funcionarios.values()){
            if(tipoFuncionario == 0 && funcionario instanceof AdmistradorDoSistema){
                lista.add(funcionario);
            } else if (tipoFuncionario == 1 && funcionario instanceof Gerente) {
                lista.add(funcionario);
            }
        }
        return lista;
    }

    public void enviarDemanda(Demanda demanda) {
        ArrayList<Funcionario> lista = buscarFuncionariosPorCargo(demanda.getTipoFuncionario());

        if(lista.isEmpty()){
            System.out.println("Não existe funcionário desse cargo.");
        }

        int escolha = random.nextInt(lista.size());
        Funcionario escolhido = lista.get(escolha);
        escolhido.receberDemandas(demanda.getProblema());

        try {
            gerenciadorArquivo.salvarDemandas(funcionarios);
        } catch (IOException e) {
            System.out.println("Erro ao salvar dados: " + e.getMessage());
        }
    }

    public void login(){

        System.out.println("------ Faça Login ------");

        System.out.println("Usuario: ");
        Integer user = SC.nextInt();
        SC.nextLine();

        Funcionario acesso = funcionarios.get(user);

        if(acesso == null){
            System.out.println("Usuário Inexistente!");
            return;
        }

        int tentativas = 0;
        String senha;

        while (tentativas < 5) {
            System.out.print("Senha: ");
            senha = SC.nextLine();

            if (Objects.equals(acesso.getSenha(), senha)) {
                System.out.println("Login realizado");
                menu(acesso.getUsuario());

                return;
            }
            tentativas++;
            System.out.println("Senha Incorreta, tente novamente: ");

        }
        System.out.println("Você atingiu o limite de tentaivas. ");
    }

    public void redefinirSenha(int user){
        Funcionario funcionario = funcionarios.get(user);

        System.out.print("Informe sua senha atual: ");
        SC.nextLine();
        String senhaAtual = SC.nextLine();

        if (!funcionario.getSenha().equals(senhaAtual)) {
            System.out.println("Senha atual incorreta.");
            return;
        }

        while (true) {

            System.out.print("Informe a nova senha: ");
            String novaSenha = SC.nextLine();

            if (novaSenha.length() < 8) {
                System.out.println("A senha deve possuir no mínimo 8 caracteres.");
                continue;
            }

            System.out.print("Confirme a nova senha: ");
            String confirmacao = SC.nextLine();

            if (!novaSenha.equals(confirmacao)) {
                System.out.println("As senhas não coincidem.");
                continue;
            }

            funcionario.setSenha(novaSenha);

            System.out.println("Senha alterada com sucesso!");
            break;
        }

        try {
            gerenciadorArquivo.salvarFuncionarios(funcionarios);
        } catch (IOException e) {
            System.out.println("Erro ao salvar dados: " + e.getMessage());
        }
    }

    public void editarFuncionario(int user){
        System.out.println("Para Editar digite o indice do que deseja: ");
        System.out.println(" 1 - Nome      ");
        System.out.println(" 2 - Idade     ");
        System.out.println(" 3 - Formação  ");
        System.out.println(" 4 - Telefone  ");
        System.out.println(" 5 - Salario   ");

        Funcionario funcionario = funcionarios.get(user);

        if(funcionario instanceof Zootecnista){
            System.out.println(" 6 - Área Atuacão:    ");
        } else if (funcionario instanceof MedicoVeterinario) {
            System.out.println(" 6 - CRVM   ");
        } else if (funcionario instanceof Biologo) {
            System.out.println(" 6 - Área de Pesquisa  ");
            System.out.println(" 7 - Registro Ambiental   ");
        } else if (funcionario instanceof Manutecao) {
            System.out.println(" 6 - Especialidade   ");
        }

        System.out.print("Opção: ");
        int opcao = SC.nextInt();
        SC.nextLine();

        switch (opcao){
            case 1:
                System.out.print("Modifição: ");
                String nome = SC.nextLine();
                funcionarios.get(user).setNome(nome);
                break;
            case 2:
                System.out.print("Nova idade: ");
                int idade = SC.nextInt();
                funcionarios.get(user).setIdade(idade);
                break;

            case 3:
                SC.nextLine();
                System.out.print("Nova formação: ");
                String formacao = SC.nextLine();
                funcionarios.get(user).setFormacao(formacao);
                break;

            case 4:
                System.out.print("Novo telefone: ");
                String telefone = SC.nextLine();
                funcionarios.get(user).setTelefone(telefone);
                break;

            case 5:
                System.out.print("Novo salário: ");
                double salario = SC.nextDouble();
                funcionarios.get(user).setSalario(salario);
                break;

            case 6:
                if(funcionario instanceof Zootecnista){
                    System.out.print("Nova Área de atuação: ");
                    String AreaAtuacao = SC.nextLine();
                    ((Zootecnista) funcionario).setAreaAtuacao(AreaAtuacao);
                    break;
                } else if (funcionario instanceof MedicoVeterinario) {
                    System.out.print("Novo CRVM: ");
                    String CRVM = SC.nextLine();
                    ((MedicoVeterinario) funcionario).setCrmv(CRVM);
                    break;
                } else if (funcionario instanceof Manutecao) {
                    System.out.print("Nova Especialidade: ");
                    String especialidade = SC.nextLine();
                    ((Manutecao) funcionario).setEspecialidade(especialidade);
                    break;

                } else if (funcionario instanceof Biologo) {
                    System.out.print("Nova Área de Pesquisa: ");
                    String areaDpesquisa = SC.nextLine();
                    ((Biologo) funcionario).setAreaPesquisa(areaDpesquisa);
                    break;
                } else{
                    System.out.println("Opção inválida.");
                }
            case 7:
                if (funcionario instanceof Biologo) {
                    System.out.print("Novo Registro Ambiental: ");
                    String RGA = SC.nextLine();
                    ((Biologo) funcionario).setAreaPesquisa(RGA);
                    break;
                } else{
                    System.out.println("Opção inválida.");
                }
            default:
                System.out.println("Opção inválida.");
        }

        try {
            gerenciadorArquivo.salvarFuncionarios(funcionarios);
        } catch (IOException e) {
            System.out.println("Erro ao salvar dados: " + e.getMessage());
        }

        System.out.println("Funcionário atualizado com sucesso!");
    }

    public void removerFuncionario(int user){
        funcionarios.remove(user);
        try {
            gerenciadorArquivo.salvarFuncionarios(funcionarios);
        } catch (IOException e) {
            System.out.println("Erro ao salvar dados: " + e.getMessage());
        }
    }

    public void verFuncionarios(int user){
        if(funcionarios.containsKey(user)) {
            System.out.println(" ------ Informações do usuario: " + user + " ------");
            funcionarios.get(user).exibirInformacoes();
        } else{
            System.out.println("Usuario Inexistente!");
        }

    }

    public void pausar(){
        System.out.println("\nPressione ENTER para contininuar...");
        SC.nextLine();
    }

    public void menu(int user){
        boolean executando = true;
        int indice;

        Funcionario funcionario = funcionarios.get(user);

        while (executando){
            SC.nextLine();
            System.out.println("Bem vindo de volta " + funcionarios.get(user).getNome());
            System.out.println();

            System.out.println("---------  Menu Principal ---------");
            System.out.println(" 0 - Sair do Menu.                 ");
            System.out.println(" 1 - Exebir Minhas Informações.    ");
            System.out.println(" 2 - Ver Minhas Demandas.          ");
            System.out.println(" 3 - Informar Demanda.             ");
            System.out.println(" 4 - Informar Conclusão da Demanda.");
            System.out.println(" 5 - Alterar Senha.                ");

            if(funcionario instanceof AdmistradorDoSistema){
                System.out.println(" 6 - Cadastrar Funcionario.     ");
                System.out.println(" 7 - Editar Funcionario.        ");
                System.out.println(" 8 - Remover Funcionario        ");
                System.out.println(" 9 - Ver Informações do Funcionario   ");
            }

            System.out.println();

            System.out.print("Opção: ");
            int opcao = SC.nextInt();

            switch (opcao) {
                case 1:
                    System.out.println();
                    funcionario.exibirInformacoes();
                    pausar();
                    break;

                case 2:
                    System.out.println();
                    funcionario.exibirDemandas();
                    pausar();
                    break;

                case 3:
                    informarDemanda();
                    pausar();
                    break;

                case 4:
                    System.out.print("\nInforme o indice da demanda que deseja apagar: ");
                    indice = SC.nextInt();
                    funcionarios.get(user).removerDemanda(indice);
                    pausar();
                    break;

                case 5:
                    System.out.println("Defina sua nova senha");
                    redefinirSenha(user);
                    pausar();
                    break;

                case 6:
                    if(funcionario instanceof AdmistradorDoSistema) {
                        crieUser();
                    } else{
                        System.out.println("Opção Invalida");
                    }
                    pausar();
                    break;

                case 7:
                    if(funcionario instanceof AdmistradorDoSistema) {
                        System.out.println("Faça as modificações: ");
                        editarFuncionario(user);
                    }else{
                        System.out.println("Opção Invalida");
                    }
                    pausar();
                    break;

                case 8:
                    if(funcionario instanceof AdmistradorDoSistema) {
                        System.out.print("Informe o usuario do funcionario a removido: ");
                        Integer usuario = SC.nextInt();
                        removerFuncionario(usuario);
                        System.out.println("Usuario foi apagado!");
                    } else{
                        System.out.println("Opção Invalida");
                    }
                    pausar();
                    break;
                case 9:
                    System.out.println("Digite o usuario que deseja ver as informações: ");
                    Integer usuario = SC.nextInt();
                    verFuncionarios(usuario);
                    pausar();
                    break;
                case 0:
                    executando = false;
                    break;
                default:
                    System.out.println("Valor fora dos limites!");
            }
        }
    }
}
