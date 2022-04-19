package com.company;

public class Kucharz extends Pracownik{
    private boolean maBadania;
    private int kebabNaH;

    public enum Kebab{
        maly,
        duzy,
        sredni,
        mega
    }

    Kucharz(){
        super();
        System.out.println("Ma zrobione Badania? true/false");
        maBadania=s.nextBoolean();
        System.out.println("sr ilosc kebabow na h");
        kebabNaH=s.nextInt();
    }
    Kucharz(boolean maBadania, int kebabNaH, String imie, String nazwisko, int lataPracy, int wiek, int pensja){
        super(imie, nazwisko, lataPracy, wiek, pensja);
        this.maBadania=maBadania;
        this.kebabNaH=kebabNaH;
    }

    public void badania(){
        if (!maBadania){
            System.out.println("Wyslac na badania");
        }
    }

    public void czasWykonania(Kebab typ, int liczba){
        double czas;
        if (typ==Kebab.maly){
            czas=liczba*0.6*kebabNaH/60;
            System.out.println("Czas wykonywania: "+czas);
        }
        else if (typ==Kebab.sredni){
            czas=liczba*0.5*kebabNaH/60;
            System.out.println("Czas wykonywania: "+czas);
        }
        else if (typ==Kebab.duzy){
            czas=liczba*0.4*kebabNaH/60;
            System.out.println("Czas wykonywania: "+czas);
        }
        else if (typ==Kebab.mega){
            czas=liczba*0.3*kebabNaH/60;
            System.out.println("Czas wykonywania: "+czas);
        }

    }
}
