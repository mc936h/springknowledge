package io.springknowledge.service;

import io.springknowledge.model.KnowledgeUnit;
import io.springknowledge.repository.KnowledgeRepository;

import java.util.List;

public class KnowledgeService {

    private final KnowledgeRepository repository;

    public KnowledgeService(KnowledgeRepository repository) {
        this.repository = repository;
    }

    public void ingest(KnowledgeUnit unit) {
        repository.save(unit);
    }

    public List<KnowledgeUnit> ask(String question) {
        return repository.search(question, 5);
    }
}