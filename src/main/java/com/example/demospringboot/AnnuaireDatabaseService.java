package com.example.demospringboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Service
public class AnnuaireDatabaseService {
    @Autowired
    PersonneRepository personneRepository;
    @Autowired
    ChienRepository chienRepository;


    public void addChien(Chien chien){
        chienRepository.save(chien);
    }

    public List<Chien> getChiens(){
        return chienRepository.findAll();
    }
    public void addPersonne(Personne personne) {
        personneRepository.save(personne);
    }

    public List<Personne> getPersonnes(){
        return personneRepository.findAll();
    }
    public void delete(Integer id){
    personneRepository.deleteById(id);
    }

    public Optional<Personne> getOnePersonne(Integer id){
        return personneRepository.findById(id);
    }

    public void updatePersonne(Integer id, Personne personne)  {
     personneRepository.save(personne);

    }
    public List<Personne> getPersonneByNom(String nom){
        return personneRepository.findAllByNom(nom);
    }
    public List<Personne> getPersonneByNomAndPrenom(String nom, String prenom){
        return personneRepository.findAllByNomAndAndPrenom(nom, prenom);
    }

    public int addition(int a,int b){
        return a + b;
    }
}