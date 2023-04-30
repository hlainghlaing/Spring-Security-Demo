package ojt.petshop.system.persistance.dao;

import ojt.petshop.system.persistence.entity.Authority;

public interface AuthorityDAO {
    
    public void dbSaveAuthority(Authority authority);

    public long dbGetAuthorityCount();
}
