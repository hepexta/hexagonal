package com.hepexta.hexagonal.core.port;

import com.hepexta.hexagonal.core.entity.Person;

public interface DatabasePort {

    Person get(String id);
}
