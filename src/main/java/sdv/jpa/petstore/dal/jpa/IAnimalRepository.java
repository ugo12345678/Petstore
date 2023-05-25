package sdv.jpa.petstore.dal.jpa;

import sdv.jpa.petstore.entities.Address;
import sdv.jpa.petstore.entities.Animal;

import java.util.List;

public interface IAnimalRepository extends IBaseRepository<Animal>{
    public List<Animal> findAnimalsByPetStoreName (String name);
}
