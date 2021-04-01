package edu.io;

import edu.*;

import java.util.Scanner;

public abstract class Input {
    public InputData read(){
        InputData data = new InputData();
        Scanner input = new Scanner(System.in);
        boolean success = false;
        while(!success){
            System.out.println("Выберите уравнение");
            int step = 1;
            for(Equations i : Equations.values()){
                System.out.println(step+". "+i);
                step++;
            }
            int a = input.nextInt();
            if(a>Equations.values().length || a<1)
                System.out.println("Нет такого уравнения");
            else{
                success=true;
                Equations equation = Equations.values()[a-1];
                data.setEquation(equation);
            }
        }
        Equations equation = data.getEquation();
        EquationChart equationChart = new EquationChart(
                new Chart(equation, equation.getLeftBorder(), equation.getRightBorder()));
        try {
            double[] numbers = readNumbers();
            data.setA(numbers[0]);
            data.setB(numbers[1]);
            data.setEpsilon(numbers[2]);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
        success = false;
        while(!success){
            System.out.println("Выберите метод");
            int step = 1;
            for(Methods i : Methods.values()){
                System.out.println(step+". "+i);
                step++;
            }
            int number = input.nextInt();
            if(number> Methods.values().length || number<1)
                System.out.println("Нет такого уравнения");
            else{
                success=true;
                data.setMethod(Methods.values()[number-1].getMethod());
            }
        }
        equationChart.dispose();
        return data;
    }

    protected abstract double[] readNumbers() throws Exception;
}
