package br.com.solucitiva.agenda.service;

import br.com.solucitiva.agenda.domain.Person;
import br.com.solucitiva.agenda.repository.PersonRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class PersonService {

    private PersonRepository repository;

    public Person save(Person person){
        System.out.println(person.toString());
        return repository.save(person);
    }


}
