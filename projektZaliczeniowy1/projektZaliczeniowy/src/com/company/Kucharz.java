package com.company;

import java.util.Random;

public class Kucharz extends Pracownik implements wyplata{

    private boolean czyMaBadania;
    private int wydajnosc;
    Random rand = new Random();
    float wsp=rand.nextFloat((float)1.5);

    public enum rodzajeKebabow {
        rollo,
        bulka,
        talerz,
        box
    }

    Kucharz(){
        super();
        System.out.println("Posiadasz badania? true/false");
        czyMaBadania=Boolean.parseBoolean(checkInput("boolean"));
        System.out.println("średnia ilość kebabów na godzine");
        wydajnosc=Integer.parseInt(checkInput("int"));
        pensja = wyplata(1.3);
    }
    Kucharz(boolean czyMaBadania, int wydajnosc, int id, String imie, String nazwisko, int lataPracy, int wiek, int pensja){
        super(id, imie, nazwisko, lataPracy, wiek, pensja);
        this.czyMaBadania=czyMaBadania;
        this.wydajnosc=wydajnosc;
        this.pensja = wyplata(1.3);
    }
    Kucharz(int id){
        this();
        this.id=id;
    }

    public double czasRobieniaKebaba(rodzajeKebabow rodzaj, int liczba) {
        double czas;
        if (rodzaj == rodzajeKebabow.box) {

            czas = liczba * 0.4 * wydajnosc*wsp;
            //System.out.println("Kucharz zrobi box w " + czas);
            return czas;
        }

        else if (rodzaj == rodzajeKebabow.rollo) {

            czas = liczba * 0.3 * wydajnosc*wsp;
            //System.out.println("Kucharz zrobi rollo w " + czas);
            return czas;
        }

        else if (rodzaj == rodzajeKebabow.bulka) {

            czas = liczba * 0.2 * wydajnosc*wsp;
            //System.out.println("Kucharz zrobi w bułce w " + czas);
            return czas;
        }
        else {
            czas = liczba * 0.1 * wydajnosc*wsp;
            //System.out.println("Kucharz zrobi na talerzu w " + czas);
            return czas;
        }
    }

    public void wyswietl()
    {
        super.wyswietl();
        System.out.println("Pozycja: Kucharz");
        System.out.println("ma badania: "+czyMaBadania);
        System.out.println("wydajnosc: "+wydajnosc);
        System.out.println("---------------------------------------------------------------------");

    }

    @Override
    public int bonus() {return 100*wydajnosc;}

    public boolean isCzyMaBadania() {
        return czyMaBadania;
    }

    public int getWydajnosc() {
        return wydajnosc;
    }

}
