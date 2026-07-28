package objetos;

import java.util.ArrayList;

public class AdmistradorDoSistema {
    private Integer usuario;
    private String senha;
    private String nome;
    private int idade;
    private String formacao;
    private double salario;
    private String orientacaoSexual;

    public AdmistradorDoSistema(String nome, int idade, String formacao, String orientacaoSexual, double salario) {
        this.nome = nome;
        this.idade = idade;
        this.formacao = formacao;
        this.salario = salario;
        this.orientacaoSexual = orientacaoSexual;
    }

}
