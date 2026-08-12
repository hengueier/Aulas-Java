# Funções (Métodos): Código Reutilizável

Até agora, você escreveu quase tudo dentro do `main`. Funciona mas imagina precisar calcular uma média em cinco lugares diferentes do programa. Copiar e colar o mesmo bloco cinco vezes?

Quando o cálculo mudar, você terá que alterar em cinco pontos. Esqueceu um? Bug.

Para isso existem as **funções**. Em Java, elas se chamam **métodos**: blocos de código com nome, que você pode chamar sempre que precisar.

Pense em uma receita de bolo. Em vez de reescrever o modo de preparo toda vez que alguém pede um bolo, você aponta para a receita: “faz o bolo de chocolate”. O método é essa receita.

---

## O que é um método?

Um método é um pedaço de código que:

1. Tem um **nome**
2. Pode receber **valores de entrada** (parâmetros)
3. Pode **devolver** um resultado (`return`)
4. Pode ser **chamado** várias vezes

### Pseudocódigo

```text
FUNÇÃO saudar(nome) {
    Mostre "Olá, " + nome;
}

saudar("Ana");
saudar("João");
```

### Em Java

```java
public class Main {
    public static void main(String[] args) {
        saudar("Ana");
        saudar("João");
    }

    public static void saudar(String nome) {
        System.out.println("Olá, " + nome);
    }
}
```

**Resultado:**

```text
Olá, Ana
Olá, João
```

O mesmo código rodou duas vezes, só mudou o valor passado.

> **Nota:** em Java, métodos ficam **dentro de uma classe**. Por enquanto, vamos escrever tudo na mesma classe do `main`. Mais à frente, quando entrarmos em POO, isso ganha mais sentido.

---

## Anatomia de um método

```java
public static void saudar(String nome) {
    System.out.println("Olá, " + nome);
}
```

| Parte            | Exemplo          | Função                                      |
|------------------|------------------|---------------------------------------------|
| Visibilidade     | `public`         | Quem pode chamar o método                   |
| `static`         | `static`         | Permite chamar sem criar objeto (por enquanto, use sempre) |
| Tipo de retorno  | `void`           | O que o método devolve (`void` = nada)      |
| Nome             | `saudar`         | Como você chama o método                    |
| Parâmetros       | `String nome`    | Valores que entram                          |
| Corpo            | `{ ... }`        | O código que executa                        |

Por enquanto, foque em três coisas: **nome**, **parâmetros** e **retorno**.

---

## Métodos sem retorno (`void`)

Quando o método só **faz** alguma coisa (imprimir, atualizar, avisar) e não precisa devolver um valor, o tipo de retorno é `void`.

```java
public static void mostrarMensagem() {
    System.out.println("Bem-vindo ao Java!");
}
```

Chamada:

```java
mostrarMensagem();
```

---

## Métodos com retorno

Quando o método **calcula** algo e você precisa usar o resultado, ele devolve um valor com `return`.

### Pseudocódigo

```text
FUNÇÃO somar(a, b) {
    RETORNE a + b;
}

resultado = somar(3, 7);
Mostre resultado;
```

### Em Java

```java
public static int somar(int a, int b) {
    return a + b;
}
```

Uso:

```java
int resultado = somar(3, 7);
System.out.println(resultado); // 10
```

Ou direto:

```java
System.out.println(somar(3, 7));
```

### O tipo do `return` importa

Se o método declara `int`, ele **precisa** retornar um `int`.

```java
public static int dobrar(int numero) {
    return numero * 2;
}
```

| Tipo de retorno | Exemplo de valor devolvido |
|-----------------|----------------------------|
| `int`           | `10`                       |
| `double`        | `3.14`                     |
| `boolean`       | `true` / `false`           |
| `String`        | `"olá"`                    |
| `void`          | (não devolve nada)         |

Quando o Java encontra um `return`, ele **sai do método imediatamente** e devolve o valor.

---

## Parâmetros

Parâmetros são as **entradas** do método — informações que ele precisa para trabalhar.

```java
public static void apresentar(String nome, int idade) {
    System.out.println(nome + " tem " + idade + " anos.");
}
```

Chamada:

```java
apresentar("Maria", 28);
```

**Resultado:**

```text
Maria tem 28 anos.
```

### Ordem e tipo

A ordem e o tipo dos argumentos precisam bater com a declaração:

```java
apresentar("Maria", 28);   // certo
apresentar(28, "Maria");   // erro: tipos trocados
apresentar("Maria");       // erro: faltou um parâmetro
```

### Parâmetro × argumento

| Termo       | Onde aparece                         | Exemplo        |
|-------------|--------------------------------------|----------------|
| Parâmetro   | Na declaração do método              | `String nome`  |
| Argumento   | No momento da chamada                | `"Maria"`      |

Em outras palavras: parâmetro é o “espaço reservado”; argumento é o valor real que você passa.

---

## Por que usar métodos?

### 1. Evitar repetição

**Sem método:**

```java
System.out.println("===== RELATÓRIO =====");
System.out.println("===== RELATÓRIO =====");
System.out.println("===== RELATÓRIO =====");
```

**Com método:**

```java
public static void titulo() {
    System.out.println("===== RELATÓRIO =====");
}

titulo();
titulo();
titulo();
```

Se o texto mudar, você altera **em um lugar só**.

### 2. Organizar o código

Em vez de um `main` gigante, você divide o programa em pedaços com nomes claros:

```java
public static void main(String[] args) {
    mostrarBoasVindas();
    calcularMedia();
    encerrar();
}
```

Fica mais fácil de ler e de manter.

### 3. Testar pedaço por pedaço

Um método pequeno e bem nomeado é mais fácil de entender e corrigir do que 80 linhas misturadas no `main`.

---

## Escopo: o que existe onde?

Variáveis criadas **dentro** de um método só existem ali.

```java
public static void exemplo() {
    int x = 10;
    System.out.println(x);
}

public static void main(String[] args) {
    exemplo();
    // System.out.println(x); // erro: x não existe aqui
}
```

Parâmetros também só existem dentro do método:

```java
public static void mostrar(int numero) {
    System.out.println(numero);
}
```

Fora de `mostrar`, a variável `numero` não existe.

---

## Exemplo prático: média de notas

```java
public class Main {
    public static void main(String[] args) {
        double media = calcularMedia(8.0, 7.5, 9.0);
        System.out.println("Média = " + media);

        if (aprovado(media)) {
            System.out.println("Aprovado!");
        } else {
            System.out.println("Reprovado.");
        }
    }

    public static double calcularMedia(double n1, double n2, double n3) {
        return (n1 + n2 + n3) / 3.0;
    }

    public static boolean aprovado(double media) {
        return media >= 7.0;
    }
}
```

**Resultado:**

```text
Média = 8.1666...
Aprovado!
```

Repare: `calcularMedia` devolve um `double`; `aprovado` devolve um `boolean`. Cada método tem uma responsabilidade clara.

---

## Exemplo prático: tabuada com método

Na aula de loops, você fez a tabuada. Agora, encapsulamos isso em um método:

```java
public static void mostrarTabuada(int numero) {
    for (int i = 1; i <= 10; i++) {
        System.out.println(numero + " x " + i + " = " + (numero * i));
    }
}
```

Uso:

```java
mostrarTabuada(7);
mostrarTabuada(3);
```

Mesma lógica, reutilizada para qualquer número.

---

## Exemplo prático: maior entre dois números

```java
public static int maior(int a, int b) {
    if (a > b) {
        return a;
    } else {
        return b;
    }
}
```

Ou, de forma mais curta:

```java
public static int maior(int a, int b) {
    if (a > b) {
        return a;
    }
    return b;
}
```

Uso:

```java
System.out.println(maior(10, 4)); // 10
System.out.println(maior(2, 9));  // 9
```

---

## Métodos que chamam outros métodos

Um método pode chamar outro. Isso é normal — e desejável.

```java
public static void main(String[] args) {
    processarPedido(3, 15.50);
}

public static void processarPedido(int quantidade, double precoUnitario) {
    double total = calcularTotal(quantidade, precoUnitario);
    exibirTotal(total);
}

public static double calcularTotal(int quantidade, double precoUnitario) {
    return quantidade * precoUnitario;
}

public static void exibirTotal(double total) {
    System.out.println("Total a pagar: R$ " + total);
}
```

Cada método faz uma coisa. O programa fica mais claro.

---

## Erros comuns

### 1. Esquecer de chamar o método

```java
public static void saudar() {
    System.out.println("Oi!");
}

public static void main(String[] args) {
    // saudar();  <- se não chamar, nada acontece
}
```

Declarar não executa. Você precisa **chamar**.

### 2. Ignorar o valor retornado

```java
somar(2, 3); // calcula 5... e joga fora
```

Se precisa do resultado, guarde ou use:

```java
int resultado = somar(2, 3);
```

### 3. Tipo de retorno errado

```java
public static int metade(int n) {
    return n / 2.0; // erro: 2.0 é double, o método prometeu int
}
```

### 4. Usar `return` e continuar escrevendo código inalcançável

```java
public static int exemplo() {
    return 10;
    System.out.println("Isso nunca roda"); // código morto
}
```

---

## Resumo rápido

| Conceito        | Em uma frase                                      |
|-----------------|---------------------------------------------------|
| Método          | Bloco de código reutilizável com nome             |
| `void`          | Método que não devolve valor                      |
| `return`        | Devolve um valor e encerra o método               |
| Parâmetro       | Entrada declarada no método                       |
| Argumento       | Valor real passado na chamada                     |
| Escopo          | Variáveis do método só existem dentro dele        |

---

## Exercícios

### Exercício 1 — Saudação Personalizada

Crie um método `saudar` que receba um `String nome` e imprima:

```text
Olá, NOME! Bem-vindo(a) ao curso de Java.
```

Chame o método pelo menos duas vezes no `main`, com nomes diferentes.

```java
public class Main {
    public static void main(String[] args) {
        // Chame saudar aqui
    }

    // Escreva o método saudar aqui
}
```

### Exercício 2 — Calculadora Simples

Crie quatro métodos:

- `somar(int a, int b)` → retorna a soma
- `subtrair(int a, int b)` → retorna a subtração
- `multiplicar(int a, int b)` → retorna a multiplicação
- `dividir(int a, int b)` → retorna a divisão (use `double`)

No `main`, teste cada um e imprima os resultados.

### Exercício 3 — Par ou Ímpar

Crie um método:

```java
public static boolean ehPar(int numero)
```

Ele deve retornar `true` se o número for par, e `false` caso contrário.

No `main`, teste com alguns valores e imprima mensagens como:

```text
4 é par? true
7 é par? false
```

### Exercício 4 — Fatorial com Loop

Crie um método `fatorial(int n)` que calcule o fatorial de `n` usando um loop (`for` ou `while`).

Exemplos:

- `fatorial(5)` → `120` (porque `5 × 4 × 3 × 2 × 1`)
- `fatorial(0)` → `1`

Imprima o resultado no `main`.

### Exercício 5 — Sistema de Notas (desafio)

Crie um pequeno programa com métodos separados para:

1. `calcularMedia(double n1, double n2, double n3)` — retorna a média
2. `conceito(double media)` — retorna `"A"`, `"B"`, `"C"` ou `"D"` conforme a faixa:
   - `>= 9.0` → `"A"`
   - `>= 7.0` → `"B"`
   - `>= 5.0` → `"C"`
   - abaixo → `"D"`
3. `aprovado(double media)` — retorna `true` se média `>= 7.0`
4. `exibirBoletim(String aluno, double media, String conceito, boolean passou)` — imprime um resumo legível

No `main`, monte o fluxo chamando esses métodos.

Exemplo de saída esperada:

```text
Aluno: Ana
Média: 8.5
Conceito: B
Situação: Aprovado
```

---
