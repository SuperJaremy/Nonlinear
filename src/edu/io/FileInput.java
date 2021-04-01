package edu.io;

import edu.InputData;

import java.io.BufferedReader;
import java.io.FileReader;

import java.io.IOException;
import java.util.Scanner;

public class FileInput extends Input{
    @Override
    public double[] readNumbers() throws Exception {
        Scanner input = new Scanner(System.in);
        System.out.println("Требования к оформелнию файла");
        System.out.println("Через пробел: a b epsilon");
        System.out.println("Введите имя файла");
        String filename = input.nextLine().trim();
        try(BufferedReader reader = new BufferedReader(new FileReader(filename))){
            String line = reader.readLine().trim();
            String[] numbers = line.split(" ");
            if(numbers.length!=3)
                throw new IOException("Неверное число аргументов");
            else{
                return new double[]{
                        Double.parseDouble(numbers[0]),
                        Double.parseDouble(numbers[1]),
                        Double.parseDouble(numbers[2])
                };
            }
        }
    }
}
