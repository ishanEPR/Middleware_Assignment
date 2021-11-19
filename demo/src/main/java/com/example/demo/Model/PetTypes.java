package com.example.demo.Model;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class PetTypes  {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String categeryType;
    private String Petfamily;
    public PetTypes() {

    }

    public PetTypes(String categeryType, String petfamily) {
        this.categeryType = categeryType;
        this.Petfamily = petfamily;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCategeryType() {
        return categeryType;
    }

    public void setCategeryType(String categeryType) {
        this.categeryType = categeryType;
    }

    public String getPetfamily() {
        return Petfamily;
    }

    public void setPetfamily(String petfamily) {
        this.Petfamily = petfamily;
    }
}
