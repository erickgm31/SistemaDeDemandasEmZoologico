package objetos;

import java.util.ArrayList;

// Classe que representa o tratador de animais dentro do sistema.
public class TratadorAnimais extends Funcionario {

    // Lista utilizada para armazenar as demandas atribuídas ao tratador.
    private ArrayList<String> demandasTratador = new ArrayList<>();

    // Inicializa os atributos herdados da classe Funcionario.
    public TratadorAnimais(String nome, int idade, String formacao,
                           String telefone, double salario) {
        super(nome, idade, formacao, telefone, salario);
    }

    public ArrayList<String> getDemandasTratador() {
        return demandasTratador;
    }

    // Exibe as informações básicas do funcionário.
    @Override
    public void exibirInformacoes() {
        super.exibirInformacoes();
    }

    // Remove uma demanda utilizando o índice informado pelo usuário.
    @Override
    public void removerDemanda(int indice){
        if (getDemandasTratador().isEmpty()) {
            System.out.println("Não há demandas cadastradas.");

            // Verifica se o índice informado corresponde a uma posição válida.
        } else if (indice - 1 < 0 || indice - 1 > getDemandasTratador().size()) {
            System.out.println("Indice errado.");

        } else {
            getDemandasTratador().remove(indice - 1);
        }
    }

    // Adiciona uma nova demanda à lista do tratador.
    @Override
    public void receberDemandas(String demanda) {
        getDemandasTratador().add(demanda);
    }

    // Exibe todas as demandas atualmente atribuídas ao tratador.
    @Override
    public void exibirDemandas() {
        if(getDemandasTratador().isEmpty()){
            System.out.println("Não há demandas cadastradas.");
        } else {
            System.out.println("Você possui tais demandas: ");

            // Percorre a lista exibindo cada demanda e seu respectivo índice.
            for(int i = 0; i < getDemandasTratador().size(); i++){
                System.out.println(
                        "Indice: " + (i + 1) +
                                " Demanda: " + getDemandasTratador().get(i)
                );
            }
        }
    }

    // Retorna a lista de demandas no formato definido pela classe Funcionario.
    @Override
    public java.util.List<String> getListaDemandas() {
        return getDemandasTratador();
    }
}
