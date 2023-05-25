package sdv.jpa.petstore.entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "PETSTORE")
public class PetStore {
    @Id
    @GeneratedValue
    @Column(name = "ID")
    private Long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "MANAGERNAME")
    private String managerName;

    @OneToOne
    private Address address;

    @ManyToMany
    @JoinTable(name="CTC",
            joinColumns= @JoinColumn(name="ID_PET", referencedColumnName= "ID"),
            inverseJoinColumns= @JoinColumn(name="ID_PRO", referencedColumnName="ID")
    )
    private Set<Product> products;
    {
        products = new HashSet<>();
    }
    @OneToMany(mappedBy="petStore")
    private Set<Animal> animals;
    {
        animals = new HashSet<>();
    }
    public PetStore() {}
    public PetStore(String name, String managerName, Address address) {
        this.name = name;
        this.managerName = managerName;
        this.address = address;
    }

    public Set<Animal> getAnimals() {
        return animals;
    }

    public void setAnimals(Set<Animal> animals) {
        this.animals = animals;
    }
    public void addAnimal(Animal animal)
    {
        if (animal != null) {
            animal.setPetStore(this);
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getManagerName() {
        return managerName;
    }

    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }

    public void addProduct(Product product)
    {
        if (product != null) {
         this.products.add(product);
         product.getPetStores().add(this);
        }
    }
}
