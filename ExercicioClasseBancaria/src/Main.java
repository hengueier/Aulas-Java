public class Main {
    public void main(String[] args) {
        ContaBancaria contaBancaria1 = new ContaBancaria("Renata Silva", 200);

        contaBancaria1.depositar(100.0);
        contaBancaria1.sacar(400.0);
        contaBancaria1.sacar(250.0);
        contaBancaria1.exibirSaldo();
    }
}

class ContaBancaria {
    String titular;
    double saldo;

    public ContaBancaria(String titular, double saldoInicial) {
        this.titular = titular;
        this.saldo = saldoInicial;
    }

    public void depositar(double valor) {
        saldo = saldo + valor;
    }

    public void sacar(double valor) {
        if (valor <= saldo) {
            saldo = saldo - valor;
        } else {
            System.out.println("Saldo insuficiente.");
        }
    }

    public void exibirSaldo() {
        System.out.println(titular + " | Saldo: R$ " + saldo);
    }
}

