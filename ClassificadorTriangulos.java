//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

public class Main {

        public static void main(String[] args) {
            int lado1 = 5;
            int lado2 = 5;
            int lado3 = 5;
            if (lado1 == lado2 && lado2 == lado3) {
                System.out.println("Equilátero");
            } else if (lado1 != lado2 && lado1 != lado3 && lado2 != lado3) {
                System.out.println("Escaleno");
            } else {
                System.out.println("Isósceles");
            }

        }
    }