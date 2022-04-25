package ro.fasttrackit.proiectfinal1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.fasttrackit.proiectfinal1.model.Book;

public interface BookRepository extends JpaRepository<Book,Integer> {
}
