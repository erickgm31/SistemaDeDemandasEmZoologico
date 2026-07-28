package objetos;

import java.util.*;

public abstract class Funcionario {
    private Integer usuario;
    private String senha;
    private String nome;
    private int idade;
    private String formacao;
    private double salario;
    private String orientacaoSexual;


    // hast map que guarda o usuario e qual o funcionario, apenas criado
   // objeto criado para fazer os sorteios


    public Funcionario(String nome,int idade, String formacao,String orientacaoSexual,double salario ){
        this.nome = nome;
        this.idade = idade;
        this.formacao = formacao;
        this.salario = salario;
        this.orientacaoSexual = orientacaoSexual;
    }


    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Integer getUsuario() {
        return usuario;
    }

    public void setUsuario(Integer usuario){
        this.usuario = usuario;
    }

    public String getOrientacaoSexual() {
        return orientacaoSexual;
    }

    public void setOrientacaoSexual(String orientacaoSexual) {
        this.orientacaoSexual = orientacaoSexual;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public String getFormacao() {
        return formacao;
    }

    public void setFormacao(String formacao) {
        this.formacao = formacao;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public abstract void exibirInformacoes();
    public abstract void removerDemanda(int indice) throws Vazio;
    public abstract void receberDemandas(String demanda) throws Vazio;
    public abstract void exibirDemandas() throws Vazio;
}
