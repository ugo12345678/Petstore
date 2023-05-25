package sdv.jpa.petstore.entities;

import javax.persistence.*;


@Entity
@Table(name = "CAT")
public class Cat extends Animal  {
    @Column(name = "SHIPID")
    private String shipid;

    public Cat() {
    }

    public Cat(String birth, String couleur, PetStore petStore, String shipid) {
        super(birth, couleur, petStore);
        this.shipid = shipid;
    }

    public String getShipid() {
        return shipid;
    }

    public void setShipid(String shipid) {
        this.shipid = shipid;
    }
}
