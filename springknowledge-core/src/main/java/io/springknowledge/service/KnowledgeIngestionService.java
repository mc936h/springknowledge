package io.springknowledge.service;

import io.springknowledge.model.KnowledgeDocument;
import io.springknowledge.model.KnowledgeUnit;
import io.springknowledge.pipeline.DocumentChunker;
import io.springknowledge.repository.KnowledgeRepository;

import java.util.List;

public class KnowledgeIngestionService {

    private final DocumentChunker chunker;
    private final KnowledgeRepository repository;

    public KnowledgeIngestionService(
            DocumentChunker chunker,
            KnowledgeRepository repository) {

        this.chunker = chunker;
        this.repository = repository;
    }

    public void ingest(KnowledgeDocument document) {

        List<KnowledgeUnit> units = chunker.chunk(document);

        System.out.println("Ingested " + units.size() + " chunks from " + document.getSource());

        for (KnowledgeUnit unit : units) {
            repository.save(unit);
        }
    }
}