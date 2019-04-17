package org.academiadecodigo.bravoteam.persistence;

import org.springframework.ui.Model;


/**
 * Base interface for data access objects, provides methods to manage models
 * @param <T> the model type
 */
public interface Dao<T extends Model> {

    /**
     * Gets the model
     *
     * @param id the model id
     * @return the model
     */
    T findById(Integer id);

    /**
     * Saves or updates the model
     *
     * @param modelObject the model to be saved or updated
     * @return the saved or updated model
     */
    T saveOrUpdate(T modelObject);

    /**
     * Deletes the model
     *
     * @param id the id of the model to be deleted
     */
    void delete(Integer id);
}
