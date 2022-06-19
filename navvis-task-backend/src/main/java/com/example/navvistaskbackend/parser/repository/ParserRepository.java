package com.example.navvistaskbackend.parser.repository;

import com.example.navvistaskbackend.parser.model.Parser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ParserRepository extends JpaRepository<Parser, UUID> {
}
