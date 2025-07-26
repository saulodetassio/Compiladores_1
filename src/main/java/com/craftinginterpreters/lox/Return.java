package main.java.com.craftinginterpreters.lox;

// Em lox/Return.java

class Return extends RuntimeException {
    final Object value;

    Return(Object value) {
        super(null, null, false, false); // Otimização para exceções de controle de fluxo
        this.value = value;
    }
}
