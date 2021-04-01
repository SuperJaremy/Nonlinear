package edu.methods;

import edu.Equations;

import java.util.function.UnaryOperator;

public class Newton extends Method {
    private double x_prev;

    public Newton(Equations equation, double a, double b, double epsilon) {
        super(equation, a, b, epsilon);
    }

    @Override
    protected boolean solve() {
        if (!checkConvergence()) {
            System.out.println("Метод не сходится на отрезке");
            return false;
        }
        if (equation.getFunction().apply(a) * equation.getSecondDerivative().apply(a) > 0)
            x = a;
        else
            x = b;
        do {
            step++;
            x_prev = x;
            x = x_prev - equation.getFunction().apply(x_prev) / equation.getDerivative().apply(x_prev);
        } while (!checkExit());
        return true;
    }

    @Override
    protected boolean checkConvergence() {
        if (!(equation.getFunction().apply(a) * equation.getFunction().apply(b) < 0)) {
            return false;
        }
        return signState(equation.getDerivative(), a, b) && signState(equation.getSecondDerivative(), a, b)
                && notZero(equation.getDerivative(),a,b);
    }

    @Override
    protected boolean checkExit() {
        return Math.abs(x - x_prev) <= epsilon;
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

    private boolean notZero(UnaryOperator<Double> _function, double a, double b) {
        double sign = Math.signum(_function.apply(a));
        for (double i = a; i <= b; i += (b - a) / 1000) {
            sign *= Math.signum(_function.apply(i));
        }
        return sign != 0;
    }
}
