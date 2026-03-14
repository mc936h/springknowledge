package io.springknowledge.springai.config;

import io.springknowledge.repository.KnowledgeRepository;
import io.springknowledge.springai.repository.VectorKnowledgeRepository;

import org.springframework.ai.embedding.EmbeddingModel;
import org.springframework.ai.vectorstore.VectorStore;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;

@Configuration
public class VectorKnowledgeAutoConfiguration {

    @Bean
    @ConditionalOnMissingBean
    public KnowledgeRepository vectorKnowledgeRepository(
            VectorStore vectorStore,
            EmbeddingModel embeddingModel) {

        return new VectorKnowledgeRepository(vectorStore, embeddingModel);
    }
}