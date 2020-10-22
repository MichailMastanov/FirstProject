package web.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.dao.DaoUser;
import web.dao.DaoUserImpl;
import web.model.User;

import java.util.List;

@Service
public class UserServiceHiber {

    private DaoUser daoUser;

    @Autowired
    public void setDaoUserImpl(DaoUser daoUser) {
        this.daoUser = daoUser;
    }

    public List<User> getUsers(){
       return daoUser.getUsers();
    }

    public void save(User user){
        daoUser.save(user);
    }

    public void removeUser(Long id){
        daoUser.removeUser(id);
    }

    public void upUs(User user){
        daoUser.upUs(user);
    }

}
