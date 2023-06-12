package com.example.tp2_najoua.entity;

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
    private Date expiration;

    //1 paiement => plusieurs clientorder
    //On ne veut pas de suppression en cascade
    //Biderection vers la classe OrderItem (mappedBy)
    @OneToMany(mappedBy = "payment",//l'attribut dans la classe ClientOrder
            fetch = FetchType.EAGER,//va chercher directement les clientOrder
            cascade = {CascadeType.DETACH, CascadeType.MERGE,
                    CascadeType.PERSIST, CascadeType.REFRESH})
    private List<ClientOrder> clientOrders;

    public Payment() {
    }

    public Payment(String cardNumber, Date expiration) {
        this.cardNumber = cardNumber;
        this.expiration = expiration;
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

    public Date getExpiration() {
        return expiration;
    }

    public void setExpiration(Date expiration) {
        this.expiration = expiration;
    }

}
