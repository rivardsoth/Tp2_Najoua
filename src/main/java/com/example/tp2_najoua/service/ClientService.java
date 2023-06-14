package com.example.tp2_najoua.service;

import com.example.tp2_najoua.entity.Client;

import java.util.List;

public interface ClientService {

    List<Client> findall();

    boolean deleteClientById(int id);

    Client findClientById(int id);
}
