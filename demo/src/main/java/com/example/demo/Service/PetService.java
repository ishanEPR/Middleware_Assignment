package com.example.demo.Service;

import com.example.demo.Model.Pet;
import com.example.demo.repository.PetRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.util.List;

@ApplicationScoped

public class PetService {

    @Inject
    private PetRepository petRepository;


    public List<Pet> getAllMethod(){
       List<Pet> petModels= petRepository.listAll();
       return petModels;

    }

    public Response createPetData(Pet petModel)
    {
        petRepository.persist(petModel);
//        if(petRepository.isPersistent()){
            return Response.created(URI.create("/pet"+ petModel.getId())).build();
//        }
       // return Response.status(Response.Status.BAD_REQUEST).build();
    }

    public String deletePetData(Long id){
        boolean deleted= petRepository.deleteById(id);
        if(deleted){
           // return Response.noContent().build();
            return "Pet deleted Successfully";
        }
     //   return Response.status(Response.Status.BAD_REQUEST).build();
        return "Doesn't Exist Data";
    }

    public Pet updateData(Long id, Pet petModel)
    {
        Pet petModelid= petRepository.findById(id);
        if(petModelid==null)
        {
           throw new NotFoundException();
        }

        petModelid.setPetName(petModel.getPetName());
        petModelid.setPetAge(petModel.getPetAge());
        petModelid.setPetType(petModel.getPetType());
        petModelid.setPetColor(petModel.getPetColor());

        return petModelid;
    }



}
