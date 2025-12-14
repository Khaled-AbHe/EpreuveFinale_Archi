package com.ep.service;

import com.ep.entity.Terminal;
import com.ep.entity.TypeTransport;
import com.ep.repository.TerminalRepository;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class TerminalService {
    private final TerminalRepository terminalRepo;

    public TerminalService(TerminalRepository terminalRepo){
        this.terminalRepo = terminalRepo;
    }

    public List<Terminal> getAllTerminals(){
        return terminalRepo.findAll();
    }

    public boolean verifyCode(String code) {
        if (code == null || code.length() != 3) {return false;} // verifie la longeur et le contenu
        for (int i = 0; i < code.length(); i++) {
            char c = code.charAt(i);
            for (int j = i+1; j < code.length(); j++) { // assure que les lettres ne se répètent pas
                if (c == code.charAt(j)) {return false;}
            }
            if (!Character.isLetter(c) || Character.isLowerCase(c)) {return false;} // assure que ça contient que des lettres majuscules
        }
        return true;
    }

    public Terminal createTerminal(int id, String code, String ville, TypeTransport typeTrajet) {
        Terminal newTerminal = new Terminal();

        if (!verifyCode(code)) {
            throw new IllegalArgumentException("Invalid code");
        }

        newTerminal.setId(id);
        newTerminal.setCode(code);
        newTerminal.setVille(ville);
        newTerminal.setTypeTrajet(typeTrajet);

        terminalRepo.save(newTerminal);

        return newTerminal;
    }
}
