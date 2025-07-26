package main.java.com.craftinginterpreters.lox;


import java.util.List;

class LoxFunction implements LoxCallable {
    private final Stmt.Function declaration;
    private final Environment closure; // Adicionado no Capítulo 11, mas bom já ter.

    LoxFunction(Stmt.Function declaration, Environment closure) {
        this.closure = closure;
        this.declaration = declaration;
    }

    @Override
    public int arity() {
        return declaration.params.size();
    }

    @Override
    public Object call(Interpreter interpreter, List<Object> arguments) {
        // Cria um novo ambiente para a função, aninhado no ambiente onde a função foi declarada (closure).
        Environment environment = new Environment(closure); 
        for (int i = 0; i < declaration.params.size(); i++) {
            environment.define(declaration.params.get(i).lexeme, arguments.get(i));
        }

        // --- A CORREÇÃO ESTÁ AQUI ---
        try {
            // Executa o corpo da função no novo ambiente.
            interpreter.executeBlock(declaration.body, environment);
        } catch (Return returnValue) {
            // Se uma exceção 'Return' for lançada, a capturamos e retornamos seu valor.
            return returnValue.value;
        }

        // Se a função terminar sem um 'return' explícito, ela retorna 'nil' (null).
        return null;
    }

    @Override
    public String toString() {
        return "<fn " + declaration.name.lexeme + ">";
    }
}