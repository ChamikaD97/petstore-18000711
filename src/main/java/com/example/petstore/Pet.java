package com.example.petstore;

import org.eclipse.microprofile.openapi.annotations.media.Schema;

import com.fasterxml.jackson.annotation.JsonProperty;

@Schema(name = "Pet")
public class Pet {

	@Schema(required = true, description = "Pet id")
	@JsonProperty("pet_id")
	private Integer petId;

	@Schema(required = true, description = "Pet type")
	@JsonProperty("pet_type")
	private String petType;

	@Schema(required = true, description = "Pet name")
	@JsonProperty("pet_name")
	private String petName;

	@JsonProperty("pet_age")
	private Integer petAge;

	public Integer getPetId() {
		return petId;
	}

	public String getPetType() {
		return petType;
	}

	public String getPetName() {
		return petName;
	}

	public Integer getPetAge() {
		return petAge;
	}

	public void setPetId(Integer petId) {
		this.petId = petId;
	}

	public void setPetType(String petType) {
		this.petType = petType;
	}

	public void setPetName(String petName) {
		this.petName = petName;
	}

	public void setPetAge(Integer petAge) {
		this.petAge = petAge;
	}
}
