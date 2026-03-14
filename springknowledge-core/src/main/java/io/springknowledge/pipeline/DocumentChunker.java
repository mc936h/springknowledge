package io.springknowledge.pipeline;

import io.springknowledge.model.KnowledgeDocument;
import io.springknowledge.model.KnowledgeUnit;

import java.util.List;

public interface DocumentChunker {

    List<KnowledgeUnit> chunk(KnowledgeDocument document);

}