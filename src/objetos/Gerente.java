package objetos;

import java.util.ArrayList;

public class Gerente extends Funcionario{
    private ArrayList<String> demandasGerente = new ArrayList<>(); //demandas exclusivas dos adims

    public Gerente(String nome, int idade, String formacao, String telefone, double salario) {
        super(nome, idade, formacao,telefone,salario);
    }

    public ArrayList<String> getDemandasGerente() {
        return demandasGerente;
    }


    public void exibirInformacoes(){
        super.exibirInformacoes();
    }

    @Override
    public void removerDemanda(int indice) {
        if(getDemandasGerente().isEmpty()){ // Tratamento de Exceção para poder remover.
            System.out.println("Não há demandas cadrastadas");
        } else if (indice-1 < 0 || indice-1 > getDemandasGerente().size()){
            System.out.println("indice errado.");
        }else {
            getDemandasGerente().remove(indice-1); // removendo demanda exclusiva dos adimns
        }
    }

    @Override
    public void receberDemandas(String demanda){
        getDemandasGerente().add(demanda);
    }

    @Override
    public void exibirDemandas(){
        if(getDemandasGerente().isEmpty()){ // Tratamento de Exceção para poder remover.
            System.out.println("Não há demandas cadrastadas.");
        } else {
            System.out.println("Você possui tais demandas: ");
            for(int i = 0; i < getDemandasGerente().size(); i++){
                System.out.println("Indice: " + (i+1) + "Demanda: " + getDemandasGerente().get(i));
            }
        }
    }

    @Override
    public java.util.List<String> getListaDemandas() {
        return getDemandasGerente();
    }
}
