package com.example.navvistaskbackend.parser.controller;

import com.example.navvistaskbackend.exception.EntityNotExistsException;
import com.example.navvistaskbackend.parser.dto.ParserDTO;
import com.example.navvistaskbackend.parser.dto.ParserIdDTO;
import com.example.navvistaskbackend.parser.dto.ParserPhoneNumberDTO;
import com.example.navvistaskbackend.parser.service.ParserService;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping
@Slf4j
@RequiredArgsConstructor
@Api(value = "ParserController", description = "REST APIs related parser and phone numbers")
public class ParserController {

    private final ParserService parserService;

    @CrossOrigin
    @PostMapping( value = "/api/parser/process-file",consumes = "multipart/form-data")
    public ResponseEntity<ParserIdDTO> processFile( @RequestParam("file") MultipartFile file) throws IOException {
        String savedParserId = parserService.parseAndSaveFile(file).toString();
        ParserIdDTO parserIdDTO = ParserIdDTO.builder().parserId(savedParserId).build();
        return ResponseEntity.ok().body(parserIdDTO);
    }

    @CrossOrigin
    @GetMapping("/api/parser")
    ResponseEntity<ParserDTO> getAllParsers()throws EntityNotExistsException{
       return ResponseEntity.ok(parserService.getAllParsers());
    }

    @CrossOrigin
    @GetMapping("/api/parser/phone-numbers/{parserId}")
    ResponseEntity<List<String>> getPhoneNumbersByParseId(@PathVariable String parserId) throws EntityNotExistsException{
        return ResponseEntity.ok(parserService.getPhoneNumbersByParseId(UUID.fromString(parserId)));
    }

    @CrossOrigin
    @DeleteMapping("/api/parser/{parserId}")
    public ResponseEntity<Void> deleteParserAndRelatedPhoneNumbersByParseId(@PathVariable String parserId)throws EntityNotExistsException{
        parserService.deleteParserAndRelatedPhoneNumbersByParseId(UUID.fromString(parserId));
        return ResponseEntity.ok().build();
    }

}