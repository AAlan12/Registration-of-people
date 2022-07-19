package com.aalan.RegistrationOfPeople.controllers;

import com.aalan.RegistrationOfPeople.entities.Person;
import com.aalan.RegistrationOfPeople.services.PersonService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonService personService;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Person save(@RequestBody Person person){
        return personService.save(person);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Person> listPerson(){
        return personService.listPerson();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Person searchById(@PathVariable("id") Long id){
        return personService.searchById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Pessoa não encontrada."));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removePerson(@PathVariable("id")Long id){
        personService.searchById(id)
                .map(person -> {
                    personService.removeById(person.getId());
                    return Void.TYPE;
                }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Pessoa não encontrada."));
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updatePerson(@PathVariable("id")Long id, @RequestBody Person person){
        personService.searchById(id)
                .map(personBase -> {
                    modelMapper.map(person,personBase);
                    personService.save(personBase);
                    return Void.TYPE;
                }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Pessoa não encontrada."));
    }
}
