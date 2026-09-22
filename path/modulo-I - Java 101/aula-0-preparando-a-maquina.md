# Tutorial de Sobrevivência do Aprendiz de Java

## Introdução: A Jornada Começa Aqui

Então você resolveu aprender Java. Boa escolha — e boa sorte!

A linguagem é robusta, tem mercado de sobra e faz parte do dia a dia de milhões de desenvolvedores pelo mundo. E, claro, a maioria deles também tem gastrite.

Mas, antes de escrever sua primeira linha de código, você precisa preparar o terreno. Seu computador não vem com as dependências do Java instaladas de fábrica; você precisa instalá-las.

Existem duas formas de fazer isso: baixar o JDK manualmente ou utilizar ferramentas que automatizam esse processo. Neste tutorial, vamos seguir a segunda abordagem. O IntelliJ IDEA pode fazer isso por você, deixando tudo muito mais simples.

Vamos lá!

---

## Passo 1: Instalando o IntelliJ IDEA — Sua Estação de Trabalho

O IntelliJ IDEA é uma das ferramentas mais populares do ecossistema Java. A versão Community é gratuita e oferece tudo o que você precisa para começar.

1. Acesse [jetbrains.com/idea/download](https://www.jetbrains.com/idea/download).
2. Baixe a versão **Community** (gratuita) — o arquivo com extensão `.exe`.
3. Execute o instalador e, durante o processo, marque as opções:
   - **Add launchers dir to the PATH** (permite abrir o IntelliJ pelo terminal).
   - **Create associations for .java** (opcional, mas útil para abrir arquivos Java diretamente pelo Windows).
4. Conclua a instalação e abra o IntelliJ.
5. Na primeira execução, ele perguntará se você deseja importar configurações. Escolha **Do not import settings**.

Pronto! O IntelliJ está instalado.

E o Java? Vamos resolver isso agora mesmo.

---

## Passo 2: Instalando o Java (JDK) pelo IntelliJ

Você não precisa sair do IntelliJ para baixar e instalar o Java. A própria ferramenta faz isso automaticamente.

1. Na tela inicial do IntelliJ, clique em **New Project**.
2. Na janela que abrir, localize o campo **JDK**.
3. Abra a lista suspensa e selecione **Download JDK...**.
4. Na janela seguinte, escolha:
   - **Version:** 17 ou 21 (são versões LTS — Long-Term Support — as mais recomendadas para começar).
   - **Vendor:** Pode deixar a opção recomendada, como Amazon Corretto ou Eclipse Temurin. Ambas são gratuitas e confiáveis.

> **Minha recomendação:** utilize o Eclipse Temurin, que é a distribuição que uso no dia a dia.

5. Clique em **Download**.

O IntelliJ fará o download, instalará o JDK e configurará tudo automaticamente.

Vídeo tutorial disponível em:

> https://www.jetbrains.com/guide/java/tips/download-jdk/

Grande parte das referências utilizadas virá diretamente da documentação oficial do produto, que é sempre a fonte mais confiável de informação.

---

## Passo 3: Criando sua Conta no GitHub — Seu Portfólio Digital

O GitHub é como um mural onde você publicará seus projetos, acompanhará sua evolução e poderá colaborar com outros desenvolvedores. Na prática, ele funciona como o currículo de qualquer programador.

O Git, que se integra ao GitHub, permite que duas ou mais pessoas trabalhem no mesmo projeto sem que uma sobrescreva o trabalho da outra. Caso duas pessoas alterem exatamente o mesmo trecho do código, ocorrerá um conflito, e as próprias ferramentas do Git ajudam a resolver esse problema.

Para criar sua conta:

1. Acesse [github.com](https://github.com).
2. Clique em **Sign up**.
3. Escolha um nome de usuário que você goste de ver estampado nos seus projetos. Pode ser algo criativo ou simplesmente seu nome.
4. Informe um e-mail válido e crie uma senha segura (e anote-a em algum lugar, porque você vai precisar dela).
5. Verifique seu e-mail e pronto!

Agora você tem um cantinho na internet para guardar seus códigos.

> **Dica:** assim que criar sua conta, faça um repositório chamado `hello-world` para começar a organizar seus projetos.

---

## Passo 4 (Opcional, mas Recomendado): Instalando o Git

Se você pretende usar o GitHub pelo terminal (o que é bastante prático e ainda passa aquela impressão de que você sabe exatamente o que está fazendo), será necessário instalar o Git.

1. Baixe o instalador em [git-scm.com](https://git-scm.com).
2. Execute-o e mantenha todas as opções padrão, a menos que saiba exatamente o que está alterando.
3. Após a instalação, procure pelo **Git Bash** no Menu Iniciar.

O Git Bash é um terminal que oferece comandos semelhantes aos do Linux dentro do Windows, facilitando bastante o acompanhamento de tutoriais.

**Material útil:** *COMO USAR GIT E GITHUB NA PRÁTICA! - desde o primeiro commit até o pull request! 2/2*

Apesar de o vídeo ter cerca de 5 anos, isso não compromete sua validade, já que o Git se mantém essencialmente o mesmo há mais de uma década.

---

## Passo 5: Verificando se Tudo Está no Lugar

Com o IntelliJ instalado e o JDK baixado por ele, você já pode começar a programar.

Se quiser verificar se o Java está disponível no sistema, abra o Prompt de Comando (`cmd`) e execute:

```bash
java -version
```

Se aparecer a versão instalada, está tudo certo.

Se não aparecer, não se preocupe. O IntelliJ continuará conseguindo executar seus programas normalmente, pois ele sabe exatamente onde o JDK foi instalado.

---

## Bônus: Comandos Básicos do Prompt de Comando

Para navegar pelo terminal com mais confiança, aqui estão alguns comandos úteis:

| O que você quer fazer              | Comando            |
|------------------------------------|--------------------|
| Ver diretório atual                | `cd`               |
| Listar arquivos                    | `dir`              |
| Entrar em uma pasta                | `cd nome-da-pasta` |
| Voltar uma pasta                   | `cd ..`            |
| Criar uma pasta                    | `mkdir nome`       |
| Remover um arquivo                 | `del arquivo`      |
| Remover uma pasta vazia            | `rmdir pasta`      |
| Remover uma pasta com conteúdo     | `rmdir /s pasta`   |
| Limpar o terminal                  | `cls`              |

> **Dica de ouro:** instalar o Git Bash é uma das melhores coisas que você pode fazer. Além de facilitar o uso do Git, ele permite utilizar diversos comandos comuns do Linux, tornando muito mais simples acompanhar tutoriais encontrados na internet.

---

## E Agora?

Com tudo instalado e configurado, você já pode criar seu primeiro projeto Java e escrever:

```java
public class HelloWorld {
    public static void main(String[] args) {
        System.out.println("Hello World!");
    }
}
```

Não se preocupe agora com esses termos como `class`, `public` e `void`. O importante neste momento é fazer o programa rodar. Depois você entenderá cada um deles com calma.

A mensagem `"Hello World!"` é praticamente um ritual de iniciação na programação. Desde a década de 1970, ela é utilizada como o primeiro programa em inúmeras linguagens e acabou se tornando uma tradição entre programadores.

Para executar o programa, basta clicar no botão verde de **Run (▶)**, localizado no canto superior direito do IntelliJ. A IDE irá compilar seu código, executá-lo e mostrar o resultado no console.

---

## Tema

Salve esse código e faça o push para o repositório que você já criou ou irá criar no GitHub, com o nome `hello-world`. Para isso, você precisará:

1. Adicionar o código à área de staging (`git add`)
2. Realizar o commit (`git commit`)
3. E, por fim, dar o push para o repositório remoto (`git push`)
