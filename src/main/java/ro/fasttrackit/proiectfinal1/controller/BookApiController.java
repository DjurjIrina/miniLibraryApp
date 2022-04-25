package ro.fasttrackit.proiectfinal1.controller;

import org.springframework.web.bind.annotation.*;
import ro.fasttrackit.proiectfinal1.model.Book;
import ro.fasttrackit.proiectfinal1.service.BookService;



@RestController
@RequestMapping("api/books")
public class BookApiController {
    private final BookService service;
    public BookApiController(BookService service) {
        this.service = service;
    }

    @PostMapping
    Book addBook(@RequestBody Book book){
        return service.add(book);
    }

    @PutMapping("{id}")
    Book replaceBook(@PathVariable int id, @RequestBody Book book) {
        return service.replace(id, book);
    }

    @DeleteMapping("{id}")
    Book deleteBook(@PathVariable int id){
        return service.delete(id)
                .orElse(null);

    }


}
