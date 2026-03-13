package io.springknowledge.example;

import io.springknowledge.model.KnowledgeUnit;
import io.springknowledge.repository.InMemoryKnowledgeRepository;
import io.springknowledge.service.KnowledgeService;

public class ExampleApplication {

    public static void main(String[] args) {

        InMemoryKnowledgeRepository repo = new InMemoryKnowledgeRepository();

        KnowledgeService service = new KnowledgeService(repo);

        service.ingest(new KnowledgeUnit(
                "1",
                "Patience is praised in many traditions.",
                "ExampleText",
                "Section1"
        ));

        System.out.println(service.ask("patience"));
    }
}