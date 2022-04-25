package ro.fasttrackit.proiectfinal1.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class BookSynopsis {
    @Id
    @GeneratedValue
    private int id;
    private String description;

    public BookSynopsis(String description){

        this.description = description;
    }
    public BookSynopsis(){

    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }
}
