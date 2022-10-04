package com.reto_3_nftc.reto_3_nftc.service;

import com.reto_3_nftc.reto_3_nftc.entity.UsuaryAdmin;
import com.reto_3_nftc.reto_3_nftc.repository.UsuaryAdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuaryAdminService {

    @Autowired
    private UsuaryAdminRepository usuaryAdminRepository;


    public List<UsuaryAdmin> getAll(){
        return usuaryAdminRepository.getAll();
    }

    public Optional<UsuaryAdmin> getUsuaryAdmin(int id){
        return usuaryAdminRepository.getUsuaryAdmin(id);
    }

    public UsuaryAdmin save(UsuaryAdmin  usuaryAdmin){
        if(usuaryAdmin.getId()==null){
            return usuaryAdminRepository.save(usuaryAdmin);
        }else {

            Optional<UsuaryAdmin > e= usuaryAdminRepository.getUsuaryAdmin(usuaryAdmin.getId());
            if(e.isPresent()){
                return usuaryAdmin;
            }else{
                return usuaryAdminRepository.save(usuaryAdmin);
            }
        }

    }

    public UsuaryAdmin  update(UsuaryAdmin  usuaryAdmin){
        if(usuaryAdmin.getId()!=null){
            Optional<UsuaryAdmin > q = usuaryAdminRepository.getUsuaryAdmin(usuaryAdmin.getId());
            if(q.isPresent()){
                if(usuaryAdmin.getName()!=null){
                    q.get().setName(usuaryAdmin.getName());
                }

                if(usuaryAdmin.getPassword()!=null){
                    q.get().setPassword(usuaryAdmin.getPassword());
                }

                if(usuaryAdmin.getEmail()!=null){
                    q.get().setEmail(usuaryAdmin.getEmail());
                }

                usuaryAdminRepository.save(q.get());
                return q.get();

            }else {
                return usuaryAdmin;
            }

        }else {
            return usuaryAdmin;
        }
    }


    public boolean delete(int id){
        Boolean flag=false;
        Optional<UsuaryAdmin > usuaryAdmin= usuaryAdminRepository.getUsuaryAdmin(id);
        if(usuaryAdmin.isPresent()){
            usuaryAdminRepository.delete(usuaryAdmin.get());
            flag=true;
        }

        return flag;
    }

}
