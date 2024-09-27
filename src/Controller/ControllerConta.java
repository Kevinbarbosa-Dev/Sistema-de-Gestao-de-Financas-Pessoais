package Controller;

import Model.Conta;
import Model.ContaDespesa;
import Model.ContaReceita;
import View.ViewConta;
import java.util.Scanner;

public class ControllerConta {
    private ContaDespesa contaDespesa;
    private ContaReceita contaReceita;
    private ViewConta view;
    private Scanner ler;

    public ControllerConta() {
        this.contaDespesa = new ContaDespesa();
        this.contaReceita = new ContaReceita();
        this.view = new ViewConta();
        this.ler = new Scanner(System.in);
    }

    public void adicionarDespesa() {
        Conta despesa = view.mostrarFormDespesa(ler);
        contaDespesa.addDespesa(despesa);
    }

    public void adicionarReceita() {
        Conta receita = view.mostrarFormReceita(ler);
        contaReceita.addReceita(receita);
    }

    public void exibirFinancas() {
        view.extratoDaConta(contaDespesa.getArmazenarDespesa(), contaReceita.getArmazenarReceita());
        double saldo = contaReceita.calcularSaldoTotal(contaDespesa);
        view.exibirSaldo(saldo);
    }

    public void pause() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void voltar() {
        int escolha;
        do {
            escolha = view.voltarMenu(ler);
            if (escolha != 1) {
                System.out.println("Opção inválida!");
                pause();
            }
        } while (escolha != 1);
        view.menu();
    }

    public void start() {
        int opcao = 0;
        while (opcao != 4) {
            if (opcao == 0 || opcao == 1 || opcao == 2) {
                view.menu();
            }

            opcao = ler.nextInt();
            ler.nextLine();

            switch (opcao) {
                case 1:
                    adicionarDespesa();
                    pause();
                    break;
                case 2:
                    adicionarReceita();
                    pause();
                    break;
                case 3:
                    exibirFinancas();
                    voltar();
                    break;
                case 4:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }
}
