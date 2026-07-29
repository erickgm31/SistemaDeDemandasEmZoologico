package objetos;

import java.util.ArrayList;

public class Manutecao extends Funcionario {
    public ArrayList<String> demandasManutencao = new ArrayList<>();

    private String especialidade;

    public Manutecao(String nome, int idade, String formacao, String telefone, double salario, String especialidade) {
        super(nome, idade, formacao, telefone, salario);
        this.especialidade = especialidade;
    }

    public ArrayList<String> getDemandasManutencao() {
        return demandasManutencao;
    }

    public String getEspecialidade() {
        return especialidade;
    }


    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }


    public void exibirInformacoes() {
        super.exibirInformacoes();
        System.out.println("especialidade :" + getEspecialidade());

    }

    @Override
    public void receberDemandas(String demanda){
        getDemandasManutencao().add(demanda);
    }

    @Override
    public void removerDemanda(int indice) {
        if(getDemandasManutencao().isEmpty()){ // Tratamento de Exceção para poder remover.
            System.out.println("Não há demandas cadrastadas.");
        } else if (indice-1 < 0 || indice-1 > getDemandasManutencao().size()){
            System.out.println("Indice errado.");
        }else {
            getDemandasManutencao().remove(indice-1); // removendo demanda exclusiva dos adimns
        }
    }

    @Override
    public void exibirDemandas(){
        if(getDemandasManutencao().isEmpty()){ // Tratamento de Exceção para poder remover.
            System.out.println("Não há demandas cadrastadas.");
        } else {
            System.out.println("Você possui tais demandas: ");
            for(int i = 0; i < getDemandasManutencao().size(); i++){
                System.out.println("Indice: " + (i+1) + "Demanda: " + getDemandasManutencao().get(i));
            }
        }
    }

    @Override
    public java.util.List<String> getListaDemandas() {
        return getDemandasManutencao();
    }
}
