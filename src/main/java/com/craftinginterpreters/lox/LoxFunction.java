package main.java.com.craftinginterpreters.lox;

import java.util.List;
class LoxFunction implements LoxCallable {
    private final Stmt.Function declaration;
    private final Environment closure;
    private final boolean isInitializer;

    LoxFunction(Stmt.Function declaration, Environment closure, boolean isInitializer) {
        this.isInitializer = isInitializer;
        this.closure = closure;
        this.declaration = declaration;
    }

    /**
     * Cria um novo ambiente para o método, vinculando a instância (this) a ele.
     * Isso garante que, quando o método for chamado, 'this' esteja disponível em seu escopo.
     */
    LoxFunction bind(LoxInstance instance) {
        Environment environment = new Environment(closure);
        environment.define("this", instance);
        return new LoxFunction(declaration, environment, isInitializer);
    }

    @Override
    public int arity() {
        return declaration.params.size();
    }

    @Override
    public Object call(Interpreter interpreter, List<Object> arguments) {
        Environment environment = new Environment(closure);
        for (int i = 0; i < declaration.params.size(); i++) {
            environment.define(declaration.params.get(i).lexeme, arguments.get(i));
        }

        try {
            interpreter.executeBlock(declaration.body, environment);
        } catch (Return returnValue) {
            // Se for um inicializador, um 'return' explícito retorna 'this'.
            if (isInitializer) return closure.getAt(0, "this");
            
            return returnValue.value;
        }

        // Se for um inicializador, retorna 'this' implicitamente no final.
        if (isInitializer) return closure.getAt(0, "this");
        
        return null;
    }

    @Override
    public String toString() {
        return "<fn " + declaration.name.lexeme + ">";
    }
}