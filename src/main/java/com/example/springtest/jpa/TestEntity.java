package com.example.springtest.jpa;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@Table(schema = "test")
public class TestEntity {
    @SequenceGenerator(name = "test_id_gen", schema = "test", sequenceName = "test_entity_seq", allocationSize = 1)
    @GeneratedValue(generator = "test_id_gen", strategy = GenerationType.SEQUENCE)
    @Id
    private Long id;
    private String name;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinTable(schema = "test",
            name = "test_address",
            joinColumns = @JoinColumn(name = "test_id"),
            inverseJoinColumns = @JoinColumn(name = "address_id"))
    private Set<Address> addresses;
}
