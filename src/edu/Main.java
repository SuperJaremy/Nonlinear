package edu;

import edu.io.*;
import edu.methods.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean success = false;
        Input in = new ConsoleInput();
        System.out.println("Откуда будет произведён ввод исходных данных [f]ile/[c]onsole?");
        while(!success) {
            String answer = input.nextLine().trim();
            if(answer.equals("f")) {
                in = new FileInput();
                success = true;
            }
            else if(answer.equals("c")) {
                success = true;
            }
            else
                System.out.println("f/c?");
        }
        InputData data = in.read();
        Method method = data.getMethod().solve(data);
        Output output = new ConsoleOutput();
        output.write(method);
        System.out.println("Сохранить результаты в файл? y/n");
        success = false;
        while(!success) {
            String answer = input.nextLine().trim();
            if(answer.equals("y")) {
                output = new FileOutput();
                output.write(method);
                success = true;
            }
            else if(answer.equals("n")) {
                success = true;
            }
            else
                System.out.println("y/n?");
        }
    }
}
