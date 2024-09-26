package Controller;

import Model.ContaDespesa;
import Model.ContaReceita;
import View.ViewConta;
import java.util.Scanner;

public class ControllerConta {
    private ContaDespesa contaDespesa;
    private ContaReceita contaReceita;
    private ViewConta view;
    private Scanner ler;

    public ControllerConta(ContaDespesa contaDespesa, ContaReceita contaReceita, ViewConta view) {
        this.contaDespesa = contaDespesa;
        this.contaReceita = contaReceita;
        this.view = view;
        this.ler = new Scanner(System.in);
    }

    public void adicionarDespesa() {
        System.out.println("Digite a descrição da despesa:");
        String descricao = ler.nextLine();
        System.out.println("Digite o valor da despesa:");
        double valor = ler.nextDouble();
        contaDespesa.inserirDespesa(descricao, valor);
    }

    public void adicionarReceita() {
        System.out.println("Digite a descrição da receita:");
        String descricao = ler.nextLine();
        System.out.println("Digite o valor da receita:");
        double valor = ler.nextDouble();
        contaReceita.inserirReceita(descricao, valor);
    }

    public void exibirFinancas() {
        view.mostrarDespesa(contaDespesa.getArmazenarDespesa());
        view.mostrarReceita(contaReceita.getArmazenarReceita());
        double saldo = contaReceita.calcularSaldoTotal(contaDespesa);
        view.exibirSaldo(saldo);
    }

    public void pause(){
        try{
            Thread.sleep(1000);
        }catch(InterruptedException e){
            e.printStackTrace();
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
