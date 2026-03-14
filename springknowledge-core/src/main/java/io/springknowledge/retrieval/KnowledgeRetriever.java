package io.springknowledge.retrieval;

import io.springknowledge.model.KnowledgeUnit;

import java.util.List;

public interface KnowledgeRetriever {

    List<KnowledgeUnit> retrieve(String query, int limit);

}