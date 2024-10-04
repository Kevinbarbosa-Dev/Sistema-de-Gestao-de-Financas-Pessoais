Sistema de Gestão de Finanças Pessoais

Objetivo: Desenvolver um sistema simples de gestão de finanças pessoais que permita ao usuário registrar despesas e receitas, calcular o saldo total financeiro. Deverá ser seguido o modelo MVC de projeto de software, criando uma Controller, os Models e as Views necessárias para o projeto financeiro.

Classe Controller: Criar classe de controle para acionamento de views e modelos.
Métodos: Acionamento das classes.

Classe Conta: Representa uma transação financeira (despesa ou receita), com métodos para registrar e recuperar informações.
Atributos: descrição, valor, tipo (despesa ou receita).
Métodos: construtor, getters e setters para os atributos.

Classes ContaDespesa e ContaReceita: Gerencia as transações financeiras e calcula o saldo total financeiro, fornecendo métodos para adicionar as transações, calcular o
saldo total.
Métodos: construtor, InsereDespesas, InsereReceitas.

Classe View: Classe para exibição dos valores, realizando as operações no sistema.
Métodos: Criar método exibir dados de contas.

Problemas:
- Conta sendo paga sem ser solicitada.
    Solução: Criar um método para solicitar a conta a ser paga.
    Opçães: Pagar tudo ou pagar uma conta específica? - Mostrar o valor que será descontado do saldo - Continuar?
    pagar conta -> listar as despesas e mostrar a receita atual
- Remover
    - Remover despesa: Mostrar despesas e pedir o número da despesa a ser removida
    - Remover receita: Mostrar receitas e pedir o número da receita a ser removida
- Editar
