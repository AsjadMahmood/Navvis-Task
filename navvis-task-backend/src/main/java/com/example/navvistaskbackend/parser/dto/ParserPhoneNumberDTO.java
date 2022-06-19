package com.example.navvistaskbackend.parser.dto;

import lombok.*;

import java.util.List;

@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class ParserPhoneNumberDTO {
    List<String> parserPhoneNumbers;
}
