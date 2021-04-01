package edu;

public class InputData {
    private Equations equation;
    private double a;
    private double b;
    private double epsilon;
    private DataToMethod method;

    public void setEquation(Equations equation) {
        this.equation = equation;
    }

    public void setA(double a) {
        this.a = a;
    }

    public void setB(double b) {
        this.b = b;
    }

    public void setEpsilon(double epsilon) {
        this.epsilon = epsilon;
    }

    public Equations getEquation() {
        return equation;
    }

    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }

    public double getEpsilon() {
        return epsilon;
    }

    public void setMethod(DataToMethod method) {
        this.method = method;
    }

    public DataToMethod getMethod() {
        return method;
    }
}
