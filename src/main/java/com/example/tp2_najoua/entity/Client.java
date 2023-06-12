package com.example.tp2_najoua.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "client")
public class Client {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "clientId", nullable = false)
    private int clientId;
    @Basic
    @Column(name = "firstName", nullable = false, length = 50)
    private String firstName;
    @Basic
    @Column(name = "lastName", nullable = false, length = 50)
    private String lastName;
    @Basic
    @Column(name = "email", nullable = false, length = 100)
    private String email;
    @Basic
    @Column(name = "address", nullable = false, length = 200)
    private String address;

    //1 client => plusieurs clientorder
    //On ne veut pas de suppression en cascade
    //Biderection vers la classe ClientOrder (mappedBy)
    @OneToMany(mappedBy = "client",//l'attribut dans la classe ClientOrder
            fetch = FetchType.EAGER,//va chercher directement les clientorder
            cascade = {CascadeType.DETACH, CascadeType.MERGE,
                    CascadeType.PERSIST, CascadeType.REFRESH})
    @JsonIgnore
    private List<ClientOrder> clientOrders;

    public Client() {
    }

    public Client(String firstName, String lastName, String email, String address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.address = address;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "ClientEntity{" +
                "clientId=" + clientId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    /**
     * Ajouter un ClientOrder au client
     * @param tempClientOrder
     */
    public void ajouterOrderItem(ClientOrder tempClientOrder) {
        if (this.clientOrders == null) {
            clientOrders = new ArrayList<>();

        }
        //faire le lien avec le client
        tempClientOrder.setClient(this);
        //on ajoute a la liste
        this.clientOrders.add(tempClientOrder);
    }
}
