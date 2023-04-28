package ojt.petshop.system.persistance.dao;

import java.util.List;

import ojt.petshop.system.persistance.entity.Pet;

public interface PetDAO {
    public int dbSave(Pet pet);

    public Pet dbGetById(int id);

    public List<Pet> dbGetList();

    public int dbUpdate(Pet pet);

    public int dbDelete(int id);
}