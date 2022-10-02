package personal.records.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import personal.records.entity.Person;

@Repository("personRepository")
public interface PersonRepository extends CrudRepository<Person, Integer> {
}
