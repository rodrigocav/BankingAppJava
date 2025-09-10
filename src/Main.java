import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Banco banco = new Banco();
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\n=== MENU BANCO ===");
            System.out.println("1. Cadastrar Cliente e Conta");
            System.out.println("2. Depositar");
            System.out.println("3. Sacar");
            System.out.println("4. Consultar Saldo");
            System.out.println("5. Listar Clientes");
            System.out.println("0. Sair");
            System.out.print("Escolha: ");
            opcao = scanner.nextInt();
            scanner.nextLine();  // limpar buffer

            switch (opcao) {
                case 1:
                    System.out.print("CPF: ");
                    String cpf = scanner.nextLine();
                    System.out.print("Nome: ");
                    String nome = scanner.nextLine();
                    System.out.print("Data de nascimento (dd/mm/aaaa): ");
                    String nascimento = scanner.nextLine();
                    System.out.print("Tipo de conta (1 - Corrente, 2 - Poupança): ");
                    int tipo = scanner.nextInt();
                    scanner.nextLine();

                    Cliente cliente = new Cliente(cpf, nome, nascimento);
                    Conta conta;

                    if (tipo == 1) {
                        conta = new ContaCorrente(cliente);
                    } else {
                        conta = new ContaPoupanca(cliente);
                    }

                    banco.adicionarConta(conta);
                    System.out.println("Conta criada com sucesso!");
                    break;

                case 2:
                    System.out.print("CPF: ");
                    cpf = scanner.nextLine();
                    Conta contaDeposito = banco.buscarContaPorCpf(cpf);
                    if (contaDeposito != null) {
                        System.out.print("Valor a depositar: ");
                        double valor = scanner.nextDouble();
                        scanner.nextLine();
                        contaDeposito.depositar(valor);
                    } else {
                        System.out.println("Conta não encontrada.");
                    }
                    break;

                case 3:
                    System.out.print("CPF: ");
                    cpf = scanner.nextLine();
                    Conta contaSaque = banco.buscarContaPorCpf(cpf);
                    if (contaSaque != null) {
                        System.out.print("Valor a sacar: ");
                        double valor = scanner.nextDouble();
                        scanner.nextLine();
                        contaSaque.sacar(valor);
                    } else {
                        System.out.println("Conta não encontrada.");
                    }
                    break;

                case 4:
                    System.out.print("CPF: ");
                    cpf = scanner.nextLine();
                    Conta contaSaldo = banco.buscarContaPorCpf(cpf);
                    if (contaSaldo != null) {
                        System.out.printf("Saldo: R$ %.2f%n", contaSaldo.consultarSaldo());
                    } else {
                        System.out.println("Conta não encontrada.");
                    }
                    break;

                case 5:
                    banco.listarClientes();
                    break;

                case 0:
                    System.out.println("Encerrando...");
                    break;

                default:
                    System.out.println("Opção inválida.");
            }

        } while (opcao != 0);

        scanner.close();
    }
}
