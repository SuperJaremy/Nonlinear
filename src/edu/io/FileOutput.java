package edu.io;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Scanner;

public class FileOutput extends Output{
    @Override
    protected void writeDown(String[] strings) throws Exception {
        System.out.println("Введите имя файла");
        Scanner input = new Scanner(System.in);
        String filename = input.nextLine().trim();
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(filename))){
            for(String i : strings){
                writer.write(i);
                writer.newLine();
            }
            System.out.println("Результат успешно записан");
        }
    }
}
