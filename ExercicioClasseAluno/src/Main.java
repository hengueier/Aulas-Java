public class Main {
    public static void main(String[] args) {
        Aluno aluno1 = new Aluno("Alice Bueno", 8.5, 7.5);
        Aluno aluno2 = new Aluno("Pedro Gomes", 6.5,7.5);

        aluno1.exibirBoletim();
        aluno2.exibirBoletim();
    }
}

class Aluno {
    String nome;
    double nota1;
    double nota2;

    public Aluno(String nome, double nota1, double nota2) {
        this.nome = nome;
        this.nota1 = nota1;
        this.nota2 = nota2;
    }

    public double calcularMedia() {
        return (nota1 + nota2) / 2;
    }

    public boolean aprovado() {
        return calcularMedia() >= 7.0;
    }

    public void exibirBoletim() {
        System.out.println("Aluno: " + nome);
        System.out.println("Nota: " + calcularMedia());
        System.out.println("Aprovado: " + aprovado());
    }
}
