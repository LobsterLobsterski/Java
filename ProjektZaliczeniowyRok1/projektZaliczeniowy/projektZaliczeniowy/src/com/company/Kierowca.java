package com.company;

public class Kierowca extends  Pracownik  implements wyplata{

    public enum   TypPojazdu{
        Seat,
        VW,
        Toyota,
        Dacia
    }
    private TypPojazdu pojazd;
    private  int srCzasDojazdu;

    private  int liczbaPunktowKarnych;

    private  boolean czyMaPrawoJazdy;

    Kierowca(){
        super();
        System.out.println("Podaj średni czas dojazu ");
        srCzasDojazdu = scanner.nextInt();
        System.out.println("Podaj liczbę punków karnych");
        liczbaPunktowKarnych=scanner.nextInt();
        System.out.println("Podaj pojazd \n "+"1. Seat \n"+"2 VW \n"+"3 Toyota \n" +"4 Dacia \n");
        int poj=scanner.nextInt();
        switch (poj){
            case 1:
                pojazd=TypPojazdu.Seat;
                break;
            case 2:
                pojazd=TypPojazdu.VW;
                break;
            case 3:
                pojazd=TypPojazdu.Toyota;
                break;
            default:
                pojazd=TypPojazdu.Dacia;
        }
        pensja = wyplata(1.1);
    }

    Kierowca(int srCzasDojazdu, int liczbaPunktowKarnych, boolean czyMaPrawoJazdy, TypPojazdu pojazd, int id, String imie, String nazwisko, int lataPracy, int wiek, int pensja){
        super(id, imie,nazwisko,lataPracy,wiek,pensja);
        this.srCzasDojazdu=srCzasDojazdu;
        this.liczbaPunktowKarnych=liczbaPunktowKarnych;
        this.czyMaPrawoJazdy=czyMaPrawoJazdy;
        this.pojazd=pojazd;
        this.pensja = wyplata(1.1);
    }

    Kierowca(int id){
        this();
        this.id=id;
    }

    public   int oblCzasDoj( int dystans) {

        int srCzas= srCzasDojazdu *dystans;
        return  srCzas;
    }
    public int obliczCzasDojazdu(int dystans){
        return srCzasDojazdu*dystans;
    }

    public void mandat(int pkt){
        liczbaPunktowKarnych+=4;
        if (liczbaPunktowKarnych>=24){
            czyMaPrawoJazdy = false;
        }
    }

    public void wyswietl()
    {
        super.wyswietl();
        System.out.println("Pozycja: Kierowca");
        System.out.println("Pojazd: "+pojazd);
        System.out.println("sredni czas dojazdu: "+srCzasDojazdu);
        System.out.println("liczba punktow karnych: "+liczbaPunktowKarnych);
        System.out.println("---------------------------------------------------------------------");

    }

    public TypPojazdu getPojazd() {
        return pojazd;
    }

    public int getSrCzasDojazdu() {
        return srCzasDojazdu;
    }

    public int getLiczbaPunktowKarnych() {
        return liczbaPunktowKarnych;
    }

    public boolean isCzyMaPrawoJazdy() {
        return czyMaPrawoJazdy;
    }

    @Override
    public int bonus() {return 1000/srCzasDojazdu -100*liczbaPunktowKarnych;}
}
