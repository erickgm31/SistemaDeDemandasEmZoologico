package objetos;

import java.util.ArrayList;

// Classe que representa o zootecnista dentro do sistema.
public class Zootecnista extends Funcionario {

    // Área específica de atuação do zootecnista.
    private String areaAtuacao;

    // Lista utilizada para armazenar as demandas atribuídas ao zootecnista.
    private ArrayList<String> demandasZootecnista = new ArrayList<>();

    // Inicializa os atributos herdados de Funcionario e a área de atuação.
    public Zootecnista(String nome, int idade, String formacao,
                       String telefone, double salario, String areaAtuacao) {
        super(nome, idade, formacao, telefone, salario);
        this.areaAtuacao = areaAtuacao;
    }

    public ArrayList<String> getDemandasZootecnista() {
        return demandasZootecnista;
    }

    public String getAreaAtuacao() {
        return areaAtuacao;
    }

    public void setAreaAtuacao(String areaAtuacao) {
        this.areaAtuacao = areaAtuacao;
    }

    // Exibe as informações básicas do funcionário e sua área de atuação.
    @Override
    public void exibirInformacoes() {
        System.out.println("Nome: " + getNome());
        System.out.println("Idade: " + getIdade());
        System.out.println("Formação: " + getFormacao());
        System.out.println("Salário: " + getSalario());
        System.out.println("Área de Atuação: " + areaAtuacao);
    }

    // Remove uma demanda utilizando o índice informado pelo usuário.
    @Override
    public void removerDemanda(int indice) {
        if (getDemandasZootecnista().isEmpty()) {
            System.out.println("Não há demandas cadastradas.");

            // Verifica se o índice informado corresponde a uma posição válida.
        } else if (indice - 1 < 0 || indice - 1 > getDemandasZootecnista().size()) {
            System.out.println("Índice errado.");

        } else {
            getDemandasZootecnista().remove(indice - 1);
        }
    }

    // Adiciona uma nova demanda à lista do zootecnista.
    @Override
    public void receberDemandas(String demanda){
        getDemandasZootecnista().add(demanda);
    }

    // Exibe todas as demandas atualmente atribuídas ao zootecnista.
    @Override
    public void exibirDemandas(){
        if(getDemandasZootecnista().isEmpty()){
            System.out.println("Não há demandas cadastradas.");
        } else {
            System.out.println("Você possui tais demandas: ");

            // Percorre a lista exibindo cada demanda e seu respectivo índice.
            for(int i = 0; i < getDemandasZootecnista().size(); i++){
                System.out.println(
                        "Indice: " + (i + 1) +
                                " Demanda: " + getDemandasZootecnista().get(i)
                );
            }
        }
    }

    // Retorna a lista de demandas no formato definido pela classe Funcionario.
    @Override
    public java.util.List<String> getListaDemandas() {
        return getDemandasZootecnista();
    }
}
