package edu.methods;

import edu.Equations;

import java.util.function.UnaryOperator;

public class Chords extends Method {
    private double x_prev;

    public Chords(Equations equation, double a, double b, double epsilon) {
        super(equation, a, b, epsilon);
    }

    @Override
    protected boolean solve() {
        if (!checkConvergence()) {
            System.out.println("Метод не сходится на отрезке");
            return false;
        }
        x = a - (b - a) / (equation.getFunction().apply(b) - equation.getFunction().apply(a))
                * equation.getFunction().apply(a);
        do {
            step++;
            if (equation.getFunction().apply(a) * equation.getFunction().apply(x) < 0)
                b = x;
            else
                a = x;
            x_prev = x;
            x = (a * equation.getFunction().apply(b) - b * equation.getFunction().apply(a))
                    / (equation.getFunction().apply(b) - equation.getFunction().apply(a));
        } while (step < LIMIT && !checkExit());
        return true;
    }

    @Override
    protected boolean checkConvergence() {
        if (!(equation.getFunction().apply(a) * equation.getFunction().apply(b) < 0)) {
            return false;
        }
        return signState(equation.getDerivative(), a, b) && signState(equation.getSecondDerivative(), a, b);
    }

    @Override
    protected boolean checkExit() {
        return Math.abs(x - x_prev) < epsilon;
    }

    private boolean signState(UnaryOperator<Double> _function, double a, double b) {
        double prev = _function.apply(a);
        double sign = Math.signum(prev);
        for (double i = a; i <= b; i += (b - a) / 1000) {
            double value = _function.apply(i);
            sign = Math.signum(prev * value);
            if(sign <= 0)
                return false;
            prev = value;
        }
        return sign > 0;
    }
}
