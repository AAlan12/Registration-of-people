package com.aalan.RegistrationOfPeople.services;

import com.aalan.RegistrationOfPeople.entities.Person;
import com.aalan.RegistrationOfPeople.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    public Person save(Person person){
        return personRepository.save(person);
    }
    public List<Person> listPerson(){
        return personRepository.findAll();
    }
    public Optional<Person> searchById(Long id){
        return personRepository.findById(id);
    }
    public void removeById(Long id){
        personRepository.deleteById(id);
    }

}
