package objetos;

import java.util.ArrayList;

public class AdmistradorDoSistema extends Funcionario {
    private ArrayList<String> demandasAdm = new ArrayList<>();

    public AdmistradorDoSistema(String nome, int idade, String formacao, String telefone, double salario) {
        super(nome, idade, formacao, telefone, salario);
    }

    public ArrayList<String> getDemadasAdm(){
        return demandasAdm;
    }


    @Override
    public void receberDemandas(String demanda)throws Vazio{
        getDemadasAdm().add(demanda);
    }

    public void exibirInformacoes(){
        super.exibirInformacoes();
    }

    @Override
    public void exibirDemandas() throws Vazio {
        if(getDemadasAdm().isEmpty()){ // Tratamento de Exceção para poder remover.
            throw new Vazio("Não há demandas cadrastadas.");
        } else {
            System.out.println("Você possui tais demandas: ");
            for(int i = 0; i < getDemadasAdm().size(); i++){
                System.out.println("Indice: " + (i+1) + "Demanda: " + getDemadasAdm().get(i));
            }
        }
    }

    @Override
    public void removerDemanda(int indice) throws Vazio{
        if(getDemadasAdm().isEmpty()){ // Tratamento de Exceção para poder remover.
            throw new Vazio("Não há demandas cadrastadas ou indice errado.");
        } else if (indice-1 < 0 || indice-1 > getDemadasAdm().size()){
            throw new Vazio("Não há demandas cadrastadas ou indice errado.");
        }else {
            getDemadasAdm().remove(indice-1); // removendo demanda exclusiva dos adimns
        }
    }



}
