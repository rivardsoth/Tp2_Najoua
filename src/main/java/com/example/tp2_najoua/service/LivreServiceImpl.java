package com.example.tp2_najoua.service;

import com.example.tp2_najoua.entity.Livre;
import com.example.tp2_najoua.repository.LivreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LivreServiceImpl implements LivreService{

    @Autowired //pas besion de faire un new
    private LivreRepository livreRepository;

    @Override
    public List<Livre> findall() {
        return livreRepository.findAll();
    }

    @Override
    public boolean deleteAll() {
        livreRepository.deleteAll();
        return true;
    }
}
