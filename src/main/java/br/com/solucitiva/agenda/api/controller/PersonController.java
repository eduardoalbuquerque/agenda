package br.com.solucitiva.agenda.api.controller;

import br.com.solucitiva.agenda.api.assembler.PersonModelAssembler;
import br.com.solucitiva.agenda.api.disassembler.PersonInputDisassembler;
import br.com.solucitiva.agenda.api.model.PersonModel;
import br.com.solucitiva.agenda.api.model.input.PersonInput;
import br.com.solucitiva.agenda.domain.Person;
import br.com.solucitiva.agenda.service.PersonService;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import javax.persistence.GeneratedValue;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@RestController
@RequestMapping("/people")
public class PersonController {

    private PersonService service;

    private PersonModelAssembler personModelAssembler;

    private PersonInputDisassembler personInputDisassembler;

    @GetMapping
    public List<PersonModel> listAll(){

        return personModelAssembler.toCollectionModel(service.listAll());
    }

    @GetMapping("/{personId}")
    public PersonModel findById(@PathVariable Long personId){

        Person person = service.findById(personId);
        return personModelAssembler.toModel(person);
    }

    @PostMapping
    public PersonModel save(@RequestBody PersonInput personInput){
        Person person = personInputDisassembler.toDomainObject(personInput);
        return personModelAssembler.toModel(service.save(person));
    }

    @DeleteMapping("/{personId}")
    public void delete(@PathVariable Long personId){
        service.delete(personId);
    }


}
