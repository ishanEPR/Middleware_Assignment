package com.example.demo.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import io.quarkus.hibernate.orm.panache.PanacheEntity;


import javax.persistence.*;

@Entity

public class Pet  {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(length = 100)
    private String petName;

    private Integer petAge;
    private  String petType;
    private String petColor;

//set the foreign key
//    @ManyToOne(fetch = FetchType.EAGER)
//    @JoinColumn(name = "type_id",referencedColumnName = "id")
//    @JsonBackReference
//    private PetTypes petType;

    public Pet() {

    }

    public Pet(String petName, Integer petAge, String petType, String petColor) {
        this.petName = petName;
        this.petAge = petAge;
        this.petType = petType;
        this.petColor = petColor;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPetName() {
        return petName;
    }

    public void setPetName(String petName) {
        this.petName = petName;
    }

    public Integer getPetAge() {
        return petAge;
    }

    public void setPetAge(Integer petAge) {
        this.petAge = petAge;
    }

    public String getPetType() {
        return petType;
    }

    public void setPetType(String petType) {
        this.petType = petType;
    }

    public String getPetColor() {
        return petColor;
    }

    public void setPetColor(String petColor) {
        this.petColor = petColor;
    }
}
