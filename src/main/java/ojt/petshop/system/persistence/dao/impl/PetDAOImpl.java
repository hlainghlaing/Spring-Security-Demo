package ojt.petshop.system.persistence.dao.impl;

import java.util.List;

import javax.swing.JOptionPane;
import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ojt.petshop.system.persistance.dao.PetDAO;
import ojt.petshop.system.persistence.entity.Pet;

/**
 * <h2>PetDAOImpl Class</h2>
 * <p>
 * Process for Displaying PetDAOImpl
 * </p>
 * 
 * @author Khin Yadanar Hlaing
 *
 */

@Repository
public class PetDAOImpl implements PetDAO {

    /**
     * <h2>sessionFactory</h2>
     * <p>
     * sessionFactory
     * </p>
     */
    @Autowired
    private SessionFactory sessionFactory;

    /**
     * <h2>SELECT_PET_HQL</h2>
     * <p>
     * SELECT_PET_HQL
     * </p>
     */
    private static final String SELECT_PET_HQL = "FROM Pet p";

    /**
     * <h2>SELECT_PET_BY_ID_HQL</h2>
     * <p>
     * SELECT_PET_BY_ID_HQL
     * </p>
     */
    public static final String SELECT_PET_BY_ID_HQL = "FROM Pet p WHERE p.id = :id ";

    /**
     * <h2>DELETE_PET_HQL</h2>
     * <p>
     * DELETE_PET_HQL
     * </p>
     */
    private static final String DELETE_PET_HQL = "DELETE FROM Pet p WHERE p.id= :id";

    @Override
    public void dbSave(Pet pet) {
        JOptionPane.showMessageDialog(null, "Successfully Saved", "Inserting", JOptionPane.INFORMATION_MESSAGE);
        this.sessionFactory.getCurrentSession().save(pet);
    }

    /**
     * <h2>dbGetById</h2>
     * <p>
     * 
     * </p>
     * 
     * @param id int
     * @return
     * @return Pet
     */
    @SuppressWarnings("unchecked")
    @Override
    public Pet dbGetById(int id) {
        Query<Pet> queryPetById = this.sessionFactory.getCurrentSession().createQuery(SELECT_PET_BY_ID_HQL);
        queryPetById.setParameter("id", id);
        Pet pet = queryPetById.uniqueResult();
        return pet;
    }

    /**
     * <h2>dbGetList</h2>
     * <p>
     * 
     * </p>
     * 
     * @return List of Pet
     */
    @Override
    public List<Pet> dbGetList() {
        Query<Pet> query = this.sessionFactory.getCurrentSession().createQuery(SELECT_PET_HQL);
        List<Pet> petList = query.list();
        return petList;
    }

    /**
     * <h2>dbUpdate</h2>
     * <p>
     * 
     * </p>
     * 
     * @param pet
     */
    @Override
    public void dbUpdate(Pet pet) {
        JOptionPane.showMessageDialog(null, "Successfully Updated", "Editing", JOptionPane.INFORMATION_MESSAGE);
        this.sessionFactory.getCurrentSession().update(pet);
    }

    /**
     * <h2>dbDelete</h2>
     * <p>
     * 
     * </p>
     * 
     * @param id
     * @return
     * @return int
     */
    @Override
    public int dbDelete(int id) {
        int option = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete?");
        if (option == JOptionPane.YES_OPTION) {
            Query<Pet> query = this.sessionFactory.getCurrentSession().createQuery(DELETE_PET_HQL);
            query.setParameter("id", id);
            return query.executeUpdate();
        }
        return option;

    }

    /**
     * private JdbcTemplate jdbcTemplate;
     * 
     * 
     * public JdbcTemplate getJdbcTemplate() { return jdbcTemplate; }
     * 
     * public void setJdbcTemplate(JdbcTemplate jdbcTemplate) { this.jdbcTemplate =
     * jdbcTemplate; } public PetDAOImpl(DataSource dataSource) { this.jdbcTemplate
     * = new JdbcTemplate(dataSource); }
     */
    /**
     * @Override public int dbSave(Pet pet) { String sql = "INSERT INTO petinfo
     *           (name,sex,age,type,hobby) values (?,?,?,?,?)"; int result =
     *           jdbcTemplate.update(sql, pet.getName(), pet.getSex(), pet.getAge(),
     *           pet.getType(), pet.getHobby()); return result; }
     * 
     * @Override public Pet dbGetById(int id) { String sql = "SELECT * FROM petinfo
     *           where id=" + id; ResultSetExtractor<Pet> extractor = new
     *           ResultSetExtractor<Pet>() {
     * 
     * @Override public Pet extractData(ResultSet rs) throws SQLException,
     *           DataAccessException { if (rs.next()) { String name =
     *           rs.getString("name"); String sex = rs.getString("sex"); String age
     *           = rs.getString("age"); String type = rs.getString("type"); String
     *           hobby = rs.getString("hobby"); Pet petObj = new Pet(name, sex, age,
     *           type, hobby); return petObj; } return null; } }; return
     *           jdbcTemplate.query(sql, extractor); }
     * 
     * @Override public List<Pet> dbGetList() { String sql = "SELECT * FROM
     *           petinfo"; RowMapper<Pet> rMapper = new RowMapper<Pet>() {
     * 
     * @Override public Pet mapRow(ResultSet rs, int rowNum) throws SQLException {
     *           int id = rs.getInt("id"); String name = rs.getString("name");
     *           String sex = rs.getString("sex"); String age = rs.getString("age");
     *           String type = rs.getString("type"); String hobby =
     *           rs.getString("hobby"); Pet petObj = new Pet(id, name, sex, age,
     *           type, hobby); return petObj; } }; return jdbcTemplate.query(sql,
     *           rMapper); }
     * 
     * @Override public int dbUpdate(Pet pet) { String sql = "UPDATE petinfo SET
     *           name=?,sex=?,age=?,type=?,hobby=? WHERE id=?"; int result =
     *           jdbcTemplate.update(sql, pet.getName(), pet.getSex(), pet.getAge(),
     *           pet.getType(), pet.getHobby(), pet.getId()); return result; }
     * 
     * @Override public int dbDelete(int id) { String sql = "DELETE FROM petinfo
     *           WHERE id=" + id; return jdbcTemplate.update(sql); }
     */
}