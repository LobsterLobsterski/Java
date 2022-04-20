package com.company;

import java.util.Vector;

public class Kelner extends Pracownik{
    private int napiwki;
    private int liczbaZrealizowanychZamowien;

    Kelner(){
        super();
        System.out.println("Ilosc napiowkow");
        napiwki=s.nextInt();
        System.out.println("liczba zrealizowanych zamowien");
        liczbaZrealizowanychZamowien=s.nextInt();
    }

    Kelner(int napiwki, int liczbaZamowien, String imie, String nazwisko, int lataPracy, int wiek, int pensja){
        super(imie, nazwisko, lataPracy, wiek, pensja);
        this.napiwki=napiwki;
        this.liczbaZrealizowanychZamowien=liczbaZamowien;
    }

    public static Vector<String> zamowienia =  new Vector<String>();

    public static void zrealizuj(String zam){
        zamowienia.add(zam);
        System.out.println("Dodano zamówienie: "+zam);
    }
    public void odbierz(){
        System.out.println("zamówienie do odebrania: "+zamowienia.get(0));
        zamowienia.remove(0);
        liczbaZrealizowanychZamowien++;
        System.out.println("zamówienie odebrane przez: " + imie+" "+nazwisko);

    }

}
