package com.reto_3_nftc.reto_3_nftc.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "reservation")
public class Reservation implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idReservation;
    private Date starDate;
    private Date devolutionDate;



    @ManyToOne
    @JoinColumn(name = "categoryId")                 //como almacena Id de categoria
    @JsonIgnoreProperties("reservations")
    private Category category;

    @ManyToOne
    @JoinColumn(name = "bikeId")                 //como almacena Id de categoria
    @JsonIgnoreProperties("reservations")
    private Bike bikes;


    @ManyToOne
    @JoinColumn(name = "messageIdMessage")
    @JsonIgnoreProperties("reservations")
    private Message messages;

    @ManyToOne
    @JoinColumn(name = "clientIdClient")
    @JsonIgnoreProperties("reservations")
    private Client clients;


    public Integer getIdReservation() {
        return idReservation;
    }

    public void setIdReservation(Integer idReservation) {
        this.idReservation = idReservation;
    }

    public Date getStarDate() {
        return starDate;
    }

    public void setStarDate(Date starDate) {
        this.starDate = starDate;
    }

    public Date getDevolutionDate() {
        return devolutionDate;
    }

    public void setDevolutionDate(Date devolutionDate) {
        this.devolutionDate = devolutionDate;
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

    public Message getMessages() {
        return messages;
    }

    public void setMessages(Message messages) {
        this.messages = messages;
    }

    public Client getClients() {
        return clients;
    }

    public void setClients(Client clients) {
        this.clients = clients;
    }
}
