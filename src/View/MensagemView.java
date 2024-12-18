package view;

public class MensagemView {
    public static void mensagemNaoTemDespesa() {
        System.out.println("Não há despesas para remover!");
    }

    public static void mensagemDespesaRemovida() {
        System.out.println("Despesa removida com sucesso!");
    }

    public static void mensagemNaoTemReceita() {
        System.out.println("Não há receitas para remover!");
    }

    public static void mensagemReceitaRemovida() {
        System.out.println("Receita removida com sucesso!");
    }

    public static void mensagemNaoTemDespesaReceita() {
        System.out.println("Não há despesas ou receitas para remover!");
    }

    public static void mensagemNumeroInvalido() {
        System.out.println("Número inválido!");
    }
    public static void opcaoInvalida() {
        System.out.println("Opção inválida!");
    }
    public static void sair(){
        System.out.println("Saindo...");
    }
    public static void mensagemListaReceita() {
        System.out.println("\n========= Receitas =========");
    }

    public static void mensagemListaDespesa() {
        System.out.println("\n========= Despesas =========");
    }
    public static void mensagemDadosInvalidos(){
        System.out.println("Dados inválidos!");
    }
    public static void mensagemDespesaAdicionada(){
        System.out.println("Despesa adicionada com sucesso!");
    }
    public static void mensagemReceitaAdicionada(){
        System.out.println("Receita adicionada com sucesso!");
    }
    
}
