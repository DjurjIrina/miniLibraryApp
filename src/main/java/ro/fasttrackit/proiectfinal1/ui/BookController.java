package ro.fasttrackit.proiectfinal1.ui;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ro.fasttrackit.proiectfinal1.service.BookService;

@Controller
@RequestMapping("books")

public class BookController {
    private final BookService service;

    public BookController(BookService service) {
        this.service = service;
    }

    @GetMapping
    String getBooksPage(Model model, @RequestParam(required = false)Integer showBook){
        model.addAttribute("message", "hello Thymeleaf");
        model.addAttribute("books", service.getAll());
        if (showBook != null){
            model.addAttribute("bookDetails" , service.getBook(showBook)
                    .orElse(null));
        }
        return "books";
    }
}
