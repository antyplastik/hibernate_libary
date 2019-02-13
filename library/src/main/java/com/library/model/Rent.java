package com.library.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.joda.time.LocalDate;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "rents")
public class Rent {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private Customer customer;

    @ManyToOne
    private BookCopy bookCopy;

    private LocalDate startDate;

    private LocalDate stopDate;

}
