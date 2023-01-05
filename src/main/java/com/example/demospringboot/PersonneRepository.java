package com.example.demospringboot;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PersonneRepository extends JpaRepository<Personne,Integer> {



    public List<Personne> findAllByNom(String nom);
    public List<Personne> findAllByNomAndAndPrenom(String nom,String prenom);

    
}
