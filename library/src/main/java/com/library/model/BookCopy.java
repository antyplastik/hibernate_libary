package com.library.model;

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
@Table(name = "bookCopies")
public class BookCopy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private Long isbn;

    @ManyToOne
    private BookInfo bookInfo;

    @OneToMany(mappedBy = "bookCopy", orphanRemoval = true, cascade = {CascadeType.PERSIST})
    private List<Rent> rents;
}
