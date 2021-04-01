package edu.io;

import java.util.Scanner;

public class ConsoleInput extends Input {
    @Override
    protected final double[] readNumbers(){
        Scanner input = new Scanner(System.in);
        System.out.println("Введите a");
        double a = input.nextDouble();
        System.out.println("Введите b");
        double b = input.nextDouble();
        System.out.println("Введите эпсилон");
        double epsilon = input.nextDouble();
        return new double[]{a,b,epsilon};
    }
}
