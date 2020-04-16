package strange.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import strange.models.Person;
import strange.models.Total;
import strange.models.User;
import strange.repositories.PersonRepository;

import java.util.List;

@RestController
@RequestMapping("/data")
public class PersonController {

    @Autowired
    private PersonRepository repository;

    @GetMapping("/persons")
    public List<Person> getPersons(){
        return repository.findAll();
    }

    @GetMapping("/total")
    public Total getTotal(){
        String total = String.valueOf(repository.findAll().size());
        String male = String.valueOf(repository.findAllByGender('M').size());
        String female = String.valueOf(repository.findAllByGender('F').size());
        return new Total(total,male,female);
    }
// 466C6t5

    @GetMapping("/person/{id}")
    public Person getPerson(@PathVariable String id){
        if (repository.findById(id).isPresent()) return repository.findById(id).get();
        return null;
    }

    @PostMapping("/person")
    public ResponseEntity<Void> addPerson(@RequestBody Person person) {
        repository.save(person);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("/person/{id}")
    public ResponseEntity<Void> deletePerson(@PathVariable String id) {
        repository.delete(this.getPerson(id));
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
