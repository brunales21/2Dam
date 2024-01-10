package com.example.calculadora;

import com.udojava.evalex.Expression;

public class Controlador {
    public static double resolverExpresion(String expresion) {
        // Evalúa la expresión matemática usando EvalEx
        Expression expression = new Expression(expresion);
        return expression.eval().doubleValue();
    }
}
