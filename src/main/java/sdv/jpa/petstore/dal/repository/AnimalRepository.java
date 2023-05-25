package sdv.jpa.petstore.dal.repository;

import sdv.jpa.petstore.dal.jpa.IAnimalRepository;
import sdv.jpa.petstore.entities.Animal;

import javax.persistence.TypedQuery;
import java.util.List;

public class AnimalRepository implements IAnimalRepository {
    public List<Animal> findAnimalsByPetStoreName (String name)
    {
        TypedQuery<Animal> query = entityManager.createQuery("Select a from Animal a Join a.petStore p where p.name = :name", Animal.class);
        query.setParameter("name", name);
        return query.getResultList();
    }
}
