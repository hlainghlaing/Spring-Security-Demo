package ojt.petshop.system.persistence.dao.impl;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ojt.petshop.system.persistance.dao.UserDAO;
import ojt.petshop.system.persistence.entity.User;

@Repository
@Transactional
public class UserDAOImpl implements UserDAO {

    /**
     * <h2>sessionFactory</h2>
     * <p>
     * Inject sessionFactory object
     * </p>
     */
    @Autowired
    private SessionFactory sessionFactory;

    /**
     * <h2>dbSaveUser</h2>
     * <p>
     * Save User
     * </p>
     * 
     * @param user
     */
    @Override
    public void dbSaveUser(User user) {
        this.sessionFactory.getCurrentSession().save(user);
    }

    @SuppressWarnings("rawtypes")
    @Override
    public User dbGetUserByName(String username) {
        Query query = this.sessionFactory.getCurrentSession()
                .createQuery("SELECT u FROM User u WHERE u.username = :username");
        query.setParameter("username", username);
        return (User) query.uniqueResult();
    }

    @SuppressWarnings("rawtypes")
    @Override
    public long dbGetUserCount() {
        Query query = this.sessionFactory.getCurrentSession().createQuery("SELECT COUNT(u) FROM User u");
        return (long) query.getSingleResult();
    }
}
