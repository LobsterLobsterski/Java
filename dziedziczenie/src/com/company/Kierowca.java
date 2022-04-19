package com.company;

public class Kierowca extends Pracownik{
    public enum Pojazd{
        Seat,
        VW,
        Toyota,
        Dacia
    }
    private int czas;
    private int iloscPktKarnych;
    private boolean maPrawko;
    private Pojazd typPojazdu;

    Kierowca(){
        super();
        System.out.println("sredni czas dojazdu: ");
        czas = s.nextInt();
        System.out.println("ilosc punktow karnych: ");
        iloscPktKarnych=s.nextInt();
        System.out.println("Pojazd: \n" +
                "1. Seat \n" +
                "2. VW \n" +
                "3. Toyota \n" +
                "4. Dacia \n");
        int poj=s.nextInt();
        switch (poj){
            case 1:
                typPojazdu=Pojazd.Seat;
            case 2:
                typPojazdu=Pojazd.VW;
            case 3:
                typPojazdu=Pojazd.Toyota;
            default:
                typPojazdu=Pojazd.Dacia;
        }
    }
    Kierowca(int czas, int iloscPktKarnych, boolean maPrawko, Pojazd typPojazdu, String imie, String nazwisko, int lataPracy, int wiek, int pensja){
        super(imie, nazwisko, lataPracy, wiek, pensja);
        this.czas=czas;
        this.iloscPktKarnych=iloscPktKarnych;
        this.maPrawko=maPrawko;
        this.typPojazdu=typPojazdu;
    }

    public int obliczCzasDojazdu(int dystans){
        return czas*dystans;
    }

    public void mandat(int pkt){
        iloscPktKarnych+=4;
        if (iloscPktKarnych>24){
            maPrawko=false;
            //maPrace=false;
        }
    }

    public void wyswietl()
    {
        System.out.println("Pojazd: "+typPojazdu);
    }
}
