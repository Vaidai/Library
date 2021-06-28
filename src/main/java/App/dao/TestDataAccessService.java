package App.dao;

import App.entity.Book;
import App.entity.Reservation;
import App.entity.User;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.Year;
import java.util.*;
import java.util.stream.Collectors;

@Repository("TestData")
public class TestDataAccessService implements BookDao {
    private static List<Book> DB = new ArrayList<>();
    private static List<Reservation> reservations = new ArrayList<>();
    private static List<User> users = new ArrayList<>();

    // todo prijungti rasyma ir skaityma is json file.

    public TestDataAccessService() {
        DB.add(new Book(0, "name", "author2", "category2", "LT", Year.of(2000), "isbn", "guid"));
        DB.add(new Book(1, "name2", "author2", "category", "EN", Year.of(2020), "isbn2", "guid2"));
        DB.add(new Book(2, "name2", "author", "category2", "EN", Year.of(2020), "isbn2", "guid2"));

        users.add(new User(0));
        users.add(new User(1));
    }


    @Override
    public List<Book> getAllBooks() {
        return DB;
    }

    @Override
    public void save(Book book) {
        Integer id = DB.size();
        if (book.getPublicationDate().isAfter(Year.of(1500)) && book.getPublicationDate().isBefore(Year.now())) {
            DB.add(new Book(id, book.getName(), book.getAuthor(), book.getCategory(), book.getLanguage(), book.getPublicationDate(), book.getIsbn(), book.getGuid()));
        } else {
            throw new IllegalArgumentException("Release Year must be more than 1950 and less than now");
        }
    }

    @Override
    public void deleteBookById(Integer id) {
        Book deleteBook = findBookById(id);
        DB.remove(deleteBook);
    }

    @Override
    public List<Book> findBooksByGuid(String guid) {
        return DB.stream()
                .filter(book -> book.getGuid().equals(guid))
                .collect(Collectors.toList());
    }

    @Override
    public void takeABook(Integer userId, Integer bookId, LocalDate periodFrom, LocalDate periodTo) {
        if (periodFrom.isBefore(LocalDate.now()) && periodFrom.plusMonths(2).isAfter(periodTo)) {
            User user = findUserByIs(userId);
            if (user.getBooksCounter() < 3) {
                reservations.add(new Reservation(userId, bookId, periodFrom, periodTo));
                user.setBooksCounter(user.getBooksCounter() + 1);
            }
        }else {
            throw new IllegalArgumentException("Wrong Date");
        }
    }

    private User findUserByIs(Integer userId) {
        return users.stream()
                .filter(user -> user.getUserId().equals(userId)).findAny().orElse(null);
    }

    @Override
    public List<Book> getBooksByParameter(Optional parameter, Optional filterBy) {

        List<Book> books = new ArrayList<>();

        switch (parameter.get().toString()) {
            case "name":
                books = DB.stream()
                        .filter(book -> book.getName().equals(filterBy.get()))
                        .collect(Collectors.toList());
                break;
            case "author":
                books = DB.stream()
                        .filter(book -> book.getAuthor().equals(filterBy.get()))
                        .collect(Collectors.toList());
                break;
            case "category":
                books = DB.stream()
                        .filter(book -> book.getCategory().equals(filterBy.get()))
                        .collect(Collectors.toList());
                break;
            case "language":
                books = DB.stream()
                        .filter(book -> book.getLanguage().equals(filterBy.get()))
                        .collect(Collectors.toList());
                break;
            case "publicationDate":
                books = DB.stream()
                        .filter(book -> book.getPublicationDate().equals(filterBy.get()))
                        .collect(Collectors.toList());
                break;
            case "isbn":
                books = DB.stream()
                        .filter(book -> book.getIsbn().equals(filterBy.get()))
                        .collect(Collectors.toList());
                break;
            case "guid":
                books = DB.stream()
                        .filter(book -> book.getGuid().equals(filterBy.get()))
                        .collect(Collectors.toList());
                break;
            default:
                System.out.println("--");
                break;
        }
        return books;
    }

    private Book findBookById(Integer id) {
        return DB.stream()
                .filter(book -> book.getId().equals(id)).findAny().orElse(null);
    }

}
