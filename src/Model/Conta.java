package Model;
public class Conta {
    private String descricao;
    private double valor;
    private String tipo; // "despesa" ou "receita"

    public Conta(String descricao, double valor, String tipo) {
        this.descricao = descricao;
        this.valor = valor;
        this.tipo = tipo;
    }

    public String getDescricao() {
        return descricao;
    }

    public double getValor() {
        return valor;
    }

    public String getTipo() {
        return tipo;
    }

}
