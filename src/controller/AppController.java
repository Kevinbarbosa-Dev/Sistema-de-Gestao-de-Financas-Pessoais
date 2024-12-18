package controller;

import model.Conta;
import view.MensagemView;
import view.ViewConta;

import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

public class AppController {
    private List<Conta> contaDespesa;
    private List<Conta> contaReceita;
    private DespesaController despesaController;
    private ReceitaController receitaController;
    private ViewConta view;
    private Scanner ler;

    public AppController() {
        this.contaDespesa = new ArrayList<>();
        this.contaReceita = new ArrayList<>();
        this.view = new ViewConta();
        this.ler = new Scanner(System.in);
        this.despesaController = new DespesaController(contaDespesa);
        this.receitaController = new ReceitaController(contaReceita);
    }


    public void exibirFinancas() {
        despesaController.exibirDespesa();
        receitaController.exibirReceita();
    }


    public void calcularSaldoTotalEExibir() {    
        double saldo = 0;
        for (Conta receita : contaReceita) {
            saldo += receita.getValor();
        }
        for (Conta despesa : contaDespesa) {
            saldo -= despesa.getValor();
        }
        view.exibirSaldo(saldo);
    }

    public void pause() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    

    public void opcoesExibir() {
        while (true) {
            int escolha = view.opcoesDepoisDeExibir();
            switch (escolha) {
                case 1:
                    if(view.confirmar(ler) == 1){
                        calcularSaldoTotalEExibir();
                        pause();
                    }
                    return;
                case 2:
                    opcoesRemover();
                    return;
                case 3:
                    return;
                default:
                    MensagemView.mensagemNumeroInvalido();
            }
            pause();
        }
    }

    public void opcoesRemover() {
        while (true) {
            int escolha = view.opcoesDeSelecionarRemover();
            switch (escolha) {
                case 1:
                    despesaController.removerDespesa();
                    pause();
                    return;
                case 2:
                    receitaController.removerReceita();
                    pause();
                    return;
                case 3:
                    return;
                default:
                    MensagemView.opcaoInvalida();
            }
            pause();
        }
    }

    public void start() {
        int opcao;
        do{
            opcao = view.menu();
            switch (opcao) {
                case 1:
                    despesaController.adicionarDespesa();
                    pause();
                    break;
                case 2:
                    receitaController.adicionarReceita();
                    pause();
                    break;
                case 3:
                    exibirFinancas();
                    opcoesExibir();
                    break;
                case 4:
                    MensagemView.sair();
                    break;
                default:
                    MensagemView.opcaoInvalida();
            }
        }while (opcao != 4);
    }
}
