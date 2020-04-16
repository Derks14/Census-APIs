package strange.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import strange.models.Person;
import strange.models.User;

import java.util.Arrays;
import java.util.List;

@Service
public class DbInit implements CommandLineRunner {
    private UserRepository userRepository;
    private PersonRepository personRepository;
    private PasswordEncoder passwordEncoder;


    @Autowired
    public DbInit(UserRepository userRepository, PersonRepository personRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.personRepository = personRepository;
        this.passwordEncoder = passwordEncoder;

    }

    @Override
    public void run(String... args) throws Exception {
        this.userRepository.deleteAll();
//        this.personRepository.deleteAll();

//        add new
//        User dan = new User("dan","dan@gmail.com","0234123434","dan123","USER","");
//        User admin = new User("admin","admin@gmai.com","02334324234","admin123","ADMIN","ACCESS_TEST1,ACCESS_TEST2");
//        User manager = new User("manager","manager@gmail.com","2342423423443","manager123","MANAGER","ACCESS_TEST1");
//
        User dan = new User("dan","dan@gmail.com","0234123434",passwordEncoder.encode("dan123"),"USER","");
        User admin = new User("admin","admin@gmai.com","02334324234",passwordEncoder.encode("admin123"),"ADMIN","ACCESS_TEST1,ACCESS_TEST2");
        User manager = new User("manager","manager@gmail.com","2342423423443",passwordEncoder.encode("manager123"),"MANAGER","ACCESS_TEST1");

        Person one = new Person();
        Person two = new Person();
        Person three = new Person();

        List<User> users = Arrays.asList(dan,admin,manager);
        List<Person> persons = Arrays.asList(one,two,three);

        // save to database
        this.userRepository.saveAll(users);
        this.personRepository.saveAll(persons);
    }
}
