package edu;


import java.util.function.UnaryOperator;

public enum Equations {
    FIRST("-2.4x^3+1.27x^2+8.63x+2.31",
            x -> -2.4 * Math.pow(x, 3) + 1.27 * Math.pow(x, 2) + 8.63 * x + 2.31,
            x -> -7.2 * Math.pow(x, 2) + 2.54 * x + 8.63,
            x -> -14.4 * x + 2.54,
            -3, 3
    ),
    SECOND("sin^2(x)-0.1x^2+1",
            x -> Math.pow(Math.sin(x), 2) - 0.1 * Math.pow(x, 2) + 1,
            x -> 2 * Math.sin(x) * Math.cos(x) - 0.2 * x,
            x -> -2 * Math.pow(Math.sin(x), 2) + 2 * Math.pow(Math.cos(x), 2) - 0.2,
            -6, 6),
    THIRD("12e^2x-4.7x^3+6x-2",
            x -> 12 * Math.exp(2 * x) - 4.7 * Math.pow(x, 3) + 6 * x - 2,
            x -> -14.1 * Math.pow(x, 2) + 24 * Math.exp(2 * x) + 6,
            x -> 48 * Math.exp(2 * x) - 28.2 * x,
            -2, 1),
    FOURTH("1.4x^5+0.3*x^4-1.1x^3-3.4*x^2+1.1",
            x -> 1.4 * Math.pow(x, 5) + 0.3 * Math.pow(x, 4) - 1.1 * Math.pow(x, 3) - 3.4 * Math.pow(x, 2) + 1.1,
            x -> x * (7 * Math.pow(x, 3) + 1.2 * Math.pow(x, 2) - 3.3 * -6.8),
            x -> 28 * (Math.pow(x, 3) + 0.128571 * Math.pow(x, 2) - 0.235714 * x - 0.242857),
            -1, 2);


    private final String equation;

    private final UnaryOperator<Double> function;

    private final UnaryOperator<Double> derivative;

    private final UnaryOperator<Double> secondDerivative;

    private final double leftBorder;

    private final double rightBorder;

    Equations(String equation, UnaryOperator<Double> function, UnaryOperator<Double> derivative,
              UnaryOperator<Double> secondDerivative,
              double leftBorder, double rightBorder) {
        this.equation = equation;
        this.derivative = derivative;
        this.function = function;
        this.secondDerivative = secondDerivative;
        this.leftBorder = leftBorder;
        this.rightBorder = rightBorder;
    }

    public UnaryOperator<Double> getFunction() {
        return function;
    }

    public UnaryOperator<Double> getDerivative() {
        return derivative;
    }

    public UnaryOperator<Double> getSecondDerivative() {
        return secondDerivative;
    }

    public double getLeftBorder() {
        return leftBorder;
    }

    public double getRightBorder() {
        return rightBorder;
    }

    @Override
    public String toString() {
        return equation;
    }
}


