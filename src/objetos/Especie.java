package objetos;

import java.util.ArrayList;

public class Especie {
    private String nomeEspecie;
    private int quantidade;
    private String setor;
    private ArrayList <Integer> identificadores;

    public Especie(String nomeEspecie, int quantidade,String setor){
        this.nomeEspecie = nomeEspecie;
        this.quantidade = quantidade;
        this.setor = setor;
    }

    public String getNomeEspecie() {
        return nomeEspecie;
    }

    public void setNomeEspecie(String nomeEspecie) {
        this.nomeEspecie = nomeEspecie;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String getSetor() {
        return setor;
    }

    public void setSetor(String setor) {
        this.setor = setor;
    }

    public void addidentificadores(int id){
        identificadores.add(id);
    }
    public void removerIderificadores(int id){
        identificadores.remove(id);
    }
}
