package com.example.navvistaskbackend.parser.repository;
import com.example.navvistaskbackend.parser.model.ParserPhoneNumbers;
import com.example.navvistaskbackend.parser.model.ParserPhoneNumbersPK;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface ParserPhoneNumbersRepository extends JpaRepository<ParserPhoneNumbers, ParserPhoneNumbersPK> {
    List<ParserPhoneNumbers> findAllByParserPhoneNumbersPK_ParserId(UUID parseId);

    void deleteAllByParserPhoneNumbersPK_ParserId(UUID parseId);
}
