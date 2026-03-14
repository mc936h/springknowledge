package io.springknowledge.springai.repository;

import io.springknowledge.model.KnowledgeUnit;
import io.springknowledge.repository.KnowledgeRepository;
import org.springframework.ai.document.Document;
import org.springframework.ai.embedding.EmbeddingModel;
import org.springframework.ai.vectorstore.VectorStore;
import org.springframework.ai.vectorstore.SearchRequest;

import java.util.List;
import java.util.Map;

public class VectorKnowledgeRepository implements KnowledgeRepository {

    private final VectorStore vectorStore;

    public VectorKnowledgeRepository(VectorStore vectorStore, EmbeddingModel embeddingModel) {
        this.vectorStore = vectorStore;
    }

    @Override
    public void save(KnowledgeUnit unit) {

        Document doc = new Document(
                unit.getContent(),
                Map.of(
                        "id", unit.getId(),
                        "source", unit.getSource(),
                        "section", unit.getSection()
                )
        );

        vectorStore.add(List.of(doc));
    }

    @Override
    public List<KnowledgeUnit> search(String query, int limit) {

        SearchRequest request = SearchRequest.query(query)
                .withTopK(limit);

        List<Document> results =
                vectorStore.similaritySearch(request);

        return results.stream()
                .map(doc -> new KnowledgeUnit(
                        (String) doc.getMetadata().getOrDefault("id", "unknown"),
                        doc.getContent(),
                        (String) doc.getMetadata().getOrDefault("source", "vector"),
                        (String) doc.getMetadata().getOrDefault("section", "unknown")
                ))
                .toList();
    }
}