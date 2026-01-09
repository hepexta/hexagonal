package com.hepexta.hexagonal.core.service

import spock.lang.Specification
import com.hepexta.hexagonal.core.entity.Person
import com.hepexta.hexagonal.core.port.CachePort
import com.hepexta.hexagonal.core.port.DatabasePort

class PersonServiceSpec extends Specification {

    CachePort cache = Mock()
    DatabasePort database = Mock()
    PersonService service = new PersonService(cache, database)

    def "returns cached person when present and does not call database"() {
        given:
        def id = "person-1"
        def cached = new Person(id, "Alice", null, null)

        and:
        cache.get(id) >> cached

        when:
        def result = service.get(id)

        then:
        result == cached
        0 * database.get(_)
    }

    def "fetches from database when cache misses and stores in cache"() {
        given:
        def id = "person-2"
        def dbPerson = new Person(id, "Bob", null, null)

        and:
        cache.get(id) >> null

        when:
        def result = service.get(id)

        then:
        1 * database.get(id) >> dbPerson
        1 * cache.add(dbPerson)
        result == dbPerson
    }

    def "add delegates to cache.add"() {
        given:
        def p = new Person("p-1", "Coco", null, null)

        when:
        service.add(p)

        then:
        1 * cache.add(p)
        0 * database._
    }
}