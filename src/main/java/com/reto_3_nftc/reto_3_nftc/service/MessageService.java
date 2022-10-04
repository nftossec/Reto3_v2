package com.reto_3_nftc.reto_3_nftc.service;

import com.reto_3_nftc.reto_3_nftc.entity.Message;
import com.reto_3_nftc.reto_3_nftc.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MessageService {

    @Autowired
    private MessageRepository messageRepository;

    public List<Message>  getAll(){
        return messageRepository.getAll();
    }

    public Optional<Message> getClient(int idClient){
        return messageRepository.getMessage(idClient);
    }

    public Message save(Message  message){
        if(message.getIdMessage()==null){
            return messageRepository.save(message);
        }else {

            Optional<Message > e= messageRepository.getMessage(message.getIdMessage());
            if(e.isPresent()){
                return message;
            }else{
                return messageRepository.save(message);
            }
        }

    }

    public Message  update(Message  message){
        if(message.getIdMessage()!=null){
            Optional<Message > q = messageRepository.getMessage(message.getIdMessage());
            if(q.isPresent()){
                if(message.getMessageText()!=null){
                    q.get().setMessageText(message.getMessageText());
                }

                messageRepository.save(q.get());
                return q.get();

            }else {
                return message;
            }

        }else {
            return message;
        }
    }


    public boolean delete(int idMessage){
        Boolean flag=false;
        Optional<Message > message= messageRepository.getMessage(idMessage);
        if(message.isPresent()){
            messageRepository.delete(message.get());
            flag=true;
        }

        return flag;
    }




}
