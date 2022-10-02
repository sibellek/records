package personal.records.service;

import personal.records.entity.Person;

public interface PersonService {

    public Iterable<Person> findAll();
    public int createPerson(Person p);
}
