# Processamento Assíncrono: “Pode Ir Fazendo, Eu Te Aviso”

Até aqui, o programa era uma pessoa educada numa fila: faz A, termina A, faz B, termina B. Síncrono. Previsível. Lento quando B é “esperar a internet”.

**Assíncrono** é outra vibe: você dispara o trabalho, segue a vida, e quando a resposta chega… alguém te cutuca. Tipo pedir um delivery e continuar assistindo série em vez de ficar na porta olhando o vazio.

Esta aula introduz a ideia. Threads entram com força na próxima — aqui o foco é o *modelo mental*.

---

## Esboço da aula

### 1. Síncrono vs assíncrono (sem academia)

- Bloqueante: “espero aqui até acabar”
- Não-bloqueante: “me chama quando tiver pronto”
- Por que I/O (rede, disco, DB) é o vilão clássico do “travou a UI / o request”
- Analogia: cozinha — um fogão, vários pratos, ou vários fogões

### 2. Onde isso aparece no dia a dia

- Chamada de API que demora
- Várias requisições em paralelo (“buscar 10 CEPs”)
- Jobs em background: e-mail, relatório, importação
- “Fire and forget” vs “preciso do resultado”

### 3. Callbacks, Futures e promessas (conceito)

- Callback: “quando terminar, roda isso” (e o inferno do callback nesting, de leve)
- `Future` / `CompletableFuture`: um recibo do trabalho
- `get()` no Future: o jeito de voltar a ser síncrono (com timeout, se for esperto)
- Encadear: `thenApply`, `thenCompose`, `exceptionally` — pipeline assíncrono

### 4. CompletableFuture em Java (mão na massa leve)

- `supplyAsync` / `runAsync`
- Combinar resultados (`allOf`, `anyOf`)
- Tratamento de erro sem engolir exceção
- Executor: “em qual pool isso roda?” (spoiler da aula de threads)

### 5. Armadilhas clássicas

- Esquecer de esperar e o `main` terminar antes do trabalho
- Race condition mental: “quem escreveu isso primeiro?”
- Assíncrono ≠ automaticamente mais rápido (às vezes só mais complicado)
- Debug: stack traces que parecem romance policial

### 6. Quando *não* usar

- Tarefa curta e local: overhead > ganho
- Código que precisa ser óbvio pra manutenção
- “Paralelizei tudo” e o banco pediu misericórdia

---

## Exercício sugerido

Simular 3–5 tarefas lentas (ex.: `Thread.sleep` fingindo API):

1. Versão síncrona: uma atrás da outra — cronometrar
2. Versão com `CompletableFuture`: disparar em paralelo — cronometrar
3. Combinar os resultados num relatório final
4. Forçar um erro numa tarefa e tratar sem derrubar as outras

---

## Próxima aula

Threads de verdade. Porque por trás do “assíncrono bonitinho” tem gente compartilhando memória, e brigando por ela.
