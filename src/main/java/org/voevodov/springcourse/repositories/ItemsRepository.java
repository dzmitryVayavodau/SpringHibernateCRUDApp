package org.voevodov.springcourse.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.voevodov.springcourse.models.Item;
import org.voevodov.springcourse.models.Person;

import java.util.List;

@Repository
public interface ItemsRepository extends JpaRepository<Item, Integer> {
     List<Item> findByOwner(Person owner);

     List<Item> findByItemName(String name);
}
