package com.ep.service;

import com.ep.entity.Terminal;
import com.ep.entity.TypeTransport;
import com.ep.repository.TerminalRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TerminalServiceTest {

    @Autowired
    TerminalService ts;

    @Autowired
    TerminalRepository tr;

    @Test
    @DisplayName("Verifie que les termiaux sont bien chargée")
    void verifyTerminal() {
        Terminal terminal = tr.findById(1).orElse(null);
        assertNotNull(terminal);
    }

    @Test
    @DisplayName("verifie si le code est valide.")
    void verifyCode() {
        String goodCode = "ABC";
        String badCode1 = "ABB";
        String badCode2 = "AB1";
        String badCode3 = "ABc";
        String badCode4 = "AB";
        String badCode5 = "ABCD";
        assertAll(
            () -> assertTrue(ts.verifyCode(goodCode)),
            () -> assertFalse(ts.verifyCode(badCode1)), // Pas bon car les lettres se répètent
            () -> assertFalse(ts.verifyCode(badCode2)), // Pas bon car il contient un nombre
            () -> assertFalse(ts.verifyCode(badCode3)), // Pas bon car il contient une lettre minuscule
            () -> assertFalse(ts.verifyCode(badCode4)), // Pas bon car c'est trop court
            () -> assertFalse(ts.verifyCode(badCode5))  // Pas bon car c'est trop long
        );
    }

    @Test
    @DisplayName("Creation d'un terminal")
    void createTerminal() {
        int id = 100;
        String code = "LAX";
        String ville = "Los Angeles";
        TypeTransport type = TypeTransport.AERIEN;

        Terminal newTerminal = ts.createTerminal(id, code, ville, type);

        assertAll(
            () -> assertNotNull(newTerminal),
            () -> assertEquals(id, newTerminal.getId()),
            () -> assertEquals(code, newTerminal.getCode()),
            () -> assertEquals(ville, newTerminal.getVille()),
            () -> assertEquals(type, newTerminal.getTypeTrajet()),
            () -> assertTrue(tr.existsById(id))
        );
    }
}