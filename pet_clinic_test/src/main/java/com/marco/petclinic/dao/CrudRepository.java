package com.marco.petclinic.dao;

import java.util.Optional;

public interface CrudRepository<T, ID> extends Repository<T, ID>  {

    /**
     * Save a given entity
     * Use the returned instance for further operations as the save operation might have changed the entity interface completely.
     *
     * @param entity must not be {@literal null}.
     * @return the saved entity will be never be {@literal null}.
     */
    <S extends T> S save(S entity);

    /**
     * Save all given entities
     *
     * @param entities must not be {@literal null}.
     * @return the saved entities will be never be {@literal null}.
     * @throws IllegalArgumentException in case the given entity is {@literal null}.
     */
    <S extends T> Iterable<S> saveAll(Iterable<S> entities);

    /**
     * Retrieves an entity by its id
     *
     * @param id must not be {@literal null}
     * @return the entity with the given id or {@literal optional#empty()} if none found
     * @throws  IllegalArgumentException if {@code id} is {@literal null}.
     */
    Optional<T> findById(ID id);

    /**
     * Returns if an entity with the given id exists
     *
     * @param id must not be {@literal null}.
     * @return {@literal true} if an entity with the given id exists. {@literal false} otherwise.
     * @throws IllegalArgumentException if {@code id} is {@literal null}.
     */
    boolean existsById(ID id);

    /**
     * Returns all instances of the type
     *
     * @return all entities
     */
    Iterable<T> findAll();

    /**
     * Return all instances of the type with the given IDs
     *
     * @param ids a collection of id
     * @return all entities of the given predicate
     */
    Iterable<T> findAllById(Iterable<T> ids);

    /**
     * Return the number of entities available.
     *
     * @return the number of entities
     */
    long count();

    /**
     * Deletes the entity with the given id.
     *
     * @param id must not be {@literal null}.
     * @throws IllegalArgumentException in case the given {@code id} is {@literal null}
     */
    void deleteById(ID id);

    /**
     * Deletes a given entity
     *
     * @param entity
     * @throws IllegalArgumentException in case the given entity is {@literal null}
     */
    void delete(T entity);

    /**
     * Deletes the given entities.
     *
     * @param entities
     * @throws IllegalArgumentException in case the given {@link Iterable} is {@literal null}.
     */
    void deleteAll(Iterable<? extends T> entities);

    /**
     * Delete all entities managed by the repository
     */
    void deleteAll();
}
