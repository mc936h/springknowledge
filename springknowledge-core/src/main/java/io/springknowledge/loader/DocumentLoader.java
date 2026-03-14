package io.springknowledge.loader;

import io.springknowledge.model.KnowledgeDocument;

import java.util.List;

public interface DocumentLoader {

    List<KnowledgeDocument> load(String source);

}