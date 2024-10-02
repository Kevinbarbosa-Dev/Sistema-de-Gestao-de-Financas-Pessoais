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
    }

    public void pause() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // public void mostrarContaArmazenada(){
    // contaDespesa.getArmazenarDespesa([]);
    // }
    public void opcoesExibir() {
        while (true) {
            int escolha = view.opcoesDepoisDeExibir(ler);
            switch (escolha) {
                case 1:
                    if (view.confirmar(ler) == 1) {
                        double saldo = contaReceita.calcularSaldoTotal(contaDespesa);
                        view.exibirSaldo(saldo);
                        System.out.println("Pagamento realizado com sucesso!");
                        pause();
                        return;
                    } else if (view.confirmar(ler) == 2) {
                        System.out.println("Pagamento cancelado!");
                        pause();
                    }
                    break;
                case 2:
                    return;
                default:
                    System.out.println("Opção inválida!");
                    pause();
            }
        }
    }

    public void opcoesRemover() {
        while (true) {
            int escolha = view.opcoesDeSelecionarRemover(ler);
            switch (escolha) {
                case 1:
                    if (contaDespesa.getArmazenarDespesa().isEmpty()) {
                        System.out.println("Não há nada para remover");
                    } else {
                        view.mostrarDespesa(contaDespesa.getArmazenarDespesa());
                        System.out.println("Digite o número da despesa que deseja remover");
                        int numeroDespesa = ler.nextInt();
                        contaDespesa.getArmazenarDespesa().remove(numeroDespesa - 1);
                        System.out.println("Despesa Atualizada!");
                        view.mostrarDespesa(contaDespesa.getArmazenarDespesa());
                        pause();
                        return;
                    }

                    break;
                case 2:
                    if (contaReceita.getArmazenarReceita().isEmpty()) {
                        System.out.println("Não há nada para remover");
                    }else{
                        view.mostrarReceita(contaReceita.getArmazenarReceita());
                        System.out.println("Digite o número da receita que deseja remover");
                        int numeroReceita = ler.nextInt();
                        contaReceita.getArmazenarReceita().remove(numeroReceita - 1);
                        System.out.println("Receita Atualizada!");
                        view.mostrarReceita(contaReceita.getArmazenarReceita());
                        pause();
                        return;
                    }
                    break;
                case 3:
                    return;
                default:
                    System.out.println("Opção inválida!");
                    pause();
            }
        }
    }

    public void start() {
        int opcao = 0;
        while (opcao != 4) {
            view.menu();
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
                    opcoesExibir();
                    opcoesRemover();
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
