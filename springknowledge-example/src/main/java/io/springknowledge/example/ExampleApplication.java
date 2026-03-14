package io.springknowledge.example;

import io.springknowledge.context.ContextAssembler;
import io.springknowledge.service.KnowledgeLoaderService;
import io.springknowledge.service.KnowledgeService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ExampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(ExampleApplication.class, args);
    }

    @Bean
    CommandLineRunner demo(
            KnowledgeLoaderService loaderService,
            KnowledgeService knowledgeService, ContextAssembler contextAssembler) {

        return args -> {

            System.out.println("=== SpringKnowledge RAG Test Starting ===");

            // 1. Load and ingest README.md
            loaderService.load("README.md");
            System.out.println("README.md loaded and ingested.");

            // 2. Ask a question based on README content
            String question = "SpringKnowledge?";
            System.out.println("\nQuestion: " + question);

            String answer = knowledgeService.ask(question);

            System.out.println("\n=== AI Answer ===");
            System.out.println(answer);

            // 3. Another test question
            String question2 = "KnowledgeUnit";
            System.out.println("\nQuestion: " + question2);

            String answer2 = knowledgeService.ask(question2);

            System.out.println("\n=== AI Answer ===");
            System.out.println(answer2);

            System.out.println("\n=== SpringKnowledge RAG Test Finished ===");
        };
    }
}