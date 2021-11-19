package com.example.petstore;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponses;
import org.json.JSONException;
import org.json.JSONObject;


@Path("/v1/pets")
@Produces("application/json")
public class PetResource {

	@APIResponses(value = {
			@APIResponse(responseCode = "200", description = "All Pets", content = @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(ref = "Pet")))})
	@GET
	public Response getPets() {

		return Response.ok(PetStore.getInstance()).build();
	}

	@APIResponses(value = {
			@APIResponse(responseCode = "200", description = "Pet for id", content = @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(ref = "Pet"))),
			@APIResponse(responseCode = "404", description = "No Pet found for the id.")})
	@GET
	@Path("{petId}")
	public Response getPet(@PathParam("petId") int petId) {
		if (petId < 0) {
			return Response.status(Status.NOT_FOUND).build();
		}
		Pet pet = new Pet();
		pet.setPetId(petId);
		pet.setPetAge(3);
		pet.setPetName("Buula");
		pet.setPetType("Dog");

		return Response.ok(pet).build();

	}

	@Path("/addPet")
	@Produces("application/json")
	@POST
	public Response addPetToStore(String request) throws JSONException {
		JSONObject json = new JSONObject(request);
		if (json.has("PetName") && json.has("PetType") && json.has("PetAge")) {
			Pet petData = new Pet();
			petData.setPetName(json.getString("PetName"));
			petData.setPetAge(Integer.parseInt(json.getString("PetAge")));
			petData.setPetType(json.getString("PetType"));

			petData.setPetId(PetStore.getInstance().getArrayList().get(PetStore.getInstance().getArrayList().size() - 1).getPetId() + 1);

			List<Pet> petList = new ArrayList<Pet>();
			List<Pet> temp = new ArrayList<Pet>();

			petList.add(petData);
			temp.addAll(PetStore.getInstance().getArrayList());
			temp.addAll(petList);
			PetStore.getInstance().setArrayList(temp);

			return Response.ok(petList).build();
		}else{
			return Response.ok("Erro 404").build();
		}

	}
	@DELETE
	@Produces("application/json")
	@Path("/deletePet/{petId}")
	public Response deletePetFromStore(@PathParam("petId") int petId){
		boolean isFound = false;
		for (int i = 0; i< PetStore.getInstance().getArrayList().size(); i++){
			if(petId == PetStore.getInstance().getArrayList().get(i).getPetId()){
				PetStore.getInstance().getArrayList().remove(i);
				isFound = true;
			}
		}
		if(isFound){
			return Response.ok("Successfully deleted").build();
		}else{
			return Response.ok("Unsuccessful").build();
		}
	}
	@PUT
	@Produces("application/json")
	@Path("/edit/{petId}")
	public Response editPetfromStore(@PathParam("petId") int petId,String petData) throws JSONException {
		JSONObject json = new JSONObject(petData);
		boolean isUpdated = false;
		int id = 0;
		if(json.has("PetName")){
			for (int i = 0; i< PetStore.getInstance().getArrayList().size(); i++){
				if(petId == PetStore.getInstance().getArrayList().get(i).getPetId()){
					PetStore.getInstance().getArrayList().get(i).setPetName(json.getString("PetName"));
					isUpdated=true;
					id = i;
				}
			}
		}
		if(json.has("PetAge")){
			for (int i = 0; i< PetStore.getInstance().getArrayList().size(); i++){
				if(petId == PetStore.getInstance().getArrayList().get(i).getPetId()){
					PetStore.getInstance().getArrayList().get(i).setPetAge(Integer.parseInt(json.getString("PetAge")));
					isUpdated=true;
					id = i;
				}
			}
		}
		if(json.has("PetType")){
			for (int i = 0; i< PetStore.getInstance().getArrayList().size(); i++){
				if(petId == PetStore.getInstance().getArrayList().get(i).getPetId()){
					PetStore.getInstance().getArrayList().get(i).setPetType(json.getString("PetType"));
					isUpdated=true;
					id = i;
				}
			}
		}
		if(isUpdated){
			return Response.ok(PetStore.getInstance().getArrayList().get(id)).build();
		}else{
			return Response.ok("{\n" + "\"success\":false\n" + "}").build();
		}

	}

}