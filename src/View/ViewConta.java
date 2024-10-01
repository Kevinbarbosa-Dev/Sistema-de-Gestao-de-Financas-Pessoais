package View;

import Model.Conta;
import java.util.List;
import java.util.Scanner;

public class ViewConta {
    public void exibirSaldo(double saldo) {
        System.out.println("Saldo atual: R$" + saldo);
    }

    public void extratoDaConta(List<Conta> despesas, List<Conta> receitas) {
        System.out.println("*******************");
        System.out.println("Despesas:");
        for (Conta despesa : despesas) {
            System.out.println(despesa.getDescricao() + ": R$" + despesa.getValor());
        }
        System.out.println("*******************");
        System.out.println("Receita:");
        for (Conta receita : receitas) {
            System.out.println(receita.getDescricao() + ": R$" + receita.getValor());
        }
        System.out.println("*******************");
    }

    public void menu() {
        System.out.println("Seja Bem Vindo, ao seu sistema de contas");
        System.out.println("Escolha a opcão de que deseja prosseguir");
        System.out.println(
                "\n1 - Adicionar Despesa" + "\n2 - Adicionar Receita" + "\n3 - Exibir Finanças" + "\n4 - Sair");
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

    public int opcoesDepoisDeExibir(Scanner ler) {
        System.out.println("\n1 - Pagar Tudo" + "\n2 - Voltar");
        return ler.nextInt();
    }

    

    public int confirmar(Scanner ler){
        System.out.println("Deseja confirmar?");
        System.out.println("1 - Sim");
        System.out.println("2 - Não");
        return ler.nextInt();
    }
}
