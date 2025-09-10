public class ContaPoupanca extends Conta {

    public ContaPoupanca(Cliente cliente) {
        super(cliente);
    }

    @Override
    public String getTipoConta() {
        return "Conta Poupança";
    }
}

