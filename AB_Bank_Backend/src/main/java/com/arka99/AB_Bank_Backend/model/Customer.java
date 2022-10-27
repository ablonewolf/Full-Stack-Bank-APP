package com.arka99.AB_Bank_Backend.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private int id;
    private String email;
    private String password;
    private String role;

}
