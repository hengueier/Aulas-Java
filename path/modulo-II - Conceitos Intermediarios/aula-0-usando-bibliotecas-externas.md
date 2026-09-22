# Usando Bibliotecas Externas: Não Precisa Inventar a Roda (De Novo)

Até agora você escreveu Java “puro”, tipo sobrevivente da floresta: JDK, classes suas, e torcida pra dar certo.

No mundo real, ninguém reimplementa HTTP, JSON, logs e conexão com banco do zero só pra provar que consegue. Existe um ecossistema enorme de bibliotecas — e a arte é **usar bem** sem transformar o projeto num Frankenstein de dependências.

Esta aula é sobre: baixar código de outras pessoas, plugar no seu projeto e não chorar quando o classpath explode.

---

## Esboço da aula

### 1. Por que bibliotecas existem

- O mito do “eu faço tudo sozinho”
- Quando faz sentido depender de algo externo
- Quando *não* faz (dependência de 200MB pra formatar data)

### 2. O que é uma dependência

- JAR, classpath e o “onde diabos o Java acha essa classe?”
- Biblioteca vs framework (spoiler: um é ferramenta, o outro quer mandar na sua vida)
- Licenças em linguagem humana (pode usar? precisa citar? pode vender?)

### 3. Maven / Gradle sem drama

- `pom.xml` ou `build.gradle`: a lista de compras do projeto
- Grupo, artefato, versão — o CPF da biblioteca
- Repositórios (Maven Central) e o ritual do `./mvnw` / `gradle build`
- Escopos: compile, test, runtime (pra não empacotar jUnit no jar de produção)

### 4. Adicionando a primeira lib de verdade

- Exemplo leve: algo tipo Gson/Jackson, ou Apache Commons, ou um logger
- Importar, usar, ver o “ah, funciona”
- Onde o IntelliJ esconde o botão de sync

### 5. Versões e o inferno dos conflitos

- SemVer em português: major que quebra, minor que adiciona, patch que conserta
- “Dependency hell”: duas libs querem versões diferentes da mesma coisa
- Dica: pinne versão, leia o changelog, não atualize tudo de madrugada

### 6. Boas práticas (pra não virar meme)

- Poucas dependências bem escolhidas > cem “só pra ver”
- Não copie JAR solto pra pasta `lib/` se puder evitar
- README com “como rodar” incluindo o build tool

---

## Exercícios

Criar um projeto Maven/Gradle mínimo que:

1. Declara uma biblioteca externa
2. Usa ela pra fazer algo útil (ex.: ler/escrever JSON, ou gerar um UUID bem formatado)
3. Roda com um comando só (`mvn exec:java` / `gradle run`)

---

## Próxima aula

Big O. Sim, aquele monstro dos slides de entrevista. Spoiler: ele não morde, ele só te faz sentir mal por ter feito `for` dentro de `for` dentro de `for`.
