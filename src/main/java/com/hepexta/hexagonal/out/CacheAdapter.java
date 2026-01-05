package com.hepexta.hexagonal.out;


import com.hepexta.hexagonal.core.entity.Person;
import com.hepexta.hexagonal.core.port.CachePort;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class CacheAdapter implements CachePort {
    public static final Map<String, Person> IN_MEMORY_STORE = new ConcurrentHashMap<>(10);

    @Override
    public void add(Person person) {
        IN_MEMORY_STORE.put(person.id(), person);
    }

    @Override
    public Person get(String id) {
        return IN_MEMORY_STORE.get(id);
    }
}
