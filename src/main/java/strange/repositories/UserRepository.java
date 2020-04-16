package strange.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import strange.models.User;

public interface UserRepository extends MongoRepository<User, String> {
    public User findByUsername(String username);

}
