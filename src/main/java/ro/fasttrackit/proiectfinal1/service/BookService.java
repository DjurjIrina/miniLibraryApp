package ro.fasttrackit.proiectfinal1.service;

import org.springframework.stereotype.Service;
import ro.fasttrackit.proiectfinal1.model.Book;
import ro.fasttrackit.proiectfinal1.repository.BookRepository;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    private final BookRepository repository;

    public BookService(BookRepository repository) {
        this.repository = repository;
    }

    public List<Book> getAll() {
        return repository.findAll();
    }


    public Optional<Book> getBook(Integer id) {
        return repository.findById(id);
    }

    public Optional<Book> delete(int id) {
        Optional<Book> toDelete = repository.findById(id);
        toDelete.ifPresent(repository::delete);
        return toDelete;
    }

    public Book add(Book book) {
        return repository.save(book);
    }

    public Book replace(int id, Book book) {
        book.setId(id);
        return repository.save(book);

    }
}
