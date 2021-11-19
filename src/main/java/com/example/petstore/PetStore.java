
package com.example.petstore;

import java.util.ArrayList;
import java.util.List;

public class PetStore {
    private static PetStore myInstance;

    List<Pet> pets = new ArrayList<Pet>();

    Pet p1 = new Pet();
    Pet p2 = new Pet();
    Pet p3 = new Pet();

    private PetStore() {
        p1.setPetId(1);
        p1.setPetAge(3);
        p1.setPetName("Boola");
        p1.setPetType("Dog");

        p2.setPetId(2);
        p2.setPetAge(4);
        p2.setPetName("Sudda");
        p2.setPetType("Cat");

        p3.setPetId(3);
        p3.setPetAge(2);
        p3.setPetName("Peththappu");
        p3.setPetType("Bird");

        pets.add(p1);
        pets.add(p2);
        pets.add(p3);
    }
	 public static PetStore getInstance() {
        if (myInstance == null){
            myInstance = new PetStore();
        }

        return myInstance;
    }
    public void setArrayList(List<Pet> pets) {
        this.pets = pets;
    }

    public List<Pet> getArrayList() {
        return this.pets;
    }

}
