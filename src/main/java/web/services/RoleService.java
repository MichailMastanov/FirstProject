package web.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.dao.DaoRole;
import web.dao.DaoRoleImpl;
import web.model.Role;

@Service
public class RoleService {

    private DaoRole daoRole;

    @Autowired
    public void setDaoRole(DaoRole daoRole) {
        this.daoRole = daoRole;
    }

    public void save(Role role){
        daoRole.save(role);
    }

    public void removeRole(Long id){
        daoRole.removeRole(id);
    }

}
