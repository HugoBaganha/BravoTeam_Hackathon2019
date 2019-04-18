package org.academiadecodigo.bravoteam.persistence;

import org.academiadecodigo.bravoteam.persistence.model.User;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class UserDao implements Dao<User> {


    protected User user;

    @PersistenceContext
    protected EntityManager em;

    public UserDao(User user) {
        this.user = user;
    }


    public List<User> findAll() {

        CriteriaQuery<User> criteriaQuery = em.getCriteriaBuilder().createQuery(User.class);
        Root<User> root = criteriaQuery.from(User.class);
        return em.createQuery(criteriaQuery).getResultList();

        // Using JPA
        // return em.createQuery( "from " + user.getSimpleName(), user).getResultList();
    }
    /**
     * Sets the entity manager
     *
     * @param em the entity manager to set
     */
    public void setEm(EntityManager em) {
        this.em = em;
    }

    /**
     * @see Dao#findById(Integer)
     */
    @Override
    public User findById(Integer id) {
        return em.find(User.class, id);
    }


    @Override
    public User saveOrUpdate(User modelObject) {
        return em.merge(modelObject);
    }

    /**
     * @see Dao#delete(Integer)
     */
    @Override
    public void delete(Integer id) {
        em.remove(em.find(User.class, id));
    }
}
