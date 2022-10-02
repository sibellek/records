package personal.records.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import personal.records.entity.Country;
import personal.records.entity.Person;
import personal.records.repository.CountryRepository;
import personal.records.repository.PersonRepository;

import java.util.NoSuchElementException;

@Controller
public class MainController {

    @Autowired
    private PersonRepository personRepository;
    @Autowired
    private CountryRepository countryRepository;

    @PostMapping(path = "/person/create")
    public @ResponseBody String addNewPerson (@RequestBody ObjectNode jsonNode)
    {
        Integer country_id = Integer.parseInt(jsonNode.get("country").asText());
        jsonNode.remove("country");
        ObjectMapper mapper = new ObjectMapper();
        Person p = mapper.convertValue(jsonNode, Person.class);
        Country c = countryRepository.findById(country_id)
                .orElseThrow(() -> new NoSuchElementException("Not found Country with id = " + country_id));
        p.setCountry(c);
        return "Saved";
    }
    @PostMapping(path = "/country/create")
    public @ResponseBody String addNewCountry ( @RequestBody Country countryRequest)
    {
        Country c = new Country(countryRequest);
        System.out.println(countryRepository.save(c).getId());
        return "Saved";
    }
    @GetMapping(path="/person/list")
    public @ResponseBody Iterable<Person> getAllPeople() {
        return personRepository.findAll();
    }
    @GetMapping(path="/country/list")
    public @ResponseBody Iterable<Country> getAllCountries() {
        return countryRepository.findAll();
    }
    
    public  Iterable<Country> getCountries() {
        return countryRepository.findAll();
    }
    @RequestMapping("/")
    public String home(){
        return "Hello World!";
    }
}
