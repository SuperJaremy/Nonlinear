package edu.methods;

import edu.Equations;

public abstract class Method {
    protected final double LIMIT = 2000000;
    protected final double epsilon;
    protected final Equations equation;
    protected double a;
    protected double b;
    protected boolean success;
    protected double x;
    protected int step = 0;

    public Method(Equations equation, double a, double b, double epsilon){
        this.epsilon = epsilon;
        this.equation = equation;
        if(a==b){
            System.out.println("Введён некорректный отрезок");
            success = false;
        }
        else {
            if(a<b) {
                this.a = a;
                this.b = b;
            }
            else{
                this.a = b;
                this.b = a;
            }
            success = solve();
        }
    }

    protected abstract boolean solve();

    public Double getSolution() {
        return success ? x : null;
    }

    public Double getValue() {
        return success ? equation.getFunction().apply(x) : null;
    }

    public Integer getStepCount() {
        return success ? step : null;
    }

    protected abstract boolean checkConvergence();

    protected abstract boolean checkExit();
}
