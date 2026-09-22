# Consumindo APIs: Pedindo Dados Educadamente pela Internet

Até agora o programa falava consigo mesmo. Bonito, introspectivo, limitado.

APIs são o jeito civilizado de pedir informação a outro sistema: clima, CEP, cotação, gatos em JSON. Você manda um HTTP, alguém responde — às vezes com o que você pediu, às vezes com um erro passivo-agressivo.

Esta aula: **cliente HTTP em Java**, JSON, e o básico pra não parecer um bot mal-educado.

---

## Esboço da aula

### 1. O que é uma API (sem slide corporativo)

- Cliente vs servidor — você é o cliente (por enquanto)
- REST em linguagem de gente: URL, verbo, corpo, status
- JSON: o esperanto dos sistemas (feio, mas universal)
- Endpoint, query param, path param — o endereço completo do favor

### 2. HTTP sem mistério

- GET (buscar), POST (criar/enviar), e os primos PUT/PATCH/DELETE
- Status: `200` ok, `404` sumiu, `401/403` sem permissão, `429` “cala a boca um pouco”, `5xx` “não fui eu”
- Headers: `Content-Type`, `Authorization`, User-Agent
- Timeout: porque esperar pra sempre não é estratégia

### 3. Fazendo request em Java

- `HttpClient` moderno (Java 11+) — o caminho feliz
- Montar URI, método, body
- Ler status + body como String
- (Opcional) libs tipo Unirest / OkHttp se o módulo de libs já estiver fluido

### 4. JSON ↔ objetos

- Parse manual vs biblioteca (Jackson / Gson)
- DTOs: classes que espelham a resposta (sem inventar campo que não existe)
- Campos opcionais, null, arrays — a vida real do JSON
- Erro de parse: a API mudou e ninguém te avisou

### 5. Autenticação e etiqueta

- API key no header (não no GitHub, pelo amor)
- Bearer token em linhas gerais
- Rate limit: backoff, retry com limite, não martelar o servidor
- Variáveis de ambiente / `.env` fora do repo

### 6. Tratando o mundo hostil

- Rede caiu, DNS sumiu, SSL reclamou
- Resposta não-JSON quando você esperava JSON
- Retry idempotente vs “não reenvia POST à toa”
- Logs úteis: status + trecho do body, sem vazar segredo

---

## Exercício

Escolher uma API pública (CEP, piada, clima, whatever está estável) e:

1. Fazer um GET
2. Mapear a resposta pra uma classe
3. Imprimir algo legível no console
4. Tratar pelo menos um erro (timeout, 404, JSON inválido)

Bônus: encapsular o client numa classezinha reutilizável (eco do módulo I).

---

## Próxima aula

Banco de dados. Porque `ArrayList` em memória é fofo até reiniciar o programa e descobrir que o “banco” era amnésia.
