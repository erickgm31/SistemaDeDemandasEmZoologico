package objetos;

import java.util.ArrayList;

// Classe que representa o Zootecnista.
public class Zootecnista extends Funcionario {

    // Atributo próprio do zootecnista
    private String areaAtuacao;

    // Lista de demandas do zootecnista
    private ArrayList<String> demandasZootecnista = new ArrayList<>();

    // Construtor
    public Zootecnista(String nome, int idade, String formacao, String telefone, double salario, String areaAtuacao) {
        super(nome, idade, formacao, telefone, salario);
        this.areaAtuacao = areaAtuacao;
    }

    // Getters e Setters

    public ArrayList<String> getDemandasZootecnista() {
        return demandasZootecnista;
    }


    public String getAreaAtuacao() {
        return areaAtuacao;
    }

    public void setAreaAtuacao(String areaAtuacao) {
        this.areaAtuacao = areaAtuacao;
    }

    // Exibe as informações do zootecnista
    @Override
    public void exibirInformacoes() {
        System.out.println("Nome: " + getNome());
        System.out.println("Idade: " + getIdade());
        System.out.println("Formação: " + getFormacao());
        System.out.println("Salário: " + getSalario());
        System.out.println("Área de Atuação: " + areaAtuacao);
    }

    // Remove uma demanda da lista
    @Override
    public void removerDemanda(int indice) {
        if (getDemandasZootecnista().isEmpty()) {
            System.out.println("Não há demandas cadastradas.");
        } else if (indice - 1 < 0 || indice - 1 > getDemandasZootecnista().size()) {
            System.out.println("índice errado.");
        } else {
            getDemandasZootecnista().remove(indice - 1);
        }
    }

    // Adiciona uma demanda
    @Override
    public void receberDemandas(String demanda){
        getDemandasZootecnista().add(demanda);
    }

    // Exibe as demandas cadastradas
    @Override
    public void exibirDemandas(){
        if(getDemandasZootecnista().isEmpty()){ // Tratamento de Exceção para poder remover.
            System.out.println("Não há demandas cadrastadas.");
        } else {
            System.out.println("Você possui tais demandas: ");
            for(int i = 0; i < getDemandasZootecnista().size(); i++){
                System.out.println("Indice: " + (i+1) + "Demanda: " + getDemandasZootecnista().get(i));
            }
        }
    }

    @Override
    public java.util.List<String> getListaDemandas() {
        return getDemandasZootecnista();
    }
}