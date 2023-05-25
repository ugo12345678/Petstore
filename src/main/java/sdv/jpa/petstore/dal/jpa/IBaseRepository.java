package sdv.jpa.petstore.dal.jpa;

import sdv.jpa.petstore.dal.PersistenceManager;

import javax.persistence.EntityManager;

public interface IBaseRepository<T>
{
    EntityManager entityManager = PersistenceManager.getEntityManager();

    default void save(T entity)
    {
        beginTransaction();
        entityManager.persist(entity);
        commitTransaction();
    }

    default void update(T entity)
    {
        beginTransaction();
        entityManager.merge(entity);
        commitTransaction();
    }

    default void remove(T entity)
    {
        beginTransaction();
        entityManager.remove(entity);
        commitTransaction();
    }

    default T findById(Integer id)
    {
        beginTransaction();
        T entity = entityManager.find((Class<T>) getClass(), id);
        commitTransaction();

        return entity;
    }

    default void beginTransaction()
    {
        entityManager.getTransaction().begin();
    }

    default void commitTransaction()
    {
        entityManager.getTransaction().commit();
    }

    default void rollbackTransaction()
    {
        entityManager.getTransaction().rollback();
    }

    default void close()
    {
        entityManager.close();
    }
}