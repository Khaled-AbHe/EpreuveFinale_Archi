package com.ep.controller;

import com.ep.entity.Terminal;
import com.ep.service.TerminalService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin/terminal")
public class TerminalAdminController {
    private final TerminalService terminalService;

    public TerminalAdminController (TerminalService terminalService){
        this.terminalService = terminalService;
    }

    // CRUD
    @GetMapping("/all")
    public List<Terminal> read(){
        return terminalService.getAllTerminals();
    }

    @PostMapping("/create")
    public ResponseEntity<Terminal> createTerminal(
            @RequestParam int id,
            @RequestParam String code,
            @RequestParam String ville,
            @RequestParam String typeTrajet
    ) {
        return ResponseEntity.ok(
                terminalService.createTerminal(id, code, ville, typeTrajet)
        );
    }
    
}
