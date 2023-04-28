package ojt.petshop.system.bl.service;

import java.util.List;

import ojt.petshop.system.persistance.entity.Pet;

public interface PetService {
    public int doSave(Pet pet);

    public Pet doGetById(int id);

    public List<Pet> doGetList();

    public int doUpdate(Pet pet);

    public int doDelete(int id);
}
