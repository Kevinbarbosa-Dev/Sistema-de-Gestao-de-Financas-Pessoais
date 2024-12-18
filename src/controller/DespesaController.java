package controller;

import model.Conta;
import view.MensagemView;
import view.ViewConta;

import java.util.List;

public class DespesaController {
    private List<Conta> contaDespesa;
    private ViewConta view;

    public DespesaController(List<Conta> contaDespesa) {
        this.contaDespesa = contaDespesa;
        this.view = new ViewConta();
    }

    public void adicionarDespesa() {
        Conta despesa = view.mostrarFormDespesa();
        contaDespesa.add(despesa);
    }

    public void exibirDespesa(){
        MensagemView.mensagemListaDespesa();
        for (Conta despesa : contaDespesa) {
            view.mostrarFinancas(despesa.getDescricao(), despesa.getValor());
        }
    }

    public void removerDespesa(){
        if(contaDespesa.isEmpty()){
            MensagemView.mensagemNaoTemDespesa();
        }else{
            if(contaDespesa.size() > 0){
                exibirDespesa();
                int numero = view.formRemoverDespesa();
                if (numero > 0 && numero <= contaDespesa.size()){
                    contaDespesa.remove(numero - 1);
                    MensagemView.mensagemDespesaRemovida();
                }else{
                    MensagemView.mensagemNumeroInvalido();
                }
            }
        }
    }
}
