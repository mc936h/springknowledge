package io.springknowledge.context;

import io.springknowledge.model.KnowledgeUnit;
import java.util.List;

public class SimpleContextAssembler implements ContextAssembler {

    @Override
    public String assemble(String query, List<KnowledgeUnit> units) {

        StringBuilder context = new StringBuilder();

        context.append("Use the following knowledge to answer the question.\n\n");

        for (KnowledgeUnit unit : units) {
            context.append(unit.getContent())
                    .append("\n\n");
        }

        context.append("Question: ")
                .append(query)
                .append("\nAnswer:");

        return context.toString();
    }
}