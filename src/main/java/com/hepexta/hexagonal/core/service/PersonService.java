package com.hepexta.hexagonal.core.service;

import com.hepexta.hexagonal.core.entity.Person;
import com.hepexta.hexagonal.core.port.CachePort;
import com.hepexta.hexagonal.core.port.DatabasePort;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    private CachePort cache;
    private DatabasePort database;

    public PersonService(CachePort cache, DatabasePort database) {
        this.cache = cache;
        this.database = database;
    }

    public Person get(String id) {
        Person cachedPerson = cache.get(id);
        if (cachedPerson != null) {
            return cachedPerson;
        }

        Person dabasePerson = database.get(id);
        cache.add(dabasePerson);

        return dabasePerson;
    }

    public void add(Person person) {
        cache.add(person);
    }
}
