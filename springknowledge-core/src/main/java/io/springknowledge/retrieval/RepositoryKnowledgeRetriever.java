package io.springknowledge.retrieval;

import io.springknowledge.model.KnowledgeUnit;
import io.springknowledge.repository.KnowledgeRepository;

import java.util.List;

public class RepositoryKnowledgeRetriever implements KnowledgeRetriever {

    private final KnowledgeRepository repository;

    public RepositoryKnowledgeRetriever(KnowledgeRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<KnowledgeUnit> retrieve(String query, int limit) {
        return repository.search(query, limit);
    }
}