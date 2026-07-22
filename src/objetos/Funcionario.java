package objetos;

import java.util.ArrayList;

public abstract class Funcionario {
    private String usuario;
    private String senha;
    private String nome;
    private int idade;
    private String formacao;
    private double salario;
    private String orientacaoSexual;
    private ArrayList<Demanda> demandas = new ArrayList<>();

    public Funcionario(String usuario,String senha,String nome,int idade, String formacao,String orientacaoSexual,double salario ){
        this.usuario = usuario;
        this.nome = nome;
        this.senha = senha;
        this.idade = idade;
        this.formacao = formacao;
        this.salario = salario;
        this.orientacaoSexual = orientacaoSexual;
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

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public abstract void informarDemanda(int funcionario, String problema);
    public abstract void exibirInformaçoes();
    public abstract void removerDemanda(Demanda demanda);
    public abstract void exibirDemandas();
}
