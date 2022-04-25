package ro.fasttrackit.proiectfinal1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.fasttrackit.proiectfinal1.model.BookSynopsis;

public interface BookSynopsisRepository extends JpaRepository<BookSynopsis, Integer> {
}
