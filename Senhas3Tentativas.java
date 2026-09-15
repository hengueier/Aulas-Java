import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String senhaCorreta = "java123";
        String tentativa;
        int tentativas = 3;

        do {
            System.out.println("Digite sua senha: ");
            tentativa = scanner.nextLine();

            if (tentativa.equals(senhaCorreta)) {
                System.out.println("Acesso liberado");
            } else {
                tentativas--;
            }
        }
        while (!tentativa.equals(senhaCorreta) && tentativas >0);

        if (!tentativa.equals(senhaCorreta)) {
            System.out.println("Acesso Bloqueado");
        }


        }
    }
