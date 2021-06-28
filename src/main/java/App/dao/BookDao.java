package App.dao;

import App.entity.Book;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface BookDao {
    List<Book> getAllBooks();

    Book save(Book book);

    void deleteBookById(Integer id);

    List<Book> findBooksByGuid(String guid);

    void takeABook(Integer userId, Integer bookId, LocalDate periodFrom, LocalDate periodTo);

    List<Book> getBooksByParameter(Optional parameter, Optional filterBy);
}
