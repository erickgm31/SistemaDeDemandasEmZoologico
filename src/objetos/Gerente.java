package objetos;

import java.util.ArrayList;

public class Gerente extends Funcionario{
    ArrayList<String> demandasGerente = new ArrayList<>(); //demandas exclusivas dos adims

    public Gerente(String nome, int idade, String formacao, String orientacaoSexual, double salario) {
        super(nome, idade, formacao,orientacaoSexual,salario);
    }

    @Override
    public void exibirInformacoes(){
        System.out.println("nome: " + getNome());
        // e demais atributos

    }

    @Override
    public void removerDemanda(int indice) throws Vazio{
        if(demandasGerente.isEmpty()){ // Tratamento de Exceção para poder remover.
            throw new Vazio("Não há demandas cadrastadas ou indice errado.");
        } else if (indice-1 < 0 || indice-1 > demandasGerente.size()){
            throw new Vazio("Não há demandas cadrastadas ou indice errado.");
        }else {
            demandasGerente.remove(indice-1); // removendo demanda exclusiva dos adimns
        }
    }

    @Override
    public void receberDemandas(String demanda)throws Vazio{
        demandasGerente.add(demanda);
    }

    @Override
    public void exibirDemandas() throws Vazio {
        if(demandasGerente.isEmpty()){ // Tratamento de Exceção para poder remover.
            throw new Vazio("Não há demandas cadrastadas.");
        } else {
            System.out.println("Você possui tais demandas: ");
            int i = 0;
            for(String d: demandasGerente) {
                System.out.println("Indice: " + (i+1) + ", Demanda:  " + d);
                i++;
            }
        }
    }
}
