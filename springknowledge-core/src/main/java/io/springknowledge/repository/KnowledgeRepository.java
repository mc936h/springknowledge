package io.springknowledge.repository;

import java.util.List;

public interface KnowledgeRepository {

    void save(io.springknowledge.model.KnowledgeUnit unit);

    List<io.springknowledge.model.KnowledgeUnit> search(String query, int limit);
}
