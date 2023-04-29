package ojt.petshop.system.persistance.dao;

import java.util.List;

import ojt.petshop.system.persistence.entity.Pet;

public interface PetDAO {
    public void dbSave(Pet pet);

    public Pet dbGetById(int id);

    public List<Pet> dbGetList();

    public void dbUpdate(Pet pet);

    public int dbDelete(int id);
}