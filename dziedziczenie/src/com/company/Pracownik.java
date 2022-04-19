package com.company;

import java.util.Scanner;

public class Pracownik {
    protected String imie;
    protected String nazwisko;
    protected int lataPracy;
    protected int wiek;
    protected int pensja;

    protected String login;
    protected String haslo;

    protected Scanner s = new Scanner(System.in);

    Pracownik(){
        System.out.println("Imie: ");
        imie = s.next();
        System.out.println("Nazwisko: ");
        nazwisko = s.next();
        System.out.println("lataPracy: ");
        lataPracy = s.nextInt();
        System.out.println("wiek: ");
        wiek = s.nextInt();
        System.out.println("pensja: ");
        pensja = s.nextInt();

        login = nazwisko+imie.charAt(0);
        haslo=""+wiek;
    }
    Pracownik(String imie, String nazwisko, int lataPracy, int wiek, int pensja){
        this.imie=imie;
        this.nazwisko=nazwisko;
        this.lataPracy=lataPracy;
        this.wiek=wiek;
        this.pensja=pensja;

        login = nazwisko+imie.charAt(0);
        haslo=""+wiek;

    }

    protected int oblZysk(){
        return pensja*lataPracy;
    }

    protected int zaloguj(){
        System.out.println("Login: ");
        String log=s.next();
        System.out.println("Haslo: ");
        String has=s.next();

        if(log.equals(login) && has.equals(haslo)){
            System.out.println("Zalagowano "+imie+" "+nazwisko);
            return 1;
        }
        else if(log.equals("admin") && has.equals("admin")){
            System.out.println("Zalagowano admin");
            return 2;
        }
        else{
            System.out.println("Sprobij ponownie");
            return 0;
        }
    }


}
