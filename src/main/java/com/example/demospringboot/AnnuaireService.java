package com.example.demospringboot;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Optional;

@Service
public class AnnuaireService {
    private ArrayList<Personne>personnes = new ArrayList<>();
    private int nextId =0;

    public void addPersonne(Personne personne){
        nextId++;
        personne.setId(nextId);
        personnes.add(personne);
    }

    public ArrayList<Personne> getPersonnes(){
        return personnes;
    }
    public void delete(Integer id){
        Iterator<Personne> it= personnes.iterator();
        while(it.hasNext()){
            Personne p = it.next();
            if(p.getId().equals(id)){
                it.remove();
            }
        }
    }
    
    public Personne getOnePersonne(Integer id){

        for ( Personne p:personnes
             ) {if(p.getId().equals(id)){
               return p;
        }
        } return null;
    }

    public void updatePersonne(Integer id, Personne personne)  {
        for (int i = 0; i < personnes.size(); i++)
          {if (personnes.get(i).getId()==id) {
                personnes.set(i, personne);
            }
        }

    }

}
