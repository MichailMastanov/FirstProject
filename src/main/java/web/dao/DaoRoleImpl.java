package web.dao;

import org.springframework.stereotype.Component;
import web.model.Role;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Component
public class DaoRoleImpl implements DaoRole{

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    @Override
    public void save(Role role) {
            entityManager.persist(role);
    }

    @Transactional
    @Override
    public void removeRole(Long id) {
        Role role = entityManager.find(Role.class, id);
        entityManager.remove(role);
    }

}
