package org.example;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

public class Main {
    public static void main(String[] args) {
        // Expresión matemática en formato de cadena
        String expression = "2* -3+10-16/8+5.5";

        // Crear un objeto ExpressionBuilder para construir la expresión
        ExpressionBuilder builder = new ExpressionBuilder(expression);

        // Crear un objeto Expression
        Expression expr = builder.build();

        try {
            // Evaluar la expresión y obtener el resultado
            double resultado = expr.evaluate();
            System.out.println("Resultado: " + resultado);
        } catch (ArithmeticException e) {
            // Manejar excepciones, por ejemplo, división por cero
            System.err.println("Error: " + e.getMessage());
        }
    }
}
