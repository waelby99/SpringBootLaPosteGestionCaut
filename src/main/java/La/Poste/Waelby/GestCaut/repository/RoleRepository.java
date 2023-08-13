package La.Poste.Waelby.GestCaut.repository;

import java.util.Optional;

import La.Poste.Waelby.GestCaut.models.ERole;
import La.Poste.Waelby.GestCaut.models.Role;
import org.springframework.data.mongodb.repository.MongoRepository;



public interface RoleRepository extends MongoRepository<Role, String> {
    Optional<Role> findByName(ERole name);
}