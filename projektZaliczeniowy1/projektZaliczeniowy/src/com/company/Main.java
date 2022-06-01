package com.company;

import java.io.*;
import java.util.*;

import static java.lang.Integer.parseInt;

public class Main {
    static int nrZam=0;
    static int nrPra=0;
    static int pozUprawnien = 0;
    static ArrayList<Pracownik> konta = new ArrayList<>();
    static ArrayList<Zamowienie> zamowienia = new ArrayList<>();
    static Comparator<Zamowienie> czasSort = Comparator.comparing(Zamowienie::getCzasWykonania);
    static PriorityQueue<Zamowienie> zam = new PriorityQueue<>(czasSort);
    static Scanner scanner = new Scanner(System.in);
    static boolean notInputted=false;

    static String str="";
    static TimerTask task = new TimerTask() {
        @Override
        public void run() {
            if(str.equals("")){
                System.out.println("Za późno, wejście unieważnione");
                notInputted=true;
            }
        }
    };

    public static void czyUsunac(){
        Timer timer = new Timer();
        timer.schedule(task, 5*1000 );

        System.out.println("Usunąć? true/false (masz 5 sekund)");
        str = scanner.next();
        if (notInputted==true){
            return;
        }
        timer.cancel();
    }

    public static void log() throws FileNotFoundException {
        while (pozUprawnien==0){
            for (Pracownik p: konta){
                pozUprawnien = p.zaloguj();
                if (pozUprawnien!=0){
                    break;
                }
            }
        }
        menuu();
    }

    public static void menuu() throws FileNotFoundException {
        while(true){
            System.out.println("1. Dodaj uzytkownika \n" +
                    "2. Usun uzytkownika \n" +
                    "3. Wyswietl liste pracownikow \n" +
                    "4. Nadpisz liste pracownikow \n" +
                    "5. dodaj zamowienie \n" +
                    "6. wyświetl listę zamówień \n" +
                    "7. odbierz zamowienie \n" +
                    "8. exportuj listę zamówień \n" +
                    "9. Wyloguj");

            int menu=scanner.nextInt();

            for (Pracownik p: konta){
                nrPra=(p.id>nrPra)?(p.id):(nrPra);
            }

            switch (menu){

                case 1://dodaj
                    if (pozUprawnien==2){
                        System.out.println("1. Nowy Kierowca \n" +
                                "2. Nowy Kelner \n" +
                                "3. Nowy Kucharz");
                        int menu1=scanner.nextInt();

                        switch (menu1){
                            case 1:
                                konta.add(new Kierowca(++nrPra));
                                break;
                            case 2:
                                konta.add(new Kelner(++nrPra));
                                break;
                            case 3:
                                konta.add(new Kucharz(++nrPra));
                                break;
                        }
                        break;
                    }
                    else{
                        System.out.println("Brak uprawnien");
                        break;
                    }

                case 2://usuń
                    if (pozUprawnien==2){
                        System.out.println("Podaj id pracownika");
                        int idx=scanner.nextInt();
                        Pracownik temp=null;
                        for (Pracownik p: konta){
                            if (p.id == idx){
                                temp = p;
                                break;
                            }
                        }

                        if (temp!=null) {
                            System.out.println("index w konta "+konta.indexOf(temp));
                            System.out.println("Pracownik " + konta.get(konta.indexOf(temp)).imie + " " + konta.get(konta.indexOf(temp)).nazwisko);

                            //System.out.println("Usunąć? true/false (masz 5 sekund)");
                            czyUsunac();
                            boolean question=Boolean.parseBoolean(str);

                            if (question) {
                                konta.remove(konta.indexOf(temp));
                                System.out.println("Usunięto");
                            } else {
                                System.out.println("Powrót");
                            }
                        } else{
                            System.out.println("Nie znaleziono pracownika o podanym ID");
                        }
                        break;
                    }
                    else{
                        System.out.println("Brak uprawnien");
                        break;
                    }

                case 3://wyswietl
                    for (Pracownik p: konta){
                        p.wyswietl();
                    }
                    break;

                case 4://nadpisz pracowników
                    try {
                        FileWriter writer = new FileWriter("pracownicy.txt", true);
                        for (Pracownik str : konta) {

                            //Kierowca 5 12 true Dacia 0 Jan Nowak 3 27 5000
                            if (str instanceof Kierowca)
                                writer.write("Kierowca " +  ((Kierowca) str).getSrCzasDojazdu() + " " + ((Kierowca) str).getLiczbaPunktowKarnych()+" "+((Kierowca) str).isCzyMaPrawoJazdy()+" "+((Kierowca) str).getPojazd() + " " +str.id+" "+str.imie + " " + str.nazwisko + " " + str.lataPracy + " " + str.wiek + " " + str.pensja);
                            //Kucharz false 30 6 ala ala 10 20 3000
                            else if (str instanceof Kucharz)
                                writer.write("Kucharz " +  ((Kucharz) str).isCzyMaBadania()+" "+((Kucharz) str).getWydajnosc() + " " +str.id+" "+str.imie + " " + str.nazwisko + " " + str.lataPracy + " " + str.wiek + " " + str.pensja);
                            //Kelner 200 20 3 Jano Nowakowski 4 25 4000
                            else if (str instanceof Kelner)
                                writer.write("Kelner "+ ((Kelner) str).getNapiwki() + " " + ((Kelner) str).getLiczbaWykonanychZamowien()+" "+str.id+" "+str.imie + " " + str.nazwisko + " " + str.lataPracy + " " + str.wiek + " " + str.pensja);
                            writer.write("\n");
                        }
                        writer.close();
                    }
                    catch (IOException io){
                        System.out.println("Błąd");
                    }finally{
                        System.out.println("Zakończono nadpisywanie pliku");
                    }
                    break;

                case 5://dodaj zam
                    System.out.println("Dodaj zamówienie: ");
                    Zamowienie zamow=new Zamowienie(zam.size(), konta);
                    zam.add(zamow);

                    try {
                        FileWriter writer = new FileWriter("zamowienia.txt", true);

                        writer.write(zamow.rodzaj+" "+zamow.ilosc+" "+zamow.cena+" "+zamow.nazwisko);
                        writer.write("\n");
                        writer.close();
                    }
                    catch (IOException io){
                        System.out.println("Błąd");
                    }finally{
                        System.out.println("Dodano nowe zamowienie");
                    }

                    break;

                case 6://wyswietl zam
                    for (Zamowienie z: zam){
                        z.wyswietl();
                    }

                    //for (Zamowienie z: zamowienia){
                        //z.wyswietl();
                    //}
                    break;

                case 7://odbierz zam
                    if (!zam.isEmpty()) {
                        System.out.println("Zamówienie " + zam.peek().nr + " do odebrania.\nKtóry kelner odbiera?(ID)");
                        for (Pracownik p : konta) {
                            if (p instanceof Kelner) {
                                System.out.println("ID: " + p.id + "\n\t" + p.imie + " " + p.nazwisko);
                            }
                        }
                        while (true) {
                            int id = scanner.nextInt();
                            Kelner k = null;
                            for (Pracownik p : konta) {
                                if (p instanceof Kelner && p.id == id) {
                                    k = (Kelner) konta.get(konta.indexOf(p));
                                }
                            }
                            if (k != null) {
                                System.out.println(k.imie + " " + k.nazwisko + " odbiera zamówienie nr " + zamowienia.get(0).nr);
                                k.setLiczbaWykonanychZamowien(k.getLiczbaWykonanychZamowien() + 1);
                                System.out.println("Ile napiwku?");
                                k.setNapiwki(k.getNapiwki() + scanner.nextInt());
                                zam.remove();
                                break;
                            } else {
                                System.out.println("Nie znaleziono kelnera o podanym id.\nSpróbuj ponownie");
                            }
                        }
                    }
                    else{
                        System.out.println("Nie ma zamówień do odebrania");
                    }

                    break;
                case 8://nadpisz zam
                    try {
                        FileWriter writer = new FileWriter("zamowienia.txt", false);
                        for (Zamowienie z : zam) {

                            writer.write(z.rodzaj+" "+z.ilosc+" "+z.cena+" "+z.nazwisko);
                            writer.write("\n");
                        }
                        writer.close();
                    }
                    catch (IOException io){
                        System.out.println("Błąd");
                    }finally{
                        System.out.println("Zakończono nadpisywanie pliku");
                    }
                    break;
                default://wyloguj
                    pozUprawnien=0;
                    log();

            }
            System.out.println();
        }
    }


    public static void main(String[] args) throws FileNotFoundException {

        //wczytywanie pliku z pracownikami
        String nazwa="pracownicy.txt";
        String linia;
        String tab[]=null;

        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(nazwa))){
            linia= bufferedReader.readLine();
            while(linia !=null){
                tab=linia.split(" ");
                if(tab[0].equals("Kierowca")){
                    konta.add(new Kierowca(parseInt(tab[1]), parseInt(tab[2]), Boolean.parseBoolean(tab[3]), Kierowca.TypPojazdu.valueOf(tab[4]), parseInt(tab[5]), tab[6], tab[7], parseInt(tab[8]), parseInt(tab[9]), parseInt(tab[10])));
                }
                else if(tab[0].equals("Kucharz")){
                    konta.add(new Kucharz(Boolean.parseBoolean(tab[1]), parseInt(tab[2]), parseInt(tab[3]), tab[4], tab[5], parseInt(tab[6]), parseInt(tab[7]), parseInt(tab[8])));
                }
                else if(tab[0].equals("Kelner")){
                    konta.add(new Kelner(parseInt(tab[1]), parseInt(tab[2]), parseInt(tab[3]), tab[4], tab[5], parseInt(tab[6]), parseInt(tab[7]), parseInt(tab[8])));
                }
                linia= bufferedReader.readLine();
            }
        }
        catch (IOException io) {
            System.out.println("Błąd z plikiem");
        }
        finally {
            System.out.println("Zakończono import pracowników");
        }

        //wczytywanie pliku z zamówieniami
        nazwa="zamowienia.txt";

        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(nazwa))){
            linia= bufferedReader.readLine();
            while(linia !=null){
                tab=linia.split(" ");

                zamowienia.add(new Zamowienie(nrZam++, parseInt(tab[1]), Float.parseFloat(tab[2]), tab[3], konta));

                linia= bufferedReader.readLine();
            }
        }
        catch (IOException io) {
            System.out.println("Błąd z plikiem");
        }
        finally {
            System.out.println("Zakończono import zamówień");
        }

        //czyUsunac();
        log();
    }
}