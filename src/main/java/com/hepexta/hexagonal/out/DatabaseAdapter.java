package com.hepexta.hexagonal.out;

import com.hepexta.hexagonal.core.entity.Address;
import com.hepexta.hexagonal.core.entity.Person;
import com.hepexta.hexagonal.core.port.DatabasePort;
import com.hepexta.hexagonal.core.valueobject.Contact;
import org.springframework.stereotype.Component;

@Component
public class DatabaseAdapter implements DatabasePort {
    @Override
    public Person get(String id) {
        return new Person(
                id,
                "Dummy",
                new Address("100", "dummy", "10"),
                new Contact("email")
        );
    }
}
