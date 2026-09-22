# Classes e Objetos: O Básico da Orientação a Objetos

No mundo real, dados e ações costumam andar juntos. Um carro tem cor, velocidade e pode acelerar. Um aluno tem nome, nota e pode ser aprovado ou não.

Em Java, essa união de **dados + comportamentos** acontece dentro de uma **classe**. A partir dela, criamos **objetos**.

Pense assim:

- A **classe** é a planta da casa.
- O **objeto** é a casa construída a partir dessa planta.

Você pode construir várias casas com a mesma planta, cada uma com endereço, cor e moradores diferentes.

---

## O que é uma classe?

Uma classe é um **molde**. Ela define:

1. Quais **atributos** (dados) o objeto terá
2. Quais **métodos** (ações) o objeto poderá executar

### Pseudocódigo

```text
CLASSE Pessoa {
    Texto nome;
    Inteiro idade;

    FUNÇÃO apresentar() {
        Mostre "Olá, eu sou " + nome;
    }
}
```

### Em Java

```java
public class Pessoa {
    String nome;
    int idade;

    public void apresentar() {
        System.out.println("Olá, eu sou " + nome + " e tenho " + idade + " anos.");
    }
}
```

Ainda não criamos nenhuma pessoa de verdade — só definimos o molde.

---

## O que é um objeto?

Objeto é uma **instância** da classe: um exemplar concreto criado a partir do molde.

```java
Pessoa p1 = new Pessoa();
p1.nome = "Ana";
p1.idade = 20;
p1.apresentar();
```

**Resultado:**

```text
Olá, eu sou Ana e tenho 20 anos.
```

A palavra `new` cria o objeto na memória.

Você pode criar vários objetos da mesma classe:

```java
Pessoa p1 = new Pessoa();
p1.nome = "Ana";
p1.idade = 20;

Pessoa p2 = new Pessoa();
p2.nome = "João";
p2.idade = 25;

p1.apresentar();
p2.apresentar();
```

**Resultado:**

```text
Olá, eu sou Ana e tenho 20 anos.
Olá, eu sou João e tenho 25 anos.
```

Mesma classe, dois objetos diferentes, cada um com seus próprios valores.

---

## Classe × Objeto

| Conceito | Analogia              | Na prática                         |
|----------|-----------------------|------------------------------------|
| Classe   | Planta / receita      | `Pessoa`, `Carro`, `Produto`       |
| Objeto   | Casa / bolo pronto    | `p1`, `meuCarro`, `notebook`       |
| Atributo | Característica        | `nome`, `idade`, `preco`           |
| Método   | Ação / comportamento  | `apresentar()`, `acelerar()`       |

---

## Atributos

Atributos são as **variáveis da classe**. Eles guardam o estado de cada objeto.

```java
public class Carro {
    String modelo;
    String cor;
    int velocidade;
}
```

Cada objeto `Carro` terá seu próprio `modelo`, `cor` e `velocidade`.

```java
Carro c1 = new Carro();
c1.modelo = "Fusca";
c1.cor = "azul";
c1.velocidade = 0;

Carro c2 = new Carro();
c2.modelo = "Civic";
c2.cor = "preto";
c2.velocidade = 0;
```

Alterar `c1` não muda `c2`. São objetos independentes.

---

## Métodos de instância

Até a aula passada, quase tudo era `static` : métodos “soltos”, sem dono.

Agora os métodos pertencem ao objeto. Eles usam os atributos daquele objeto.

```java
public class Carro {
    String modelo;
    int velocidade;

    public void acelerar(int valor) {
        velocidade = velocidade + valor;
        System.out.println(modelo + " agora está a " + velocidade + " km/h");
    }

    public void frear(int valor) {
        velocidade = velocidade - valor;
        if (velocidade < 0) {
            velocidade = 0;
        }
        System.out.println(modelo + " agora está a " + velocidade + " km/h");
    }
}
```

Uso:

```java
Carro carro = new Carro();
carro.modelo = "Fusca";
carro.velocidade = 0;

carro.acelerar(30);
carro.acelerar(20);
carro.frear(10);
```

**Resultado:**

```text
Fusca agora está a 30 km/h
Fusca agora está a 50 km/h
Fusca agora está a 40 km/h
```

Repare: o método `acelerar` não precisa receber o modelo, ele já “conhece” o objeto em que foi chamado.

---

## Onde fica o `main`?

O `main` continua sendo o ponto de partida do programa. Em geral, ele fica em uma classe separada (por exemplo, `Main`) e usa as outras classes.

### Arquivo `Pessoa.java`

```java
public class Pessoa {
    String nome;
    int idade;

    public void apresentar() {
        System.out.println("Olá, eu sou " + nome);
    }
}
```

### Arquivo `Main.java`

```java
public class Main {
    public static void main(String[] args) {
        Pessoa pessoa = new Pessoa();
        pessoa.nome = "Ana";
        pessoa.idade = 20;
        pessoa.apresentar();
    }
}
```

> **Dica no IntelliJ:** normalmente cada classe pública fica em um arquivo com o mesmo nome (`Pessoa.java`, `Main.java`).

---

## Construtor: como o objeto nasce

Toda vez que você faz `new Pessoa()`, o Java chama um **construtor**.

Se você não escrever nenhum, o Java cria um construtor vazio automaticamente. Por isso isto funciona:

```java
Pessoa p = new Pessoa();
```

Mas você pode (e deve) criar um construtor para já inicializar os atributos:

```java
public class Pessoa {
    String nome;
    int idade;

    public Pessoa(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
    }

    public void apresentar() {
        System.out.println("Olá, eu sou " + nome + " e tenho " + idade + " anos.");
    }
}
```

Uso:

```java
Pessoa p = new Pessoa("Ana", 20);
p.apresentar();
```

Muito melhor do que criar o objeto e depois preencher atributo por atributo.

### O que é `this`?

`this` representa **o próprio objeto**.

Neste trecho:

```java
public Pessoa(String nome, int idade) {
    this.nome = nome;
    this.idade = idade;
}
```

- `nome` (parâmetro) é o valor que chegou na chamada
- `this.nome` é o atributo do objeto

Usamos `this` para não misturar os dois quando têm o mesmo nome.

---

## Exemplo prático: Conta Bancária

```java
public class ContaBancaria {
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
```

Uso no `main`:

```java
ContaBancaria conta = new ContaBancaria("Ana", 100.0);
conta.depositar(50.0);
conta.sacar(30.0);
conta.exibirSaldo();
```

**Resultado:**

```text
Ana | Saldo: R$ 120.0
```

Aqui está a ideia central da POO: a conta **guarda** o saldo e também **sabe** depositar, sacar e exibir.

---

## Exemplo prático: Produto

```java
public class Produto {
    String nome;
    double preco;
    int quantidade;

    public Produto(String nome, double preco, int quantidade) {
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
    }

    public double calcularTotal() {
        return preco * quantidade;
    }

    public void exibir() {
        System.out.println(nome + " | R$ " + preco + " | Qtd: " + quantidade);
        System.out.println("Total: R$ " + calcularTotal());
    }
}
```

Uso:

```java
Produto p = new Produto("Caderno", 12.50, 3);
p.exibir();
```

**Resultado:**

```text
Caderno | R$ 12.5 | Qtd: 3
Total: R$ 37.5
```

---

## `static` × método de objeto

| Tipo                         | Como chama              | Usa atributos do objeto? |
|------------------------------|-------------------------|---------------------------|
| Método `static`              | `Calculos.somar(2, 3)`  | Não                       |
| Método de instância (objeto) | `carro.acelerar(10)`    | Sim                       |

Regra prática para começar:

- Se a ação depende dos dados de um objeto específico → método normal (sem `static`)
- Se é um cálculo genérico, sem “dono” → pode ser `static`

O `main` precisa ser `static` porque o Java o chama antes de existir qualquer objeto.

---

## Erros comuns

### 1. Usar a classe sem criar o objeto

```java
Pessoa.apresentar(); // erro: apresentar precisa de um objeto
```

Correto:

```java
Pessoa p = new Pessoa("Ana", 20);
p.apresentar();
```

### 2. Esquecer o `new`

```java
Pessoa p;
p.nome = "Ana"; // erro: p ainda não aponta para nenhum objeto
```

### 3. Confundir classe com objeto

A classe é o molde. Você não “muda a planta da casa” para pintar uma parede — você pinta **aquela casa** (o objeto).

### 4. Esquecer de inicializar atributos

```java
Pessoa p = new Pessoa();
System.out.println(p.nome); // null, se não atribuiu nada
```

Por isso o construtor ajuda: o objeto já nasce com valores válidos.

---

## Mini mapa mental

```text
Classe Pessoa
 ├── atributos: nome, idade
 ├── construtor: Pessoa(nome, idade)
 └── método: apresentar()

Objeto p1  →  nome = "Ana",  idade = 20
Objeto p2  →  nome = "João", idade = 25
```

---

## Exercícios

### Exercício 1 — Classe Livro

Crie uma classe `Livro` com:

- atributos: `titulo`, `autor`, `paginas`
- método `exibirInfo()` que imprima esses dados

No `main`, crie dois livros diferentes e chame `exibirInfo()` em cada um.

### Exercício 2 — Classe Aluno

Crie a classe `Aluno` com:

- atributos: `nome`, `nota1`, `nota2`
- construtor que receba esses três valores
- método `calcularMedia()` que retorne a média
- método `aprovado()` que retorne `true` se a média for `>= 7.0`
- método `exibirBoletim()` que imprima nome, média e se foi aprovado

Teste com pelo menos dois alunos no `main`.

### Exercício 3 — Classe Retângulo

Crie a classe `Retangulo` com:

- atributos: `largura`, `altura`
- construtor
- método `area()` → retorna `largura * altura`
- método `perimetro()` → retorna `2 * (largura + altura)`
- método `exibir()` → imprime área e perímetro

### Exercício 4 — Classe ContaBancária (completa)

Implemente a `ContaBancaria` desta aula e teste no `main`:

1. Criar uma conta com saldo inicial
2. Depositar um valor
3. Tentar sacar um valor maior que o saldo
4. Sacar um valor válido
5. Exibir o saldo final

### Exercício 5 — Carrinho simples (desafio)

Crie uma classe `ItemCarrinho` com:

- `nome`
- `preco`
- `quantidade`
- método `subtotal()` (`preco * quantidade`)
- método `exibir()`

No `main`:

1. Crie 3 itens
2. Calcule o total do carrinho somando os subtotais
3. Imprima o total

(Por enquanto, pode somar manualmente no `main`. Em aulas futuras, isso vira uma lista/array.)

---
