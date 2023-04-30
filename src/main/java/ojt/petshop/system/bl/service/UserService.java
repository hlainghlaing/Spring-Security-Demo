package ojt.petshop.system.bl.service;

import ojt.petshop.system.persistence.entity.User;

public interface UserService {
    
    public User doGetByUserName(String name);
    
    public long doGetUserCount();
}
