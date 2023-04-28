package ojt.petshop.system.bl.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ojt.petshop.system.bl.service.PetService;
import ojt.petshop.system.persistance.dao.PetDAO;
import ojt.petshop.system.persistance.entity.Pet;

@Service
@Transactional
public class PetServiceImpl implements PetService {

    @Autowired
    private PetDAO petDao;

    @Override
    public int doSave(Pet pet) {
        return petDao.dbSave(pet);
    }

    @Override
    public Pet doGetById(int id) {
        return petDao.dbGetById(id);
    }

    @Override
    public List<Pet> doGetList() {
        return petDao.dbGetList();
    }

    @Override
    public int doUpdate(Pet pet) {
        return petDao.dbUpdate(pet);
    }

    @Override
    public int doDelete(int id) {
        return petDao.dbDelete(id);
    }
}
