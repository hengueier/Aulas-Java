# Introdução ao Java e Conceitos Básicos de Programação

Java é uma linguagem de Programação Orientada a Objetos (POO). Ela organiza o código em classes e utiliza uma estrutura hierárquica para executar os programas.

Neste material, porém, vamos deixar essa parte mais técnica para depois e começar pelos conceitos fundamentais que existem em praticamente todas as linguagens de programação.

---

## Variáveis

Variáveis são espaços onde podemos armazenar valores. Esses valores podem ser:

- Números
- Textos
- Valores verdadeiro/falso
- Números quebrados (`double`)

Pense em uma expressão matemática:

```text
a == b
```

Isso significa que o valor de `b` será o mesmo valor de `a`.

**Exemplos:**

- Se `a == 10`, então `b == 10`.
- Se `a == "coxinha"`, então `b == "coxinha"`.
- Se `a == verdadeiro`, então `b == verdadeiro`.

Em pseudocódigo, isso seria representado assim:

```text
variavel = "valor";
```

---

## Tipos de dados

Cada tipo de valor possui um nome técnico.

| Tipo de Valor     | Tipo em Java |
|-------------------|--------------|
| Número inteiro    | `int`        |
| Texto             | `String`     |
| Verdadeiro/Falso  | `boolean`    |
| Número decimal    | `double`     |

Como Java é uma linguagem fortemente tipada, precisamos informar o tipo da variável antes de utilizá-la.

**String**

```java
String variavel = "valor";
```

**Número inteiro**

```java
int variavel = 1;
```

**Booleano**

```java
boolean variavel = false;
```

> **Importante:** Se você declarar uma variável como `boolean` e tentar armazenar um texto ou número nela, o Java apresentará um erro de compilação.

---

## Declarando variáveis em Java

```java
String variavel = "valor";
int numero = 10;
boolean ativo = false;
```

Não esqueça do ponto e vírgula (`;`) ao final de cada instrução.

### Utilizando o valor de outra variável

Também podemos utilizar o valor de uma variável para calcular outra.

```java
int variavelA = 10;
int variavelB = 5;

int variavelC = variavelA + variavelB;
```

**Resultado:**

```text
variavelC = 15
```

---

## Condicionais

Agora vamos conhecer uma das estruturas mais importantes da programação: o `if`.

A palavra `if` significa **"se"**.

Ela permite que o programa tome decisões dependendo de uma condição.

Imagine uma estrada que se divide em dois caminhos. Você escolhe um deles dependendo da situação.

Por exemplo:

- Se estiver com pressa, pega o caminho mais curto.
- Se quiser mais segurança, pega o caminho mais longo.

O programa faz exatamente a mesma coisa.

### Exemplo em pseudocódigo

```text
Inteiro variavel = 10;

SE variavel é MAIOR que 5 {
    Execute este código;
}

Continue executando o restante do programa.
```

Como o valor é `10`, a condição é verdadeira.

Agora veja outro exemplo:

```text
Inteiro variavel = 3;

SE variavel é MAIOR que 5 {
    // Não executa
}

Continue executando o restante do programa.
```

Nesse caso, como `3` não é maior que `5`, o código dentro do `SE` não será executado.

### Escrevendo isso em Java

```java
int numero = 10;

if (numero > 5) {
    executarCodigo();
}
```

O símbolo `>` significa **maior que**.

### Operadores de comparação

| Operador | Significado      |
|----------|------------------|
| `>`      | Maior que        |
| `<`      | Menor que        |
| `>=`     | Maior ou igual   |
| `<=`     | Menor ou igual   |
| `==`     | Igual a          |
| `!=`     | Diferente de     |

### Diferença entre `=` e `==`

Essa é uma das dúvidas mais comuns de quem está começando.

**Atribuição (`=`)**

Serve para guardar um valor em uma variável.

```java
int idade = 20;
```

**Comparação (`==`)**

Serve para verificar se dois valores são iguais.

```java
if (idade == 20) {
    System.out.println("Tem 20 anos");
}
```

### O `else`

Junto do `if`, existe o `else`, que significa **"senão"**.

```java
if (condicao) {
    // Executa se a condição for verdadeira
} else {
    // Executa se a condição for falsa
}
```

Somente um dos blocos será executado.

---

## Switch Case

Até agora vimos que o `if/else` funciona muito bem quando existem poucas possibilidades.

Mas imagine um programa que precisa escolher entre 10 ou 20 opções diferentes. Nesses casos, usar vários `else if` deixa o código grande e difícil de ler.

Para isso existe o `switch`.

### O que é o Switch?

O `switch` compara uma única variável com vários valores possíveis. Em vez de escrever vários `if`, criamos vários `cases`.

### Pseudocódigo

```text
Escolha (variavel) {

    Caso valor1:
        Faça isso;
        Pare;

    Caso valor2:
        Faça aquilo;
        Pare;

    Caso valor3:
        Faça outra coisa;
        Pare;

    Padrão:
        Faça isso;
}
```

### Exemplo: Dias da semana

```java
int dia = 3;
int horasDeEstudo;

switch (dia) {

    case 1:
        horasDeEstudo = 2;
        break;

    case 2:
        horasDeEstudo = 3;
        break;

    case 3:
        horasDeEstudo = 4;
        break;

    case 4:
        horasDeEstudo = 3;
        break;

    case 5:
        horasDeEstudo = 5;
        break;

    case 6:
        horasDeEstudo = 1;
        break;

    case 7:
        horasDeEstudo = 0;
        break;

    default:
        horasDeEstudo = -1;
        break;
}
```

Como `dia = 3`, a variável `horasDeEstudo` receberá o valor `4`.

### Comparando com If/Else

O mesmo código usando `if/else` ficaria assim:

```java
int dia = 3;
int horasDeEstudo;

if (dia == 1) {
    horasDeEstudo = 2;
} else if (dia == 2) {
    horasDeEstudo = 3;
} else if (dia == 3) {
    horasDeEstudo = 4;
} else if (dia == 4) {
    horasDeEstudo = 3;
} else if (dia == 5) {
    horasDeEstudo = 5;
} else if (dia == 6) {
    horasDeEstudo = 1;
} else if (dia == 7) {
    horasDeEstudo = 0;
} else {
    horasDeEstudo = -1;
}
```

O `switch` deixa esse tipo de situação muito mais organizado.

### O comando `break`

O `break` encerra a execução do `switch` assim que um caso é encontrado.

```java
switch (dia) {

    case 1:
        System.out.println("Segunda");
        break;

    case 2:
        System.out.println("Terça");
        break;
}
```

### O que acontece sem o `break`?

```java
int dia = 3;
String mensagem;

switch (dia) {

    case 1:
        mensagem = "Segunda";

    case 2:
        mensagem = "Terça";

    case 3:
        mensagem = "Quarta";

    case 4:
        mensagem = "Quinta";

    case 5:
        mensagem = "Sexta";

    default:
        mensagem = "Fim de semana";
}
```

Mesmo que o valor seja `3`, o programa continuará executando todos os casos seguintes.

Esse comportamento é chamado de **fall-through**. Por isso, normalmente utilizamos `break`.

### O `default`

O `default` funciona como o `else` do `switch`. Ele é executado quando nenhum caso corresponde ao valor informado.

```java
int dia = 10;
String tipoDoDia;

switch (dia) {

    case 1:
    case 2:
    case 3:
    case 4:
    case 5:
        tipoDoDia = "Dia útil";
        break;

    case 6:
    case 7:
        tipoDoDia = "Fim de semana";
        break;

    default:
        tipoDoDia = "Dia inválido";
        break;
}
```

Como `dia = 10`, o resultado será:

```text
Dia inválido
```

### Quando usar Switch?

Utilize `switch` quando:

- Existe apenas uma variável sendo comparada.
- Os valores são conhecidos previamente.
- Existem muitas opções possíveis.
- Você está comparando valores exatos.

### Exemplo com String

```java
String estacao = "verao";
String clima;

switch (estacao) {

    case "verao":
        clima = "Quente e ensolarado";
        break;

    case "inverno":
        clima = "Frio e chuvoso";
        break;

    case "primavera":
        clima = "Ameno e florido";
        break;

    case "outono":
        clima = "Fresco e ventoso";
        break;

    default:
        clima = "Estação desconhecida";
        break;
}
```

### If/Else × Switch

| Característica | If/Else                    | Switch                 |
|----------------|----------------------------|------------------------|
| Melhor para    | Condições complexas        | Muitos valores possíveis |
| Compara        | Qualquer expressão booleana | Valores específicos   |
| Organização    | Pode ficar grande          | Mais limpo             |

### Agrupando vários cases

Quando vários casos executam exatamente o mesmo código, basta colocá-los juntos.

```java
int dia = 3;
String mensagem;

switch (dia) {

    case 1:
    case 2:
    case 3:
    case 4:
    case 5:
        mensagem = "Bora trabalhar!";
        break;

    case 6:
    case 7:
        mensagem = "Finalmente, descanso!";
        break;

    default:
        mensagem = "Dia inválido";
        break;
}
```

Isso evita repetição de código e melhora a legibilidade.

---

## Exercícios

### Exercício 1 — Calculadora de Gorjeta

Você foi a um restaurante e deseja calcular uma gorjeta de 10% sobre uma conta de R$ 150,00.

Crie um programa em Java que:

1. Crie uma variável para armazenar o valor da conta.
2. Crie uma variável para armazenar a porcentagem da gorjeta.
3. Calcule o valor da gorjeta.
4. Calcule o valor total (conta + gorjeta).

```java
public class Main {
    public static void main(String[] args) {

        double valorDaConta = 150.00;
        double porcentagemDaGorgeta = 0.10;

        double gorgeta = valorDaConta * porcentagemDaGorgeta;

        double valorTotal = gorgeta + valorDaConta;

    }
}
```

### Exercício 2 — Conversão de Idade

João tem 25 anos.

Considerando que cada ano possui 365 dias, calcule:

- Quantos meses ele viveu.
- Quantos dias ele viveu.
- Quantas horas ele viveu.

Crie variáveis para armazenar todos esses valores.

### Exercício 3 — Classificador de Triângulos

Crie um programa que receba três lados de um triângulo e determine sua classificação.

**Classificações**

- **Equilátero:** todos os lados iguais.
- **Isósceles:** dois lados iguais.
- **Escaleno:** todos os lados diferentes.

**Regra importante**

Antes de classificar, verifique se os valores realmente formam um triângulo.

Para existir um triângulo:

> A soma de dois lados deve ser maior que o terceiro lado.

```java
int lado1 = 5;
int lado2 = 5;
int lado3 = 5;

// Escreva seu código aqui.
// Primeiro verifique se forma um triângulo.
// Depois faça a classificação.
```

---

## Resumo

Neste capítulo você aprendeu:

- O que são variáveis.
- Os principais tipos de dados (`int`, `double`, `String` e `boolean`).
- Como declarar variáveis em Java.
- Como utilizar operadores de comparação.
- Como utilizar estruturas condicionais (`if` e `else`).
- Quando utilizar `switch case`.
- A importância do comando `break`.
- Como utilizar `default`.
- Como agrupar vários `case` em uma única condição.

Esses conceitos formam a base da programação em Java e serão utilizados constantemente nos próximos capítulos.
