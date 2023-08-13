package La.Poste.Waelby.GestCaut.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import La.Poste.Waelby.GestCaut.models.Caution;
import La.Poste.Waelby.GestCaut.repository.CautionRepository;
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
import org.springframework.web.bind.annotation.RestController;



@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api")
public class CautionController {

    @Autowired
    CautionRepository cautionRepository;

    @GetMapping("/cautions")
    public ResponseEntity<List<Caution>> getAllCautions() {
        try {
            List<Caution> cautions = new ArrayList<>();
            cautionRepository.findAll().forEach(cautions::add);

            if (cautions.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(cautions, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/cautions/{id}")
    public ResponseEntity<Caution> getCautionById(@PathVariable("id") String id) {
        Optional<Caution> cautionData = cautionRepository.findById(id);

        if (cautionData.isPresent()) {
            return new ResponseEntity<>(cautionData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/cautions")
    public ResponseEntity<Caution> createCaution(@RequestBody Caution caution) {
        try {
            Caution _caution = cautionRepository.save(caution);
            return new ResponseEntity<>(_caution, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/cautions/{id}")
    public ResponseEntity<Caution> updateCaution(@PathVariable("id") String id, @RequestBody Caution caution) {
        Optional<Caution> cautionData = cautionRepository.findById(id);

        if (cautionData.isPresent()) {
            Caution _caution = cautionData.get();
            _caution.setCode(caution.getCode());
            _caution.setDatecaut(caution.getDatecaut());
            _caution.setReference(caution.getReference());
            _caution.setMontant(caution.getMontant());
            _caution.setDateleve(caution.getDateleve());
            _caution.setDaterest(caution.getDaterest());
            _caution.setRemarque(caution.getRemarque());
            _caution.setOrdonnateurs(caution.getOrdonnateurs());
            _caution.setBanques(caution.getBanques());
            _caution.setFournisseurs(caution.getFournisseurs());

            return new ResponseEntity<>(cautionRepository.save(_caution), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/cautions/{id}")
    public ResponseEntity<HttpStatus> deleteCaution(@PathVariable("id") String id) {
        try {
            cautionRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
