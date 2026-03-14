package io.springknowledge.service;

import io.springknowledge.loader.DocumentLoader;
import io.springknowledge.model.KnowledgeDocument;

import java.util.List;

public class KnowledgeLoaderService {

    private final DocumentLoader loader;
    private final KnowledgeIngestionService ingestionService;

    public KnowledgeLoaderService(
            DocumentLoader loader,
            KnowledgeIngestionService ingestionService) {

        this.loader = loader;
        this.ingestionService = ingestionService;
    }

    public void load(String source) {

        List<KnowledgeDocument> documents = loader.load(source);

        for (KnowledgeDocument document : documents) {
            ingestionService.ingest(document);
        }
    }
}