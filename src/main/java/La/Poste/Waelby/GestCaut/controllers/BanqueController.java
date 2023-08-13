package La.Poste.Waelby.GestCaut.controllers;


import La.Poste.Waelby.GestCaut.models.Banque;
import La.Poste.Waelby.GestCaut.repository.BanqueRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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





@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api")
public class BanqueController {

    @Autowired
    BanqueRepository banqueRepository;

    @GetMapping("/banques")
    public ResponseEntity<List<Banque>> getAllBanques(@RequestParam(required = false) String nom) {
        try {
            List<Banque> banques = new ArrayList<Banque>();

            if (nom == null)
                banqueRepository.findAll().forEach(banques::add);
            else
                banqueRepository.findByNomContaining(nom).forEach(banques::add);

            if (banques.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(banques, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/banques/{id}")
    public ResponseEntity<Banque> getBanqueById(@PathVariable("id") String id) {
        Optional<Banque> banqueData = banqueRepository.findById(id);

        if (banqueData.isPresent()) {
            return new ResponseEntity<>(banqueData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/banques")
    public ResponseEntity<Banque> createBanque(@RequestBody Banque banque) {
        try {
            Banque _banque = banqueRepository.save(new Banque(banque.getNom(), banque.getMail(), banque.getAdresse(),banque.getTel()));

            return new ResponseEntity<>(_banque, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/banques/{id}")
    public ResponseEntity<Banque> updateBanque(@PathVariable("id") String id, @RequestBody Banque banque) {
        Optional<Banque> banqueData = banqueRepository.findById(id);

        if (banqueData.isPresent()) {
            Banque _banque = banqueData.get();
            _banque.setNom(banque.getNom());
            _banque.setMail(banque.getMail());
            _banque.setAdresse(banque.getAdresse());
            _banque.setTel(banque.getTel());
            return new ResponseEntity<>(banqueRepository.save(_banque), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/banques/{id}")
    public ResponseEntity<HttpStatus> deleteBanque(@PathVariable("id") String id) {
        try {
            banqueRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

   /* @GetMapping("/banques/mail")
    public ResponseEntity<List<Banque>> findByEmail() {

    }*/
}
