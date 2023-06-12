package com.example.tp2_najoua.service;

import com.example.tp2_najoua.entity.ClientOrder;
import com.example.tp2_najoua.repository.ClientOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientOrderServiceImpl implements ClientOrderService{

    @Autowired //pas besoin de faire un new
    private ClientOrderRepository clientOrderRepository;
    @Override
    public List<ClientOrder> findall() {
        return clientOrderRepository.findAll();
    }
}
