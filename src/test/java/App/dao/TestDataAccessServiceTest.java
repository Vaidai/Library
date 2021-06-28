package App.dao;

import App.controller.BookController;
import App.entity.Book;
import App.entity.Reservation;
import App.entity.User;
import App.service.BookService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.Year;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.AdditionalAnswers.returnsFirstArg;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class TestDataAccessServiceTest {

    private static List<Book> DB = new ArrayList<>();
    private static List<Reservation> reservations = new ArrayList<>();
    private static List<User> users = new ArrayList<>();


    public TestDataAccessServiceTest() {
        DB.add(new Book(0, "name", "author2", "category2", "LT", Year.of(2000), "isbn", "guid"));
        DB.add(new Book(1, "name2", "author2", "category", "EN", Year.of(2020), "isbn2", "guid2"));
        DB.add(new Book(2, "name2", "author", "category2", "EN", Year.of(2020), "isbn2", "guid2"));

        users.add(new User(0));
        users.add(new User(1));
    }

    @Mock
    private BookDao bookDao;
    @InjectMocks
    private BookService bookService;

    @Test
    void testGetAllBooks() {
        bookService.getAllBooks();
        verify(bookDao).getAllBooks();
    }

    @Test
    void addBook() {
        Book newBook = new Book( "testName", "testAuthor", "category", "LT", Year.of(2020), "isbn", "guid");
        bookService.addBook(newBook);

        ArgumentCaptor<Book> bookArgumentCaptor = ArgumentCaptor.forClass(Book.class);

        verify(bookDao).save(bookArgumentCaptor.capture());
        Book capturedBook = bookArgumentCaptor.getValue();
        assertThat(capturedBook).isEqualTo(newBook);
    }

    @Test
    void findBookByGuid() {
        Book newBook = new Book( "testName", "testAuthor", "category", "LT", Year.of(2020), "isbn", "guid");

        bookDao.findBooksByGuid(newBook.getGuid());

        ArgumentCaptor<Book> bookArgumentCaptor = ArgumentCaptor.forClass(Book.class);
        verify(bookDao).findBooksByGuid(bookArgumentCaptor.capture().getGuid());
        Book capturedBook = bookArgumentCaptor.getValue();
        assertThat(capturedBook.getGuid()).isEqualTo(newBook.getGuid());
    }
}