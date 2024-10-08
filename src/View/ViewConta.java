package View;

import Model.Conta;
import java.util.List;
import java.util.Scanner;

public class ViewConta {
    public void exibirSaldo(double saldo) {
        System.out.println("====================================");
        System.out.printf("     Saldo atual: R$ %.2f\n", saldo);
        System.out.println("====================================\n");
    }

    // Método para exibir o extrato da conta com separação clara
    public void extratoDaConta(List<Conta> despesas, List<Conta> receitas) {
        System.out.println("========= Extrato de Finanças =========\n");

        System.out.println(">>> Despesas:");
        for (Conta despesa : despesas) {
            System.out.printf("   - %s: R$ %.2f\n", despesa.getDescricao(), despesa.getValor());
        }
        System.out.println("\n--------------------------------------");

        System.out.println(">>> Receitas:");
        for (Conta receita : receitas) {
            System.out.printf("   - %s: R$ %.2f\n", receita.getDescricao(), receita.getValor());
        }

        System.out.println("\n======================================\n");
    }

    // Método para exibir lista de despesas com números formatados
    public void mostrarDespesa(List<Conta> despesas) {
        System.out.println("\n========= Despesas =========");
        int listaNumerica = 1;
        for (Conta despesa : despesas) {
            System.out.printf("%d - %s: R$ %.2f\n", listaNumerica++, despesa.getDescricao(), despesa.getValor());
        }
        System.out.println("============================\n");
    }

    // Método para exibir lista de receitas com números formatados
    public void mostrarReceita(List<Conta> receitas) {
        System.out.println("\n========= Receitas =========");
        int listaNumerica = 1;
        for (Conta receita : receitas) {
            System.out.printf("%d - %s: R$ %.2f\n", listaNumerica++, receita.getDescricao(), receita.getValor());
        }
        System.out.println("============================\n");
    }

    public int menu(Scanner ler) {
        System.out.println("\n********** Sistema de Contas **********");
        System.out.println(
                "\n1 - Adicionar Despesa" +
                        "\n2 - Adicionar Receita" +
                        "\n3 - Exibir Finanças" +
                        "\n4 - Sair");
        System.out.println("Escolha a opcão de que deseja prosseguir: ");
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
        System.out.println(
                "\n1 - Pagar Tudo" +
                        "\n2 - Remover" +
                        "\n3 - Voltar");
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
            return 1;
        }
    }

    public int opcoesDeSelecionarRemover(Scanner ler) {
        System.out.println(
                "\n1 - Remover Despesa" +
                        "\n2 - Remover Receita" +
                        "\n3 - Voltar");
        return ler.nextInt();
    }

    public void removerDespesa(Scanner ler, List<Conta> despesas) {
        if (despesas.isEmpty()) {
            System.out.println("Não há despesas para remover!");
        } else {
            mostrarDespesa(despesas);
            System.out.println("Digite o número da despesa que deseja remover:");
            int numero = ler.nextInt();
            if (numero > 0 && numero <= despesas.size()) {
                despesas.remove(numero - 1);
                System.out.println("Despesa removida com sucesso!");
            } else {
                System.out.println("Número de despesa inválido!");
            }
        }
    }

    public void removerReceita(Scanner ler, List<Conta> receitas) {
        if (receitas.isEmpty()) {
            System.out.println("Não há receitas para remover!");
        } else {
            mostrarReceita(receitas);
            System.out.println("Digite o número da receita que deseja remover:");
            int numero = ler.nextInt();
            if (numero > 0 && numero <= receitas.size()) {
                receitas.remove(numero - 1);
                System.out.println("Receita removida com sucesso!");
            } else {
                System.out.println("Número de receita inválido!");
            }
        }
    }

    public void opcaoInvalida() {
        System.out.println("Opção inválida!");
    }
}