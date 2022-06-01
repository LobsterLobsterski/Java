package com.company;

public interface wyplata {
    default int wyplata(double wsp){
        return (int)(3000*wsp)+bonus();
    }
    int bonus();
}
