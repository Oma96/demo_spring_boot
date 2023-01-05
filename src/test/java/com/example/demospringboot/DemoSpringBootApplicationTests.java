package com.example.demospringboot;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class DemoSpringBootApplicationTests {
@Autowired
AnnuaireDatabaseService annuaireDatabaseService;
    @Test
    void testfindAllPersonnesByNom() {
        List<Personne> familleDelon= annuaireDatabaseService.getPersonneByNom("Delon");
        assertEquals(3,familleDelon.size());
    }
    @Test
    void testaddition() {
        int resultat = annuaireDatabaseService.addition(2,3);
        assertEquals(5,resultat);
    }
}
