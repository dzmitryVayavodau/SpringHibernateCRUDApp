package org.voevodov.springcourse.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.voevodov.springcourse.models.Person;

import java.util.List;

@Repository
public interface PeopleRepository extends JpaRepository<Person, Integer> {

    List<Person> findByName(String name);
    List<Person> findByNameOrderByAge(String name);
    List<Person> findByEmail(String email);

    List<Person> findByNameStartingWith(String startCharacter);

    List<Person> findByNameOrEmail(String name, String email);
}
