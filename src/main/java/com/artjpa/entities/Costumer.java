package com.artjpa.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "costumers")
public class Costumer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;


    private String email;


    private String phone;


    private String adress;
}
