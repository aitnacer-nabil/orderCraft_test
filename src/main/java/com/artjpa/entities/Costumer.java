package com.artjpa.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "costumers",uniqueConstraints = {@UniqueConstraint(name = "unique_name",columnNames = "name"),
@UniqueConstraint(name = "unique_email",columnNames = "email")})
public class Costumer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(unique = true)
    private String name;

    @Column(unique = true)
    private String email;


    private String phone;


    private String adress;

}
