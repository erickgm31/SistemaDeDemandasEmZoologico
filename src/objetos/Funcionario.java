package objetos;

public abstract class Funcionario {

    // Dados comuns a todos os funcionários do sistema.
    private Integer usuario;
    private String senha;
    private String nome;
    private int idade;
    private String formacao;
    private double salario;
    private String telefone;

    // Inicializa os dados básicos do funcionário.
    // Os atributos específicos de cada cargo são definidos nas classes filhas.
    public Funcionario(String nome, int idade, String formacao, String telefone, double salario) {
        this.nome = nome;
        this.idade = idade;
        this.formacao = formacao;
        this.salario = salario;
        this.telefone = telefone;
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

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
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

    // Exibe os dados básicos do funcionário.
    // As classes filhas podem complementar essas informações
    // com seus próprios atributos.
    public void exibirInformacoes() {
        System.out.println("Nome: " + getNome());
        System.out.println("Usuario: " + getUsuario());
        System.out.println("Idade: " + getIdade());
        System.out.println("Formação: " + getFormacao());
        System.out.println("Numero de Celular: " + getTelefone());
        System.out.println("Salario: " + getSalario());
    }

    // Define operações que devem ser implementadas pelas classes filhas.
    // Cada cargo pode possuir sua própria forma de gerenciar demandas.
    public abstract void removerDemanda(int indice);

    public abstract void receberDemandas(String demanda);

    public abstract void exibirDemandas();

    public abstract java.util.List<String> getListaDemandas();
}

