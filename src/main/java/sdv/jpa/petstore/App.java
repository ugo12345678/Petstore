package sdv.jpa.petstore;

import sdv.jpa.petstore.dal.PersistenceManager;
import sdv.jpa.petstore.dal.jpa.*;
import sdv.jpa.petstore.dal.repository.*;
import sdv.jpa.petstore.entities.*;



public class App {

    public static void main(String[] args) {
        IAddressRepository  addressRepository  = new AddressRepository();
        IAnimalRepository   animalRepository   = new AnimalRepository();
        ICatRepository      catRepository      = new CatRepository();
        IFishRepository     fishRepository     = new FishRepository();
        IPetStoreRepository petStoreRepository = new PetStoreRepository();
        IProductRepository  productRepository  = new ProductRepository();

        try
        {
            // Création d'un PetStore
            PetStore petStore1 = new PetStore(
                    "Maxi Zoo",
                    "Declan Rice",
                    new Address("3", "rue de la forêt", "76620", "Le Havre")
            );

            PetStore petStore2 = new PetStore(
                    "Teranimo",
                    "Gabriel Jesus",
                    new Address("5", "impasse du moineau", "35000", "Rennes")
            );

            PetStore petStore3 = new PetStore(
                    "Animal Master",
                    "Allan Saint-Maximain",
                    new Address("9", "rue du lapin", "78130", "Les Mureaux")
            );

            // Création d'animaux pour le petStore1
            petStore1.addAnimal(new Cat(
                    "2019-03-02" ,
                    "brown",
                    petStore1,
                    "CA-756"
            ));

            petStore1.addAnimal(new Cat(
                    "2019-02-02",
                    "black",
                    petStore1,
                    "CA-123"
            ));

            petStore1.addAnimal(new Fish(
                    "2019-11-20",
                    "red",
                    petStore1,
                    FishLivEnv.FRESH_WATER
            ));

            // Création d'animaux pour le petStore2
            petStore2.addAnimal(new Cat(
                    "2019-08-23",
                    "white",
                    petStore2,
                    "CA-322"
            ));

            petStore2.addAnimal(new Cat(
                    "2019-04-15",
                    "red",
                    petStore2,
                    "CA-012"
            ));

            petStore2.addAnimal(new Fish(
                    "2019-04-16",
                    "blue",
                    petStore2,
                    FishLivEnv.SEA_WATER
            ));

            // Création d'animaux pour le petStore3
            petStore3.addAnimal(new Cat(
                    "2019-04-18",
                    "brown",
                    petStore3,
                    "CA-756"
            ));

            petStore3.addAnimal(new Fish(
                    "2019-03-23",
                    "black",
                    petStore3,
                    FishLivEnv.SEA_WATER
            ));

            petStore3.addAnimal(new Fish(
                    "2019-01-11",
                    "red",
                    petStore3,
                    FishLivEnv.FRESH_WATER
            ));

            // Création de produits
            Product product1 = new Product("p-125", "Croquettes pour chat", ProdType.FOOD, 5.65);
            Product product2 = new Product("p-127", "Nourriture pour poisson", ProdType.FOOD, 3.99);
            Product product3 = new Product("p-127", "Pâté pour chat", ProdType.FOOD, 5.90);
            Product product4 = new Product("p-129", "Pelle pour litière", ProdType.CLEANING, 4.00);
            Product product5 = new Product("p-131", "Kit nettoyage aquarium", ProdType.CLEANING, 11.50);
            Product product6 = new Product("p-127", "Litière + pelle pour chat", ProdType.CLEANING, 8.99);
            Product product7 = new Product("p-133", "Aquarium", ProdType.ACCESSORY, 32.99);
            Product product8 = new Product("p-135", "Souris tressé pour chat", ProdType.ACCESSORY, 1.90);
            Product product9 = new Product("p-127", "Balle rebondissante", ProdType.ACCESSORY, 1.35);

            petStore1.addProduct(product1);
            petStore1.addProduct(product2);
            petStore1.addProduct(product7);
            petStore1.addProduct(product8);

            petStore2.addProduct(product1);
            petStore2.addProduct(product3);
            petStore2.addProduct(product6);
            petStore2.addProduct(product9);

            petStore3.addProduct(product4);
            petStore3.addProduct(product5);
            petStore3.addProduct(product7);
            petStore3.addProduct(product8);

            // On persist
            petStoreRepository.save(petStore1);


            System.out.println("----------------------- Liste des PetStores -----------------------");
            System.out.println(petStore1);
            System.out.println(petStore2);
            System.out.println(petStore3);
            System.out.println();

        }
        catch (Exception e)
        {
            System.out.println("ERREUR");
            System.err.println(e.getMessage());
        }
        finally
        {
            addressRepository.close();
            animalRepository.close();
            catRepository.close();
            fishRepository.close();
            petStoreRepository.close();
            productRepository.close();
            PersistenceManager.closeEntityManagerFactory();
        }
    }
}
