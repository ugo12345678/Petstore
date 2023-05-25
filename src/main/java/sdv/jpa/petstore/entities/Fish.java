package sdv.jpa.petstore.entities;

import javax.persistence.*;

@Entity
@Table(name = "FISH")
public class Fish extends Animal {

    @Column(name = "LIVINGENV")
    @Enumerated(EnumType.STRING)
    private FishLivEnv livingEnv;


    public Fish() {
    }

    public Fish(FishLivEnv livingEnv) {
        this.livingEnv = livingEnv;
    }

    public Fish(String birth, String couleur, PetStore petStore, FishLivEnv livingEnv) {
        super(birth, couleur, petStore);
        this.livingEnv = livingEnv;
    }

    @Override
    public String toString() {
        return "Fish{" +
                "livingEnv=" + livingEnv +
                '}';
    }

    public FishLivEnv getLivingEnv() {
        return livingEnv;
    }

    public void setLivingEnv(FishLivEnv livingEnv) {
        this.livingEnv = livingEnv;
    }
}