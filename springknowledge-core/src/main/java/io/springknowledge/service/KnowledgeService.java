package io.springknowledge.service;

import io.springknowledge.repository.KnowledgeRepository;

import java.util.List;

public class KnowledgeService {

    private final KnowledgeRepository repository;

    public KnowledgeService(KnowledgeRepository repository) {
        this.repository = repository;
    }

    public List<io.springknowledge.model.KnowledgeUnit> search(String question) {
        return repository.search(question, 5);
    }
}