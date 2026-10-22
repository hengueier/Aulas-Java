public class Main {
    public static void main(String[] args) {
        Livro livro1 = new Livro("Crime e Castigo", "Fiódor Dostoiévski", 618);
        Livro livro2 = new Livro("O Conde de Monte-Cristo", "Alexandre Dumas", 1296);

        livro1.exibirInfo();
        livro2.exibirInfo();
    }
}

class Livro{
    String titulo;
    String autor;
    int paginas;

    public Livro(String titulo, String autor, int paginas) {
        this.titulo = titulo;
        this.autor = autor;
        this.paginas = paginas;
    }

    public void exibirInfo() {
        System.out.println("Titulo: " + titulo);
        System.out.println("Autor: " + autor);
        System.out.println("Paginas: " + paginas);
    }
}