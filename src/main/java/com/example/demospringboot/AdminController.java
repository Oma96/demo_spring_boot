package com.example.demospringboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("admin/api")
public class AdminController {
    @Autowired
     private AnnuaireDatabaseService annuaireDatabaseService;


//    @DeleteMapping ("personnes/{id}")
//    public ResponseEntity deletePersonne(@PathVariable Integer id){
//       Personne p =annuaireDatabaseService.getOnePersonne(id);
//       if(p==null){
//           // indiquer status code 404
//           return ResponseEntity.notFound().build();
//       } else {
//           annuaireDatabaseService.delete(id);
//           return ResponseEntity.ok().build();
//       }
//    }
//    @PutMapping("personnes/{id}")
//    public ResponseEntity updatePersonne(@PathVariable Integer id, @RequestBody Personne personne)  {
//        if (!id.equals(personne.getId())){
//            return ResponseEntity.badRequest().build();
//        }
//        Personne p = annuaireDatabaseService.getOnePersonne(id);
//        if(p == null){
//            return ResponseEntity.notFound().build();
//        } else {
//            annuaireDatabaseService.updatePersonne(id,personne);
//            return ResponseEntity.ok().build();
//
//        }
//    }
}
