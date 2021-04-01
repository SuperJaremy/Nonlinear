package edu.io;

import edu.methods.Method;

public abstract class Output {
    public void write(Method method){
        String[] strings = new String[3];
        strings[0] = "Корень уравнения на отрезке: "+method.getSolution();
        strings[1] = "Значение функции в корне: "+method.getValue();
        strings[2] = "Количество шагов работы метода: "+method.getStepCount();
        try {
            writeDown(strings);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    protected abstract void writeDown(String[] strings) throws Exception;
}
