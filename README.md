# Interpretador Lox - Compiladores_1

![Language Badge](https://img.shields.io/badge/Language-Java-informational?style=flat&logo=java&logoColor=white&color=007396)
![GitHub last commit](https://img.shields.io/github/last-commit/saulodetassio/Compiladores_1)
![GitHub Repo stars](https://img.shields.io/github/stars/saulodetassio/Compiladores_1?style=social)
![GitHub forks](https://img.shields.io/github/forks/saulodetassio/Compiladores_1?style=social)

## 🚀 Visão Geral do Projeto

Este repositório contém a implementação de um interpretador para a linguagem de programação [Lox](https://craftinginterpreters.com/the-lox-language.html), conforme detalhado no livro "Crafting Interpreters" de Bob Nystrom. O projeto foi desenvolvido como parte da disciplina de Compiladores do curso de Engenharia da Computação da Universidade Federal do Maranhão (UFMA).

Atualmente, o projeto implementa as funcionalidades até o **Capítulo 12: Classes**, constituindo um interpretador completo com suporte a análise léxica, sintática, resolução de escopo estático e execução de código orientado a objetos.

## ✨ Funcionalidades Implementadas

* **Análise Léxica (`Scanner`):** Converte o código-fonte em uma sequência de tokens.
* **Análise Sintática (`Parser`):** Constrói uma Árvore de Sintaxe Abstrata (AST) a partir dos tokens.
* **Resolução Estática (`Resolver`):** Analisa os escopos e resolve as variáveis antes da execução para maior eficiência e detecção de erros estáticos.
* **Execução de Código (`Interpreter`):**
    * Avaliação de expressões aritméticas, lógicas e de comparação.
    * Suporte a **variáveis** com escopo de bloco.
    * **Controle de fluxo** com `if/else`.
    * Suporte completo a **Funções**, com closures e recursão.
    * Suporte completo a **Classes**, incluindo métodos, inicializadores (`init`), `this`, e herança com `super`.
* **Funções Nativas:** Exemplo de função nativa (`clock()`) implementada em Java.

## 🛠️ Tecnologias Utilizadas

* **Java 8+**

## 📚 Estrutura do Projeto

Compiladores_1/
├── src/
│   └── main/
│       └── java/
│           └── com/
│               └── craftinginterpreters/
│                   ├── lox/
│                   │   ├── Interpreter.java  # Executa a AST
│                   │   ├── Lox.java          # Ponto de entrada
│                   │   ├── LoxClass.java     # Representação de uma classe
│                   │   ├── LoxFunction.java  # Representação de uma função
│                   │   ├── LoxInstance.java  # Representação de um objeto
│                   │   ├── Parser.java       # Analisador Sintático
│                   │   ├── Resolver.java     # Analisador Estático de Escopo
│                   │   ├── Scanner.java      # Analisador Léxico
│                   │   ├── Stmt.java         # AST para Declarações (gerado)
│                   │   └── ... (outros arquivos de suporte)
│                   └── tool/
│                       └── GenerateAst.java  # Ferramenta para gerar a AST
├── teste_avancado.lox
└── README.md


## 🚀 Como Compilar e Executar

O projeto pode ser executado facilmente a partir de um ambiente de desenvolvimento como o VS Code, utilizando o arquivo de configuração `.vscode/launch.json`.

1.  **Gerar as Classes da AST:**
    * Execute a configuração **`⚙️ Gerar AST`** para criar ou atualizar os arquivos `Expr.java` e `Stmt.java`.

2.  **Executar o Interpretador:**
    * **Modo Interativo (REPL):** Execute a configuração **`▶️ Executar Lox (Interativo / REPL)`** para digitar código Lox linha a linha.
    * **Executar um Script:** Crie um arquivo `.lox` (como o `teste_avancado.lox`) e use uma configuração que o passe como argumento para testar programas completos.

## 👥 Participantes

Este projeto foi desenvolvido pelos seguintes alunos:

| Nome                                   | Curso                      | Matrícula  | Usuário GitHub  | E-mail                     |
| :------------------------------------- | :------------------------- | :--------- | :-------------- | :------------------------- |
| **SAULO DE TASSIO DA COSTA DOS SANTOS**| ENGENHARIA DA COMPUTAÇÃO   | 2021071572 | `saulodetassio` | `saulodetassio@gmail.com`  |
| **MARIA HELENA DE SOUSA COSTA** | CIÊNCIA E TECNOLOGIA       | 2021041368 | `maria.hsc`     | `maria.hsc@discente.ufma.br` |

## 🔗 Repositório

[https://github.com/saulodetassio/Compiladores_1](https://github.com/saulodetassio/Compiladores_1)

---
## 📝 Licença

Este projeto está sob a licença [MIT License](https://opensource.org/licenses/MIT).