package com.example.demospringboot;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class AdressesSpringTests {

@Autowired AdresseRepository adresseRepository;
@Autowired PersonneRepository personneRepository;
@Autowired StageRepository stageRepository;

@Autowired ChienRepository chienRepository;
    @Test
    void testAdresses() {
      Adresse adresse= new Adresse(13,"Rue du vieuxport","13000","Marseille");
      adresseRepository.save(adresse);

    }
@Test
    void testManyToOne() {
        Adresse adresse= new Adresse(6,"Boulevard Calmette","78200","Mantes");
        adresseRepository.save(adresse);
        Personne personne = new Personne("Jarraya","Oumaima");
        personne.setAdresse(adresse);
        personneRepository.save(personne);
    }

    @Test
    void testAjoutDeuxPersonnes(){
        Adresse adresse = adresseRepository.findById(2).get();
        Personne Houcem = new Personne("Fourati","Houcem");
        Houcem.setAdresse(adresse);
        personneRepository.save(Houcem);
    }

    @Test
    void testEntityStage(){
        Stage stage = new Stage("Java",
                LocalDateTime.of(2023,06,21,18,00));
        stageRepository.save(stage);
    }

    @Test
    void testManyToMany(){
        Stage stage =stageRepository.findById(1).get();
        Personne Oumaima = personneRepository.findById(4).get();
        Personne Houcem = personneRepository.findById(5).get();

       stage.addStiagaire(Oumaima);
       stage.addStiagaire(Houcem);
       stageRepository.save(stage);
    }


    @Test
    void testManyToOneChien(){
        Chien chien = new Chien("Bibou");
        Chien chien1 = new Chien("Boby");
        Personne Oumaima = personneRepository.findById(4).get();
        chien.setPersonne(Oumaima);
        chien1.setPersonne(Oumaima);
        chienRepository.save(chien);
        chienRepository.save(chien1);
    }
}
