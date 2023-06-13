package com.example.tp2_najoua.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "orderitem")
public class OrderItem {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Basic
    @Column(name = "quantity", nullable = true)
    private Integer quantity;
    @Basic
    @Column(name = "price", nullable = true)
    private double price;

    //mappedBy = bidirection
    //Si on supprime un orderItem => on ne supprime pas le clientOrder
    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE,
            CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name="clientOrder_id")//colonne de jointure (clé étrangère)
    @JsonIgnore
    private ClientOrder clientOrder;

    //mappedBy = bidirection
    //Si on supprime un orderItem => on ne supprime pas le livre
    @ManyToOne
    @JoinColumn(name="livre_id")//colonne de jointure (clé étrangère)
    private Livre livre;

    public OrderItem() {
    }

    public OrderItem(Integer quantity, Livre livre) {
        this.quantity = quantity;
        this.livre = livre;
        this.price = livre.getPrice();

    }

    public ClientOrder getClientOrder() {
        return clientOrder;
    }

    public void setClientOrder(ClientOrder clientOrder) {
        this.clientOrder = clientOrder;
    }

    public Livre getLivre() {
        return livre;
    }

    public void setLivre(Livre livre) {
        this.livre = livre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "OrderItem{" +
                "id=" + id +
                ", quantity=" + quantity +
                ", price=" + price +
                '}';
    }

}
