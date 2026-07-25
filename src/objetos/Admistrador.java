package objetos;

import java.util.ArrayList;
import java.util.Scanner;

public class Admistrador extends Funcionario{

    ArrayList<String> demandasAdm = new ArrayList<>(); //demandas exclusivas dos adims


    public Admistrador(String nome,int idade, String formacao,String orientacaoSexual,double salario) {
        super(nome, idade, formacao,orientacaoSexual,salario);
    }

    @Override
    public void informarDemanda(String problema, int tipoFuncionario){
        Demanda X = new Demanda(problema, tipoFuncionario);
        setDemandas(X);
    }

    @Override
    public void exibirInformacoes(){
        System.out.println("nome: " + getNome());
        // e demais atributos

    }

    @Override
    public void removerDemanda(Demanda demanda){
        removeDemanda(demanda); //removendo demanda geral
        demandasAdm.remove(demanda.getProblema()); // removendo demanda exclusiva dos adimns
    }

    @Override
    public void exibirDemandas(String demanda){
        demandasAdm.add(demanda);

        System.out.println("Você possui tais demandas: ");
        for(String d: demandasAdm){
            System.out.println(d);
        }
    }

    public void criarUsuarios(){
        Scanner SC = new Scanner(System.in);
        System.out.println("Selecione qual o tipo: ");
        int escolha = SC.nextInt();
        if (escolha == 0){

            System.out.println("Crie o Admim: ");

            String nome = SC.next();
            int idade = SC.nextInt();
            double salario = SC.nextDouble();
            String formacao = SC.next();
            String orientacaoS = SC.next();

            Admistrador Ad01 = new Admistrador(nome,idade, formacao, orientacaoS, salario);
            Ad01.criaUser();
            funcionarios.put(Ad01.getUsuario(), Ad01);
        }
    }
    
}
