package AulaUm;

/*Exercício 1 — Calculadora de Gorjeta

Você foi a um restaurante e deseja calcular uma gorjeta de 10% sobre uma conta de R$ 150,00.

Crie um programa em Java que:

1. Crie uma variável para armazenar o valor da conta.
2. Crie uma variável para armazenar a porcentagem da gorjeta.
3. Calcule o valor da gorjeta.
4. Calcule o valor total (conta + gorjeta).*/

public class CalculadoraDeGorjeta {
        public static void main(String[] args) {

            double valorDaConta = 150.00;
            double porcentagemDaGorgeta = 0.10;

            double gorgeta = valorDaConta * porcentagemDaGorgeta;

            double valorTotal = gorgeta + valorDaConta;

            System.out.printf("Valor da gorgeta: " + gorgeta + " - Valor total da conta: " + valorTotal);

        }


}
