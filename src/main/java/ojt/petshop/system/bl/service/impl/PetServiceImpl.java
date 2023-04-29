package ojt.petshop.system.bl.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ojt.petshop.system.bl.service.PetService;
import ojt.petshop.system.persistance.dao.PetDAO;
import ojt.petshop.system.persistence.entity.Pet;

@Service
@Transactional
public class PetServiceImpl implements PetService {

    /**
     * <h2>petDao</h2>
     * <p>
     * Injection to PetDAO object
     * </p>
     */
    @Autowired
    private PetDAO petDao;

    /**
     * <h2>doSave</h2>
     * <p>
     * 
     * </p>
     * 
     * @param pet
     */
    @Override
    public void doSave(Pet pet) {
        petDao.dbSave(pet);
    }

    /**
     * <h2>doGetById</h2>
     * <p>
     * 
     * </p>
     * 
     * @param id
     * @return
     * @return petDao.dbGetById(id)
     */
    @Override
    public Pet doGetById(int id) {
        return petDao.dbGetById(id);
    }

    /**
     * <h2>doGetList</h2>
     * <p>
     * 
     * </p>
     * 
     * @return
     * @return PetDAO list
     */
    @Override
    public List<Pet> doGetList() {
        return petDao.dbGetList();
    }

    /**
     * <h2>doUpdate</h2>
     * <p>
     * Update Pet
     * </p>
     * 
     * @param pet
     */
    @Override
    public void doUpdate(Pet pet) {
        petDao.dbUpdate(pet);
    }

    /**
     * <h2>doDelete</h2>
     * <p>
     * Delete Pet
     * </p>
     * 
     * @param id
     * @return
     */
    @Override
    public int doDelete(int id) {
        return petDao.dbDelete(id);
    }
}
