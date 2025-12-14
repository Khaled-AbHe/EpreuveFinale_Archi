package com.ep.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TerminalServiceTest {

    @Autowired
    TerminalService ts;

    @Test
    @DisplayName("verifie si le code est valide.")
    void verifyCode() {
        String goodCode = "ABC";
        String badCode1 = "ABB";
        String badCode2 = "AB1";
        assertAll(
            () -> assertTrue(ts.verifyCode(goodCode)),
            () -> assertFalse(ts.verifyCode(badCode1)),
            () -> assertFalse(ts.verifyCode(badCode2))
        );
    }
}