package strange.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import strange.models.Person;

import java.util.List;

public interface PersonRepository extends MongoRepository<Person, String> {
    public List<Person> findAllByAgeLessThan(Integer age);
    public List<Person> findAllByGender(Character gender);
    public List<Person> findAllByNationalityEquals(String nationality);

}
