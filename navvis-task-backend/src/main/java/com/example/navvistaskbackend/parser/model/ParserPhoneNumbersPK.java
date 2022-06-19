package com.example.navvistaskbackend.parser.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.UUID;

@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class ParserPhoneNumbersPK implements Serializable {
    @Column(name = "parser_id")
    private UUID parserId;

    @Column(name = "phone_numbers")
    private String phoneNumbers;
}
