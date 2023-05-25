package sdv.jpa.petstore.entities;

import javax.persistence.*;


@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "ANIMAL")
public abstract class Animal {

    @Id
    @GeneratedValue
    @Column(name = "ID")
    private Long id;

    @Column(name = "BIRTH")
    private String birth;

    @Column(name = "COULEUR")
    private String couleur;

    @ManyToOne
    @JoinColumn(name="ID_PETSTORE")
    private PetStore petStore;

    public Animal() {
    }
    public Animal(String birth, String couleur, PetStore petStore) {
        this.birth = birth;
        this.couleur = couleur;
        this.petStore = petStore;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public String getCouleur() {
        return couleur;
    }

    public void setCouleur(String couleur) {
        this.couleur = couleur;
    }

    public PetStore getPetStore() {
        return petStore;
    }

    public void setPetStore(PetStore petStore) {
        this.petStore = petStore;
        this.petStore.getAnimals().add(this);
    }
}
