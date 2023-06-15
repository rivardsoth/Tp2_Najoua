package com.example.tp2_najoua.controlleur;

import com.example.tp2_najoua.entity.*;
import com.example.tp2_najoua.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LivreControlleur {

    private LivreService livreService;


    public LivreControlleur() {
    }

    @Autowired
    public LivreControlleur(LivreService livreService) {
        this.livreService = livreService;
    }

    @GetMapping("/livres") //http://localhost:8080/livres
    public List<Livre> getAllLivre() {
        return livreService.findall();
    }

}
