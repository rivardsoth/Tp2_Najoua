package com.example.tp2_najoua.entity;

import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreType;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "livre")
public class Livre {

    @Id
    @Column(name = "ean_isbn13", nullable = false, length = 13)
    private String eanIsbn13;
    @Basic
    @Column(name = "title", nullable = false, length = 145)
    private String title;
    @Basic
    @Column(name = "creators", nullable = false, length = 123)
    private String creators;
    @Basic
    @Column(name = "firstName", nullable = false, length = 13)
    private String firstName;
    @Basic
    @Column(name = "lastName", nullable = false, length = 14)
    private String lastName;
    @Basic
    @Column(name = "description", nullable = false, length = 4769)
    private String description;
    @Basic
    @Column(name = "publisher", nullable = true, length = 37)
    private String publisher;
    @Basic
    @Column(name = "publishDate", nullable = true)
    private String publishDate;
    @Basic
    @Column(name = "price", nullable = false, precision = 3)
    private double price;
    @Basic
    @Column(name = "length", nullable = false)
    private int length;

    //1 livre peut être dans plusieurs orderItem
    //On ne veut pas de suppression en cascade
    //Biderection vers la classe OrderItem (mappedBy)
    /*@OneToMany(mappedBy = "livre",//l'attribut dans la classe OrderItem
            fetch = FetchType.EAGER,//va chercher directement les orderItem
            cascade = {CascadeType.DETACH, CascadeType.MERGE,
                    CascadeType.PERSIST, CascadeType.REFRESH})
    @JsonIgnore
    private List<OrderItem> orderItems;*/

    public Livre() {
    }

    public Livre(String eanIsbn13, String title, String creators, String firstName, String lastName, String description, String publisher, String publishDate, double price, int length) {
        this.eanIsbn13 = eanIsbn13;
        this.title = title;
        this.creators = creators;
        this.firstName = firstName;
        this.lastName = lastName;
        this.description = description;
        this.publisher = publisher;
        this.publishDate = publishDate;
        this.price = price;
        this.length = length;
    }

    public String getEanIsbn13() {
        return eanIsbn13;
    }

    public void setEanIsbn13(String eanIsbn13) {
        this.eanIsbn13 = eanIsbn13;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCreators() {
        return creators;
    }

    public void setCreators(String creators) {
        this.creators = creators;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(String publishDate) {
        this.publishDate = publishDate;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    @Override
    public String toString() {
        return "Livre{" +
                "eanIsbn13=" + eanIsbn13 +
                ", title='" + title + '\'' +
                ", creators='" + creators + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", description='" + description + '\'' +
                ", publisher='" + publisher + '\'' +
                ", publishDate=" + publishDate +
                ", price=" + price +
                ", length=" + length +
                '}';
    }

    /*public void ajouterLivreDansOrderItem(OrderItem tempOrderItem) {
        if (orderItems == null) {
            orderItems = new ArrayList<>();
        }
        tempOrderItem.setLivre(this);
        orderItems.add(tempOrderItem);
    }*/
}
