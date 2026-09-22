# Otimizando o Código: Mais Rápido, Menos Drama (Com Medição)

Otimização sem medição é superstição com teclado.

Você já viu Big O, streaming, APIs, banco, async e threads. Esta aula junta o kit: **achar o gargalo, atacar o que importa, não reescrever o projeto por ego**.

Regra de ouro: código claro e correto primeiro. Rápido depois. Bonito no profiler, não só no slide.

---

## Esboço da aula

### 1. A pirâmide do “por que está lento”

- Algoritmo errado (Big O te avisou)
- I/O demais (N+1 no banco, API no loop)
- Contenção (locks, pool pequeno, conexão única)
- Alocação/GC fazendo hora extra
- “Otimizei o que não era o problema”

### 2. Medir de verdade

- Benchmark ingênuo (`System.nanoTime`) e os cuidados
- Aquecimento da JVM (microbenchmark mentiroso)
- JMH como menção: quando o micro importa
- Profiler / sampling: quem está no topo da stack
- Logs de timing em pontos-chave (sem logar a cada byte)

### 3. Vitórias fáceis (low-hanging fruit)

- Tirar trabalho do loop quente
- Cache com responsabilidade (e invalidação, o plot twist)
- Batch: uma query / um request em vez de mil
- Estrutura de dados certa pro acesso (HashMap vs List, de novo)
- Evitar criar objetos à toa no caminho crítico

### 4. I/O e banco: onde o tempo realmente some

- Connection pool
- Índices e “EXPLAIN” em nível conceitual
- Lazy load acidente vs fetch consciente
- Compressão, buffer size, keep-alive — detalhes que somam

### 5. Concorrência a serviço da performance

- Paralelizar o que é independente
- Não paralelizar o que compete pelo mesmo recurso
- Tamanho do pool ≠ “núcleo × 1000”
- Backpressure: produzir mais devagar que a fila aguenta

### 6. O que *não* fazer

- Micro-otimizar String vs StringBuilder em código que roda 1x
- Obfuscar lógica “porque é mais rápido”
- Premature optimization: o clássico de Donald Knuth ainda vale
- Trocar clareza por 0,3% sem necessidade de negócio

### 7. Checklist de otimização (pra colar na parede)

1. Está correto?
2. Tem teste / reprodutível?
3. Medi o gargalo?
4. A mudança ataca o gargalo?
5. Medi de novo?
6. Ainda dá pra ler o código?

---

## Exercício sugerido

Pegar um dos projetos anteriores (API + processamento, ou DB + relatório) e:

1. Cronometrar o caminho lento
2. Identificar a causa (algoritmo / I/O / lock)
3. Aplicar **uma** otimização justificada
4. Mostrar antes/depois com números
5. Escrever 5 linhas explicando *por que* melhorou (não “coloquei thread e foi”)

---

## Fim do Módulo III — Agora Lascou (de propósito)

Se o módulo I te ensinou a falar Java, e o II te tirou de casa, este te ensinou a não botar fogo na casa quando o sistema escala.

Próximo passo natural: um capstone “de verdade” — serviço que fala com API, grava em DB, processa em background e não derrete sob carga moderada. Mas isso é história pro próximo plot twist.
