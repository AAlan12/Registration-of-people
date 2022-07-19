package com.aalan.RegistrationOfPeople.repositories;

import com.aalan.RegistrationOfPeople.entities.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
}
