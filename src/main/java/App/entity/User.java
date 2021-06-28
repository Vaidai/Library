package App.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


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
