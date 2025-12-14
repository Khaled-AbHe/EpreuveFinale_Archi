package com.ep.service;


import com.ep.entity.Terminal;
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

    public Terminal createTerminal(int id, String code, String ville, String typeTrajet) {
        Terminal newTerminal = new Terminal();

        Terminal Terminal = terminalRepo.findById(id).orElseThrow(() -> new IllegalArgumentException(""));

        newTerminal.setId(id);
        newTerminal.setCode(code);
        newTerminal.setVille(ville);
        newTerminal.setTypeTrajet(typeTrajet);

        terminalRepo.save(newTerminal);

        return newTerminal;
    }
}
