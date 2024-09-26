
import Model.ContaDespesa;
import Model.ContaReceita;
import View.ViewConta;
import Controller.ControllerConta;

public class App {
    public static void main(String[] args) {
        ContaDespesa despesa = new ContaDespesa();
        ContaReceita receita = new ContaReceita();
        ViewConta view = new ViewConta();
        ControllerConta controller = new ControllerConta(despesa, receita, view);

        controller.start();
        
    }
}
