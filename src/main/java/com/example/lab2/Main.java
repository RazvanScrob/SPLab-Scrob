package com.example.lab2;

public class Main {
    import java.util.ArrayList;
import java.util.List;
    public class main {
        public static void main(String[] args) {
            Autor autor = new Autor("John Doe");
            Book carte = new Book("Cartea Mea", autor);

            Capitol capitol1 = new Capitol("Capitolul 1");
            SubCapitol subCapitol1 = new SubCapitol("SubCapitolul 1.1");
            subCapitol1.adaugaImagine(new Imagine("Imagine1.1.1"));
            subCapitol1.adaugaParagraf(new Paragraf("Paragraf1.1.2"));
            subCapitol1.adaugaTabel(new Tabel("Tabel1.1.3"));
            capitol1.adaugaSubCapitol(subCapitol1);

            Capitol capitol2 = new Capitol("Capitolul 2");
            SubCapitol subCapitol2 = new SubCapitol("SubCapitolul 2.1");
            subCapitol2.adaugaImagine(new Imagine("Imagine2.1.1"));
            subCapitol2.adaugaParagraf(new Paragraf("Paragraf2.1.2"));
            subCapitol2.adaugaTabel(new Tabel("Tabel2.1.3"));
            capitol2.adaugaSubCapitol(subCapitol2);

            carte.adaugaCapitol(capitol1);
            carte.adaugaCapitol(capitol2);

            carte.print();
        }
    }

