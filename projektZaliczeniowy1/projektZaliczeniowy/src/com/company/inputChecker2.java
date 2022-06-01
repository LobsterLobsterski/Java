package com.company;

import java.util.Scanner;

/*********************************************************
Próbowałem to z interfejsem robić ale nie mogłem tego
 wtedy użyć w main'ie bo static, działało tylko dla
 innych klas.
 Metoda ta sprawdza typ wejścia od uzytkownika i
 sprawdza czy jest poprawnego typu, jeżeli nie
 użytkownik zostanie o tym poinformowany oraz
 będzie zmuszony wpisywac tak długo aż wpisze
 dobrze.
*********************************************************/

public class inputChecker2 {
    static Scanner scanner = new Scanner(System.in);

    static String checkInput(String type){
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
                if (input.equals("true") || input.equals("1")){
                    return "true";
                }
                else if(input.equals("false") || input.equals("0")){
                    return "false";
                }
                else{
                    System.out.println("Nie poprawne wejście, oczekiwano wartości typu boolean (true/false) lub (1/0).\nSpróbuj ponownie");
                }
            }
        }
    }
}
