package com.example.demo.Service;

import com.example.demo.Model.Pet;
import com.example.demo.Model.PetTypes;
import com.example.demo.repository.PetTypeRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.util.List;

@ApplicationScoped
public class PetServiceType {

    @Inject
    private PetTypeRepository petTypeRepository;
    public List<PetTypes> getAllMethod(){
        List<PetTypes> petTypesList= petTypeRepository.listAll();
        return petTypesList;

    }

    public Response createPetData(PetTypes petTypes)
    {
        petTypeRepository.persist(petTypes);
//        if(petTypes.isPersistent()){
            return Response.created(URI.create("/pet-types"+ petTypes.getId())).build();
//        }
//        return Response.status(Response.Status.BAD_REQUEST).build();
    }


    public PetTypes updateData(Long id, PetTypes petTypes)
    {
        PetTypes petModelid= petTypeRepository.findById(id);
        if(petModelid==null)
        {
            throw new NotFoundException();
        }
        petModelid.setCategeryType(petTypes.getCategeryType());
        petModelid.setPetfamily(petTypes.getPetfamily());


        return petModelid;
    }

    public String deletePetData(Long id){
        boolean deleted= petTypeRepository.deleteById(id);
        if(deleted){
            // return Response.noContent().build();
            return "Pet Type deleted Successfully";
        }
        //   return Response.status(Response.Status.BAD_REQUEST).build();
        return "Doesn't Exist Pet Type Data ";
    }


}
