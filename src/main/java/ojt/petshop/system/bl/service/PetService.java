package ojt.petshop.system.bl.service;

import java.util.List;

import ojt.petshop.system.persistence.entity.Pet;

public interface PetService {
    public void doSave(Pet pet);

    public Pet doGetById(int id);

    public List<Pet> doGetList();

    public void doUpdate(Pet pet);

    public int doDelete(int id);
}
