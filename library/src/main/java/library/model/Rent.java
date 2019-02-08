package library.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.joda.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Rent {
    @Id
    @GeneratedValue
    private Long id;

    private Customer customer;

    private BookCopy bookCopy;

    private LocalDate startDate;

    private LocalDate stopDate;

}
