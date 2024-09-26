package View;
import Model.Conta;
import java.util.List;
import java.util.Scanner;
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

    public Conta mostrarFormDespesa(Scanner ler) {
        System.out.println("Digite a descrição da despesa:");
        String descricao = ler.nextLine();
        System.out.println("Digite o valor da despesa:");
        double valor = ler.nextDouble();
        return new Conta(descricao, valor, "Despesa");
        
    }

    public Conta mostrarFormReceita(Scanner ler) {
        System.out.println("Digite a descrição da receita:");
        String descricao = ler.nextLine();
        System.out.println("Digite o valor da receita:");
        double valor = ler.nextDouble();
        return new Conta(descricao, valor, "Receita");
    }
}
