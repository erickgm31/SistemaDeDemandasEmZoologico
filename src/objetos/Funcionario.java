package objetos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.UUID;

public abstract class Funcionario {
    private Integer usuario;
    private String senha;
    private String nome;
    private int idade;
    private String formacao;
    private double salario;
    private String orientacaoSexual;



    protected ArrayList<Demanda> demandas = new ArrayList<>(); //armazenar as demandas gerais

    protected HashMap<Integer, Funcionario> funcionarios = new HashMap<>();  // hast map que guarda o usuario e qual o funcionario, apenas criado

    Random random = new Random(); // objeto criado para fazer os sorteios


    public Funcionario(String nome,int idade, String formacao,String orientacaoSexual,double salario ){
        this.nome = nome;
        this.idade = idade;
        this.formacao = formacao;
        this.salario = salario;
        this.orientacaoSexual = orientacaoSexual;
    }

    public void criaUser(){
        this.usuario = random.nextInt(90000) + 10000;  // Criando User Aleatorio com 5 numeros entre 10000 - 99999
        if(funcionarios.containsKey(usuario)){  // verifica se ja existi, so sai do while, quando for exclusivo
            while (funcionarios.containsKey(usuario)){
                this.usuario = random.nextInt(90000) + 10000;
            }
        }
    }

    public void criarSenha(){
        this.senha = UUID.randomUUID().toString().substring(0,8); // cria senha aleatoria, o plano é que depois do primeiro acesso, o user a troque
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

    public HashMap<Integer, Funcionario>  getFuncionarios(){
        return funcionarios;  // retorna o hast map de funcrionario
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

    public void setDemandas(Demanda demanda) {
        this.demandas.add(demanda);
    }

    public void removeDemanda(Demanda demanda){
        this.demandas.remove(demanda); //remove a demanda
    }

    public void enviarDemanda(){
        for(Demanda d : demandas) { // unica forma de enviar que pensei, é fazendo tudo de uma vez
            if (d.getTipoFuncionario() == 0) { // forma mais facil de definir qual o funcionario é por numeros
                ArrayList<Funcionario> Admins = new ArrayList<>();
                for (Funcionario funcionario : getFuncionarios().values()) {
                    if (funcionario instanceof Admistrador) {
                        Admins.add(funcionario);
                    }
                }
                int escolha = random.nextInt(Admins.size());  // delimita uma escolha aleatoria entre a quantidade dos adims
                Funcionario escolhido = Admins.get(escolha); // escolhe o adim do indice sorteado a cima
                escolhido.exibirDemandas(d.getProblema()); // envia para o adim escolhido
            }

            // Aqui continua o teste, para envio, exemplo
            // if else(d.getTipoFuncionario() == 1){ faz o arraylist proprio dos tratadores
        }
    }


    public abstract void informarDemanda(String problema, int tipoFuncionario );
    public abstract void exibirInformacoes();
    public abstract void removerDemanda(Demanda demanda);
    public abstract void exibirDemandas(String demanda);
}
