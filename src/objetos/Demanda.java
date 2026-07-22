package objetos;

public class Demanda {
    private int idFuncionario;
    private String problema;

    public Demanda(String problema, int idFuncionario ){
        this.idFuncionario = idFuncionario;
        this.problema = problema;
    }

    public int getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(int idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    public String getProblema() {
        return problema;
    }

    public void setProblema(String problema) {
        this.problema = problema;
    }
}
