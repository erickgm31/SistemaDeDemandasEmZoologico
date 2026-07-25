package objetos;

public class Demanda {
    private int tipoFuncionario;
    private String problema;

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
