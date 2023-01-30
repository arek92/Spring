package pl.galus.pacjenci.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigInteger;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Patient {

    @GeneratedValue
    @Id
    private long id;
    String name;
    long pesel;

    public Patient(String name, long pesel) {
        this.name = name;
        this.pesel = pesel;
    }
}
