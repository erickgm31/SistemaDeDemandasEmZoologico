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
    public void removerDemanda(int indice) throws Vazio{
        if(getDemandasGerente().isEmpty()){ // Tratamento de Exceção para poder remover.
            throw new Vazio("Não há demandas cadrastadas ou indice errado.");
        } else if (indice-1 < 0 || indice-1 > getDemandasGerente().size()){
            throw new Vazio("Não há demandas cadrastadas ou indice errado.");
        }else {
            getDemandasGerente().remove(indice-1); // removendo demanda exclusiva dos adimns
        }
    }

    @Override
    public void receberDemandas(String demanda)throws Vazio{
        getDemandasGerente().add(demanda);
    }

    @Override
    public void exibirDemandas() throws Vazio {
        if(getDemandasGerente().isEmpty()){ // Tratamento de Exceção para poder remover.
            throw new Vazio("Não há demandas cadrastadas.");
        } else {
            System.out.println("Você possui tais demandas: ");
            for(int i = 0; i < getDemandasGerente().size(); i++){
                System.out.println("Indice: " + (i+1) + "Demanda: " + getDemandasGerente().get(i));
            }
        }
    }
}
