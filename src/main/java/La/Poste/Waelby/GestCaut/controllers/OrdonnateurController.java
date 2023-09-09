package La.Poste.Waelby.GestCaut.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import La.Poste.Waelby.GestCaut.models.Ordonnateur;
import La.Poste.Waelby.GestCaut.repository.OrdonnateurRepository;
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
public class OrdonnateurController {

    @Autowired
    OrdonnateurRepository ordonnateurRepository;

    @GetMapping("/ordonnateurs")
    public ResponseEntity<List<Ordonnateur>> getAllOrdonnateurs(@RequestParam(required = false) String nom) {
        try {
            List<Ordonnateur> ordonnateurs = new ArrayList<Ordonnateur>();

            if (nom == null)
                ordonnateurRepository.findAll().forEach(ordonnateurs::add);
            else
                ordonnateurRepository.findByNomContaining(nom).forEach(ordonnateurs::add);

            if (ordonnateurs.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(ordonnateurs, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/ordonnateurs/{id}")
    public ResponseEntity<Ordonnateur> getOrdonnateurById(@PathVariable("id") String id) {
        Optional<Ordonnateur> ordonnateurData = ordonnateurRepository.findById(id);

        if (ordonnateurData.isPresent()) {
            return new ResponseEntity<>(ordonnateurData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/ordonnateurs")
    public ResponseEntity<Ordonnateur> createOrdonnateur(@RequestBody Ordonnateur ordonnateur) {
        try {
            Ordonnateur _ordonnateur = ordonnateurRepository.save(new Ordonnateur(ordonnateur.getRef(),  ordonnateur.getNom()));

            return new ResponseEntity<>(_ordonnateur, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/ordonnateurs/{id}")
    public ResponseEntity<Ordonnateur> updateOrdonnateur(@PathVariable("id") String id, @RequestBody Ordonnateur ordonnateur) {
        Optional<Ordonnateur> ordonnateurData = ordonnateurRepository.findById(id);

        if (ordonnateurData.isPresent()) {
            Ordonnateur _ordonnateur = ordonnateurData.get();
            _ordonnateur.setRef(ordonnateur.getRef());
            _ordonnateur.setNom(ordonnateur.getNom());
            return new ResponseEntity<>(ordonnateurRepository.save(_ordonnateur), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/ordonnateurs/{id}")
    public ResponseEntity<HttpStatus> deleteOrdonnateur(@PathVariable("id") String id) {
        try {
            ordonnateurRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/ordonnateursref/{ref}")
    public ResponseEntity<List<Ordonnateur>> findByRefOrdonnateur(@PathVariable("ref") String ref) {
        try {
            List<Ordonnateur> ordonnateurs = ordonnateurRepository.findByRef(ref);

            if (ordonnateurs.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(ordonnateurs, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/ordonnateursnom/{nom}")
    public ResponseEntity<List<Ordonnateur>> findByNomOrdonnateur(@PathVariable("nom") String nom) {
        try {
            List<Ordonnateur> ordonnateurs = ordonnateurRepository.findByNomContaining(nom);

            if (ordonnateurs.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(ordonnateurs, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}


