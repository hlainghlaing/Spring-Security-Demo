package ojt.petshop.system.bl.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import ojt.petshop.system.bl.service.UserService;
import ojt.petshop.system.dto.CustomUserDetail;
import ojt.petshop.system.persistance.dao.UserDAO;
import ojt.petshop.system.persistence.entity.User;


@Service("userService")
public class UserServiceImpl implements UserService,UserDetailsService{

    @Autowired
    UserDAO userDao;
    
    @Override
    public User doGetByUserName(String name) {
        return this.userDao.dbGetUserByName(name);
    }

    @Override
    public long doGetUserCount() {
        return this.userDao.dbGetUserCount();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User userInfo = this.userDao.dbGetUserByName(username);
        if (userInfo == null) {
            throw new UsernameNotFoundException("Invalid Username or Password!");
        }
        UserDetails user = new CustomUserDetail(userInfo.getUsername(), userInfo.getPassword(),
                userInfo.getAuthorities());
        return user;
    }
}
