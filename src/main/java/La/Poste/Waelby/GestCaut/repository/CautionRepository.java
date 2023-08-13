package La.Poste.Waelby.GestCaut.repository;

import La.Poste.Waelby.GestCaut.models.Caution;
import La.Poste.Waelby.GestCaut.models.Fournisseur;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface CautionRepository extends MongoRepository<Caution,String> {
    List<Caution> findByCode(int code);
    List<Caution> findByReference(String reference);

}
