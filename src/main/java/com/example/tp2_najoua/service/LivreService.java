package com.example.tp2_najoua.service;

import com.example.tp2_najoua.entity.Livre;

import java.util.List;

public interface LivreService {

    List<Livre> findall();

    boolean deleteAll();
}
