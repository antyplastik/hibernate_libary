package library.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class BookInfo {

    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    private String title;

    @Length(max = 250)
    private String description;

    @OneToMany
    private AuthorInfo author;

    @OneToMany(mappedBy = "BookInfo", orphanRemoval = true, cascade = {CascadeType.PERSIST})
    private List<BookCopy> bookCopies;

}
