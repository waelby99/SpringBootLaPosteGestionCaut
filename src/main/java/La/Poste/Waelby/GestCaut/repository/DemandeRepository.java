package La.Poste.Waelby.GestCaut.repository;
import java.util.List;


import La.Poste.Waelby.GestCaut.models.Demande;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DemandeRepository  extends MongoRepository<Demande,String> {
}
