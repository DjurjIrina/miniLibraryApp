package ro.fasttrackit.proiectfinal1.model;

import javax.persistence.*;

@Entity
public class Book {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    private String author;
    private BookType type;
    private String publisher;

    @OneToOne
    private BookSynopsis synopsis;

    protected Book() {

    }

    public Book(String name, String author, String publisher) {
        this(name, author, BookType.FANTASY, publisher, null);
    }

    public Book(String name, String author, BookType type, String publisher, BookSynopsis synopsis) {
        this.name = name;
        this.author = author;
        this.type = type;
        this.publisher = publisher;
        this.synopsis = synopsis;
    }

    public BookSynopsis getSynopsis() {
        return synopsis;

    }

    public void setSynopsis(BookSynopsis synopsis) {
        this.synopsis = synopsis;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public BookType getType() {
        return type;
    }

    public void setType(BookType type) {
        this.type = type;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

}

