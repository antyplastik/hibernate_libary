package library.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class AuthorInfo {

    @Id
    @GeneratedValue
    @OneToMany
    private Long id;

    @NotNull
    private String name;

    @NotNull
    private String lastName;

    @OneToMany(mappedBy = "AuthorInfo", orphanRemoval = true, cascade = {CascadeType.PERSIST})
    private List<BookInfo> books;

}
