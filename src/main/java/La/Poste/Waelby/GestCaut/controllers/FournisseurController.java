package La.Poste.Waelby.GestCaut.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import La.Poste.Waelby.GestCaut.models.Fournisseur;
import La.Poste.Waelby.GestCaut.repository.FournisseurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600, allowCredentials="true")
@RestController
@RequestMapping("/api")
public class FournisseurController {

    @Autowired
    FournisseurRepository fournisseurRepository;

    @GetMapping("/fournisseurs")
    public ResponseEntity<List<Fournisseur>> getAllFournisseurs(@RequestParam(required = false) String nom) {
        try {
            List<Fournisseur> fournisseurs = new ArrayList<Fournisseur>();

            if (nom == null)
                fournisseurRepository.findAll().forEach(fournisseurs::add);
            else
                fournisseurRepository.findByNomContaining(nom).forEach(fournisseurs::add);

            if (fournisseurs.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(fournisseurs, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/fournisseurs/{id}")
    public ResponseEntity<Fournisseur> getFournisseurById(@PathVariable("id") String id) {
        Optional<Fournisseur> fournisseurData = fournisseurRepository.findById(id);

        if (fournisseurData.isPresent()) {
            return new ResponseEntity<>(fournisseurData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/fournisseurs")
    public ResponseEntity<Fournisseur> createFournisseur(@RequestBody Fournisseur fournisseur) {
        try {
            Fournisseur _fournisseur = fournisseurRepository.save(new Fournisseur(fournisseur.getNom(), fournisseur.getMail(), fournisseur.getAdresse(),fournisseur.getTel()));

            return new ResponseEntity<>(_fournisseur, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/fournisseurs/{id}")
    public ResponseEntity<Fournisseur> updateFournisseur(@PathVariable("id") String id, @RequestBody Fournisseur fournisseur) {
        Optional<Fournisseur> fournisseurData = fournisseurRepository.findById(id);

        if (fournisseurData.isPresent()) {
            Fournisseur _banque = fournisseurData.get();
            _banque.setNom(fournisseur.getNom());
            _banque.setMail(fournisseur.getMail());
            _banque.setAdresse(fournisseur.getAdresse());
            _banque.setTel(fournisseur.getTel());
            return new ResponseEntity<>(fournisseurRepository.save(_banque), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/fournisseurs/{id}")
    public ResponseEntity<HttpStatus> deleteFournisseur(@PathVariable("id") String id) {
        try {
            fournisseurRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/fournisseursmail/{mail}")
    public ResponseEntity<List<Fournisseur>> findByFournisseur(@PathVariable("mail") String mail) {
        try {
            List<Fournisseur> fournisseurs = fournisseurRepository.findByMail(mail);

            if (fournisseurs.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(fournisseurs, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/fournisseursnom/{nom}")
    public ResponseEntity<List<Fournisseur>> findByNomFour(@PathVariable("nom") String nom) {
        try {
            List<Fournisseur> fournisseurs = fournisseurRepository.findByNomContaining(nom);

            if (fournisseurs.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(fournisseurs, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
