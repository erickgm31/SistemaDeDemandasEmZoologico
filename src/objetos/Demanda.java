package objetos;

public class Demanda {

    // Armazena o tipo de funcionário responsável por atender a demanda.
    private int tipoFuncionario;

    // Descrição do problema ou tarefa que precisa ser resolvida.
    private String problema;

    // Inicializa a demanda com o problema e o cargo responsável.
    public Demanda(String problema, int tipoFuncionario ){
        this.problema = problema;
        this.tipoFuncionario = tipoFuncionario;
    }

    public int getTipoFuncionario() {
        return tipoFuncionario;
    }

    public void setIdFuncionario(int tipoFuncionario) {
        this.tipoFuncionario = tipoFuncionario;
    }

    public String getProblema() {
        return problema;
    }

    public void setProblema(String problema) {
        this.problema = problema;
    }
}

