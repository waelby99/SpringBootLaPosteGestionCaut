package La.Poste.Waelby.GestCaut.repository;

import La.Poste.Waelby.GestCaut.models.Ordonnateur;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface OrdonnateurRepository extends MongoRepository<Ordonnateur,String> {
    List<Ordonnateur> findByNomContaining(String adresse);
    List<Ordonnateur> findByTel(int tel);
}
