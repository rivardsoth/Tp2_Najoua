package com.example.tp2_najoua.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "clientorder")
public class ClientOrder {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "orderId", nullable = false)
    private int orderId;
    @Basic
    @Column(name = "orderDate", nullable = true)
    private String orderDate;
    @Basic
    @Column(name = "totalAmount", nullable = true)
    private double totalAmount;

    //mappedBy = bidirection
    //Si on supprime un clientOrder => on ne supprime pas le client
    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE,
            CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name="client_id")//colonne de jointure (clé étrangère)
    private Client client;

    //1 clientOrder => plusieurs orderItem
    //On ne veut pas de suppression en cascade
    //Biderection vers la classe OrderItem (mappedBy)
    @OneToMany(mappedBy = "clientOrder",//l'attribut dans la classe OrderItem
            fetch = FetchType.EAGER,//va chercher directement les orderitems
            cascade = {CascadeType.DETACH, CascadeType.MERGE,
                    CascadeType.PERSIST, CascadeType.REFRESH})
    private List<OrderItem> orderItems;

    //mappedBy = bidirection
    //Si on supprime un clientOrder => on ne supprime pas le payment
    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE,
            CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name="payment_id")//colonne de jointure (clé étrangère)
    private Payment payment;

    public ClientOrder() {
    }

    public ClientOrder(String orderDate) {
        this.orderDate = orderDate;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    @Override
    public String toString() {
        return "ClientOrder{" +
                "orderId=" + orderId +
                ", orderDate=" + orderDate +
                ", totalAmount=" + totalAmount +
                ", client=" + client +
                '}';
    }

    /**
     * Ajouter un orderItem au ClientOrder
     * @param tempOrderItem
     */
    public void ajouterOrderItem(OrderItem tempOrderItem) {
        if (this.orderItems == null) {
            orderItems = new ArrayList<>();
            this.totalAmount = 0;
        }
        //faire le lien avec le client
        tempOrderItem.setClientOrder(this);
        //on ajoute a la liste
        this.orderItems.add(tempOrderItem);
        //mettre a jour le total de la commande
        this.totalAmount += (tempOrderItem.getPrice() * tempOrderItem.getQuantity());
    }
}
