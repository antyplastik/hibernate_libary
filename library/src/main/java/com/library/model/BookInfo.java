package com.library.model;

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
@Table(name = "bookInfo")
public class BookInfo {

    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    private String title;

    @Length(max = 250)
    private String description;

    @ManyToOne
    private AuthorInfo author;

    @OneToMany(mappedBy = "bookInfo", orphanRemoval = true, cascade = {CascadeType.PERSIST})
    private List<BookCopy> bookCopies;

}
