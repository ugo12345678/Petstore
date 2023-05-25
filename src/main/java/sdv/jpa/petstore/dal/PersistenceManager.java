package sdv.jpa.petstore.dal;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class PersistenceManager
{
    private static final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("petstore");

    public static EntityManager getEntityManager()
    {
        return entityManagerFactory.createEntityManager();
    }

    public static void closeEntityManagerFactory()
    {
        if (entityManagerFactory.isOpen())
        {
            entityManagerFactory.close();
        }
    }
}