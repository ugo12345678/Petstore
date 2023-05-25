package sdv.jpa.petstore.entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "FISH")
public class Product {
    @Id
    @GeneratedValue
    @Column(name = "ID")
    private Long id;

    @Column(name = "CODE")
    private String code;

    @Column(name = "LABEL")
    private String label;

    @Column(name = "PRODTYPE")
    @Enumerated(EnumType.STRING)
    private ProdType type;
    @Column(name = "PRICE")
    private Double price;

    @ManyToMany
    @JoinTable(name="CTC",
            joinColumns= @JoinColumn(name="ID_PRO", referencedColumnName= "ID"),
            inverseJoinColumns= @JoinColumn(name="ID_PET", referencedColumnName="ID")
    )
    private Set<PetStore> petStores;
    {
        petStores = new HashSet<>();
    }

    public Product() {}
    public Product(String code, String label, ProdType type, Double price) {
        this.code = code;
        this.label = label;
        this.type = type;
        this.price = price;
    }

    public Set<PetStore> getPetStores() {
        return petStores;
    }

    public void setPetStores(Set<PetStore> petStores) {
        this.petStores = petStores;
    }

    public void addPetStore(PetStore petStore)
    {
        if(petStore != null)
        {
            petStore.addProduct(this);
        }
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public ProdType getType() {
        return type;
    }

    public void setType(ProdType type) {
        this.type = type;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
