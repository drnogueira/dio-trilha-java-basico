import java.text.DecimalFormat;
import java.util.Scanner;

public class ContaTerminal {
    // TODO: Declarar atributos da conta, como titular, número da conta e saldo
    private String titular;
    private int numeroConta;
    private double saldo;

    // TODO: Criar um construtor para inicializar a conta com nome do titular,
    // numero da conta e saldo incial.
    public ContaTerminal(String titular, int numeroConta, double saldoInicial) {
        this.titular = titular;
        this.numeroConta = numeroConta;
        this.saldo = saldoInicial;
    }

    // TODO: Implementar um método para exibir o saldo atual.
    public void exibirSaldo() {
        DecimalFormat format = new DecimalFormat("#,##0.00"); // Formato para 2 casas decimais
        System.out.println("Seu saldo atual é: " + format.format(saldo));
    }

    // TODO: Implementar um método para depositar dinheiro na conta.

    public void depositar(double valor) {
        if (valor > 0) {
            saldo += valor;
            DecimalFormat format = new DecimalFormat("#,##0.00"); // Formato para 2 casas decimais
            System.out.println("Depósito de " + format.format(valor) + " realizado com sucesso.");
        } else {
            System.out.println("Valor inválido para despósito.");
        }
    }

    // TODO: Implementar um método para sacar dinheiro da conta.
    public void sacar(double valor) {
        if (valor > 0 && valor <= saldo) {
            saldo -= valor;
            DecimalFormat format = new DecimalFormat("#,##0.00"); // Formato para 2 casas decimais
            System.out.println("Saque de " + format.format(valor) + " realizado com sucesso.");
        } else {
            System.out.println("Saldo insuficeinte ou valor inválido.");
        }
    }

    public static void main(String[] args) {
        // TODO: Criar um objeto Scanner para obter dados do usuário pelo console.
        Scanner scanner = new Scanner(System.in);

        // TODO: Solicitar ao usuário os detalhes iniciais da conta (Titular, nuúmero da
        // conta e saldo inicial).
        System.out.print("Digite o nome do titular da conta: ");
        String titular = scanner.nextLine();

        System.out.print("Digite o número da conta: ");
        int numeroConta = scanner.nextInt();

        System.out.print("Digite o saldo inicial: ");
        double saldoInicial = scanner.nextDouble();

        // TODO: Criar uma instância da classe ContaTerminal com os dados fornecidos
        // pelo usuário.
        ContaTerminal conta = new ContaTerminal(titular, numeroConta, saldoInicial);

        // TODO: Implementar um sistema de menu para o usuário escolher diferentes
        // operações (exibir saldo, depositar, sacar).
        int opcao;
        do {
            System.err.println("\n --- Menu ---");
            System.err.println("1. Exibir Saldo");
            System.err.println("2. Depositar");
            System.err.println("3. Sacar");
            System.err.println("4. Sair");
            System.err.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    // TODO: Chamar o método para exibir o saldo atual.
                    conta.exibirSaldo();
                    break;
                case 2:
                    // TODO: Solicitar ao usuário o valor do depósito e chamar o método de depósito.
                    System.out.print("Digite o valor do depósito: ");
                    double valorDeposito = scanner.nextDouble();
                    conta.depositar(valorDeposito);
                    break;
                case 3:
                    // TODO: Solicitar ao usuário o valor do saque e chamar o método de saque.
                    System.out.print("Digite o valor do saque: ");
                    double valorSaque = scanner.nextDouble();
                    conta.sacar(valorSaque);
                    break;
                case 4:
                    // TODO: Exibir uma mensagem de despedida antes de sair do programa.
                    System.out.println("Saindo... Obrigado!");
                    break;
                default:
                    // TODO: Tratar opções inválidas do menu com uma mensagem de erro.
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 4);

        // TODO: Fechar o objeto Scanner para liberar recursos.
        scanner.close();
    }
}
