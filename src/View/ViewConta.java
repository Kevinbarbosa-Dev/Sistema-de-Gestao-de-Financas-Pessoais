package View;
import Model.Conta;
import java.util.List;
public class ViewConta {
    public void exibirSaldo(double saldo) {
        System.out.println("Saldo atual: R$" + saldo);
    }
    public void mostrarDespesa(List<Conta> despesas) {
        System.out.println("Despesas:");
        for (Conta despesa : despesas) {
            System.out.println(despesa.getDescricao() + ": R$" + despesa.getValor());
        }
    }
    public void mostrarReceita(List<Conta> receitas) {
        System.out.println("Receita:");
        for (Conta receita : receitas) {
            System.out.println(receita.getDescricao() + ": R$" + receita.getValor());
        }
    }
    
    public void menu(){
        System.out.println("Seja Bem Vindo, ao seu sistema de contas");
        System.out.println("Escolha a opcão de que deseja prosseguir");
        System.out.println("\n1 - Adicionar Despesa" + "\n2 - Adicionar Receita" + "\n3 - Exibir Finanças" + "\n4 - Sair");
    }
}
