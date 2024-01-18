import java.util.ArrayList;
import java.util.List;

class Element {
    private String name;
    private Element parent;
    private List<Element> children;

    public Element(String name) {
        this.name = name;
        this.parent = null;
        this.children = new ArrayList<>();
    }

    public Element getParent() {
        return parent;
    }

    public void setParent(Element parent) {
        this.parent = parent;
    }

    public void add(Element element) {
        children.add(element);
        element.setParent(this);
    }

    public void remove(Element element) {
        children.remove(element);
    }
}

class Section extends Element {
    public Section(String title) {
        super(title);
    }
}

class TableOfContents extends Element {
    public TableOfContents(String content) {
        super(content);
    }
}

class Paragraph extends Element {
    public Paragraph(String text) {
        super(text);
    }
}

class Picture {
    private String url;

    public Picture(String url) {
        this.url = url;
    }

    public Integer getsize(Integer dim) {
        return dim;
    }

    public String getcontent(String content) {
        return content;
    }

    public void display() {
    }
}

class Image extends Element {
    public Image(String url) {
        super(url);
    }

    @Override
    public void display() {
        System.out.println(this);
    }
}

class ImageProxy extends Picture {
    private String url;
    private String content;

    public ImageProxy(String url) {
        super(url);
        this.url = super.getcontent();
    }

    public void loadImage() {
        if (url != null) {
            url = new Image(url).toString();
        }
        super.display();
    }
}

class Author {
    private String name;

    public Author(String name) {
        this.name = name;
    }

    public void print() {
        System.out.println("Author: " + name);
    }
}

class Book {
    private String name;
    private List<Author> authors;
    private List<Element> content;

    public Book(String name) {
        this.name = name;
        this.authors = new ArrayList<>();
        this.content = new ArrayList<>();
    }

    public void addAuthor(Author author) {
        authors.add(author);
    }

    public void addContent(Element element) {
        content.add(element);
    }

    public void print() {
        System.out.println("Name: " + name);
        System.out.println("Authors:");
        for (Author author : authors) {
            author.print();
        }
    }

    public static void main(String[] args) {
        Book book = new Book("carte");
        Author a1 = new Author("autor 1");
        Author a2 = new Author("autor 2");
        book.addAuthor(a1);
        book.addAuthor(a2);
        book.print();
    }
}
