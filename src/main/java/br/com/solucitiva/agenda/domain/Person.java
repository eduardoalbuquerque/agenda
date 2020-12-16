package br.com.solucitiva.agenda.domain;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Person {

    @Id
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "person_sequence")
//    @SequenceGenerator(name = "person_sequence", sequenceName = "person_sequence")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String firstName;

    @Column(nullable = false,length = 100)
    private String lastName;

}
