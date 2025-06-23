Interpretador Lox - Compiladores_1
🚀 Visão Geral do Projeto

Este repositório contém a implementação de um interpretador para a linguagem de programação Lox, conforme detalhado no livro "Crafting Interpreters" de Bob Nystrom. O projeto está sendo desenvolvido como parte da disciplina de Compiladores do curso de Engenharia da Computação da Universidade Federal do Maranhão (UFMA).

Atualmente, o projeto implementa as funcionalidades até o Capítulo 5: Representing Code.
✨ Funcionalidades Atuais

    Análise Léxica (Scanner):
        Converte o código-fonte em uma sequência de tokens (operadores, palavras-chave, literais, etc.).
        Trata comentários, espaços em branco e reporta erros de caracteres inesperados.

    Estruturas de Sintaxe (AST):
        Ferramenta (GenerateAst.java) para gerar programaticamente as classes que representam a gramática de expressões.
        Implementação do padrão de projeto Visitor, que permite a criação de operações sobre a árvore de sintaxe (ex: impressão, análise, interpretação).
        Um "Pretty Printer" (AstPrinter.java) que imprime a estrutura da AST para fins de depuração.

🛠️ Tecnologias Utilizadas

    Java 8+

📚 Estrutura do Projeto

Compiladores_1/
├── src/
│   └── main/
│       └── java/
│           └── com/
│               └── craftinginterpreters/
│                   ├── lox/
│                   │   ├── AstPrinter.java   # Implementação do Visitor para imprimir a AST
│                   │   ├── Expr.java         # Classes da AST (gerado automaticamente)
│                   │   ├── Lox.java          # Ponto de entrada do interpretador
│                   │   ├── Parser.java       # Análise de expressões
│                   │   ├── Scanner.java      # Implementação do analisador léxico
│                   │   ├── Token.java        # Representação de um token
│                   │   └── TokenType.java    # Enumeração dos tipos de tokens
│                   └── tool/
│                       └── GenerateAst.java  # Ferramenta para gerar a AST
└── README.md
🚀 Como Usar o Projeto

Todo o projeto pode ser compilado e executado a partir de um ambiente de desenvolvimento Java (IDE) como VS Code ou IntelliJ.

    Gerar as Classes da AST:
        Para criar o arquivo Expr.java, execute o método main da classe GenerateAst.java.

    Testar a Estrutura da AST:
        Para verificar se a AST e o AstPrinter estão funcionando, execute o método main da classe AstPrinter.java.
        A saída esperada no console é a representação em texto de uma árvore de exemplo:

        (* (- 123) (group 45.67))

        
    Gerado Analise de Parser (Fase atual do projeto)

👥 Participantes

Este projeto está sendo desenvolvido pelos seguintes alunos:
Nome	Curso	Matrícula	Usuário GitHub	E-mail
SAULO DE TASSIO DA COSTA DOS SANTOS	ENGENHARIA DA COMPUTAÇÃO	2021071572	saulodetassio	saulodetassio@gmail.com
MARIA HELENA DE SOUSA COSTA	CIÊNCIA E TECNOLOGIA	2021041368	maria.hsc	maria.hsc@discente.ufma.br
🔗 Repositório

https://github.com/saulodetassio/Compiladores_1
📝 Licença

Este projeto está sob a licença MIT License.