package com.company;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

/*********************************************************
 Klasa przechowywująca wszystkie elementy potrzebne dla
 zamówienia.
 Ma 3 konstruktory: podstawowy jest do dodawania zamówień
 pierszy customowy przyjmuje nr oraz liste kont,
 i odwołuje się i tak do podstawowego a 2 customowy
 jest dla wczytywania z pliku.
 *********************************************************/

public class Zamowienie extends inputChecker2{
    int nr;
    int ilosc;
    Kucharz.rodzajeKebabow rodzaj;
    float cena;
    String nazwisko;
    Kucharz kucharz;

    int czasWykonania;
    private Scanner scanner = new Scanner(System.in);

    Zamowienie(){
        System.out.println("Rodzaj kebaba: \n"+"1. rollo \n"+"2 bułka \n"+"3 talerz \n" +"4 box \n");
        switch (Integer.parseInt(checkInput("int"))){
            case 1:
                rodzaj= Kucharz.rodzajeKebabow.rollo;
                break;
            case 2:
                rodzaj= Kucharz.rodzajeKebabow.bulka;
                break;
            case 3:
                rodzaj= Kucharz.rodzajeKebabow.talerz;
                break;
            default:
                rodzaj= Kucharz.rodzajeKebabow.box;
        }
        System.out.println("Ile?");
        ilosc=Integer.parseInt(checkInput("int"));
        System.out.println("Cena: ");
        cena=Integer.parseInt(checkInput("float"));
        System.out.println("Nazwisko kucharza: ");
        nazwisko=scanner.next();

    }

    Zamowienie(int nr, ArrayList<Pracownik> konta){
        this();
        this.nr=nr;
        setKucharz(nazwisko, konta);
        czasWykonania=(int)kucharz.czasRobieniaKebaba(rodzaj, ilosc);

    }

    Zamowienie(int nr, int ilosc, float cena, String nazwisko, ArrayList<Pracownik> konta){
        this.nr=nr;
        this.ilosc=ilosc;
        this.cena=cena;
        this.nazwisko=nazwisko;

        setKucharz(nazwisko, konta);
        czasWykonania=(int)kucharz.czasRobieniaKebaba(rodzaj, ilosc);
    }

    public void wyswietl(){
        System.out.print("nr zamówienia: "+nr+"\n");
        System.out.println("\tRodzaj kebaba: "+rodzaj);
        System.out.println("\tIlość: "+ilosc);
        System.out.println("\tCena: "+cena);
        System.out.println("\tKucharz: "+kucharz.imie+" "+kucharz.nazwisko);
        System.out.println("\tCzasWykonania: "+czasWykonania+" min");
        System.out.println();
    }

    public void setKucharz(String nazwisko, ArrayList<Pracownik> konta) {

        boolean jest=false;
        while (jest==false) {

            for (Pracownik p : konta) {
                if (p instanceof Kucharz && p.nazwisko.equals(nazwisko)) {
                    kucharz = (Kucharz) p;
                    jest = true;
                    break;
                }
            }
            if (jest == false) {
                System.out.println("Nieznaleziono kucharza o nazwisku "+nazwisko+"\nSpróbuj ponownie.");
                for (Pracownik p : konta) {
                    if (p instanceof Kucharz) {
                        System.out.println("ID: " + p.id + "\n\t" + p.imie + " " + p.nazwisko);
                    }
                }
                nazwisko=scanner.next();
                this.nazwisko=nazwisko;
            }

        }
    }

    public int getCzasWykonania() {
        return czasWykonania;
    }
}
