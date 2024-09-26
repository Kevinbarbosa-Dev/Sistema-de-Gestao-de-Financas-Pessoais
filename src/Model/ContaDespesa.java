package Model;

import java.util.ArrayList;
import java.util.List;

public class ContaDespesa{
    private List<Conta> armazenarDespesa = new ArrayList<>();

   
     public List<Conta> getArmazenarDespesa() {
        return armazenarDespesa;
    }

    public void inserirDespesa(String descricao, Double valor){
      Conta  despesa = new Conta(descricao,valor, "Despesa");
        armazenarDespesa.add(despesa);
    }
}
