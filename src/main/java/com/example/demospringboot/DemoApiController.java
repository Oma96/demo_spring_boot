package com.example.demospringboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController // pour les api on utilise RestController, il transforme tout les objets en JSON
@RequestMapping("api")
public class DemoApiController {
    @Autowired // pour injecter un objet dans une variable sans faire new Annuaire
    AnnuaireDatabaseService annuaireDatabaseService;



    @GetMapping("personnes")
    public List<PersonneDTO> getPersonnes(){
        List<PersonneDTO> dtos = new ArrayList<>();
        List<Personne> entities= annuaireDatabaseService.getPersonnes();
        for(Personne entity: entities){
            PersonneDTO dto= PersonneMapper.convertToDTO(entity);
            dtos.add(dto);
        }
        return dtos;
    }
    @GetMapping("personne/{id}")
    public ResponseEntity getOnePersonne(@PathVariable Integer id){

        Optional<Personne> optional= annuaireDatabaseService.getOnePersonne(id);
        if(optional.isEmpty()){
            return ResponseEntity.notFound().build();
        } else {
            Personne personne = optional.get();
            return ResponseEntity.ok().body(personne);

        }

    }

    @PostMapping("personne")
    public void createPersonne(@RequestBody Personne personne){

        annuaireDatabaseService.addPersonne(personne);

    }


    @PostMapping("chien")
    public void createChien(@RequestBody Chien chien ){

        annuaireDatabaseService.addChien(chien);
    }

    @GetMapping("chiens")
    public List<Chien> getChiens(){
        return annuaireDatabaseService.getChiens();
    }

    //findallbynom?nom=bond
    @GetMapping("findallbynom")
    public List<Personne> findallbynom(@RequestParam String nom){
        return annuaireDatabaseService.getPersonneByNom(nom);
    }

    //findallbynom?nom=bond&prenom=james
    @GetMapping("findallbynomandprenom")
    public List<Personne> findallbynom(@RequestParam String nom,@RequestParam String prenom){
        return annuaireDatabaseService.getPersonneByNomAndPrenom(nom,prenom);
    }

}
