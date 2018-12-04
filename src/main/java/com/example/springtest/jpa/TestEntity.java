package com.example.springtest.jpa;

import lombok.Data;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;

@Data
@Entity
@Table(schema = "test")
public class TestEntity {
    @SequenceGenerator(name = "test_id_gen", schema = "test", sequenceName = "test_entity_seq", allocationSize = 1)
    @GeneratedValue(generator = "test_id_gen", strategy = GenerationType.SEQUENCE)
    @Id
    private Long id;
    @NaturalId
    private String name;
}
