package com.example.navvistaskbackend.parser.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "parser_phone_numbers")
@Data
@EqualsAndHashCode(exclude = {"parser"},callSuper = false)
@ToString()
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class ParserPhoneNumbers implements Serializable {

    @ManyToOne
    @JoinColumn(name = "parser_id")
    @MapsId("parser")
    @JsonIgnore()
    private Parser parser;

    @EmbeddedId()
    private ParserPhoneNumbersPK parserPhoneNumbersPK;

}
