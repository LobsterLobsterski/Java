package com.company;

import java.util.Scanner;

public class Pracownik{

    protected int id;
    protected String imie;
    protected String nazwisko;
    protected int lataPracy;
    protected int wiek;
    protected int pensja;
    protected String login;
    protected String haslo;

    protected Scanner scanner = new Scanner(System.in);

    Pracownik() {
        System.out.println("Imie: ");
        imie = scanner.next();
        System.out.println("Nazwisko: ");
        nazwisko = scanner.next();
        System.out.println("lataPracy: ");
        lataPracy = scanner.nextInt();
        System.out.println("wiek: ");
        wiek = scanner.nextInt();
        System.out.println("pensja: ");
        pensja = scanner.nextInt();

        login = nazwisko + imie.charAt(0);
        haslo = "" + wiek;

    }

    Pracownik(int id, String imie, String nazwisko, int lataPracy, int wiek, int pensja) {
        this.id=id;
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.lataPracy = lataPracy;
        this.wiek = wiek;
        this.pensja = pensja;

        login = nazwisko + imie.charAt(0);
        haslo = imie + nazwisko.charAt(0);
        //System.out.println(login+" "+haslo);
    }


    protected int zaloguj() {
        System.out.println("Login: ");
        String log = scanner.next();
        System.out.println("Haslo: ");
        String has = scanner.next();

        if (log.equals(login) && has.equals(haslo)) {
            System.out.println("Zalagowano " + imie + " " + nazwisko+"\n");
            return 1;
        } else if (log.equals("admin") && has.equals("admin")) {
            System.out.println("Zalagowano admin\n");
            return 2;
        } else {
            System.out.println("Sprobuj ponownie");
            return 0;
        }
    }

    public void wyswietl(){
        System.out.println("ID: "+id);
        System.out.println("Imie: "+imie);
        System.out.println("Nazwisko: "+nazwisko);
        System.out.println("Lata pracy: "+lataPracy);
        System.out.println("Wiek: "+wiek);
        System.out.println("Pensja: "+pensja);
    }

}







