package edu;

import edu.methods.Chords;
import edu.methods.Newton;
import edu.methods.SimpleIteration;

public enum Methods {
    CHORDS("Метод хорд" ,x-> new Chords(x.getEquation(), x.getA(), x.getB(), x.getEpsilon())),
    NEWTON("Метод Ньютона" ,x -> new Newton(x.getEquation(), x.getA(), x.getB(), x.getEpsilon())),
    ITERATIONS("Метод простых итераций" ,
            x -> new SimpleIteration(x.getEquation(),x.getA(), x.getB(), x.getEpsilon()));

    private String name;
    private DataToMethod method;
    private Methods(String name, DataToMethod method){
        this.name = name;
        this.method = method;
    }

    public DataToMethod getMethod(){
        return method;
    }

    @Override
    public String toString() {
        return name;
    }
}
