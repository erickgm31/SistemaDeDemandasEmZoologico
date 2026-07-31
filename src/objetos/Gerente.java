package objetos;

import java.util.ArrayList;

public class Gerente extends Funcionario {

    // Lista responsável por armazenar as demandas atribuídas ao gerente.
    private ArrayList<String> demandasGerente = new ArrayList<>();

    public Gerente(String nome, int idade, String formacao,
                   String telefone, double salario) {
        super(nome, idade, formacao, telefone, salario);
    }

    public ArrayList<String> getDemandasGerente() {
        return demandasGerente;
    }

    // Utiliza as informações básicas definidas na classe Funcionario.
    public void exibirInformacoes(){
        super.exibirInformacoes();
    }

    // Remove uma demanda utilizando o índice informado pelo usuário.
    @Override
    public void removerDemanda(int indice) {
        if(getDemandasGerente().isEmpty()){
            System.out.println("Não há demandas cadrastadas");

            // Verifica se o índice informado corresponde a uma posição válida.
        } else if (indice-1 < 0 || indice-1 > getDemandasGerente().size()){
            System.out.println("indice errado.");

        } else {
            getDemandasGerente().remove(indice-1);
        }
    }

    // Adiciona uma nova demanda à lista do gerente.
    @Override
    public void receberDemandas(String demanda){
        getDemandasGerente().add(demanda);
    }

    // Exibe todas as demandas atualmente atribuídas ao gerente.
    @Override
    public void exibirDemandas(){
        if(getDemandasGerente().isEmpty()){
            System.out.println("Não há demandas cadrastadas.");
        } else {
            System.out.println("Você possui tais demandas: ");

            // Percorre a lista exibindo cada demanda e seu respectivo índice.
            for(int i = 0; i < getDemandasGerente().size(); i++){
                System.out.println(
                        "Indice: " + (i+1) +
                                " Demanda: " + getDemandasGerente().get(i)
                );
            }
        }
    }

    // Retorna a lista de demandas de forma padronizada para o sistema.
    @Override
    public java.util.List<String> getListaDemandas() {
        return getDemandasGerente();
    }
}
