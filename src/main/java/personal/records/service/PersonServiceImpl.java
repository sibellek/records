package personal.records.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import personal.records.entity.Person;
import personal.records.repository.PersonRepository;

import javax.transaction.Transactional;

@Service("personService")
@Transactional
public class PersonServiceImpl implements PersonService{

    @Autowired
    private PersonRepository personRepository;

    @Override
    public Iterable<Person> findAll() {
        return personRepository.findAll();
    }
    public int createPerson(Person p) {
        return personRepository.save(p).getId();
    }
}
