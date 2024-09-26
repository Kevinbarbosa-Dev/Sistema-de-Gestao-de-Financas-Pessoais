package Model;

import java.util.ArrayList;
import java.util.List;

public class ContaDespesa{
    private List<Conta> armazenarDespesa = new ArrayList<>();

   
     public List<Conta> getArmazenarDespesa() {
        return armazenarDespesa;
    }

    public void addDespesa(Conta despesa) {
        this.armazenarDespesa.add(despesa);
    }
}
