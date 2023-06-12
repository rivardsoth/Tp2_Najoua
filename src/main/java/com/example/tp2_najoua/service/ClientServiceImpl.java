package com.example.tp2_najoua.service;

import com.example.tp2_najoua.entity.Client;
import com.example.tp2_najoua.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {

    @Autowired //pas besoin de faire un new
    private ClientRepository clientRepository;

    @Override
    public List<Client> findall() {
        return clientRepository.findAll();
    }
}
