# Conectando a um DB: Onde os Dados De Verdade Moram

Memória RAM é ótima pra demo. Péssima pra “cadê meu cadastro de ontem?”.

Banco de dados é o armário com etiquetas: grava, busca, atualiza, apaga — e continua lá depois que o programa morre. Em Java, o portal clássico se chama **JDBC** (e depois ORMs entram na conversa, mas primeiro o básico sem mágica).

Sim, SQL. Não, não vai doer… muito.

---

## Esboço da aula

### 1. Por que banco (e por que agora)
- Persistência vs “tudo em lista”
- Relacional em uma frase: tabelas, linhas, colunas, chaves
- SQL ≠ Java: duas línguas, um objetivo
- Local (Docker / SQLite / Postgres) pra estudar sem crédito de cloud

### 2. Anatomia mínima de um banco
- Tabela, PK, FK (sem virar DBA)
- Tipos: texto, número, data, boolean — e o mapeamento mental pro Java
- Índice: por que busca por CPF não precisa varrer a tabela inteira (eco do Big O)

### 3. JDBC: o ritual
- Driver: a peça que fala a língua do banco
- URL de conexão (`jdbc:...`), usuário, senha
- `Connection` → `Statement` / `PreparedStatement` → `ResultSet`
- Abrir, usar, **fechar** (try-with-resources de novo — ele não te larga)

### 4. CRUD sem choradeira
- `INSERT`, `SELECT`, `UPDATE`, `DELETE`
- `PreparedStatement` e o porquê de nunca concatenar SQL com input do usuário (SQL injection: o clássico)
- Mapear `ResultSet` → objeto Java (DTO / entidade simples)
- Transações: commit, rollback — “ou tudo, ou nada”

### 5. Organização do código
- Não espalhar SQL no `main` como confete
- Camada de acesso a dados (DAO / repository na mão)
- Configuração fora do código (properties / env)
- Migration mental: schema versionado (Flyway/Liquibase como menção, não obrigação)

### 6. ORM? Calma
- O que Hibernate/JPA resolvem
- O que escondem (e quando isso te morde)
- Nesta aula: JDBC primeiro; ORM depois, com respeito

---

## Exercício sugerido
Modelo simples (ex.: clientes, produtos, ou contas do capstone do módulo I):
1. Criar tabela(s)
2. Inserir / listar / atualizar / apagar via Java
3. Usar `PreparedStatement`
4. Tratar “não encontrado” e falha de conexão sem stack trace crú no usuário

Bônus: subir o mesmo fluxo do capstone bancário, mas persistindo de verdade.

---

## Fim do Módulo II
Você saiu do “Java na caixinha” e entrou no mundo: libs, desempenho, arquivos grandes, HTTP e banco.

Próximo módulo: **Agora Lascou** — assíncrono, threads e otimização. Onde o código para de ser uma fila indiana e vira um caos coordenado (com sorte).
