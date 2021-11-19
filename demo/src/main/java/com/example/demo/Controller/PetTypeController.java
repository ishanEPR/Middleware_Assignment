package com.example.demo.Controller;

import com.example.demo.Model.Pet;
import com.example.demo.Model.PetTypes;
import com.example.demo.Service.PetService;
import com.example.demo.Service.PetServiceType;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponses;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/pet-types")
@Transactional
public class PetTypeController {

    @Inject
    PetServiceType petServiceType;



    //display pet type details
    @GET
    @Path("/getDetails")
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "List of all the Pets type Details ")
    @APIResponses(value = {
            @APIResponse(responseCode = "200",description = "List of all the Pets type Details"),
            @APIResponse(responseCode = "400",description = "Pet type list is empty")

    })
    public Response getAll()
    {
        List<PetTypes> petTypeModels=petServiceType.getAllMethod();
        //  List<PetModel> petModels=PetModel.listAll();
        return Response.ok(petTypeModels).build();
    }


    //add pet type data
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Operation(summary = "A pet type add")
    @APIResponses(value = {
            @APIResponse(responseCode = "200",description = "Pet type Data Added successfully"),
            @APIResponse(responseCode = "400",description = "Some Errors Occured")
    })
    public Response create(PetTypes petTypes)
    {
        return   petServiceType.createPetData(petTypes);

    }

    //update pet type data
    @PUT
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Operation(summary = "update the pet type details")
    @APIResponses(value = {
            @APIResponse(responseCode = "200",description = "Pet type Data Updated successfully"),
            @APIResponse(responseCode = "404",description = "Pet type Id doesn't Exists")

    })
    public PetTypes updateData(@PathParam("id") Long id, PetTypes petTypes)
    {
        return  petServiceType.updateData(id,petTypes);

    }


    //delete a pet type
    @DELETE
    @Path("{id}")
    @Operation(summary = "Pet type Data Deleted")
    @APIResponses(value = {
            @APIResponse(responseCode = "200",description = "Pet type data Deleted successfully"),
            @APIResponse(responseCode = "404",description = "Pet type Id doesn't Exists")

    })
    public String deleteById(@PathParam("id") Long id)
    {
        return petServiceType.deletePetData(id);
    }


//http://localhost:8080/q/dev/

}
