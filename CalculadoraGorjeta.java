public class Main {
    public static void main(String[] args) {

        double valorDaConta = 150.00;
        double porcentagemDaGorgeta = 0.10;

        double gorjeta = valorDaConta * porcentagemDaGorgeta;

        double valorTotal = gorjeta + valorDaConta;

        System.out.println("Gorjeta: " + gorjeta);
        System.out.println("Valor total: " + valorTotal);

    }
}