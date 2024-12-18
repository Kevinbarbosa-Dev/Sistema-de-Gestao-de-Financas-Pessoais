package model;
public class Conta {
    private String descricao;
    private int valor;
    private String tipo;

    public Conta(String descricao, int valor, String tipo) {
        this.descricao = descricao;
        this.valor = valor;
        this.tipo = tipo;
    }

    public String getDescricao() {
        return descricao;
    }

    public int getValor() {
        return valor;
    }

    public String getTipo() {
        return tipo;
    }

}
