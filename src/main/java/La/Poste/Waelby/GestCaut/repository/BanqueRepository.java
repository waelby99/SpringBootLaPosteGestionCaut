package La.Poste.Waelby.GestCaut.repository;
import java.util.List;

import La.Poste.Waelby.GestCaut.models.Banque;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BanqueRepository extends MongoRepository<Banque,String>{
    List<Banque> findByNomContaining(String nom);
    List<Banque> findByMail(String mail);
}

