package spring.deep.dive.jpa.entity;


import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import spring.deep.dive.jpa.entity.common.AdditionalInfo;

import java.util.Date;

@Entity
@Table(name = "books")
@Getter
@Setter
@ToString
public class Book extends AdditionalInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

//    private String author;
    public Book(String title) {
        this.title = title;
    }

    public Book() {

    }
}