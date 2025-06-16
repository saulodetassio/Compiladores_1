# Interpretador Lox - Compiladores_1

![Java Badge](https://img.shields.io/badge/Language-Java-informational?style=flat&logo=java&logoColor=white&color=007396)
![GitHub Repo stars](https://img.shields.io/github/stars/saulodetassio/Compiladores_1?style=social)
![GitHub watchers](https://img.shields.io/github/watchers/saulodetassio/Compiladores_1?style=social)
![GitHub forks](https://img.shields.io/github/forks/saulodetassio/Compiladores_1?style=social)

## 🚀 Visão Geral do Projeto

Este repositório contém a implementação de um interpretador para a linguagem de programação [Lox](https://craftinginterpreters.com/the-lox-language.html), conforme detalhado no livro "Crafting Interpreters" de Bob Nystrom. O projeto está sendo desenvolvido como parte da disciplina de Compiladores do curso de Engenharia da Computação da Universidade Federal do Maranhão (UFMA).

Atualmente, o interpretador está na fase de **Scanning (Análise Léxica)**, que é responsável por transformar o código-fonte Lox em uma sequência de tokens.

## ✨ Funcionalidades Atuais

* **Análise Léxica (Scanner):**
    * Reconhecimento de operadores de uma e duas caracteres (ex: `+`, `-`, `!`, `!=`, `<=`, `>=`).
    * Identificação de palavras-chave da linguagem Lox (ex: `var`, `if`, `else`, `while`, `fun`, `print`).
    * Detecção de identificadores, literais de string e números inteiros/flutuantes.
    * Tratamento de comentários de linha (`//`).
    * Ignorar espaços em branco.
    * Reporte de erros léxicos (ex: caracteres inesperados, strings não terminadas).
* **Modo Interativo (REPL):** Permite executar comandos Lox linha a linha diretamente no terminal.
* **Modo Script:** Capacidade de ler e processar um arquivo `.lox`.

## 🛠️ Tecnologias Utilizadas

* **Java 8+**

## 📚 Estrutura do Projeto

A estrutura de pastas segue as convenções de projetos Java padrão, com o código-fonte principal localizado em `src/main/java`.

Compiladores_1/
├── src/
│   └── main/
│       └── java/
│           └── com/
│               └── craftinginterpreters/
│                   └── lox/
│                       ├── Lox.java        # Ponto de entrada do interpretador
│                       ├── Scanner.java    # Implementação do analisador léxico
│                       ├── Token.java      # Representação de um token
│                       └── TokenType.java  # Enumeração dos tipos de tokens
└── README.md


## 🚀 Como Compilar e Executar

Certifique-se de ter o [JDK (Java Development Kit)](https://www.oracle.com/java/technologies/downloads/) instalado (versão 8 ou superior).

1.  **Navegue até o diretório do código-fonte:**
    ```bash
    cd Compiladores_1/src/main/java
    ```

2.  **Compile os arquivos Java:**
    ```bash
    javac com/craftinginterpreters/lox/*.java
    ```

3.  **Execute o Interpretador:**

    * **Modo Interativo (REPL):**
        ```bash
        java com.craftinginterpreters.lox.Lox
        ```
        Você verá o prompt `> `. Digite seu código Lox e pressione Enter. Para sair, use `Ctrl+C` ou `Ctrl+D`.

    * **Modo Script (executando um arquivo `.lox`):**
        Primeiro, crie um arquivo de exemplo, digamos `exemplo.lox`, na raiz do seu projeto (`Compiladores_1/`).

        **Conteúdo de `exemplo.lox`:**
        ```lox
        // Exemplo de código Lox
        var nome = "Mundo";
        print "Olá, " + nome + "!";
        1 + 2 * 3;
        if (true) {
            print "Verdadeiro!";
        }
        ```

        Então, execute o comando (assumindo que você ainda está em `src/main/java`):
        ```bash
        java com.craftinginterpreters.lox.Lox ../../../../exemplo.lox
        ```
        (Alternativamente, se estiver na pasta raiz `Compiladores_1`):
        ```bash
        cd Compiladores_1
        java -cp src/main/java com.craftinginterpreters.lox.Lox exemplo.lox
        ```

        A saída no terminal mostrará os tokens gerados pelo scanner para o código no arquivo.

## 👥 Participantes

Este projeto está sendo desenvolvido pelos seguintes alunos:

| Nome                           | Curso                      | Matrícula  | Usuário GitHub  | E-mail                     |
| :----------------------------- | :------------------------- | :--------- | :-------------- | :------------------------- |
| **SAULO DE TASSIO DA COSTA DOS SANTOS** | ENGENHARIA DA COMPUTAÇÃO | 2021071572 | `saulodetassio` | `saulodetassio@gmail.com`  |
| **MARIA HELENA DE SOUSA COSTA** | CIÊNCIA E TECNOLOGIA       | 2021041368 | `maria.hsc` | `maria.hsc@discente.ufma.br` |

## 🔗 Repositório

[https://github.com/saulodetassio/Compiladores_1](https://github.com/saulodetassio/Compiladores_1)

---

## 📝 Licença

Este projeto está sob a licença [MIT License](https://opensource.org/licenses/MIT).

