package com.hepexta.hexagonal.in;

import com.hepexta.hexagonal.core.entity.Person;
import com.hepexta.hexagonal.core.service.PersonService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/person")
public class PersonController {

    private PersonService service;

    public PersonController(PersonService service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    public PersonDTO get(@PathVariable String id) {
        Person person = service.get(id);

        if (person == null) {
            return null;
        }

        PersonDTO personDTO = new PersonDTO();
        personDTO.setId(person.id());
        personDTO.setName(person.name());
        personDTO.setStreet(person.address().street());
        personDTO.setEmail(person.contact().email());
        return personDTO;
    }
}
