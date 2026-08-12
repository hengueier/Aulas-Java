# Loops — Repetindo Código sem Repetir Trabalho

Até agora, você aprendeu a guardar valores em variáveis e a tomar decisões com `if`, `else` e `switch`.

Mas imagine o seguinte: você precisa imprimir os números de 1 até 100. Copiar e colar `System.out.println` cem vezes? Funciona… mas ninguém merece isso.

Para situações em que o mesmo bloco de código precisa rodar várias vezes, existem os **loops** (laços de repetição).

Pense em uma esteira de fábrica: enquanto houver peças, o processo continua. Quando a condição deixa de ser verdadeira, a esteira para.

---

## O que é um loop?

Um loop executa um bloco de código **enquanto uma condição for verdadeira**.

Em pseudocódigo:

```text
ENQUANTO condição for verdadeira {
    Execute este código;
}
```

Quando a condição se torna falsa, o programa sai do loop e continua normalmente.

---

## O loop `while`

O `while` significa **"enquanto"**.

Ele verifica a condição **antes** de executar o bloco. Se a condição já começar falsa, o código dentro dele **não roda nenhuma vez**.

### Pseudocódigo

```text
Inteiro contador = 1;

ENQUANTO contador for MENOR OU IGUAL a 5 {
    Mostre o contador;
    contador = contador + 1;
}
```

### Em Java

```java
int contador = 1;

while (contador <= 5) {
    System.out.println(contador);
    contador = contador + 1;
}
```

**Resultado:**

```text
1
2
3
4
5
```

### Cuidado com o loop infinito

Se a condição nunca deixar de ser verdadeira, o programa fica preso para sempre.

```java
int contador = 1;

while (contador <= 5) {
    System.out.println(contador);
    // Esqueceu de incrementar o contador!
}
```

Nesse caso, `contador` permanece `1` para sempre, e a condição `contador <= 5` nunca fica falsa.

> **Regra de ouro:** dentro do `while`, algo precisa mudar a cada volta — senão, você criou um loop infinito.

---

## O loop `do-while`

O `do-while` é parecido com o `while`, com uma diferença importante:

Ele executa o bloco **pelo menos uma vez**, e só depois verifica a condição.

### Pseudocódigo

```text
FAÇA {
    Execute este código;
} ENQUANTO condição for verdadeira;
```

### Em Java

```java
int contador = 1;

do {
    System.out.println(contador);
    contador++;
} while (contador <= 5);
```

### Quando usar `do-while`?

Use quando o código precisa rodar **ao menos uma vez**, mesmo que a condição inicial seja falsa.

Exemplo clássico: pedir uma senha até o usuário acertar.

```java
String senhaCorreta = "java123";
String tentativa;

do {
    tentativa = "java123"; // no mundo real, viria do teclado
    System.out.println("Tentando entrar...");
} while (!tentativa.equals(senhaCorreta));
```

---

## O loop `for`

O `for` é o loop mais usado quando você **já sabe quantas vezes** algo precisa se repetir.

Ele junta em uma linha três coisas:

1. Inicialização
2. Condição
3. Atualização

### Estrutura

```java
for (inicializacao; condicao; atualizacao) {
    // código
}
```

### Pseudocódigo

```text
PARA contador de 1 até 5 {
    Mostre o contador;
}
```

### Em Java

```java
for (int i = 1; i <= 5; i++) {
    System.out.println(i);
}
```

**Resultado:**

```text
1
2
3
4
5
```

### O que cada parte faz?

| Parte          | Exemplo     | Função                                      |
|----------------|-------------|---------------------------------------------|
| Inicialização  | `int i = 1` | Cria o contador e define o valor inicial    |
| Condição       | `i <= 5`    | Decide se o loop continua                   |
| Atualização    | `i++`       | Muda o contador a cada volta (`i = i + 1`)  |

### Contando de trás para frente

```java
for (int i = 5; i >= 1; i--) {
    System.out.println(i);
}
```

**Resultado:**

```text
5
4
3
2
1
```

### Pulando de 2 em 2

```java
for (int i = 0; i <= 10; i += 2) {
    System.out.println(i);
}
```

**Resultado:**

```text
0
2
4
6
8
10
```

---

## `while` × `do-while` × `for`

| Característica        | `while`                         | `do-while`                          | `for`                              |
|-----------------------|----------------------------------|-------------------------------------|------------------------------------|
| Quando verificar      | Antes de executar                | Depois de executar                  | Antes de executar                  |
| Executa ao menos 1x?  | Não                              | Sim                                 | Não                                |
| Melhor para           | Quando não se sabe quantas vezes | Quando precisa rodar pelo menos 1x  | Quando se sabe quantas repetições  |
| Contador embutido?    | Não                              | Não                                 | Sim                                |

---

## Incremento e decremento

Você vai ver bastante estes atalhos:

| Escrita      | Significado        |
|--------------|--------------------|
| `i++`        | `i = i + 1`        |
| `i--`        | `i = i - 1`        |
| `i += 2`     | `i = i + 2`        |
| `i -= 3`     | `i = i - 3`        |
| `i *= 2`     | `i = i * 2`        |

---

## O comando `break` em loops

No `switch`, o `break` encerra o case. Em loops, ele **interrompe o laço por completo**.

```java
for (int i = 1; i <= 10; i++) {
    if (i == 5) {
        break;
    }
    System.out.println(i);
}
```

**Resultado:**

```text
1
2
3
4
```

Quando `i` chega a `5`, o `break` para o loop imediatamente.

---

## O comando `continue`

O `continue` **pula apenas a volta atual** e segue para a próxima.

```java
for (int i = 1; i <= 5; i++) {
    if (i == 3) {
        continue;
    }
    System.out.println(i);
}
```

**Resultado:**

```text
1
2
4
5
```

O número `3` foi pulado, mas o loop continuou.

---

## Loops aninhados

Você também pode colocar um loop dentro de outro.

Exemplo: imprimir uma tabuada simples.

```java
for (int i = 1; i <= 3; i++) {
    for (int j = 1; j <= 3; j++) {
        System.out.println(i + " x " + j + " = " + (i * j));
    }
    System.out.println("---");
}
```

O loop de fora controla a linha; o de dentro controla as colunas.

> **Dica:** quanto mais aninhamentos, mais difícil fica ler o código. Comece simples.

---

## Exemplo prático: soma de 1 até N

```java
int n = 5;
int soma = 0;

for (int i = 1; i <= n; i++) {
    soma = soma + i;
}

System.out.println("Soma = " + soma);
```

**Resultado:**

```text
Soma = 15
```

Porque `1 + 2 + 3 + 4 + 5 = 15`.

---

## Exemplo prático: contagem regressiva

```java
int segundos = 5;

while (segundos > 0) {
    System.out.println(segundos);
    segundos--;
}

System.out.println("Lançar!");
```

**Resultado:**

```text
5
4
3
2
1
Lançar!
```

---

## Exercícios

### Exercício 1 — Contagem Progressiva

Crie um programa que imprima os números de `1` até `20` usando um loop `for`.

```java
public class Main {
    public static void main(String[] args) {
        // Escreva seu código aqui.
    }
}
```

### Exercício 2 — Soma dos Pares

Calcule a soma de todos os números **pares** de `1` até `100`.

Regras:

1. Use um loop.
2. Some apenas os pares.
3. Ao final, imprima o resultado.

Dica: um número é par quando `numero % 2 == 0`.

### Exercício 3 — Tabuada

Peça (ou defina) um número e imprima a tabuada dele de `1` até `10`.

Exemplo com `numero = 7`:

```text
7 x 1 = 7
7 x 2 = 14
...
7 x 10 = 70
```

### Exercício 4 — Senha com Tentativas

Simule um sistema de login com no máximo **3 tentativas**.

- A senha correta é `"java123"`.
- Enquanto a senha estiver errada e ainda houver tentativas, continue pedindo.
- Se acertar, mostre `"Acesso liberado"`.
- Se esgotar as tentativas, mostre `"Acesso bloqueado"`.

Você pode começar com valores fixos nas variáveis e depois evoluir para entrada pelo teclado.

### Exercício 5 — Classificador de Números (desafio)

Percorra os números de `1` até `50` e classifique cada um:

- Se for múltiplo de `3` e de `5`: imprima `"FizzBuzz"`.
- Se for múltiplo só de `3`: imprima `"Fizz"`.
- Se for múltiplo só de `5`: imprima `"Buzz"`.
- Caso contrário: imprima o próprio número.

---

## Resumo

Neste capítulo você aprendeu:

- O que são loops e por que eles evitam repetição manual de código.
- Como usar o `while`.
- Como usar o `do-while` (executa ao menos uma vez).
- Como usar o `for` quando se sabe quantas repetições haverá.
- A diferença entre `while`, `do-while` e `for`.
- Os atalhos `++`, `--`, `+=` e similares.
- Como usar `break` para interromper um loop.
- Como usar `continue` para pular uma repetição.
- Como combinar loops (loops aninhados).

Com condicionais e loops, você já consegue escrever programas que tomam decisões e repetem tarefas — a base de praticamente qualquer software.
