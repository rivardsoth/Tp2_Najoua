package com.example.tp2_najoua.service;


import com.example.tp2_najoua.entity.ClientOrder;
import com.example.tp2_najoua.entity.OrderItem;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ClientOrderService {

    List<ClientOrder> findall();

    boolean deleteClientOrderById(int id);

    ClientOrder findClientOrderById(int id);
}
