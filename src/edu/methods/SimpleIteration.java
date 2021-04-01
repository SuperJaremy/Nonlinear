package edu.methods;

import edu.Equations;

import java.util.function.UnaryOperator;

public class SimpleIteration extends Method {
    private double lambda = 0;
    private UnaryOperator<Double> normalizedFunction;
    private double previousX;
    private double q = 0;

    public SimpleIteration(Equations equation, double a, double b, double epsilon) {
        super(equation, a, b, epsilon);
    }

    @Override
    protected boolean solve() {
        if (!normalize()) {
            System.out.println("Не удалось нормализовать функцию");
            return false;
        }
        if (!checkConvergence()) {
            System.out.println("Метод не сходится на отрезке");
            return false;
        }
        x = (a + b) / 2;
        do {
            previousX = x;
            x = normalizedFunction.apply(previousX);
            step++;
        } while (step < LIMIT && !checkExit());
        return true;
    }

    @Override
    protected boolean checkConvergence() {
        q = findMax(a, b, x -> Math.abs(1 + lambda * equation.getDerivative().apply(x)));
        return q < 1;
    }

    private boolean normalize() {
        double val = findMax(a, b, equation.getDerivative());
        if (val != 0)
            lambda = -1 / val;
        else
            return false;
        normalizedFunction = x -> x + lambda * equation.getFunction().apply(x);
        return true;
    }

    private double findMax(double a, double b, UnaryOperator<Double> _function) {
        double max = _function.apply(a);
        for (double i = a; i <= b; i += (b - a) / 100) {
            max = Math.max(max, _function.apply(i));
        }
        return max;
    }

    @Override
    protected boolean checkExit() {
        if (q <= 0.5)
            return Math.abs(x - previousX) <= epsilon;
        else
            return Math.abs(x - previousX) <= (1 - q) / q * epsilon;
    }
}