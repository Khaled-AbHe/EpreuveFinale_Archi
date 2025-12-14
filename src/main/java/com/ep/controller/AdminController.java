package com.ep.controller;

import com.ep.entity.Offre;
import com.ep.entity.Terminal;
import com.ep.entity.TypeTransport;
import com.ep.service.OffresService;
import com.ep.service.TerminalService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin")
public class AdminController {
    private final OffresService offresService;
    private final TerminalService terminalService;

    public AdminController (OffresService offresService, TerminalService terminalService){
        this.offresService = offresService;
        this.terminalService = terminalService;
    }

    // OfferBuilder
    @GetMapping("/allOffers")
    public List<Offre> readOffers(){
        return offresService.getAllOffres();
    }

    @PostMapping("/addOffer")
    public ResponseEntity<Offre> addOffre(
            @RequestParam int id,
            @RequestParam int trajetId,
            @RequestParam int operateurId,
            @RequestParam String depart,
            @RequestParam double prixBase
    ) {
        return ResponseEntity.ok(
                offresService.createOffre(id, trajetId, operateurId, depart, prixBase)
        );
    }

    // TerminalBuilder
    @GetMapping("/allTerminals")
    public List<Terminal> readTerminals(){
        return terminalService.getAllTerminals();
    }

    @PostMapping("/addTerminal")
    public ResponseEntity<Terminal> addTerminal(
            @RequestParam int id,
            @RequestParam String code,
            @RequestParam String ville,
            @RequestParam TypeTransport typeTrajet
    ) {
        return ResponseEntity.ok(
                terminalService.createTerminal(id, code, ville, typeTrajet)
        );
    }
}
