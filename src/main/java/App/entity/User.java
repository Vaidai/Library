package App.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private Integer userId;
    private int booksCounter;

    public User(Integer userId) {
        this.userId = userId;
        this.booksCounter = 0;
    }
}
