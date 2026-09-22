# Threads: Várias Mãos no Mesmo Código (Que Deus Nos Ajude)

Uma thread é uma linha de execução. Duas threads são duas linhas. Cem threads são… um chamado no Slack às 3h da manhã.

Você já usou o conceito (CompletableFuture, pools). Agora vamos olhar o motor: **criar threads, sincronizar, não corromper estado compartilhado**.

Bem-vindo à parte do Java em que “funcionou na minha máquina” vira “funcionou *nessa* execução”.

---

## Esboço da aula

### 1. Processo vs thread
- Processo: o programa inteiro
- Thread: trabalhador dentro do processo
- Memória compartilhada: a bênção e a maldição
- Por que o processador “parece” fazer várias coisas ao mesmo tempo

### 2. Criando threads em Java
- `extends Thread` vs `implements Runnable` (prefira Runnable)
- `start()` vs `run()` — o erro clássico de quem chama o método errado
- Nomear threads: futuro-você agradece no debugger
- Daemon threads: a limpeza que some quando o app acaba

### 3. Ciclo de vida e coordenação básica
- New → Runnable → Running → Blocked/Waiting → Terminated
- `join()`: “espera essa terminar”
- `sleep()`: pausa educada (não é lock)
- Interrupção: pedir pra parar sem matar no peito

### 4. O problema: estado compartilhado
- Race condition: dois cooks, um contador
- Exemplo mínimo: `contador++` que “às vezes” erra
- Visibilidade: o que uma thread escreve, a outra pode não ver (ainda)
- `synchronized`, locks, e o custo de sincronizar demais

### 5. Ferramentas menos brutais
- `AtomicInteger` e família
- `concurrent` collections (`ConcurrentHashMap`, filas)
- `ExecutorService` / thread pools: não criar thread por request como se fosse confete
- `volatile` em uma frase honesta (quando ajuda, quando não)

### 6. Deadlock e amigos
- Duas threads, dois locks, ordem trocada — parabéns, ninguém anda
- Como diagnosticar (thread dump mental)
- Regras práticas: ordem fixa de locks, timeouts, menos estado compartilhado
- Preferir mensagens/filas a “todo mundo mexe no mesmo objeto”

---

## Exercício sugerido
1. Programa com N threads incrementando um contador compartilhado — ver o bug
2. Corrigir com `synchronized` / `AtomicInteger`
3. Refazer com `ExecutorService` e pool fixo
4. (Bônus) Provocar um deadlock de brinquedo e depois desfazer

---

## Próxima aula
Otimizando o código. Agora que você sabe *onde* o tempo vai (CPU, I/O, lock), dá pra acelerar sem chutar o que está “lento por vibe”.
