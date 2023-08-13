package La.Poste.Waelby.GestCaut.repository;

import java.util.Optional;

import La.Poste.Waelby.GestCaut.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;



public interface UserRepository extends MongoRepository<User, String> {
    Optional<User> findByUsername(String username);

    Boolean existsByUsername(String username);

    Boolean existsByEmail(String email);
}
