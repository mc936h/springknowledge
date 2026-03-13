package io.springknowledge.example;

import io.springknowledge.model.KnowledgeUnit;
import io.springknowledge.service.KnowledgeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.SpringApplication;

@SpringBootApplication
public class ExampleApplication implements CommandLineRunner {

    @Autowired
    private KnowledgeService knowledgeService;

    public static void main(String[] args) {
        SpringApplication.run(ExampleApplication.class, args);
    }

    @Override
    public void run(String... args) {

        knowledgeService.ingest(
                new KnowledgeUnit(
                        "1",
                        "Patience is praised in many traditions.",
                        "ExampleText",
                        "Section1"
                )
        );

        System.out.println(
                knowledgeService.ask("patience")
        );
    }
}