package App.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.Year;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {
    private Integer id;

    @NotNull
    @Size(min = 2, max = 20)
    private String name;

    private String author;
    private String category;
    private String language;
    private Year publicationDate;
    private String isbn;
    private String guid;

    public Book(String name, String author, String category, String language, Year publicationDate, String isbn, String guid) {
        this.name = name;
        this.author = author;
        this.category = category;
        this.language = language;
        this.publicationDate = publicationDate;
        this.isbn = isbn;
        this.guid = guid;
    }
}