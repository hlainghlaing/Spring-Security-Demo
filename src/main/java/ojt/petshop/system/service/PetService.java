package ojt.petshop.system.service;

import java.util.List;

import ojt.petshop.system.entity.Pet;

public interface PetService {
    public int savePet(Pet pet);

    public Pet getPetById(int id);

    public List<Pet> getPetList();

    public int updatePet(Pet pet);

    public int deletePet(int id);
}
