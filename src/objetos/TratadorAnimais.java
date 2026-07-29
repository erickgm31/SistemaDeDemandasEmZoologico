package objetos;

import java.util.ArrayList;

// Classe que representa o Tratador de Animais.
public class TratadorAnimais extends Funcionario {

    // Lista de demandas do tratador
    private ArrayList<String> demandasTratador = new ArrayList<>();

    // Construtor
    public TratadorAnimais(String nome, int idade, String formacao, String telefone, double salario) {
        super(nome, idade, formacao, telefone, salario);
    }

    // Getters e Setters

    public ArrayList<String> getDemandasTratador() {
        return demandasTratador;
    }


    // Exibe as informações do tratador
    @Override
    public void exibirInformacoes() {
        super.exibirInformacoes();
    }

    // Remove uma demanda da lista
    @Override
    public void removerDemanda(int indice){
        if (getDemandasTratador().isEmpty()) {
            System.out.println("Não há demandas cadastradas.");
        } else if (indice - 1 < 0 || indice - 1 > getDemandasTratador().size()) {
            System.out.println("Indice errado.");
        } else {
            demandasTratador.remove(indice - 1);
        }
    }

    // Adiciona uma demanda
    @Override
    public void receberDemandas(String demanda) {
        getDemandasTratador().add(demanda);
    }

    // Exibe as demandas cadastradas
    @Override
    public void exibirDemandas() {
        if(getDemandasTratador().isEmpty()){ // Tratamento de Exceção para poder remover.
            System.out.println("Não há demandas cadrastadas.");
        } else {
            System.out.println("Você possui tais demandas: ");
            for(int i = 0; i < getDemandasTratador().size(); i++){
                System.out.println("Indice: " + (i+1) + "Demanda: " + getDemandasTratador().get(i));
            }
        }
    }

    @Override
    public java.util.List<String> getListaDemandas() {
        return getDemandasTratador();
    }
}