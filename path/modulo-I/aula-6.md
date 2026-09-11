# Arrays e Listas: Guardando Vários Valores

Até agora, cada variável guardava **um** valor: um `int`, um `String`, um objeto.

Mas e se você precisar das notas de 30 alunos? Criar `nota1`, `nota2`, `nota3`… até `nota30`? Funciona… e vira um pesadelo.

Para isso existem as **coleções**: estruturas que guardam vários valores sob um mesmo nome. Nesta aula vamos ver duas:

1. **Array** — tamanho fixo, mais “cru”
2. **ArrayList** — tamanho flexível, com métodos como adicionar e remover (o famosos “push/pop” de outras linguagens)

Na aula de classes, o desafio do carrinho pediu para somar itens “na mão”. Agora você tem a ferramenta certa para isso.

---

## O que é um array?

Um array é uma **sequência de caixinhas** do mesmo tipo, numeradas a partir de `0`.

Pense em um prédio de apartamentos:

- O prédio tem um nome (`notas`)
- Cada apartamento tem um número (`0`, `1`, `2`…)
- Dentro de cada um mora um valor (`7.5`, `8.0`, `6.0`)

### Pseudocódigo

```text
Array de Decimais notas com tamanho 3;

notas[0] = 7.5;
notas[1] = 8.0;
notas[2] = 6.0;

Mostre notas[1];  // 8.0
```

### Em Java

```java
double[] notas = new double[3];

notas[0] = 7.5;
notas[1] = 8.0;
notas[2] = 6.0;

System.out.println(notas[1]); // 8.0
```

---

## Declarando e criando arrays

Há duas formas comuns.

### 1. Criar vazio e preencher depois

```java
int[] numeros = new int[5]; // 5 posições: 0 a 4
numeros[0] = 10;
numeros[1] = 20;
```

No começo, valores numéricos começam em `0`, `boolean` em `false`, e referências (`String`, objetos) em `null`.

### 2. Criar já com valores

```java
int[] numeros = {10, 20, 30, 40, 50};
String[] frutas = {"maçã", "banana", "uva"};
```

Mais curto e legível quando você já sabe o conteúdo.

### Anatomia

```java
tipo[] nome = new tipo[tamanho];
```

| Parte     | Exemplo        | Função                         |
|-----------|----------------|--------------------------------|
| Tipo      | `int`          | O que cada posição guarda      |
| `[]`      | `[]`           | Indica que é um array          |
| Nome      | `numeros`      | Como você acessa o array       |
| `new`     | `new int[5]`   | Reserva espaço na memória      |
| Tamanho   | `5`            | Quantas posições existem       |

---

## Índice: a numeração começa em 0

Esta é uma das pegadinhas mais clássicas da programação.

```java
String[] cores = {"vermelho", "verde", "azul"};
// índices:          0           1        2
```

- Primeiro elemento → índice `0`
- Segundo → índice `1`
- Último → índice `tamanho - 1`

```java
System.out.println(cores[0]); // vermelho
System.out.println(cores[2]); // azul
```

### `length`: tamanho do array

```java
System.out.println(cores.length); // 3
```

`length` **não** é método (sem `()`). É um atributo do array.

### Erro clássico: índice inválido

```java
System.out.println(cores[3]); // ArrayIndexOutOfBoundsException
```

Se o array tem tamanho `3`, os índices válidos são `0`, `1` e `2`. Não existe `3`.

---

## Percorrendo arrays com `for`

Como você já sabe o tamanho, o `for` combina perfeitamente.

```java
int[] numeros = {10, 20, 30, 40, 50};

for (int i = 0; i < numeros.length; i++) {
    System.out.println("Posição " + i + ": " + numeros[i]);
}
```

**Resultado:**

```text
Posição 0: 10
Posição 1: 20
Posição 2: 30
Posição 3: 40
Posição 4: 50
```

### `for-each`: quando você só precisa do valor

```java
for (int numero : numeros) {
    System.out.println(numero);
}
```

Mais curto. O detalhe: você **não** tem o índice `i` nessa forma.

Use `for` clássico quando precisar da posição; use `for-each` quando só precisa ler os valores.

---

## Exemplos práticos com array

### Soma e média

```java
double[] notas = {7.0, 8.5, 6.0, 9.0};
double soma = 0;

for (int i = 0; i < notas.length; i++) {
    soma = soma + notas[i];
}

double media = soma / notas.length;
System.out.println("Média = " + media);
```

### Maior valor

```java
int[] valores = {4, 12, 7, 19, 3};
int maior = valores[0];

for (int i = 1; i < valores.length; i++) {
    if (valores[i] > maior) {
        maior = valores[i];
    }
}

System.out.println("Maior = " + maior); // 19
```

### Array de objetos

Na aula de classes você criou `Produto`, `Aluno`, etc. Arrays também guardam objetos:

```java
Produto[] itens = new Produto[3];
itens[0] = new Produto("Caderno", 12.50, 2);
itens[1] = new Produto("Caneta", 3.00, 5);
itens[2] = new Produto("Borracha", 1.50, 1);
```

---

## Limitação do array: tamanho fixo

Depois de criado, o array **não cresce e não encolhe**.

```java
int[] numeros = new int[3];
// impossível "adicionar uma 4ª posição" no mesmo array
```

Se você precisa:

- adicionar itens dinamicamente
- remover o último
- inserir no meio

…o array sozinho fica desajeitado. Aí entra o **ArrayList**.

---

## ArrayList: a lista que muda de tamanho

`ArrayList` é uma lista dinâmica da biblioteca padrão do Java (`java.util`).

Analogia:

- **Array** = gaveta com número fixo de divisórias
- **ArrayList** = fila que cresce e encolhe conforme você coloca ou tira gente

### Import necessário

```java
import java.util.ArrayList;
```

### Criando uma lista

```java
ArrayList<String> frutas = new ArrayList<>();
```

O `<String>` diz o tipo dos elementos. Isso se chama **generics**: a lista só aceita `String`.

Outros exemplos:

```java
ArrayList<Integer> numeros = new ArrayList<>();
ArrayList<Double> notas = new ArrayList<>();
ArrayList<Produto> produtos = new ArrayList<>();
```

> **Atenção:** com tipos primitivos (`int`, `double`, `boolean`), use as versões “objeto”: `Integer`, `Double`, `Boolean`. O Java converte automaticamente na maioria dos casos.

---

## Métodos do ArrayList (push, pop e companhia)

Se você veio de JavaScript, Python ou similar, provavelmente conhece `push`, `pop`, `shift`, `unshift`.

Em Java, os nomes são outros — a ideia é a mesma.

| Ideia (outras linguagens) | Em ArrayList              | O que faz                                      |
|---------------------------|---------------------------|------------------------------------------------|
| `push` / `append`         | `add(elemento)`           | Adiciona no **final**                          |
| `pop`                     | `remove(size() - 1)`      | Remove o **último**                            |
| `shift`                   | `remove(0)`               | Remove o **primeiro**                          |
| acesso por índice         | `get(indice)`             | Lê o valor na posição                          |
| troca valor               | `set(indice, valor)`      | Substitui o valor na posição                   |
| tamanho                   | `size()`                  | Quantos elementos existem agora                |
| está vazia?               | `isEmpty()`               | `true` se não tem ninguém                      |
| contém?                   | `contains(elemento)`      | Verifica se o valor existe                     |
| limpar tudo               | `clear()`                 | Remove todos                                   |
| inserir no meio           | `add(indice, elemento)`   | Empurra os outros para a frente                |
| remover por valor         | `remove(elemento)`        | Remove a **primeira** ocorrência desse valor   |

### `add` — o “push”

```java
ArrayList<String> fila = new ArrayList<>();

fila.add("Ana");
fila.add("Bruno");
fila.add("Carla");

System.out.println(fila); // [Ana, Bruno, Carla]
```

### `get` e `set`

```java
System.out.println(fila.get(0)); // Ana

fila.set(1, "Bia");
System.out.println(fila); // [Ana, Bia, Carla]
```

### “pop” — remover o último

O ArrayList **não tem** um método chamado `pop`. Você remove pelo índice do último:

```java
String ultimo = fila.remove(fila.size() - 1);
System.out.println(ultimo); // Carla
System.out.println(fila);   // [Ana, Bia]
```

`remove(indice)` devolve o elemento removido — igualzinho a um `pop` clássico.

### Remover o primeiro (“shift”)

```java
String primeiro = fila.remove(0);
System.out.println(primeiro); // Ana
```

### `add` com índice — inserir no meio

```java
ArrayList<String> nomes = new ArrayList<>();
nomes.add("Ana");
nomes.add("Carla");
nomes.add(1, "Bruno"); // entra na posição 1

System.out.println(nomes); // [Ana, Bruno, Carla]
```

---

## Percorrendo um ArrayList

### Com `for` e índice

```java
for (int i = 0; i < frutas.size(); i++) {
    System.out.println(frutas.get(i));
}
```

Repare: em array era `.length` e `frutas[i]`. Em ArrayList é `.size()` e `frutas.get(i)`.

### Com `for-each`

```java
for (String fruta : frutas) {
    System.out.println(fruta);
}
```

---

## Exemplo prático: lista de compras

```java
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> compras = new ArrayList<>();

        compras.add("Arroz");
        compras.add("Feijão");
        compras.add("Café");

        System.out.println("Itens: " + compras.size());

        for (String item : compras) {
            System.out.println("- " + item);
        }

        // "pop": tirou o último da lista
        String removido = compras.remove(compras.size() - 1);
        System.out.println("Removido: " + removido);
        System.out.println("Agora: " + compras);
    }
}
```

**Resultado:**

```text
Itens: 3
- Arroz
- Feijão
- Café
Removido: Café
Agora: [Arroz, Feijão]
```

---

## Exemplo prático: notas com ArrayList

```java
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Double> notas = new ArrayList<>();
        notas.add(7.5);
        notas.add(8.0);
        notas.add(6.5);

        double soma = 0;
        for (double nota : notas) {
            soma = soma + nota;
        }

        double media = soma / notas.size();
        System.out.println("Média = " + media);
    }
}
```

Se amanhã entrar mais uma prova, basta `notas.add(9.0)`. Com array fixo, você teria que recriar tudo.

---

## Exemplo prático: carrinho (evolução da aula 4)

```java
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Produto> carrinho = new ArrayList<>();

        carrinho.add(new Produto("Caderno", 12.50, 2));
        carrinho.add(new Produto("Caneta", 3.00, 5));
        carrinho.add(new Produto("Borracha", 1.50, 1));

        double total = 0;
        for (Produto item : carrinho) {
            total = total + item.calcularTotal();
            item.exibir();
        }

        System.out.println("Total do carrinho: R$ " + total);
    }
}
```

Agora o carrinho cresce de verdade: cada `add` é um novo item.

---

## Array × ArrayList

| Característica     | Array                         | ArrayList                          |
|--------------------|-------------------------------|------------------------------------|
| Tamanho            | Fixo                          | Dinâmico                           |
| Sintaxe de acesso  | `lista[i]`                    | `lista.get(i)`                     |
| Tamanho            | `lista.length`                | `lista.size()`                     |
| Adicionar no fim   | Manual / recriar              | `add(elemento)`                    |
| Remover            | Manual / trabalhoso           | `remove(...)`                      |
| Tipo               | Aceita primitivos direto      | Usa `Integer`, `Double`, etc.      |
| Quando usar        | Tamanho conhecido e estável   | Tamanho muda com frequência        |

Regra prática:

- Sabe exatamente quantos elementos são e isso não muda → **array**
- Vai adicionar/remover durante o programa → **ArrayList**

---

## Mini “tradutor” push/pop

Se alguém te mostrar código de outra linguagem:

```text
lista.push("x")     →  lista.add("x")
lista.pop()         →  lista.remove(lista.size() - 1)
lista[0]            →  lista.get(0)   (no ArrayList)
lista.length        →  lista.size()   (no ArrayList)
```

Você não precisa decorar todos os nomes de uma vez. Comece com: `add`, `get`, `set`, `remove`, `size`.

---

## Erros comuns

### 1. Confundir `length` com `size()`

```java
int[] a = {1, 2, 3};
ArrayList<Integer> b = new ArrayList<>();

a.length;   // array
b.size();   // ArrayList
```

### 2. Usar `[]` em ArrayList

```java
frutas[0];      // funciona em array
frutas.get(0);  // ArrayList
```

### 3. Estourar o índice

Tanto array quanto ArrayList quebram se o índice não existir.

```java
lista.get(10); // se só tem 3 elementos → Exception
```

### 4. Esquecer o `import`

Sem `import java.util.ArrayList;`, o compilador não encontra a classe.

### 5. Achar que array tem `add` / `pop`

Array **não** tem esses métodos. Se precisa disso, use `ArrayList`.

---

## Resumo rápido

| Conceito     | Em uma frase                                           |
|--------------|--------------------------------------------------------|
| Array        | Sequência de tamanho fixo, índice começando em 0       |
| `length`     | Tamanho do array                                       |
| ArrayList    | Lista dinâmica com métodos prontos                     |
| `add`        | Equivalente ao “push”                                  |
| `remove`     | Remove por índice (último índice = “pop”)              |
| `get` / `set`| Ler e alterar posição                                  |
| `size()`     | Quantos elementos a lista tem agora                    |

---

## Exercícios

### Exercício 1 — Array de temperaturas

Crie um array `double[]` com 7 temperaturas (uma por dia).

1. Imprima todas com um `for`
2. Calcule a média da semana
3. Encontre a maior temperatura

```java
public class Main {
    public static void main(String[] args) {
        double[] temps = {28.5, 30.0, 27.0, 29.5, 31.0, 26.5, 28.0};
        // Escreva seu código aqui.
    }
}
```

### Exercício 2 — Busca em array

Crie um array de `String` com nomes. Percorra o array e diga se um nome procurado existe ou não.

Exemplo: procurar `"Ana"` em `{"João", "Ana", "Pedro"}`.

### Exercício 3 — Lista de tarefas (ArrayList)

Crie um `ArrayList<String>` de tarefas:

1. Adicione pelo menos 4 tarefas com `add`
2. Imprima a lista
3. Remova a última (simulando `pop`)
4. Remova a primeira
5. Imprima o tamanho final com `size()`

### Exercício 4 — Média com ArrayList

Peça (ou defina) várias notas em um `ArrayList<Double>`, calcule a média e diga se o aluno foi aprovado (`média >= 7.0`).

### Exercício 5 — Carrinho com ArrayList (desafio)

Usando a classe `Produto` (ou `ItemCarrinho`) das aulas anteriores:

1. Crie um `ArrayList` de produtos
2. Adicione 3 ou mais itens
3. Percorra a lista e some os totais
4. Remova um item
5. Recalcule e imprima o novo total

Extra: encapsule o carrinho em uma classe `Carrinho` com métodos `adicionar`, `removerUltimo`, `calcularTotal` e `exibir`.

---

Com arrays e ArrayList, você deixa de pensar em “uma variável por valor” e passa a trabalhar com **coleções** — base para quase todo sistema real: turmas, estoques, filas, feeds, carrinhos.
