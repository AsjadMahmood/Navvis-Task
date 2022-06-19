package com.example.navvistaskbackend.parser.service;

import com.example.navvistaskbackend.parser.dto.ParserDTO;
import com.example.navvistaskbackend.parser.dto.ParserPhoneNumberDTO;
import com.example.navvistaskbackend.parser.model.Parser;
import com.example.navvistaskbackend.parser.model.ParserPhoneNumbers;
import com.example.navvistaskbackend.parser.model.ParserPhoneNumbersPK;
import com.example.navvistaskbackend.parser.repository.ParserPhoneNumbersRepository;
import com.example.navvistaskbackend.parser.repository.ParserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.*;

@Component
@Slf4j
@RequiredArgsConstructor
public class ParserService {
    private final ParserPhoneNumbersRepository parserPhoneNumbersRepository;
    private final ParserRepository parserRepository;

    @Transactional
    public void deleteParserAndRelatedPhoneNumbersByParseId(UUID parserId){
        log.info("deleting phone numbers related to parser");
        parserPhoneNumbersRepository.deleteAllByParserPhoneNumbersPK_ParserId(parserId);
        log.info("deleting parser");
        parserRepository.deleteById(parserId);
    }

    public ParserDTO getAllParsers(){
        List<String> parserIds = new ArrayList<>();
        List<Parser> parsers =  parserRepository.findAll();
        for (Parser parser:parsers){
            parserIds.add(parser.getParserId().toString());
        }
        ParserDTO parserDTO = ParserDTO.builder()
                .parserIds(parserIds)
                .build();
        return parserDTO;
    }

    public List<String> getPhoneNumbersByParseId(UUID parserId){
        List<String> phoneNumbers = new ArrayList<>();
        List<ParserPhoneNumbers> parserPhoneNumbers = parserPhoneNumbersRepository.findAllByParserPhoneNumbersPK_ParserId((parserId));

        for (ParserPhoneNumbers parserPhoneNumber:parserPhoneNumbers ){
            phoneNumbers.add(parserPhoneNumber.getParserPhoneNumbersPK().getPhoneNumbers());
        }
//        ParserPhoneNumberDTO parserPhoneNumberDTO = ParserPhoneNumberDTO.builder()
//                .parserPhoneNumbers(phoneNumbers)
//                .build();
        return phoneNumbers;
    }

    public UUID parseAndSaveFile(MultipartFile file) throws IOException {
        Set<ParserPhoneNumbers> phoneNumbersHashSet =  new HashSet<>();
        Scanner myReader = new Scanner(file.getInputStream());
        String germanPhoneCode1 = "+49";
        String germanPhoneCode2 = "0049";
        int validPhoneNumberLength = 11;
        Parser parser = new Parser();
        parser = parserRepository.save(parser);
        log.info("reading file for processing");
        while (myReader.hasNextLine()) {
            String data = myReader.nextLine();
            if(!data.isEmpty()){
                data = data.trim().replaceAll("\\s+", "");
                if(data.startsWith(germanPhoneCode1) || data.startsWith(germanPhoneCode2)){
                    if(data.startsWith(germanPhoneCode1))
                        data = data.replaceFirst("\\"+germanPhoneCode1,"");
                    else
                        data = data.replaceFirst(germanPhoneCode2,"");

                    if(data.length() == validPhoneNumberLength){
                        ParserPhoneNumbersPK parserPhoneNumbersPK =  ParserPhoneNumbersPK.builder()
                                .phoneNumbers(data).parserId(parser.getParserId())
                                .build();

                        ParserPhoneNumbers parserPhoneNumbers = new ParserPhoneNumbers();
                        parserPhoneNumbers.setParserPhoneNumbersPK(parserPhoneNumbersPK);
                        phoneNumbersHashSet.add(parserPhoneNumbers);
                    }
                }
            }
        }

        parser.setPhoneNumbers(phoneNumbersHashSet);
        log.info("saving parsed phone numbers");
        parser = parserRepository.save(parser);
        return parser.getParserId();
    }

}