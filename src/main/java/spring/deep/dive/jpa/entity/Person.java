package spring.deep.dive.jpa.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import spring.deep.dive.jpa.entity.common.AdditionalInfo;

@Entity
@Table(name = "persons")
@Getter
@Setter
public class Person extends AdditionalInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    public Person(String name) {
        this.name = name;
    }

    public Person() {

    }
}