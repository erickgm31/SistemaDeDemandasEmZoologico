package objetos;

import objetos.Funcionario;
import objetos.Vazio;

import java.util.ArrayList;

public class AuxiliardeLimpeza extends Funcionario {
    public ArrayList<String> demandasAuxiliar = new ArrayList<>();

    public AuxiliardeLimpeza(String nome, int idade, String formacao, String telefone, double salario) {
        super(nome, idade, formacao, telefone, salario);
    }

    public ArrayList<String> getDemandasAuxiliar() {
        return demandasAuxiliar;
    }

    @Override
    public void exibirInformacoes(){
        super.exibirInformacoes();
    }

    @Override
    public void receberDemandas(String demanda){
        getDemandasAuxiliar().add(demanda);
    }

    @Override
    public void removerDemanda(int indice) {
        if(getDemandasAuxiliar().isEmpty()){ // Tratamento de Exceção para poder remover.
            System.out.println("Não há demandas cadrastadas.");
        } else if (indice-1 < 0 || indice-1 > getDemandasAuxiliar().size()){
            System.out.println("Indice errado.");
        }else {
            getDemandasAuxiliar().remove(indice-1); // removendo demanda exclusiva dos adimns
        }
    }

    @Override
    public void exibirDemandas() {
        if(getDemandasAuxiliar().isEmpty()){ // Tratamento de Exceção para poder remover.
            System.out.println("Não há demandas cadrastadas.");
        } else {
            System.out.println("Você possui tais demandas: ");
            for(int i = 0; i < getDemandasAuxiliar().size(); i++){
                System.out.println("Indice: " + (i+1) + "Demanda: " + getDemandasAuxiliar().get(i));
            }
        }
    }

    @Override
    public java.util.List<String> getListaDemandas() {
        return getDemandasAuxiliar();
    }

}



