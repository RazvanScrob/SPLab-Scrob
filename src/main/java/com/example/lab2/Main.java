import java.util.ArrayList;
import java.util.List;

// Clasa de baza
class Autor {
    private String nume;

    public Autor(String nume) {
        this.nume = nume;
    }

    public void print() {
        System.out.println("Autor: " + nume);
    }
}

// Clasa pentru imagine
class Imagine {
    private String nume;

    public Imagine(String nume) {
        this.nume = nume;
    }

    public void print() {
        System.out.println("Imagine: " + nume);
    }
}

// Clasa pentru paragraf
class Paragraf {
    private String text;

    public Paragraf(String text) {
        this.text = text;
    }

    public void print() {
        System.out.println("Paragraf: " + text);
    }
}

// Clasa pentru tabel
class Tabel {
    private String nume;

    public Tabel(String nume) {
        this.nume = nume;
    }

    public void print() {
        System.out.println("Tabel: " + nume);
    }
}

// Clasa pentru subcapitol
class SubCapitol {
    private String nume;
    private List<Imagine> imagini;
    private List<Paragraf> paragrafe;
    private List<Tabel> tabele;

    public SubCapitol(String nume) {
        this.nume = nume;
        this.imagini = new ArrayList<>();
        this.paragrafe = new ArrayList<>();
        this.tabele = new ArrayList<>();
    }

    public void adaugaImagine(Imagine imagine) {
        imagini.add(imagine);
    }

    public void adaugaParagraf(Paragraf paragraf) {
        paragrafe.add(paragraf);
    }

    public void adaugaTabel(Tabel tabel) {
        tabele.add(tabel);
    }

    public void print() {
        System.out.println("SubCapitol: " + nume);
        for (Imagine imagine : imagini) {
            imagine.print();
        }
        for (Paragraf paragraf : paragrafe) {
            paragraf.print();
        }
        for (Tabel tabel : tabele) {
            tabel.print();
        }
    }
}

// Clasa pentru Capitol
class Capitol {
    private String nume;
    private List<SubCapitol> subcapitoale;

    public Capitol(String nume) {
        this.nume = nume;
        this.subcapitoale = new ArrayList<>();
    }

    public void adaugaSubCapitol(SubCapitol subCapitol) {
        subcapitoale.add(subCapitol);
    }

    public void print() {
        System.out.println("Capitol: " + nume);
        for (SubCapitol subCapitol : subcapitoale) {
            subCapitol.print();
        }
    }
}

// Clasa pentru cuprins
class TableOfContents {
    public void print() {
        System.out.println("Cuprinsul este afisat aici.");
    }
}

// Clasa pentru carte
class Book {
    private String titlu;
    private Autor autor;
    private TableOfContents tableOfContents;
    private List<Capitol> capitole;

    public Book(String titlu, Autor autor) {
        this.titlu = titlu;
        this.autor = autor;
        this.tableOfContents = new TableOfContents();
        this.capitole = new ArrayList<>();
    }

    public void adaugaCapitol(Capitol capitol) {
        capitole.add(capitol);
    }

    public void print() {
        System.out.println("Titlu: " + titlu);
        autor.print();
        tableOfContents.print();
        for (Capitol capitol : capitole) {
            capitol.print();
        }
    }
}

// Clasa principala pentru testare
public class Main {
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
