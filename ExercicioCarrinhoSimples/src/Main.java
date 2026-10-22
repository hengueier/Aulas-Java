public class Main {
    public void main(String[] args) {
        ItemCarrinho item1 = new ItemCarrinho("Blusa Lisa", 35.90, 3);
        ItemCarrinho item2 = new ItemCarrinho("Calça Jeans", 79.90, 1);
        ItemCarrinho item3 = new ItemCarrinho("Jaqueta", 89.90, 1);

        item1.exibir();
        item2.exibir();
        item3.exibir();

        double total = item1.subtotal() + item2.subtotal() + item3.subtotal();

        System.out.println("Valor Total Carrinho R$: " + total);
    }
}

class ItemCarrinho {
    String nome;
    double preco;
    int quantidade;

    public ItemCarrinho(String nome, double preco, int quantidade) {
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
    }

    public double subtotal() {
        return (preco * quantidade);
    }

    public void exibir() {
        System.out.println("Produto: " + nome + " | preço: " + preco + " | Quantidade: "+ quantidade);
    }
}