package services;

import model.Person;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

@Service
public class PersonServices {
    private final AtomicLong counter = new AtomicLong();

    private Logger logger = Logger.getLogger(PersonServices.class.getName());

    public List<Person> findAll(){

        logger.info("Finding all person!");
        List<Person> persons = new ArrayList<>();
        for (int i = 0; i < 8; i++){
            Person person = mockPerson(i);
            persons.add(person);
        }
        return persons;
    }
    public Person findById(String id){

        logger.info("Finding one person"); //locar a informação de que está buscando uma pessoa
        //moc é uma estrutura de codigo temporaria até que o codigo esteja pronto

        Person person = new Person();
        person.setId(counter.incrementAndGet());
        person.setFirstName("LEandro");
        person.setLastName("Costa");
        person.setAddress("Sao luis");
        person.setGender("Male");
        return person;
    }
    public Person create(Person person){
        logger.info("Creating one person!");

        return person;
    }
    public Person update(Person person){
        logger.info("Creating one person!");

        return person;
    }

    private Person mockPerson(int i){
        Person person = new Person();
        person.setId(counter.incrementAndGet());
        person.setFirstName("Person name" + i);
        person.setLastName("Last name" + i);
        person.setAddress("Some address in Brasil " + i);
        person.setGender("Male");
        return person;
    }

}
