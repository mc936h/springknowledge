package io.springknowledge.service;

import io.springknowledge.answer.KnowledgeAnswerer;
import io.springknowledge.context.ContextAssembler;
import io.springknowledge.model.KnowledgeUnit;
import io.springknowledge.repository.KnowledgeRepository;
import io.springknowledge.retrieval.KnowledgeRetriever;

import java.util.List;

public class KnowledgeService {

    private final KnowledgeRepository repository;
    private final KnowledgeRetriever retriever;
    private final ContextAssembler contextAssembler;
    private final KnowledgeAnswerer answerer;

    public KnowledgeService(
            KnowledgeRepository repository,
            KnowledgeRetriever retriever,
            ContextAssembler contextAssembler,
            KnowledgeAnswerer answerer
    ) {
        this.repository = repository;
        this.retriever = retriever;
        this.contextAssembler = contextAssembler;
        this.answerer = answerer;
    }

    public void ingest(KnowledgeUnit unit) {
        repository.save(unit);
    }

    public List<KnowledgeUnit> search(String query, int limit) {
        return retriever.retrieve(query, limit);
    }

    public String ask(String query) {

        List<KnowledgeUnit> units =
                retriever.retrieve(query, 5);

        if (units.isEmpty()) {
            return "No relevant knowledge found.";
        }

        String context =
                contextAssembler.assemble(query,units);

        return answerer.answer(context);
    }
}