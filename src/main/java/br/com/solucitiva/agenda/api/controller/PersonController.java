package br.com.solucitiva.agenda.api.controller;

import br.com.solucitiva.agenda.domain.Person;
import br.com.solucitiva.agenda.service.PersonService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/people")
public class PersonController {

    private PersonService service;

    @PostMapping
    public Person save(@RequestBody Person person){
        return service.save(person);
    }

}
