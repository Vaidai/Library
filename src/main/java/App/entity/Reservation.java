package App.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Reservation {
    private Integer userId;
    private Integer bookId;
    private LocalDate periodFrom;//todo valid max min values for date
    private LocalDate periodTo;//todo valid max min values for date
}
