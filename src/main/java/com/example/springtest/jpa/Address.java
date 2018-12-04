package com.example.springtest.jpa;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(schema = "test")
public class Address {
    @SequenceGenerator(name = "test_id_gen", schema = "test", sequenceName = "test_entity_seq", allocationSize = 1)
    @GeneratedValue(generator = "test_id_gen", strategy = GenerationType.SEQUENCE)
    @Id
    private Long id;
    private String city;
}
