package View;

import Model.Conta;
import java.util.List;
import java.util.Scanner;

public class ViewConta {
    public void exibirSaldo(double saldo) {
        System.out.println("Saldo atual: R$" + saldo);
    }

    public void extratoDaConta(List<Conta> despesas, List<Conta> receitas) {
        System.out.println("--------------------");
        System.out.println("Despesas:");
        for (Conta despesa : despesas) {
            System.out.println(despesa.getDescricao() + ": R$" + despesa.getValor());
        }
        System.out.println("--------------------");
        System.out.println("Receita:");
        for (Conta receita : receitas) {
            System.out.println(receita.getDescricao() + ": R$" + receita.getValor());
        }
        System.out.println("--------------------");
    }

    public void mostrarDespesa(List<Conta> despesas) {
        int listaNumerica = 1;
        System.out.println("--------------------");
        System.out.println("Despesas:");
        for (Conta despesa : despesas) {
            System.out.println(listaNumerica++ + "-" + despesa.getDescricao() + ": R$" + despesa.getValor());
        }
        System.out.println("--------------------");
    }

    public void mostrarReceita(List<Conta> receitas) {
        int listaNumerica = 1;
        System.out.println("--------------------");
        System.out.println("Receita:");
        for (Conta receita : receitas) {
            System.out.println(listaNumerica++ + "-" + receita.getDescricao() + ": R$" + receita.getValor());
        }
        System.out.println("--------------------");
    }

    public int menu(Scanner ler) {
        System.out.println("Seja Bem Vindo, ao seu sistema de contas");

        System.out.println(
                "\n1 - Adicionar Despesa" + "\n2 - Adicionar Receita" + "\n3 - Exibir Finanças" + "\n4 - Sair");
        System.out.println("Escolha a opcão de que deseja prosseguir ");
        return ler.nextInt();
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
        System.out.println("\n1 - Pagar Tudo" + "\n2 - Remover" + "\n3 - Voltar");
        return ler.nextInt();
    }

    public int confirmar(Scanner ler) {
        System.out.println("Deseja confirmar?");
        System.out.println("1 - Sim");
        System.out.println("2 - Não");
        if (ler.nextInt() == 1) {
            System.out.println("Pagamento realizado com sucesso!");
            return 1;
        } else {
            System.out.println("Pagamento cancelado!");
            return 2;
        }
    }

    public int opcoesDeSelecionarRemover(Scanner ler) {
        System.out.println("\n1 - Remover Despesa" + "\n2 - Remover Receita" + "\n3 - Voltar");
        return ler.nextInt();
    }

        public int numeroParaRemover(Scanner ler, List<Conta> despesa, List<Conta> receita) {
            if(receita.isEmpty() && despesa.isEmpty()) {
                System.out.println("Não há despesas ou receitas para remover.");
                return -1;
            }
            if(!receita.isEmpty()) {
                mostrarDespesa(despesa);
                System.out.println("Digite o número da despesa que deseja remover:");
                return ler.nextInt();
            } else if (!despesa.isEmpty()) {
                mostrarReceita(receita);
                System.out.println("Digite o número da receita que deseja remover:");
                return ler.nextInt(); 
            }
            return -1;
        }
    }


