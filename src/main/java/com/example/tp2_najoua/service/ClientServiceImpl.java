package com.example.tp2_najoua.service;

import com.example.tp2_najoua.entity.Client;
import com.example.tp2_najoua.entity.ClientOrder;
import com.example.tp2_najoua.entity.OrderItem;
import com.example.tp2_najoua.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {

    @Autowired //pas besoin de faire un new
    private ClientRepository clientRepository;
    @Autowired
    private ClientOrderService clientOrderService;

    @Override
    public List<Client> findall() {
        return clientRepository.findAll();
    }


    @Override
    public boolean deleteClientById(int id) {
        Client tempclient = this.findClientById(id);
        if (tempclient != null) {

            //verifier l'existence de clientOrder
            List<ClientOrder> clientOrders = tempclient.getClientOrders();
            if (clientOrders != null) {
                for (ClientOrder temp: clientOrders) {
                    clientOrderService.deleteClientOrderById(temp.getOrderId());
                }
                tempclient.setClientOrders(null);
                clientRepository.save(tempclient);
            }
            clientRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public Client findClientById(int id) {
        Client tempclient = clientRepository.findById(id).get();
        return tempclient;
    }
}
