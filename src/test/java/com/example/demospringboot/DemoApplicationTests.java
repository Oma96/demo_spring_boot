package com.example.demospringboot;

import org.junit.jupiter.api.Test;


import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


class DemoApplicationTests {


    @Test
    void testaddition() {
        AnnuaireDatabaseService annuaireDatabaseService = new AnnuaireDatabaseService();
        int resultat = annuaireDatabaseService.addition(2,3);
        assertEquals(5,resultat);
    }
}
