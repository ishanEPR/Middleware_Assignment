package com.example.demo.repository;

import com.example.demo.Model.Pet;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class PetRepository implements PanacheRepository<Pet> {
}
