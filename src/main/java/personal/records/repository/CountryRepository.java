package personal.records.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import personal.records.entity.Country;

@Repository("countryRepository")
public interface CountryRepository extends CrudRepository<Country, Integer> {
}
