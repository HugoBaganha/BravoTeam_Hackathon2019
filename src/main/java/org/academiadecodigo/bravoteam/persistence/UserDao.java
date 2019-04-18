package org.academiadecodigo.bravoteam.persistence;

import org.springframework.ui.Model;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class UserDao<T extends Model> implements Dao<T> {


    protected Class<T> modelType;

    @PersistenceContext
    protected EntityManager em;

    /**
     * Initializes a new JPA DAO instance given a model type
     *
     * @param modelType the model type
     */
    public UserDao(Class<T> modelType) {
        this.modelType = modelType;
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
    public T findById(Integer id) {
        return em.find(modelType, id);
    }

    /**
     * @see Dao#saveOrUpdate(Model)
     */
    @Override
    public T saveOrUpdate(T modelObject) {
        return em.merge(modelObject);
    }

    /**
     * @see Dao#delete(Integer)
     */
    @Override
    public void delete(Integer id) {
        em.remove(em.find(modelType, id));
    }
}
