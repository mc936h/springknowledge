package io.springknowledge.autoconfigure;

import io.springknowledge.repository.InMemoryKnowledgeRepository;
import io.springknowledge.repository.KnowledgeRepository;
import io.springknowledge.service.KnowledgeService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KnowledgeAutoConfiguration {

    @Bean
    public KnowledgeRepository knowledgeRepository() {
        return new InMemoryKnowledgeRepository();
    }

    @Bean
    public KnowledgeService knowledgeService(KnowledgeRepository repository) {
        return new KnowledgeService(repository);
    }
}