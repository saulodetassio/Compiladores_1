package main.java.com.craftinginterpreters.lox;

import java.util.*;

class Interpreter implements Expr.Visitor<Object> {

  Object evaluate(Expr expr) {
    return expr.accept(this);
  }

  @Override
  public Object visitLiteralExpr(Expr.Literal expr) {
    return expr.value;
  }

  @Override
  public Object visitGroupingExpr(Expr.Grouping expr) {
    return evaluate(expr.expression);
  }

  @Override
  public Object visitUnaryExpr(Expr.Unary expr) {
    Object right = evaluate(expr.right);

    switch (expr.operator.type) {
      case MINUS:
        return -(double) right;
      case BANG:
        return !isTruthy(right);
    }

    // Unreachable.
    return null;
  }

  @Override
  public Object visitBinaryExpr(Expr.Binary expr) {
    Object left = evaluate(expr.left);
    Object right = evaluate(expr.right);

    switch (expr.operator.type) {
      case PLUS:
        if (left instanceof Double && right instanceof Double) {
          return (double) left + (double) right;
        }
        if (left instanceof String && right instanceof String) {
          return (String) left + (String) right;
        }
        throw new RuntimeError(expr.operator,
            "Operands must be two numbers or two strings.");
      case MINUS:
        checkNumberOperands(expr.operator, left, right);
        return (double) left - (double) right;
      case STAR:
        checkNumberOperands(expr.operator, left, right);
        return (double) left * (double) right;
      case SLASH:
        checkNumberOperands(expr.operator, left, right);
        return (double) left / (double) right;
      case GREATER:
        checkNumberOperands(expr.operator, left, right);
        return (double) left > (double) right;
      case GREATER_EQUAL:
        checkNumberOperands(expr.operator, left, right);
        return (double) left >= (double) right;
      case LESS:
        checkNumberOperands(expr.operator, left, right);
        return (double) left < (double) right;
      case LESS_EQUAL:
        checkNumberOperands(expr.operator, left, right);
        return (double) left <= (double) right;
      case BANG_EQUAL:
        return !isEqual(left, right);
      case EQUAL_EQUAL:
        return isEqual(left, right);
    }

    // Unreachable.
    return null;
  }

  private boolean isTruthy(Object object) {
    if (object == null) return false;
    if (object instanceof Boolean) return (boolean) object;
    return true;
  }

  private boolean isEqual(Object a, Object b) {
    if (a == null && b == null) return true;
    if (a == null) return false;
    return a.equals(b);
  }

  private void checkNumberOperand(Token operator, Object operand) {
    if (operand instanceof Double) return;
    throw new RuntimeError(operator, "Operand must be a number.");
  }

  private void checkNumberOperands(Token operator, Object left, Object right) {
    if (left instanceof Double && right instanceof Double) return;
    throw new RuntimeError(operator, "Operands must be numbers.");
  }

  // Converte valor para string pra exibir adequadamente.
  private String stringify(Object object) {
    if (object == null) return "nil";
    if (object instanceof Double) {
      String text = object.toString();
      if (text.endsWith(".0")) {
        text = text.substring(0, text.length() - 2);
      }
      return text;
    }
    return object.toString();
  }
}
