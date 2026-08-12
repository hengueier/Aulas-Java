# Encapsulamento: Protegendo os Dados da Classe

Na aula passada, você criou classes com atributos e métodos. Funcionava, mas havia um problema:

qualquer um podia alterar os dados do objeto **diretamente**.

```java
ContaBancaria conta = new ContaBancaria("Ana", 100.0);
conta.saldo = -999999; // ninguém deveria poder fazer isso
```

Saldo negativo absurdo? Idade `-10`? Preço negativo? Se os atributos estão abertos, o programa aceita qualquer coisa.

**Encapsulamento** é a ideia de esconder os detalhes internos e controlar o acesso aos dados. Em vez de mexer direto no atributo, o mundo externo usa métodos seguros.

Pense em um cofre: você não abre a porta de qualquer jeito, usa a senha. Os métodos são essa interface controlada.

---

## O problema do acesso direto

```java
public class Pessoa {
    String nome;
    int idade;
}
```

```java
Pessoa p = new Pessoa();
p.nome = "Ana";
p.idade = -5; // inválido, mas o Java deixa
```

O compilador não conhece as regras do seu domínio. Se você não proteger, qualquer valor entra.

---

## `private`: trancando os atributos

A palavra `private` significa: **só a própria classe pode acessar**.

```java
public class Pessoa {
    private String nome;
    private int idade;
}
```

Agora isto **não funciona** de fora da classe:

```java
Pessoa p = new Pessoa();
p.idade = 20; // erro de compilação
```

Os dados ficam internos. Para ler ou alterar, a classe precisa oferecer métodos.

---

## Getters e Setters

- **Getter** → lê o valor (`get`)
- **Setter** → altera o valor (`set`)

### Exemplo

```java
public class Pessoa {
    private String nome;
    private int idade;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }
}
```

Uso:

```java
Pessoa p = new Pessoa();
p.setNome("Ana");
p.setIdade(20);

System.out.println(p.getNome());  // Ana
System.out.println(p.getIdade()); // 20
```

Parece “mais código” no começo e é. Mas o ganho está no **controle**.

---

## O poder está na validação

Com setter, você pode recusar valores inválidos:

```java
public void setIdade(int idade) {
    if (idade < 0 || idade > 150) {
        System.out.println("Idade inválida: " + idade);
        return;
    }
    this.idade = idade;
}
```

Agora:

```java
p.setIdade(20);   // ok
p.setIdade(-5);   // recusado
```

Sem encapsulamento, essa regra seria fácil de furar.

### Outro exemplo: preço

```java
public void setPreco(double preco) {
    if (preco < 0) {
        System.out.println("Preço não pode ser negativo.");
        return;
    }
    this.preco = preco;
}
```

---

## Construtor + encapsulamento

O construtor também pode validar na criação:

```java
public class Pessoa {
    private String nome;
    private int idade;

    public Pessoa(String nome, int idade) {
        setNome(nome);
        setIdade(idade);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (nome == null || nome.isBlank()) {
            System.out.println("Nome inválido.");
            return;
        }
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        if (idade < 0 || idade > 150) {
            System.out.println("Idade inválida.");
            return;
        }
        this.idade = idade;
    }

    public void apresentar() {
        System.out.println("Olá, eu sou " + nome + " e tenho " + idade + " anos.");
    }
}
```

Assim, tanto na criação quanto depois, as regras ficam no mesmo lugar.

> **Dica:** reutilizar o setter no construtor evita duplicar a validação.

---

## Nem tudo precisa de setter

Às vezes o atributo só deve ser lido, não alterado livremente.

Exemplo clássico: saldo de conta. Você **não** quer um `setSaldo` aberto. Quer `depositar` e `sacar`.

```java
public class ContaBancaria {
    private String titular;
    private double saldo;

    public ContaBancaria(String titular, double saldoInicial) {
        this.titular = titular;
        if (saldoInicial >= 0) {
            this.saldo = saldoInicial;
        } else {
            this.saldo = 0;
            System.out.println("Saldo inicial inválido. Começando em 0.");
        }
    }

    public String getTitular() {
        return titular;
    }

    public double getSaldo() {
        return saldo;
    }

    public void depositar(double valor) {
        if (valor <= 0) {
            System.out.println("Valor de depósito inválido.");
            return;
        }
        saldo = saldo + valor;
    }

    public void sacar(double valor) {
        if (valor <= 0) {
            System.out.println("Valor de saque inválido.");
            return;
        }
        if (valor > saldo) {
            System.out.println("Saldo insuficiente.");
            return;
        }
        saldo = saldo - valor;
    }

    public void exibirSaldo() {
        System.out.println(titular + " | Saldo: R$ " + saldo);
    }
}
```

Uso:

```java
ContaBancaria conta = new ContaBancaria("Ana", 100.0);
conta.depositar(50);
conta.sacar(30);
// conta.saldo = 999999; // erro: saldo é private
System.out.println(conta.getSaldo()); // 120.0
```

O saldo só muda por caminhos válidos.

---

## Visibilidade em resumo

| Modificador   | Quém acessa                         | Uso típico        |
|---------------|-------------------------------------|-------------------|
| `private`     | Só a própria classe                 | Atributos         |
| `public`      | Qualquer lugar                      | Métodos da API    |
| (sem nada)*   | Classes do mesmo pacote             | Casos específicos |

\* O padrão sem palavra-chave é o acesso de pacote (*package-private*). Por enquanto, foque em `private` nos atributos e `public` nos métodos que o mundo externo pode usar.

---

## Antes × Depois

### Antes (aberto)

```java
public class Produto {
    String nome;
    double preco;
}
```

```java
Produto p = new Produto();
p.preco = -10; // problema
```

### Depois (encapsulado)

```java
public class Produto {
    private String nome;
    private double preco;

    public Produto(String nome, double preco) {
        setNome(nome);
        setPreco(preco);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (nome == null || nome.isBlank()) {
            System.out.println("Nome inválido.");
            return;
        }
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        if (preco < 0) {
            System.out.println("Preço inválido.");
            return;
        }
        this.preco = preco;
    }
}
```

---

## Por que encapsular?

1. **Proteção**: evita estados inválidos (`idade = -3`)
2. **Controle** : mudanças passam por regras (`sacar`, `depositar`)
3. **Manutenção** : se a regra mudar, você altera em um lugar só
4. **Clareza** : a classe mostra *como* deve ser usada

---

## Erros comuns

### 1. Deixar atributo `public` “só por enquanto”

Depois vira hábito, e o código cresce cheio de acesso direto. Comece `private` desde cedo.

### 2. Getter/setter sem validação nenhuma

Ainda é melhor que atributo público (você pode evoluir depois), mas o grande benefício aparece quando há regra.

### 3. Criar `setSaldo` em conta bancária

Se o saldo pode ser setado livremente, `depositar` e `sacar` perdem o sentido.

### 4. Esquecer que `private` bloqueia só de *fora*

Dentro da própria classe, você continua acessando os atributos normalmente.

---

## Exemplo completo: Aluno encapsulado

```java
public class Aluno {
    private String nome;
    private double nota1;
    private double nota2;

    public Aluno(String nome, double nota1, double nota2) {
        setNome(nome);
        setNota1(nota1);
        setNota2(nota2);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (nome == null || nome.isBlank()) {
            System.out.println("Nome inválido.");
            return;
        }
        this.nome = nome;
    }

    public double getNota1() {
        return nota1;
    }

    public void setNota1(double nota1) {
        if (!notaValida(nota1)) {
            System.out.println("Nota 1 inválida.");
            return;
        }
        this.nota1 = nota1;
    }

    public double getNota2() {
        return nota2;
    }

    public void setNota2(double nota2) {
        if (!notaValida(nota2)) {
            System.out.println("Nota 2 inválida.");
            return;
        }
        this.nota2 = nota2;
    }

    private boolean notaValida(double nota) {
        return nota >= 0 && nota <= 10;
    }

    public double calcularMedia() {
        return (nota1 + nota2) / 2.0;
    }

    public boolean aprovado() {
        return calcularMedia() >= 7.0;
    }

    public void exibirBoletim() {
        System.out.println("Aluno: " + nome);
        System.out.println("Média: " + calcularMedia());
        System.out.println("Situação: " + (aprovado() ? "Aprovado" : "Reprovado"));
    }
}
```

Repare no método `notaValida`: ele é `private`, porque é detalhe interno. O mundo externo não precisa conhecê-lo.

---

## Exercícios

### Exercício 1 — Pessoa encapsulada

Pegue (ou reescreva) a classe `Pessoa` com:

- atributos `private`: `nome`, `idade`
- getters e setters
- validação: idade entre `0` e `150`
- método `apresentar()`

No `main`, teste valores válidos e inválidos.

### Exercício 2 — Produto seguro

Crie `Produto` com:

- `nome` e `preco` privados
- construtor
- getters/setters com validação (`preco >= 0`, nome não vazio)
- método `exibir()`

Tente atribuir preço negativo pelo setter e confirme que a regra impede.

### Exercício 3 — ContaBancaria reforçada

Reescreva a `ContaBancaria` desta aula:

- `titular` e `saldo` privados
- **sem** `setSaldo`
- `getSaldo` e `getTitular`
- `depositar` e `sacar` com validação
- `exibirSaldo`

No `main`, faça depósitos, saques válidos e inválidos.

### Exercício 4 — Retângulo encapsulado

Crie `Retangulo` com `largura` e `altura` privadas:

- setters que rejeitam valores `<= 0`
- métodos `area()` e `perimetro()`
- método `exibir()`

### Exercício 5 — Catálogo de livros (desafio)

Crie a classe `Livro` encapsulada com:

- `titulo`, `autor`, `paginas`, `disponivel` (boolean)
- construtor
- getters
- setters com validação (`paginas > 0`, textos não vazios)
- métodos `emprestar()` e `devolver()`:
  - `emprestar`: só se estiver disponível; senão, avisa
  - `devolver`: marca como disponível
- método `exibirInfo()`

No `main`, crie dois livros, empreste um, tente emprestar de novo e depois devolva.

---
