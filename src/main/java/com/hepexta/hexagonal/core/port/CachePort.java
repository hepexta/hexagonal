package com.hepexta.hexagonal.core.port;

import com.hepexta.hexagonal.core.entity.Person;

public interface CachePort {

    void add(Person person);

    Person get(String id);
}
