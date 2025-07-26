// Em lox/LoxCallable.java
package main.java.com.craftinginterpreters.lox;

import java.util.List;

interface LoxCallable {
    int arity(); // Número de argumentos que a função espera.
    Object call(Interpreter interpreter, List<Object> arguments);
}