package com.arka99.AB_Bank_Backend.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class Customer {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO,generator="native")
    @GenericGenerator(name = "native",strategy = "native")
    @Column(name = "customer_id")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private int id;
    private String name;
    private String email;
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;
    @Column(name = "mobile_number")
    private String mobileNumber;
    @EqualsAndHashCode.Exclude
    private String role;
    @Column(name = "create_dt")
    private String createDt;

}
