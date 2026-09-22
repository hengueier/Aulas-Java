# O Terrível Big O: Ou “Por Que Seu Código Demora a Vida Inteira”

Você escreveu um programa. Funciona. Parabéns.

Agora rode com 10 itens. Ok. Com 1.000. Ainda ok. Com 1.000.000… o notebook virou um aquecedor e você começou a questionar as escolhas de carreira.

**Big O** é a forma de falar, sem spreadsheet, “esse algoritmo escala bem ou vai te trair no dia do demo”.

Não precisa virar matemático. Precisa saber cheirar código lento.

---

## Esboço da aula

### 1. O problema não é “funcionar” — é “funcionar quando crescer”

- Complexidade de tempo vs complexidade de espaço
- “Mas no meu PC é rápido” (clássico último palavras)
- Contar operações, não milissegundos (ainda)

### 2. As celebridades do Big O

- `O(1)` — constante: olhar uma posição no array
- `O(log n)` — logarítmica: busca binária (a amiga que divide pra conquistar)
- `O(n)` — linear: passar uma vez pela lista
- `O(n log n)` — sort de gente grande
- `O(n²)` — for dentro de for (o vilão das entrevistas e dos relatórios)
- `O(2ⁿ)` / `O(n!)` — “funciona em teoria”; na prática, vá tomar um café. Ou três.

### 3. Como “ler” o seu código

- Loop simples → geralmente `O(n)`
- Dois loops aninhados no mesmo tamanho → cheira a `O(n²)`
- Chamar método caro dentro de loop (olha o banco, olha a API…)
- Melhor/médio/pior caso: por que “às vezes é rápido” não salva o currículo

### 4. Estruturas e o preço delas

- Array / ArrayList: acesso rápido, inserção no meio… dói
- HashMap: busca média `O(1)` (quando o hash se comporta)
- LinkedList: “inserir no meio é O(1)” — e o asterisco embaixo da letra miúda
- Trade-off: memória vs tempo (você quase sempre escolhe um)

### 5. Otimização precoce é o diabo

- Primeiro: código legível e correto
- Depois: medir (profiler, timer, dados reais)
- Só então: trocar algoritmo / estrutura
- Big O não justifica escrever código ilegível “porque é O(n)”

### 6. Exemplos práticos em Java

- Busca linear vs busca com `HashSet` / `HashMap`
- Ordenar e depois buscar vs buscar burro
- “Remover duplicatas” do jeito O(n²) vs O(n)

---

## Exercício

Pegar 2–3 trechos “ingênuos” (ex.: achar pares, verificar duplicata, buscar em lista) e:

1. Classificar o Big O atual
2. Reescrever com complexidade melhor
3. Comparar tempo com listas grandes (1k, 10k, 100k) — sentir o drama na pele

---

## Próxima aula

Processar dados sem explodir o PC. Porque Big O te avisou; agora a gente aprende a não carregar a internet inteira na RAM.
