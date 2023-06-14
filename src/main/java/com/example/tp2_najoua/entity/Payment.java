package com.example.tp2_najoua.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;

import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "payment")
public class Payment {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "paymentId", nullable = false)
    private int paymentId;
    @Basic
    @Column(name = "cardNumber", nullable = false, length = 16)
    private String cardNumber;
    @Basic
    @Column(name = "expiration", nullable = false)
    private String expiration;

    //1 paiement => 1 clientorder
    //On ne veut pas de suppression en cascade
    //Biderection vers la classe clientorder (mappedBy)
    @OneToOne(mappedBy = "payment"/*,//l'attribut dans la classe ClientOrder
            //pas de cascade pour le delete enlever la suppresion en cascade
            /*cascade = CascadeType.PERSIST*/)
    @JsonIgnore
    private ClientOrder clientOrder;


    public Payment() {
    }

    public Payment(String cardNumber, String expiration) {
        this.cardNumber = cardNumber;
        this.expiration = expiration;
    }

    public ClientOrder getClientOrder() {
        return clientOrder;
    }

    public void setClientOrder(ClientOrder clientOrder) {
        this.clientOrder = clientOrder;
    }

    public int getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(int paymentId) {
        this.paymentId = paymentId;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getExpiration() {
        return expiration;
    }

    public void setExpiration(String expiration) {
        this.expiration = expiration;
    }

}
