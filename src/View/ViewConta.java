package view;

import java.util.Scanner;

import model.Conta;

public class ViewConta {
    private Scanner ler = new Scanner(System.in);

    public void exibirSaldo(double saldo) {
        System.out.println("====================================");
        System.out.printf("     Saldo atual: R$ %.2f\n", saldo);
        System.out.println("====================================\n");
    }

    public void mostrarFinancas(String descricao, double valor) {
        int listaNumerica = 1;
        System.out.printf("%d - %s: R$ %.2f\n", listaNumerica++, descricao, valor);
        System.out.println("============================\n");
    }

    public int menu() {
        System.out.println("\n********** Sistema de Contas **********");
        System.out.println("1 - Adicionar Despesa");
        System.out.println("2 - Adicionar Receita");
        System.out.println("3 - Exibir Finanças");
        System.out.println("4 - Sair");
        System.out.println("Escolha a opcão de que deseja prosseguir: ");
        return ler.nextInt();
    }

    public Conta mostrarFormDespesa() {
        System.out.println("Digite a descrição da despesa:");
        String descricao = ler.nextLine();
        System.out.println("Digite o valor da despesa:");
        int valor = ler.nextInt();
        if(descricao.isEmpty() || valor <= 0){
            MensagemView.mensagemDadosInvalidos();
            return null;
        }else{
            MensagemView.mensagemDespesaAdicionada();
            return new Conta(descricao, valor, "Despesa");
        }
    }

    public Conta mostrarFormReceita() {
        System.out.println("Digite a descrição da receita:");
        String descricao = ler.nextLine();
        System.out.println("Digite o valor da receita:");
        int valor = ler.nextInt();
        if(descricao.isEmpty() || valor <= 0){
            MensagemView.mensagemDadosInvalidos();
            return null;
        }else{
            MensagemView.mensagemReceitaAdicionada();
            return new Conta(descricao, valor, "Receita");
        }
    }

    public int opcoesDepoisDeExibir() {
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

    public int opcoesDeSelecionarRemover() {
        System.out.println(
                "\n1 - Remover Despesa" +
                        "\n2 - Remover Receita" +
                        "\n3 - Voltar");
        return ler.nextInt();
    }

    public int formRemoverDespesa() {
        System.out.println("Digite o número da despesa que deseja remover:");
        return ler.nextInt();
    }

    public int formRemoverReceita() {
        System.out.println("Digite o número da receita que deseja remover:");
        return ler.nextInt();
    }
}