package simplejavacalculator;

import static java.lang.Double.NaN;
import static java.lang.Math.log10;
import static java.lang.Math.pow;

public class Calculator {

    // Binary operators: +, -, *, /, power
    public enum BiOperatorModes {
        normal, add, minus, multiply, divide, xpowerofy
    }

    // Single number operators: square, sqrt, sin, cos, etc.
    public enum MonoOperatorModes {
        square, squareRoot, oneDividedBy, cos, sin, tan, log, rate, abs
    }

    private double num1, num2;
    private BiOperatorModes mode = BiOperatorModes.normal;

    // Performs calculation based on selected binary operator
    private double calculateBiImpl() {

        if (mode == BiOperatorModes.normal) {
            return num2;
        }

        if (mode == BiOperatorModes.add) {
            return num1 + num2;
        }

        if (mode == BiOperatorModes.minus) {
            return num1 - num2;
        }

        if (mode == BiOperatorModes.multiply) {
            return num1 * num2;
        }

        if (mode == BiOperatorModes.divide) {
            if (num2 == 0) {
                return NaN; // prevent divide by zero
            }
            return num1 / num2;
        }

        if (mode == BiOperatorModes.xpowerofy) {
            return pow(num1, num2);
        }

        // should never reach here
        throw new Error("Unknown operation");
    }

    // Handles +, -, *, /, power button presses
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

    // Handles "=" button
    public Double calculateEqual(Double num) {
        return calculateBi(BiOperatorModes.normal, num);
    }

    // Clears calculator
    public Double reset() {
        num2 = 0.0;
        num1 = 0.0;
        mode = BiOperatorModes.normal;
        return NaN;
    }

    // Handles single-number operations
    public Double calculateMono(MonoOperatorModes newMode, Double num) {

        if (newMode == MonoOperatorModes.square) {
            return num * num;
        }

        if (newMode == MonoOperatorModes.squareRoot) {
            return Math.sqrt(num);
        }

        if (newMode == MonoOperatorModes.oneDividedBy) {
            if (num == 0) return NaN;
            return 1 / num;
        }

        if (newMode == MonoOperatorModes.cos) {
            return Math.cos(Math.toRadians(num));
        }

        if (newMode == MonoOperatorModes.sin) {
            return Math.sin(Math.toRadians(num));
        }

        if (newMode == MonoOperatorModes.tan) {
            if (num == 0 || num % 180 == 0) {
                return 0.0;
            }
            if (num % 90 == 0 && num % 180 != 0) {
                return NaN;
            }
            return Math.tan(Math.toRadians(num));
        }

        if (newMode == MonoOperatorModes.log) {
            return log10(num);
        }

        if (newMode == MonoOperatorModes.rate) {
            return num / 100;
        }

        // 🔥 NEW CONTRIBUTION: abs implementation
        if (newMode == MonoOperatorModes.abs) {
            return Math.abs(num);
        }

        return NaN;
    }
}
