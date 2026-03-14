package io.springknowledge.autoconfigure;

import io.springknowledge.answer.KnowledgeAnswerer;
import io.springknowledge.context.ContextAssembler;
import io.springknowledge.context.SimpleContextAssembler;
import io.springknowledge.loader.DocumentLoader;
import io.springknowledge.loader.MarkdownDocumentLoader;
import io.springknowledge.pipeline.DocumentChunker;
import io.springknowledge.pipeline.SimpleDocumentChunker;
import io.springknowledge.repository.InMemoryKnowledgeRepository;
import io.springknowledge.repository.KnowledgeRepository;
import io.springknowledge.retrieval.KnowledgeRetriever;
import io.springknowledge.retrieval.RepositoryKnowledgeRetriever;
import io.springknowledge.service.KnowledgeIngestionService;
import io.springknowledge.service.KnowledgeLoaderService;
import io.springknowledge.service.KnowledgeService;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;

@AutoConfiguration
@ConditionalOnClass(KnowledgeAnswerer.class)
public class KnowledgeAutoConfiguration {

    @Bean
    @ConditionalOnMissingBean
    public KnowledgeRepository knowledgeRepository() {
        return new InMemoryKnowledgeRepository();
    }

    @Bean
    @ConditionalOnMissingBean
    public KnowledgeRetriever knowledgeRetriever(
            KnowledgeRepository repository) {

        return new RepositoryKnowledgeRetriever(repository);
    }

    @Bean
    @ConditionalOnMissingBean
    public KnowledgeService knowledgeService(
            KnowledgeRepository repository,
            KnowledgeRetriever retriever,
            ContextAssembler contextAssembler,
            KnowledgeAnswerer answerer) {

        return new KnowledgeService(
                repository,
                retriever,
                contextAssembler,
                answerer
        );
    }

    @Bean
    @ConditionalOnMissingBean
    public DocumentChunker documentChunker() {
        return new SimpleDocumentChunker();
    }

    @Bean
    @ConditionalOnMissingBean
    public DocumentLoader documentLoader() {
        return new MarkdownDocumentLoader();
    }

    @Bean
    @ConditionalOnMissingBean
    public KnowledgeIngestionService knowledgeIngestionService(
            DocumentChunker chunker,
            KnowledgeRepository repository) {

        return new KnowledgeIngestionService(chunker, repository);
    }

    @Bean
    @ConditionalOnMissingBean
    public KnowledgeLoaderService knowledgeLoaderService(
            DocumentLoader loader,
            KnowledgeIngestionService ingestionService) {

        return new KnowledgeLoaderService(loader, ingestionService);
    }

    @Bean
    @ConditionalOnMissingBean
    public ContextAssembler contextAssembler() {
        return new SimpleContextAssembler();
    }

    @Bean
    public KnowledgeAnswerer knowledgeAnswerer(ChatClient chatClient) {
        return new io.springknowledge.springai.service.SpringAiKnowledgeAnswerer(chatClient);
    }
}