package com.reto_3_nftc.reto_3_nftc.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


@Entity
@Table(name = "message")
public class Message implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idMessage;
    private String messageText;


    @ManyToOne
    @JoinColumn(name = "idClient")
    @JsonIgnoreProperties("messages")
    private Client clients;

    @ManyToOne
    @JoinColumn(name = "categoryId")                 //como almacena Id de categoria
    @JsonIgnoreProperties("messages")
    private Category category;

    @ManyToOne
    @JoinColumn(name = "bikeId")
    @JsonIgnoreProperties("messages")
    private Bike bikes;

    @OneToMany(cascade = {CascadeType.PERSIST},mappedBy = "messages")  // mappea messages
    @JsonIgnoreProperties("messages")
    private List<Reservation> reservations;


    public Integer getIdMessage() {
        return idMessage;
    }

    public void setIdMessage(Integer idMessage) {
        this.idMessage = idMessage;
    }

    public String getMessageText() {
        return messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }

    public Client getClients() {
        return clients;
    }

    public void setClients(Client clients) {
        this.clients = clients;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Bike getBikes() {
        return bikes;
    }

    public void setBikes(Bike bikes) {
        this.bikes = bikes;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }
}
