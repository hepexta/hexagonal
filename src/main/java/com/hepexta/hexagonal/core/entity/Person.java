package com.hepexta.hexagonal.core.entity;

import com.hepexta.hexagonal.core.valueobject.Contact;

public record Person(String id, String name, Address address, Contact contact) {
}
