package com.example.demo.repository;

import com.example.demo.Model.PetTypes;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class PetTypeRepository implements PanacheRepository<PetTypes> {

}
