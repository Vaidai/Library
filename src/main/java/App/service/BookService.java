package App.service;

import App.dao.BookDao;
import App.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    private final BookDao bookDao;

    @Autowired
    public BookService(@Qualifier("TestData") BookDao bookDao) {
        this.bookDao = bookDao;
    }


    public List<Book> getAllBooks() {
        return bookDao.getAllBooks();
    }

    public void addBook(Book book) {
        bookDao.save(book);
    }

    public void deleteBook(Integer id) {
        bookDao.deleteBookById(id);
    }

    public List<Book> findBooksByGuid(String guid) {
        return bookDao.findBooksByGuid(guid);
    }

    public void takeABook(Integer userId, Integer bookId, LocalDate periodFrom, LocalDate periodTo) {
        bookDao.takeABook(userId, bookId, periodFrom, periodTo);
    }

    public List<Book> getBooksByParameter(Optional parameter, Optional filterBy) {
        return bookDao.getBooksByParameter(parameter, filterBy);
    }
}
