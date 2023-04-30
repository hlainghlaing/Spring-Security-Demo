package ojt.petshop.system.persistance.dao;

import ojt.petshop.system.persistence.entity.User;

public interface UserDAO {
    
    public void dbSaveUser(User user);

    public User dbGetUserByName(String username);

    public long dbGetUserCount();
}
