package com.library.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "customers")
public class Customer {

    @Id
    @GeneratedValue
    private Long id;

    @Length(max = 20)
    private String login;

    @Length(max = 40)
    private String passwordHash;

    @Length(max = 40)
    private String email;

    @OneToMany(mappedBy = "customer", orphanRemoval = true, cascade = {CascadeType.PERSIST})
    private List<Rent> rents;

}
