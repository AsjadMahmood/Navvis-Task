package com.example.navvistaskbackend.parser.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;
import java.util.UUID;

@Entity
@Data
@EqualsAndHashCode(callSuper = false)
@ToString()
@Builder(toBuilder = true)
@Table(name = "parser")
@NoArgsConstructor
@AllArgsConstructor
public class Parser implements Serializable {

    @Id
    @Column(name = "parser_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID parserId;

    @OneToMany(
            mappedBy = "parser",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private Set<ParserPhoneNumbers> phoneNumbers;

}
