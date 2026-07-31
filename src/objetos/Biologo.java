package objetos;

import java.util.ArrayList;

public class Biologo extends Funcionario {

    // Lista responsável por armazenar as demandas atribuídas ao biólogo.
    public ArrayList<String> demandasBiologo = new ArrayList<>();

    // Informações específicas da função de biólogo.
    private String areaPesquisa;
    private String registroAmbiental;

    public Biologo(String nome, int idade, String formacao,
                   String telefone, double salario,
                   String areaPesquisa, String registroAmbiental) {

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

    // Exibe os dados comuns do funcionário e as informações específicas do biólogo.
    @Override
    public void exibirInformacoes(){
        super.exibirInformacoes();
        System.out.println("Área de pesquisa: " + getAreaPesquisa());
        System.out.println("Registro ambiental: " + getRegistroAmbiental());
    }

    // Adiciona uma nova demanda à lista do biólogo.
    @Override
    public void receberDemandas(String demanda){
        getDemandasBiologo().add(demanda);
    }

    // Remove uma demanda utilizando o índice informado pelo usuário.
    @Override
    public void removerDemanda(int indice) {
        if(getDemandasBiologo().isEmpty()){
            System.out.println("Não há demandas cadrastadas.");

            // Verifica se o índice informado corresponde a uma posição válida.
        } else if (indice-1 < 0 || indice-1 > getDemandasBiologo().size()){
            System.out.println("Indice errado.");

        } else {
            getDemandasBiologo().remove(indice-1);
        }
    }

    // Exibe todas as demandas atualmente atribuídas ao biólogo.
    @Override
    public void exibirDemandas() {
        if(getDemandasBiologo().isEmpty()){
            System.out.println("Não há demandas cadrastadas.");
        } else {
            System.out.println("Você possui tais demandas: ");

            // Percorre a lista exibindo cada demanda e seu respectivo índice.
            for(int i = 0; i < getDemandasBiologo().size(); i++){
                System.out.println(
                        "Indice: " + (i+1) +
                                " Demanda: " + getDemandasBiologo().get(i)
                );
            }
        }
    }

    // Retorna a lista de demandas seguindo o padrão definido em Funcionario.
    @Override
    public java.util.List<String> getListaDemandas() {
        return getDemandasBiologo();
    }
}
