package org.voevodov.springcourse.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.voevodov.springcourse.models.Person;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Component
public class PersonDAO {

    private final EntityManager entityManager;

    public PersonDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }




    @Transactional(readOnly = true)
    public void testNPlus1(){

        Session session = entityManager.unwrap(Session.class);

//        //1
//        List<Person> people = session.createQuery("from Person", Person.class).getResultList();
//
//        //N
//        for (Person p : people) {
//            System.out.println("Person " + p.getName() + " has: " + p.getItems());
//        }

        //HQL solution
        Set<Person> people = new HashSet<Person>( session.createQuery(
                "select p from Person p left join fetch p.items ")
                .getResultList());

        for (Person p : people) {
             System.out.println("Person " + p.getName() + " has: " + p.getItems());
        }


    }

}

