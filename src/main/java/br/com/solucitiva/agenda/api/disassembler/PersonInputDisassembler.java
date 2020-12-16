package br.com.solucitiva.agenda.api.disassembler;

import br.com.solucitiva.agenda.api.model.input.PersonInput;
import br.com.solucitiva.agenda.domain.Person;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class PersonInputDisassembler {

    private ModelMapper modelMapper;

    public Person toDomainObject(PersonInput personInput){

        return modelMapper.map(personInput, Person.class);

    }

}
