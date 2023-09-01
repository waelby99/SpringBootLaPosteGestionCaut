package La.Poste.Waelby.GestCaut.controllers;

import La.Poste.Waelby.GestCaut.models.Demande;
import La.Poste.Waelby.GestCaut.repository.DemandeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600, allowCredentials="true")
@RestController
@RequestMapping("/api")
public class DemandeController {
    @Autowired
    DemandeRepository demandeRepository;

    @GetMapping("/demandes")
    public ResponseEntity<List<Demande>> getAllDemandes(@RequestParam(required = false) String nom) {
        try {
            List<Demande> demandes = new ArrayList<Demande>();

            if (nom == null)
                demandeRepository.findAll().forEach(demandes::add);

            if (demandes.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(demandes, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/demandes/{id}")
    public ResponseEntity<Demande> getDemandeById(@PathVariable("id") String id) {
        Optional<Demande> DemandeData = demandeRepository.findById(id);

        if (DemandeData.isPresent()) {
            return new ResponseEntity<>(DemandeData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/demandes")
    public ResponseEntity<Demande> createDemande(@RequestBody Demande demande) {
        try {
            Demande _demande = demandeRepository.save(new Demande(
                    demande.getUsername(),
                    demande.getNom(),
                    demande.getPosition(),
                    demande.getPrenom(),
                    demande.getEmail(),
                    demande.getPassword(),
                    demande.getDemandecreatedat(),
                    demande.getEtat(),
                    demande.getArchived()
            ));

            return new ResponseEntity<>(_demande, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/demandes/{id}")
    public ResponseEntity<Demande> updateDemande(@PathVariable("id") String id, @RequestBody Demande demande) {
        Optional<Demande> DemandeData = demandeRepository.findById(id);

        if (DemandeData.isPresent()) {
            Demande _demande = DemandeData.get();
            _demande.setEtat(demande.getEtat());
            _demande.setArchived(demande.getArchived());
            return new ResponseEntity<>(demandeRepository.save(_demande), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/demandes/{id}")
    public ResponseEntity<HttpStatus> deleteDemande(@PathVariable("id") String id) {
        try {
            demandeRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
