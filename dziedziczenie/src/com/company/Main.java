package com.company;

import java.util.ArrayList;
import java.util.Scanner;


public class Main {
    static int pozUprawnien=0;
    static ArrayList<Pracownik> konta = new ArrayList<>();
    static Scanner s = new Scanner(System.in);

    public static void log(){
        while (pozUprawnien==0){
            System.out.println("Login: ");
            String log=s.next();
            System.out.println("Haslo: ");
            String has=s.next();
            for (Pracownik p: konta){
                pozUprawnien = p.zaloguj(log, has);
                if (pozUprawnien!=0){
                    break;
                }
            }
        }
        menuu();
    }

    public static void menuu(){
        while(true){
            System.out.println("1.Dodaj uzytkownika \n" +
                    "2.Usun uzytkownika \n" +
                    "3. Wyswietl liste pracownikow \n" +
                    "4. dodaj zamowienie \n" +
                    "5. odbierz zamowienie \n" +
                    "6. Wyloguj");

            int menu=s.nextInt();
            switch (menu){
                case 1://dodaj
                    if (pozUprawnien==2){
                        System.out.println("1. kierowca \n" +
                                "2. kelner \n" +
                                "3. kucharz");
                        int menu1=s.nextInt();

                        switch (menu1){
                            case 1:
                                konta.add(new Kierowca());
                                break;
                            case 2:
                                konta.add(new Kelner());
                                break;
                            case 3:
                                konta.add(new Kucharz());
                                break;
                        }

                        break;
                    }
                    else{
                        System.out.println("Brak uprawnien");
                        break;
                    }

                case 2://usun
                    if (pozUprawnien==2){
                        System.out.println("Podaj idx pracownika");
                        int idx=s.nextInt();
                        System.out.println("Pracownik "+konta.get(idx).imie +" "+konta.get(idx).nazwisko);
                        System.out.println("Usunac? true/false");
                        boolean question=s.nextBoolean();
                        if (question) {
                            konta.remove(idx);
                            System.out.println("Usunieto");
                        }
                        else{
                            System.out.println("Powrot");
                        }
                        break;
                    }
                    else{
                        System.out.println("Brak uprawnien");
                        break;
                    }


                case 3://wyswietl
                    int i=0;
                    for (Pracownik p: konta){

                        System.out.println(i+" "+p.imie +" "+p.nazwisko+" "+p.wiek);
                        i++;
                    }
                    break;

                case 4://dodaj zam
                    System.out.println("Zamowienie: ");
                    String zam = s.next();
                    Kelner.zrealizuj(zam);
                    break;

                case 5://odbierz zam
                    if (Kelner.zamowienia.size() <1){
                        System.out.println("Brak zamowien");
                    }
                    else{
                        System.out.println("Wybierz indeks kelnera ktory ma odebrac zamowienie");
                        for (i=0; i<konta.size()-1; i++){
                            if (konta.get(i) instanceof Kelner){
                                System.out.println(i+" "+konta.get(i).imie +" "+konta.get(i).nazwisko+" "+konta.get(i).wiek);
                            }
                        }
                        System.out.println();
                        int idx = s.nextInt();
                        Kelner k = (Kelner) konta.get(idx);

                        k.odbierz();
                    }
                    break;

                default://wyloguj
                    pozUprawnien=0;
                    log();

            }
            System.out.println();
        }
    }


    public static void main(String[] args) {

        //int czas, int iloscPktKarnych, boolean maPrawko, Pojazd typPojazdu
        konta.add(new Kierowca(5,5,true, Kierowca.Pojazd.Dacia,"Jan","Nowak",3,27,5000));
        konta.add(new Kelner(200, 20,"Jano","Nowakowski",4,25,4000));
        konta.add(new Kucharz(true, 100,"Ahmed","Muhammad II",8,42,2000));

        log();

    }
}
