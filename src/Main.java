import java.util.ArrayList;
import java.util.List;

class Book {
    private final String title;
    private final List<Chapter> chapters = new ArrayList<>();
    private final List<Section> sections = new ArrayList<>();

    public Book(String title) {
        this.title = title;
    }

    public void addChapter(Chapter chapter) {
        chapters.add(chapter);
    }

    public void addSection(Section section) {
        sections.add(section);
    }

    public void printBook() {
        System.out.println("Book Title: " + title);
        for (Chapter chapter : chapters) {
            chapter.printChapter();
        }
        for (Section section : sections) {
            section.printSection();
        }
    }
}

class Author {
    private final String name;

    public Author(String name) {
        this.name = name;
    }

    public void print() {
        System.out.println("Author: " + name);
    }
}

class Table {
    private final String title;

    public Table(String title) {
        this.title = title;
    }

    public void print() {
        System.out.println("Table Title: " + title);
    }
}

class Paragraph {
    private final String text;

    public Paragraph(String text) {
        this.text = text;
    }

    public void print() {
        System.out.println("Paragraph Text: " + text);
    }
}

class Image {
    private final String caption;

    public Image(String caption) {
        this.caption = caption;
    }

    public void print() {
        System.out.println("Image Caption: " + caption);
    }
}

class Section {
    private final String title;
    private final List<Object> contents = new ArrayList<>();

    public Section(String title) {
        this.title = title;
    }

    public void addContent(Object content) {
        contents.add(content);
    }

    public void printSection() {
        System.out.println("Section Title: " + title);
        for (Object content : contents) {
            if (content instanceof Table) {
                ((Table) content).print();
            } else if (content instanceof Paragraph) {
                ((Paragraph) content).print();
            } else if (content instanceof Image) {
                ((Image) content).print();
            }
        }
    }
}

class SubChapter {
    private final String name;
    private final List<Object> contents = new ArrayList<>();

    public SubChapter(String name) {
        this.name = name;
    }

    public void addContent(Object content) {
        contents.add(content);
    }

    public void printSubChapter() {
        System.out.println("SubChapter: " + name);
        for (Object content : contents) {
            if (content instanceof Table) {
                ((Table) content).print();
            } else if (content instanceof Paragraph) {
                ((Paragraph) content).print();
            }
        }
    }
}

class Chapter {
    private final String name;
    private final List<SubChapter> subChapters = new ArrayList<>();

    public Chapter(String name) {
        this.name = name;
    }

    public void addSubChapter(SubChapter subChapter) {
        subChapters.add(subChapter);
    }

    public void printChapter() {
        System.out.println("Chapter: " + name);
        for (SubChapter subChapter : subChapters) {
            subChapter.printSubChapter();
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Author author = new Author("F. Scott Fitzgerald");
        Book book = new Book("The Great Gatsby");

        Chapter chapter1 = new Chapter("Chapter 1");
        SubChapter subChapter1 = new SubChapter("SubChapter 1");
        SubChapter subChapter2 = new SubChapter("SubChapter 2");

        chapter1.addSubChapter(subChapter1);
        chapter1.addSubChapter(subChapter2);

        book.addChapter(chapter1);

        // Adăugați conținut la subcapitole
        Paragraph paragraph1 = new Paragraph("This is the first paragraph.");
        Table table1 = new Table("Table 1");

        subChapter1.addContent(paragraph1);
        subChapter2.addContent(table1);

        author.print();
        book.printBook();
    }

    public static void main2(String[] args) throws Exception {
        long startTime = System.currentTimeMillis();
        Image img1 = new Image("Pamela Anderson");
        Image img2 = new Image("Kim Kardashian");
        Image img3 = new Image("Kirby Griffin");
        Section playboyS1 = new Section("Front Cover");
        playboyS1.addContent(img1);
        Section playboyS2 = new Section("Summer Girls");
        playboyS2.addContent(img2);
        playboyS2.addContent(img3);
        Book playboy = new Book("Playboy");
        playboy.addSection(playboyS1);
        playboy.addSection(playboyS2);
        long endTime = System.currentTimeMillis();
        System.out.println("Creation of the content took " + (endTime - startTime) + " milliseconds");
        startTime = System.currentTimeMillis();
        playboyS1.printSection();
        endTime = System.currentTimeMillis();
        System.out.println("Printing of the section 1 took " + (endTime - startTime) + " milliseconds");
        startTime = System.currentTimeMillis();
        playboyS2.printSection();
        endTime = System.currentTimeMillis();
        System.out.println("Printing of the section 2 took " + (endTime - startTime) + " milliseconds");
    }
}
