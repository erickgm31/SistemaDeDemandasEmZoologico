package objetos;

import java.util.ArrayList;

public class AuxiliardeLimpeza extends Funcionario {

    // Lista utilizada para armazenar as demandas atribuídas ao auxiliar de limpeza.
    public ArrayList<String> demandasAuxiliar = new ArrayList<>();

    // Inicializa os atributos herdados da classe Funcionario.
    public AuxiliardeLimpeza(String nome, int idade, String formacao,
                             String telefone, double salario) {
        super(nome, idade, formacao, telefone, salario);
    }

    public ArrayList<String> getDemandasAuxiliar() {
        return demandasAuxiliar;
    }

    // Exibe as informações básicas herdadas da classe Funcionario.
    @Override
    public void exibirInformacoes(){
        super.exibirInformacoes();
    }

    // Adiciona uma nova demanda à lista do auxiliar.
    @Override
    public void receberDemandas(String demanda){
        getDemandasAuxiliar().add(demanda);
    }

    // Remove uma demanda utilizando o índice informado pelo usuário.
    @Override
    public void removerDemanda(int indice) {
        if(getDemandasAuxiliar().isEmpty()){
            System.out.println("Não há demandas cadrastadas.");

            // Verifica se o índice informado corresponde a uma posição válida.
        } else if (indice-1 < 0 || indice-1 > getDemandasAuxiliar().size()){
            System.out.println("Indice errado.");

        } else {
            getDemandasAuxiliar().remove(indice-1);
        }
    }

    // Exibe todas as demandas atualmente atribuídas ao auxiliar.
    @Override
    public void exibirDemandas() {
        if(getDemandasAuxiliar().isEmpty()){
            System.out.println("Não há demandas cadrastadas.");
        } else {
            System.out.println("Você possui tais demandas: ");

            // Percorre a lista exibindo cada demanda e seu respectivo índice.
            for(int i = 0; i < getDemandasAuxiliar().size(); i++){
                System.out.println(
                        "Indice: " + (i+1) +
                                " Demanda: " + getDemandasAuxiliar().get(i)
                );
            }
        }
    }

    // Retorna a lista de demandas no formato definido pela classe Funcionario.
    @Override
    public java.util.List<String> getListaDemandas() {
        return getDemandasAuxiliar();
    }
}
