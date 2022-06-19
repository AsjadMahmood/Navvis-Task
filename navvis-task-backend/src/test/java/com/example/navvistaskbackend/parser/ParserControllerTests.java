package com.example.navvistaskbackend.parser;

import com.example.navvistaskbackend.parser.controller.ParserController;
import com.example.navvistaskbackend.parser.model.Parser;
import com.example.navvistaskbackend.parser.model.ParserPhoneNumbers;
import com.example.navvistaskbackend.parser.service.ParserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@RunWith(SpringRunner.class)
@WebMvcTest(value = ParserController.class)
public class ParserControllerTests {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ParserService parserService;


    @Test
    public void createParserWithPhoneNumbers() throws Exception {
        UUID mockParserId = UUID.randomUUID();
        Set<ParserPhoneNumbers> phoneNumbersHashSet =  new HashSet<>();

        Parser mockParser = new Parser(mockParserId,phoneNumbersHashSet);


    }
}
