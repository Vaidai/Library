package App.controller;

import App.entity.Book;
import App.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RequestMapping("/book")
@RestController
public class BookController {
    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }


    @GetMapping
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    @PostMapping(value = "/add", consumes = {"application/json"})
    public void addBook(@Valid @RequestBody Book book) {
        bookService.addBook(book);
    }

    @GetMapping("/take/{userId}/{bookId}/{periodFrom}/{periodTo}")
    public void takeABook(@PathVariable("userId") Integer userId,
                          @PathVariable("bookId") Integer bookId,
                          @PathVariable("periodFrom") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate periodFrom,
                          @PathVariable("periodTo") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate periodTo) {
        bookService.takeABook(userId, bookId, periodFrom, periodTo);
    }

    @GetMapping("/{guid}")
    public List<Book> getBooksByGuid(@PathVariable("guid") String guid) {
        return bookService.findBooksByGuid(guid);
    }

    @GetMapping("/filter/{parameter}/{filterBy}")
    public List<Book> filterByEndpointParameter(@PathVariable("parameter") Optional parameter,
                                                @PathVariable("filterBy") Optional filterBy
    ) {
        return bookService.getBooksByParameter(parameter, filterBy);
    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable Integer id) {
        bookService.deleteBook(id);
    }
}
