public class Main {
    public void main(String[] args){
        Retangulo retangulo1 = new Retangulo(4, 9);

        retangulo1.exibir();
    }

    class Retangulo {
        int largura;
        int altura;

        public Retangulo(int largura, int altura) {
            this.altura = altura;
            this.largura = largura;
        }

        public int area() {
            return largura * altura;
        }

        public int perimetro() {
            return 2 * (largura + altura);
        }

        public void exibir() {
            System.out.println();
            System.out.println("Area: " + area());
            System.out.println("Perimetro: " + perimetro());
        }
    }
}