package personal.records.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import personal.records.entity.Country;
import personal.records.repository.CountryRepository;

import javax.transaction.Transactional;

@Service("countryService")
@Transactional
public class CountryServiceImpl implements CountryService{

    @Autowired
    private CountryRepository countryRepository;

    @Override
    public Iterable<Country> findAll() {
        return countryRepository.findAll();
    }
}
