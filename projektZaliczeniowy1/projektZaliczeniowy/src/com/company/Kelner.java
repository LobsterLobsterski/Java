package com.company;

import java.util.Vector;

public class Kelner extends Pracownik implements wyplata{

    private  int napiwki;

    private int liczbaWykonanychZamowien;

    Kelner(){
        super();
        System.out.println("Ile napiwku: ");
        napiwki=Integer.parseInt(checkInput("int"));
        System.out.println("liczba wykonanych zamówień ");
        liczbaWykonanychZamowien=Integer.parseInt(checkInput("int"));
        pensja = wyplata(1);
    }
    Kelner(int napiwki, int liczbaWykonanychZamowien, int id, String imie, String nazwisko, int lataPracy, int wiek, int pensja){
        super(id, imie, nazwisko, lataPracy, wiek, pensja);
        this.napiwki=napiwki;
        this.liczbaWykonanychZamowien=liczbaWykonanychZamowien;
        this.pensja = wyplata(1);
    }
    Kelner(int id){
        this();
        this.id=id;
    }

    public void wyswietl()
    {
        super.wyswietl();
        System.out.println("Pozycja: Kelner");
        System.out.println("napwiki: "+napiwki);
        System.out.println("liczba wykonanych zamowien: "+liczbaWykonanychZamowien);
        System.out.println("---------------------------------------------------------------------");

    }

    public int getNapiwki() {
        return napiwki;
    }

    public void setNapiwki(int napiwki) {
        this.napiwki = napiwki;
    }

    public int getLiczbaWykonanychZamowien() {
        return liczbaWykonanychZamowien;
    }

    public void setLiczbaWykonanychZamowien(int liczbaWykonanychZamowien) {
        this.liczbaWykonanychZamowien = liczbaWykonanychZamowien;
    }

    @Override
    public int bonus() {return napiwki;}
}
