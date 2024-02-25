package spring.deep.dive.jpa.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.boot.context.properties.bind.DefaultValue;
import spring.deep.dive.jpa.entity.common.AdditionalInfo;

@Entity
@Table(name = "persons")
@Getter
@Setter
@ToString
public class Person extends AdditionalInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String nickName;

    @PrePersist
    public void prePersist() {
        if (nickName == null) {
            nickName = "john doe";
        }
        // You can set default values for other fields as needed
    }

    public Person(String name) {
        this.name = name;
    }

    public Person() {

    }
}