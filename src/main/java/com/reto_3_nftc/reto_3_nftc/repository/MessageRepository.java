package com.reto_3_nftc.reto_3_nftc.repository;

import com.reto_3_nftc.reto_3_nftc.entity.Client;
import com.reto_3_nftc.reto_3_nftc.entity.Message;
import com.reto_3_nftc.reto_3_nftc.repository.crudRepository.ClientCrudRepository;
import com.reto_3_nftc.reto_3_nftc.repository.crudRepository.MessageCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class MessageRepository {

    @Autowired
    private MessageCrudRepository messageCrudRepository;


    public List<Message> getAll(){
        return (List<Message>) messageCrudRepository.findAll();
    }

    public Message save(Message message){
        return messageCrudRepository.save(message);
    }

    public Optional<Message> getMessage(int idMessage){
        return messageCrudRepository.findById(idMessage);
    }

    public void delete(Message message){
        messageCrudRepository.delete(message);
    }


}
