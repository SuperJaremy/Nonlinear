package edu.io;

public class ConsoleOutput extends Output {
    @Override
    public void writeDown(String[] strings){
        for(String i : strings){
            System.out.println(i);
        }
    }
}
