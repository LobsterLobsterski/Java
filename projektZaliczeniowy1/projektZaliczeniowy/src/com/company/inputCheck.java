package com.company;

import java.util.Scanner;

public interface inputCheck {
    Scanner scanner = new Scanner(System.in);

    default String checkInput(String type){
        while (true) {
            String input = scanner.next();
            if (type.equals("int")) {
                try {
                    int x = Integer.parseInt(input);
                    return Integer.toString(x);
                } catch (NumberFormatException e) {
                    System.out.println("Nie poprawne wejście, oczekiwano liczby całkowitej.\nSpróbuj ponownie");
                }
            }
            else if(type.equals("float")){
                try {
                    float x = Float.parseFloat(input);
                    return Float.toString(x);
                } catch (NumberFormatException e) {
                    System.out.println("Nie poprawne wejście, oczekiwano wartości zmiennoprzecinkowej.\nSpróbuj ponownie");
                }
            }
            else if(type.equals("boolean")){
                try {
                    boolean x = Boolean.parseBoolean(input);
                    return Boolean.toString(x);
                } catch (NumberFormatException e) {
                    System.out.println("Nie poprawne wejście, oczekiwano wartości typu boolean.\nSpróbuj ponownie");
                }
            }
        }
    }
}
