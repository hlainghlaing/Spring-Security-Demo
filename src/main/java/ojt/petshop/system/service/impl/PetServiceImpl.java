package ojt.petshop.system.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ojt.petshop.system.dao.PetDAO;
import ojt.petshop.system.entity.Pet;
import ojt.petshop.system.service.PetService;

@Service
public class PetServiceImpl implements PetService {
    
    @Autowired
    private PetDAO petDao;
    
    @Override
    public int savePet(Pet pet) {
        return this.petDao.savePet(pet);
    }

    @Override
    public Pet getPetById(int id) {
        return this.petDao.getPetById(id);
    }

    @Override
    public List<Pet> getPetList() {
        return this.petDao.getPetList();
    }

    @Override
    public int updatePet(Pet pet) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int deletePet(int id) {
        return this.petDao.deletePet(id);
    }
    
}
