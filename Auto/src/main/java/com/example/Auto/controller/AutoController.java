package com.example.Auto.controller;

import com.example.Auto.model.Auto;
import com.example.Auto.model.PatchAuto;
import com.example.Auto.repository.AutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class AutoController {

    @Autowired
    AutoRepository repository;

    @GetMapping("/dodajAuto")
    public Auto dodajDoBazy() {
        Auto auto = new Auto("Ford", "Focus", 2012);
        repository.save(auto);

        return auto;
    }

    @GetMapping("/autos")
    public List<Auto> getAllAutos() {
        return repository.findAll();
    }

    @GetMapping("/autos/{id}")
    public Auto getAuto(@PathVariable Long id) {
        Auto auto = repository.findById(id).get();
        return auto;
    }

    @PostMapping("/autos")
    public Auto addAuto(@RequestBody Auto auto) {
        repository.save(auto);
        return auto;
    }

    @PostMapping("autos/{id}")
    public Auto patchAuto(@RequestBody Auto updateAuto, @PathVariable Long id) {

        Auto auto = repository.findById(id).get();
        if (auto != null) {
auto.setMarka(updateAuto.getMarka());
            // przepisujemy wszystkie pola z updateAuto do auto
            repository.save(auto);

        } else {
            new RuntimeException("Obiektu o id " + id + " nie ma w bazie");
        }


        return auto;

    }
}
