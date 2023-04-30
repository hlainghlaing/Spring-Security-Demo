package ojt.petshop.system.config;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import ojt.petshop.system.persistance.dao.AuthorityDAO;
import ojt.petshop.system.persistance.dao.UserDAO;
import ojt.petshop.system.persistence.entity.Authority;
import ojt.petshop.system.persistence.entity.User;

@Component
public class DeploymentListener {

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private AuthorityDAO authorityDao;

    @Autowired
    private UserDAO userDao;

    @PostConstruct
    public void addInitialData() {

        // adding default data
        if (this.authorityDao.dbGetAuthorityCount() <= 0 && this.userDao.dbGetUserCount() <= 0) {
            List<Authority> adminAuthorities = new ArrayList<Authority>();
            Authority adminAuthority = new Authority(null, "ROLE_ADMIN");
            this.authorityDao.dbSaveAuthority(adminAuthority);
            adminAuthorities.add(adminAuthority);
            User admin = new User(null, "admin", passwordEncoder.encode("123"), adminAuthorities);
            this.userDao.dbSaveUser(admin);

            List<Authority> userAuthorities = new ArrayList<Authority>();
            Authority userAuthority = new Authority(null, "ROLE_USER");
            this.authorityDao.dbSaveAuthority(userAuthority);
            userAuthorities.add(userAuthority);
            User user = new User(null, "user", passwordEncoder.encode("123"), userAuthorities);
            this.userDao.dbSaveUser(user);
        }
    }
}
