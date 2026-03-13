package io.springknowledge.repository;

import io.springknowledge.model.KnowledgeUnit;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class InMemoryKnowledgeRepository implements KnowledgeRepository {

    private final List<KnowledgeUnit> store = new ArrayList<>();

    @Override
    public void save(KnowledgeUnit unit) {
        store.add(unit);
    }

    @Override
    public List<KnowledgeUnit> search(String query, int limit) {

        return store.stream()
                .filter(u -> u.getContent().toLowerCase().contains(query.toLowerCase()))
                .limit(limit)
                .collect(Collectors.toList());
    }
}