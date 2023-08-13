package La.Poste.Waelby.GestCaut.repository;

import La.Poste.Waelby.GestCaut.models.Fournisseur;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface FournisseurRepository extends MongoRepository<Fournisseur,String> {
    List<Fournisseur> findByNomContaining(String nom);
    List<Fournisseur> findByMail(String mail);
}
