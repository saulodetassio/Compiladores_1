package main.java.com.craftinginterpreters.lox; // CORRIGIDO AQUI

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
// import java.util.Scanner; // REMOVIDO: Você não precisa disso, pois usa sua própria classe Scanner

public class Lox {
  static boolean hadError = false; // Declaração ÚNICA de hadError

  public static void main(String[] args) throws IOException {
    if (args.length > 1) {
      System.out.println("Usage: jlox [script]");
      System.exit(64);
    } else if (args.length == 1) {
      runFile(args[0]);
    } else {
      runPrompt();
    }
  }

  private static void runFile(String path) throws IOException {
    byte[] bytes = Files.readAllBytes(Paths.get(path));
    run(new String(bytes, Charset.defaultCharset()));
    if (hadError) System.exit(65);
  }

  private static void runPrompt() throws IOException {
    InputStreamReader input = new InputStreamReader(System.in);
    BufferedReader reader = new BufferedReader(input);

    for (;;) {
      System.out.print("> ");
      String line = reader.readLine();
      if (line == null) break;
      run(line);
      hadError = false; // Reseta a flag de erro para o próximo comando no prompt
    }
  }

  // Definição ÚNICA do método run(String source)
  private static void run(String source) {
    // A lógica de escaneamento e tokenização deve vir aqui
    Scanner scanner = new Scanner(source); // Isso usa sua classe Scanner do mesmo pacote
    List<Token> tokens = scanner.scanTokens();

    // Por enquanto, apenas imprima os tokens.
    for (Token token : tokens) {
      System.out.println(token);
    }
  }

  // Definição ÚNICA do método error(int line, String message)
  static void error(int line, String message) {
    report(line, "", message);
  }

  // Definição ÚNICA do método report(int line, String where, String message)
  private static void report(int line, String where, String message) {
    System.err.println("[line " + line + "] Error" + where + ": " + message);
    hadError = true;
  }
}