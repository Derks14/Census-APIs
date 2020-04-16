package strange.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import strange.models.User;
import strange.repositories.UserRepository;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/system")
public class UserController {
    @Autowired
    private UserRepository repository;

    @Autowired
    private PasswordEncoder encoder;

    @GetMapping("users")
    public List<User> getUsers(){
        return repository.findAll();
    }

//    @GetMapping("/user/{id}")
//    public User getUserById(@PathVariable String id){
//        if (repository.findById(id).isPresent()) return repository.findById(id).get();
//        return null;
//    }

    @GetMapping("/user/{username}")
    public User getUserByUsername(@PathVariable String username){
        return repository.findByUsername(username);
    }

    @PostMapping("/user")
    public ResponseEntity<Void> addUser(@RequestBody User user) {
        User fresh = new User(user.getUsername(),user.getEmail(),user.getTelephone(),
                encoder.encode(user.getPassword()),"USER","");
        repository.save(fresh);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("/user/{username}")
    public ResponseEntity<Void> deleteUser(@PathVariable String username){
        User guy =repository.findByUsername(username);
        repository.delete(guy);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
