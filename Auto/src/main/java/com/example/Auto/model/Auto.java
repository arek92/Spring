package com.example.Auto.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@Getter
@Setter
@NoArgsConstructor
//@AllArgsConstructor
@Entity
public class Auto {

        @jakarta.persistence.Id
    @GeneratedValue
    @Id
    Long id;
    String marka;
    String model;
    int rokProdukcji;

    public Auto(String marka, String model, int rokProdukcji) {
        this.marka = marka;
        this.model = model;
        this.rokProdukcji = rokProdukcji;
    }
}
