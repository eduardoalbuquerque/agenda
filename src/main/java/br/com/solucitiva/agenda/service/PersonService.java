package br.com.solucitiva.agenda.service;

import br.com.solucitiva.agenda.api.model.input.PersonInput;
import br.com.solucitiva.agenda.domain.Person;
import br.com.solucitiva.agenda.repository.PersonRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class PersonService {

    private PersonRepository repository;

    public List<Person> listAll(){
        return repository.findAll();
    }

    public Person findById(Long personId){
        Optional<Person>  optionalPerson=  repository.findById(personId);
        if(optionalPerson.isPresent()){
            return optionalPerson.get();
        }

        return null;
    }

    public Person save(Person person){
        return repository.save(person);
    }

    public void delete(Long personId){
        Person personToDelete = this.findById(personId);
        if(personToDelete != null){
            repository.delete(personToDelete);
        }
    }

}
