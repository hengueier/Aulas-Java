# Processando Sem Explodir o PC: Memória, Streams e Bom Senso

Seu programa leu um arquivo. Legal. Leu um arquivo de 4GB. Menos legal. Tentou meter tudo numa `ArrayList<String>` e o SO pediu socorro.

Esta aula é sobre processar dados **como adulto**: aos poucos, com streaming, sem achar que RAM é infinita só porque o tutorial usava 10 linhas.

Big O te ensinou que algoritmo importa. Agora: **volume** também importa.

---

## Esboço da aula

### 1. O que “explode o PC”, na prática

- OutOfMemoryError: o erro que parece xingamento
- CPU a 100% vs disco a 100% vs rede engasgada — sintomas diferentes, culpas diferentes
- Por que “funciona no exemplo” não prova nada

### 2. Carregar tudo vs processar em fluxo

- Buffer: ler pedaço, processar, descartar, repetir
- Cursor / iterator mental: “próximo item”, não “todos os itens”
- Quando *precisa* carregar tudo (spoiler: menos vezes do que você pensa)

### 3. I/O em Java sem drama

- `InputStream` / `Reader` / `BufferedReader` — por que buffer existe
- try-with-resources: fechar arquivo pra não vazar handle
- Ler linha a linha, escrever linha a linha
- Charset: o plot twist do UTF-8 vs “foi o Excel”

### 4. Streams da linguagem (java.util.stream)

- `filter`, `map`, `reduce` — pipeline, não mágica
- Lazy evaluation: só processa quando precisa
- Quando Stream ajuda e quando é só frescura (loop clássico às vezes é mais claro)
- Cuidado: `collect(toList())` no final de um arquivo gigante = você voltou ao problema

### 5. Chunking e paginação

- Processar de N em N registros
- Arquivos grandes: split mental (não necessariamente físico)
- Relatórios: agregar no caminho, não guardar tudo pra “somar depois”

### 6. Medir antes de chorar

- Heap size, GC fazendo festa
- Timer simples vs profiler
- Logs de progresso (“processei 10k…”) pra saber se travou ou só está pensando

---

## Exercício

Dado um arquivo CSV (ou .txt) razoavelmente grande:

1. Versão “ingênua”: carregar tudo e processar
2. Versão “adulto”: ler em streaming / chunks e produzir o mesmo resultado
3. Comparar memória/tempo (mesmo que de olho no Task Manager / `htop`)

Bônus: gerar estatísticas (contagem, média, top N) sem guardar a lista inteira.

---

## Próxima aula

Consumindo APIs. Porque os dados não moram só no seu HD — e a internet também sabe dizer “não” (429, timeout, JSON torto…).
