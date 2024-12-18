package controller;

import java.util.List;

import model.Conta;
import view.MensagemView;
import view.ViewConta;
public class ReceitaController {
    private List<Conta> contaReceita;
    private ViewConta view;

    public ReceitaController(List<Conta> contaReceita) {
        this.contaReceita = contaReceita;
        this.view = new ViewConta();
    }
    public void adicionarReceita() {
        Conta receita = view.mostrarFormReceita();
        contaReceita.add(receita);
    }
    public void exibirReceita(){
        MensagemView.mensagemListaReceita();
        for (Conta receita : contaReceita) {
            view.mostrarFinancas(receita.getDescricao(), receita.getValor());
        }
    }
    public void removerReceita(){
        if(contaReceita.isEmpty()){
            MensagemView.mensagemNaoTemReceita();
        }else{
            if(contaReceita.size() > 0){
                exibirReceita();
                int numero = view.formRemoverReceita();
                if (numero > 0 && numero <= contaReceita.size()){
                    contaReceita.remove(numero - 1);
                    MensagemView.mensagemReceitaRemovida();
                }else{
                    MensagemView.mensagemNumeroInvalido();
                }
            }
        }
    }
}
