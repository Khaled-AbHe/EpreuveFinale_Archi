package com.ep.service;

import com.ep.entity.Offre;
import com.ep.repository.OffreRepository;
import com.ep.repository.OperateurRepository;
import com.ep.repository.VolRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class OffresServiceTest {

    @Autowired
    OffresService os;

    @Autowired
    OffreRepository or;

    @Test
    @DisplayName("Devrait créer l'offre avec les bonnes paramètres")
    void createOffre() {
        int id = 9999;
        int volId = 101;
        int operateurId = 1;
        String depart = "2025-12-25T10:00";
        double prixBase = 100.00;

        Offre newOffre = os.createOffre(id, volId, operateurId, depart, prixBase);

        assertAll(
            () -> assertNotNull(newOffre), // check si ça existe
            () -> assertEquals(id, newOffre.getId()), // check l'id
            () -> assertEquals(volId, newOffre.getTrajet().getId()), // check le trajet
            () -> assertEquals(operateurId, newOffre.getOperateur().getId()), // check l'operateur
            () -> assertEquals(depart, newOffre.getDepart()), // check le départ
            () -> assertEquals(prixBase, newOffre.getPrixBase()) // check le prix
        );

        assertTrue(or.existsById(id), "Offer should exist in database");
    }

    @Test
    @DisplayName("Doit lancer un exception lors la creation d'un offre avec un operateur non-existant")
    void createOffreAvecOperateurInvalide() {
        int id = 9997;
        int volId = 101;
        int operateurId = 9999;
        String depart = "2025-12-25T10:00";
        double prixBase = 100.00;

        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () -> os.createOffre(id, volId, operateurId, depart, prixBase));
        assertEquals("Operateur n'existe pas", ex.getMessage());
    }

    @Test
    @DisplayName("Doit lancer un exception lors la creation d'un offre avec un vol non-existant")
    void createOffreAvecVolInvalide() {
        int id = 9998;
        int volId = 9999;
        int operateurId = 1;
        String depart = "2025-12-25T10:00";
        double prixBase = 100.00;

        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () -> os.createOffre(id, volId, operateurId, depart, prixBase));
        assertEquals("Vol n'existe pas", ex.getMessage());
    }
}