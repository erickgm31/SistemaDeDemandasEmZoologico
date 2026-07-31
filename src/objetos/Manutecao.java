package objetos;

import java.util.ArrayList;

public class Manutecao extends Funcionario {

    // Lista utilizada para armazenar as demandas atribuídas ao profissional de manutenção.
    public ArrayList<String> demandasManutencao = new ArrayList<>();

    // Define a área de especialidade do profissional de manutenção.
    private String especialidade;

    // Inicializa os atributos herdados de Funcionario e a especialidade do profissional.
    public Manutecao(String nome, int idade, String formacao,
                     String telefone, double salario, String especialidade) {
        super(nome, idade, formacao, telefone, salario);
        this.especialidade = especialidade;
    }

    public ArrayList<String> getDemandasManutencao() {
        return demandasManutencao;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    // Exibe as informações básicas do funcionário e sua especialidade.
    public void exibirInformacoes() {
        super.exibirInformacoes();
        System.out.println("Especialidade: " + getEspecialidade());
    }

    // Adiciona uma nova demanda à lista do profissional de manutenção.
    @Override
    public void receberDemandas(String demanda){
        getDemandasManutencao().add(demanda);
    }

    // Remove uma demanda utilizando o índice informado pelo usuário.
    @Override
    public void removerDemanda(int indice) {
        if(getDemandasManutencao().isEmpty()){
            System.out.println("Não há demandas cadrastadas.");

            // Verifica se o índice informado corresponde a uma posição válida.
        } else if (indice-1 < 0 || indice-1 > getDemandasManutencao().size()){
            System.out.println("Indice errado.");

        } else {
            getDemandasManutencao().remove(indice-1);
        }
    }

    // Exibe todas as demandas atualmente atribuídas ao profissional.
    @Override
    public void exibirDemandas(){
        if(getDemandasManutencao().isEmpty()){
            System.out.println("Não há demandas cadrastadas.");
        } else {
            System.out.println("Você possui tais demandas: ");

            // Percorre a lista para exibir cada demanda com seu índice.
            for(int i = 0; i < getDemandasManutencao().size(); i++){
                System.out.println(
                        "Indice: " + (i+1) +
                                " Demanda: " + getDemandasManutencao().get(i)
                );
            }
        }
    }

    // Retorna a lista de demandas seguindo o padrão definido em Funcionario.
    @Override
    public java.util.List<String> getListaDemandas() {
        return getDemandasManutencao();
    }
}
