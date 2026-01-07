package simplejavacalculator;

import static java.lang.Double.NaN;
import static java.lang.Math.log10;
import static java.lang.Math.pow;

/**
 * Clase Calculator que maneja operaciones matemáticas básicas y avanzadas.
 * Mejorada con estructuras switch y validaciones de seguridad.
 */
public class Calculator {

    /**
     * Modos para operaciones que requieren dos números (binarias).
     */
    public enum BiOperatorModes {
        normal, add, minus, multiply, divide, xpowerofy 
    }

    /**
     * Modos para operaciones que requieren un solo número (monarias).
     */
    public enum MonoOperatorModes {
        square, squareRoot, oneDividedBy, cos, sin, tan, log, rate, abs
    }

    private double num1, num2;
    private BiOperatorModes mode = BiOperatorModes.normal;

    /**
     * Implementación interna de los cálculos binarios utilizando switch para mayor claridad.
     * @return El resultado de la operación aplicada a num1 y num2.
     */
    private double calculateBiImpl() {
        switch (mode) {
            case add:
                return num1 + num2;
            case minus:
                return num1 - num2;
            case multiply:
                return num1 * num2;
            case divide:
                // Validación para evitar división por cero
                return (num2 != 0) ? num1 / num2 : NaN;
            case xpowerofy:
                return pow(num1, num2);
            case normal:
                return num2;
            default:
                throw new UnsupportedOperationException("Modo de operación no soportado");
        }
    }

    /**
     * Prepara y ejecuta un cálculo binario.
     * @param newMode El nuevo modo de operación a establecer.
     * @param num El número actual ingresado.
     * @return El resultado acumulado o NaN si es la primera entrada.
     */
    public Double calculateBi(BiOperatorModes newMode, Double num) {
        if (mode == BiOperatorModes.normal) {
            num2 = 0.0;
            num1 = num;
            mode = newMode;
            return NaN;
        } else {
            num2 = num;
            num1 = calculateBiImpl();
            mode = newMode;
            return num1;
        }
    }

    /**
     * Ejecuta el cálculo final (botón igual).
     */
    public Double calculateEqual(Double num) {
        return calculateBi(BiOperatorModes.normal, num);
    }

    /**
     * Reinicia los valores de la calculadora.
     */
    public Double reset() {
        num2 = 0.0;
        num1 = 0.0;
        mode = BiOperatorModes.normal;
        return NaN;
    }

    /**
     * Realiza operaciones de un solo operando con validaciones matemáticas.
     * @param newMode Operación a realizar.
     * @param num Número sobre el cual operar.
     * @return Resultado del cálculo.
     */
    public Double calculateMono(MonoOperatorModes newMode, Double num) {
        switch (newMode) {
            case square:
                return num * num;
            case squareRoot:
                return (num >= 0) ? Math.sqrt(num) : NaN;
            case oneDividedBy:
                return (num != 0) ? 1 / num : NaN;
            case cos:
                return Math.cos(Math.toRadians(num));
            case sin:
                return Math.sin(Math.toRadians(num));
            case tan:
                // Manejo de asíntotas de la tangente
                if (num % 180 == 0) return 0.0;
                if (num % 90 == 0 && num % 180 != 0) return NaN;
                return Math.tan(Math.toRadians(num));
            case log:
                return (num > 0) ? log10(num) : NaN;
            case rate:
                return num / 100;
            case abs:
                return Math.abs(num);
            default:
                return NaN;
        }
    }
}
