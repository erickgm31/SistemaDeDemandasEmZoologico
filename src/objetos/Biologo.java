package objetos;

import java.util.ArrayList;

public class Biologo extends Funcionario {
    public ArrayList<String> demandasBiologo = new ArrayList<>();
    
    private String areaPesquisa;
    private String registroAmbiental;
    
    public Biologo(String nome, int idade, String formacao, String telefone, double salario, String areaPesquisa, String registroAmbiental)  {
        super(nome, idade, formacao, telefone, salario);
        this.areaPesquisa = areaPesquisa;
        this.registroAmbiental = registroAmbiental;
    }

    public ArrayList<String> getDemandasBiologo() {
        return demandasBiologo;
    }

    public String getAreaPesquisa() {
            return areaPesquisa;
        }
    public String getRegistroAmbiental() {
            return registroAmbiental;
        }
    public void setAreaPesquisa(String areaPesquisa) {
            this.areaPesquisa = areaPesquisa;
        }
    public void setRegistroAmbiental(String registroAmbiental) {
            this.registroAmbiental = registroAmbiental;
        }

    @Override
    public void exibirInformacoes(){
        super.exibirInformacoes();
        System.out.println("área de pesquisa :" + getAreaPesquisa());
        System.out.println("registro ambiental :" + getRegistroAmbiental());
    }

    @Override
    public void receberDemandas(String demanda){
        getDemandasBiologo().add(demanda);
    }

    @Override
    public void removerDemanda(int indice) {
        if(getDemandasBiologo().isEmpty()){ // Tratamento de Exceção para poder remover.
            System.out.println("Não há demandas cadrastadas.");
        } else if (indice-1 < 0 || indice-1 > getDemandasBiologo().size()){
            System.out.println("Indice errado.");
        } else {
            getDemandasBiologo().remove(indice-1); // removendo demanda exclusiva dos adimns
        }
    }

    @Override
    public void exibirDemandas() {
        if(getDemandasBiologo().isEmpty()){ // Tratamento de Exceção para poder remover.
            System.out.println("Não há demandas cadrastadas.");
        } else {
            System.out.println("Você possui tais demandas: ");
            for(int i = 0; i < getDemandasBiologo().size(); i++){
                System.out.println("Indice: " + (i+1) + "Demanda: " + getDemandasBiologo().get(i));
            }
        }
    }

    @Override
    public java.util.List<String> getListaDemandas() {
        return getDemandasBiologo();
    }

}
