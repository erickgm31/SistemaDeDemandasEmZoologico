package objetos;

import java.util.ArrayList;

public class AdmistradorDoSistema extends Funcionario {

    // Lista responsável por armazenar as demandas atribuídas ao administrador.
    private ArrayList<String> demandasAdm = new ArrayList<>();

    public AdmistradorDoSistema(String nome, int idade, String formacao,
                                String telefone, double salario) {
        super(nome, idade, formacao, telefone, salario);
    }

    public ArrayList<String> getDemadasAdm(){
        return demandasAdm;
    }

    // Adiciona uma nova demanda à lista do administrador.
    @Override
    public void receberDemandas(String demanda){
        getDemadasAdm().add(demanda);
    }

    // Utiliza as informações básicas definidas na classe Funcionario.
    public void exibirInformacoes(){
        super.exibirInformacoes();
    }

    // Exibe todas as demandas atribuídas ao administrador.
    @Override
    public void exibirDemandas() {
        if(getDemadasAdm().isEmpty()){
            System.out.println("Não há demandas cadrastadas.");
        } else {
            System.out.println("Você possui tais demandas: ");

            // Exibe um índice para facilitar a identificação da demanda.
            for(int i = 0; i < getDemadasAdm().size(); i++){
                System.out.println(
                        "Indice: " + (i+1) +
                                " Demanda: " + getDemadasAdm().get(i)
                );
            }
        }
    }

    // Remove uma demanda utilizando o índice informado pelo usuário.
    @Override
    public void removerDemanda(int indice){
        if(getDemadasAdm().isEmpty()){
            System.out.println("Não há demandas cadrastadas.");

            // Verifica se o índice informado corresponde a uma posição válida.
        } else if (indice-1 < 0 || indice-1 > getDemadasAdm().size()){
            System.out.println("Indice errado.");

        } else {
            getDemadasAdm().remove(indice-1);
        }
    }

    // Retorna a lista de demandas para que outras partes do sistema
    // possam acessar as demandas de forma padronizada.
    @Override
    public java.util.List<String> getListaDemandas() {
        return getDemadasAdm();
    }
}

