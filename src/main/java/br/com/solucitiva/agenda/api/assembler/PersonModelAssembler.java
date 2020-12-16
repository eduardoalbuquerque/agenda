package br.com.solucitiva.agenda.api.assembler;

import br.com.solucitiva.agenda.api.model.PersonModel;
import br.com.solucitiva.agenda.domain.Person;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Component
public class PersonModelAssembler {

    private ModelMapper modelMapper;


    public PersonModel toModel(Person person) {
        return modelMapper.map(person, PersonModel.class);
    }

    public List<PersonModel> toCollectionModel(List<Person> people){
        return people.stream().map(person->toModel(person))
                .collect(Collectors.toList());
    }


}
