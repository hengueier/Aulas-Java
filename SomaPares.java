
public class Main {
    public static void main(String[] args) {
        int soma = 0;

        for (int i = 1; i <= 10; i++) {
            if (i % 2 == 0) {
                soma = soma + i;
            }
        }

        System.out.println(soma);
    }
}