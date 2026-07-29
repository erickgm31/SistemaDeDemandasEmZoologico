package objetos;

import java.util.ArrayList;

// Classe que representa o Médico Veterinário.
public class MedicoVeterinario extends Funcionario {

    // Atributos próprios do médico veterinário
    private String crmv;

    // Lista de demandas do médico veterinário
    private ArrayList<String> demandasVeterinario = new ArrayList<>();

    // Construtor
    public MedicoVeterinario(String nome, int idade, String formacao, String telefone, double salario, String crmv) {
        super(nome, idade, formacao, telefone, salario);
        this.crmv = crmv;
    }

    // Getters e Setters

    public ArrayList<String> getDemandasVeterinario() {
        return demandasVeterinario;
    }

    public String getCrmv() {
        return crmv;
    }

    public void setCrmv(String crmv) {
        this.crmv = crmv;
    }


    // Exibe as informações do veterinário
    @Override
    public void exibirInformacoes() {
        super.exibirInformacoes();
        System.out.println("CRMV: " + crmv);
    }

    // Remove uma demanda da lista
    @Override
    public void removerDemanda(int indice){
        if (getDemandasVeterinario().isEmpty()) {
            System.out.println("Não há demandas cadastradas.");
        } else if (indice - 1 < 0 || indice - 1 > getDemandasVeterinario().size()) {
            System.out.println("Indice errado.");
        } else {
            getDemandasVeterinario().remove(indice - 1);
        }
    }

    // Adiciona uma demanda
    @Override
    public void receberDemandas(String demanda) {
        getDemandasVeterinario().add(demanda);
    }

    // Exibe as demandas cadastradas
    @Override
    public void exibirDemandas() {
        if(getDemandasVeterinario().isEmpty()){ // Tratamento de Exceção para poder remover.
            System.out.println("Não há demandas cadrastadas.");
        } else {
            System.out.println("Você possui tais demandas: ");
            for(int i = 0; i < getDemandasVeterinario().size(); i++){
                System.out.println("Indice: " + (i+1) + "Demanda: " + getDemandasVeterinario().get(i));
            }
        }
    }

    @Override
    public java.util.List<String> getListaDemandas() {
        return getDemandasVeterinario();
    }
}