import java.util.*;

public class Banco {
    private List<Conta> contas;

    public Banco() {
        contas = new ArrayList<>();
    }

    public void adicionarConta(Conta conta) {
        contas.add(conta);
    }

    public Conta buscarContaPorCpf(String cpf) {
        for (Conta conta : contas) {
            if (conta.getCliente().getCpf().equals(cpf)) {
                return conta;
            }
        }
        return null;
    }

    public void listarClientes() {
        for (Conta conta : contas) {
            System.out.println(conta.getCliente());
        }
    }
}
