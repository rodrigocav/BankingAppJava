import java.util.Scanner;

public abstract class Conta {
    protected Cliente cliente;
    protected double saldo;

    public Conta(Cliente cliente) {
        this.cliente = cliente;
        this.saldo = 0.0;
    }

    public void depositar(double valor) {
        if (valor > 0) {
            saldo += valor;
            System.out.println("Depósito de R$" + valor + " realizado com sucesso.");
        } else {
            System.out.println("Valor inválido para depósito.");
        }
    }

    public boolean sacar(double valor) {
        if (valor <= 0) {
            System.out.println("Valor inválido para saque.");
            return false;
        }

        if (saldo >= valor) {
            saldo -= valor;
            System.out.println("Saque de R$" + valor + " realizado com sucesso.");
            return true;
        }

        // Saldo insuficiente
        if (saldo == 0 && valor <= 450) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Seu saldo é R$0,00.");
            System.out.print("Deseja utilizar o limite de R$450,00 fornecido pelo banco? (Sim/Não): ");
            String resposta = scanner.nextLine();

            if (resposta.equalsIgnoreCase("Sim")) {
                saldo -= valor; // saldo ficará negativo
                System.out.println("Limite utilizado com sucesso. Novo saldo: R$" + saldo);
                return true;
            } else {
                System.out.println("Operação cancelada.");
                return false;
            }
        }

        System.out.println("Saldo insuficiente e limite não disponível ou excedido.");
        return false;
    }

    public double consultarSaldo() {
        return saldo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public abstract String getTipoConta();
}
