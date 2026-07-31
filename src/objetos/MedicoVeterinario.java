package objetos;

import java.util.ArrayList;

// Classe que representa o médico veterinário dentro do sistema.
public class MedicoVeterinario extends Funcionario {

    // Registro profissional específico do médico veterinário.
    private String crmv;

    // Lista utilizada para armazenar as demandas atribuídas ao veterinário.
    private ArrayList<String> demandasVeterinario = new ArrayList<>();

    // Inicializa os atributos herdados de Funcionario e o registro profissional.
    public MedicoVeterinario(String nome, int idade, String formacao,
                             String telefone, double salario, String crmv) {
        super(nome, idade, formacao, telefone, salario);
        this.crmv = crmv;
    }

    public ArrayList<String> getDemandasVeterinario() {
        return demandasVeterinario;
    }

    public String getCrmv() {
        return crmv;
    }

    public void setCrmv(String crmv) {
        this.crmv = crmv;
    }

    // Exibe as informações básicas do funcionário e seu registro profissional.
    @Override
    public void exibirInformacoes() {
        super.exibirInformacoes();
        System.out.println("CRMV: " + crmv);
    }

    // Remove uma demanda utilizando o índice informado pelo usuário.
    @Override
    public void removerDemanda(int indice){
        if (getDemandasVeterinario().isEmpty()) {
            System.out.println("Não há demandas cadastradas.");

            // Verifica se o índice informado corresponde a uma posição válida.
        } else if (indice - 1 < 0 || indice - 1 > getDemandasVeterinario().size()) {
            System.out.println("Indice errado.");

        } else {
            getDemandasVeterinario().remove(indice - 1);
        }
    }

    // Adiciona uma nova demanda à lista do veterinário.
    @Override
    public void receberDemandas(String demanda) {
        getDemandasVeterinario().add(demanda);
    }

    // Exibe todas as demandas atualmente atribuídas ao veterinário.
    @Override
    public void exibirDemandas() {
        if(getDemandasVeterinario().isEmpty()){
            System.out.println("Não há demandas cadastradas.");
        } else {
            System.out.println("Você possui tais demandas: ");

            // Percorre a lista exibindo cada demanda e seu respectivo índice.
            for(int i = 0; i < getDemandasVeterinario().size(); i++){
                System.out.println(
                        "Indice: " + (i + 1) +
                                " Demanda: " + getDemandasVeterinario().get(i)
                );
            }
        }
    }

    // Retorna a lista de demandas no formato definido pela classe Funcionario.
    @Override
    public java.util.List<String> getListaDemandas() {
        return getDemandasVeterinario();
    }
}
