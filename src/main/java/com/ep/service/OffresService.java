package com.ep.service;

import com.ep.entity.Offre;
import com.ep.entity.Vol;
import com.ep.entity.Operateur;

import com.ep.repository.OffreRepository;
import com.ep.repository.VolRepository;
import com.ep.repository.OperateurRepository;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OffresService {

    private final OffreRepository offreRepo;
    private final VolRepository volRepo;
    private final OperateurRepository opRepo;

    public OffresService (OffreRepository offreRepo, VolRepository volRepo, OperateurRepository opRepo){
        this.offreRepo = offreRepo;
        this.volRepo = volRepo;
        this.opRepo = opRepo;
    }

    public List<Offre> getAllOffres(){
        return offreRepo.findAll();
    }

    public Offre createOffre(int id, int volId, int operateurId, String depart, double prixBase) {
        Offre newOffre = new Offre();

        // TO DO
        // vérfier les parametres
        Vol vol = volRepo.findById(volId).orElseThrow(() -> new IllegalArgumentException(""));
        Operateur op = opRepo.findById(operateurId).orElseThrow(() -> new IllegalArgumentException(""));

        // créer l'offre
        newOffre.setId(id);
        newOffre.setTrajet(vol);
        newOffre.setOperateur(op);
        newOffre.setDepart(depart);
        newOffre.setPrixBase(prixBase);

        offreRepo.save(newOffre);

        return newOffre;
    }
}
