package com.ep.controller;

import com.ep.entity.Offre;
import com.ep.service.OffresService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin/offres")
public class OfferController {
    private final OffresService offresService;

    public OfferController(OffresService offresService){
        this.offresService = offresService;
    }

    // CRUD
    @GetMapping("/all")
    public List<Offre> read(){
        return offresService.getAllOffres();
    }

    @PostMapping("/create")
    public ResponseEntity<Offre> createOffre(
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
}
