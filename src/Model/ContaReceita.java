package Model;

import java.util.List;
import java.util.ArrayList;

public class ContaReceita {
    private List<Conta> armazenarReceita = new ArrayList<>();

    public List<Conta> getArmazenarReceita() {
        return armazenarReceita;
    }

    public void inserirReceita(String descricao, double valor) {
        Conta receita = new Conta(descricao, valor, "Receita");
        armazenarReceita.add(receita);
    }
    
    public double calcularSaldoTotal(ContaDespesa despesas) {    
        double saldo = 0;
        for (Conta receita : armazenarReceita) {
            saldo += receita.getValor();
        }
        for (Conta despesa : despesas.getArmazenarDespesa()) {
            saldo -= despesa.getValor();
        }
        return saldo;
    }
}
