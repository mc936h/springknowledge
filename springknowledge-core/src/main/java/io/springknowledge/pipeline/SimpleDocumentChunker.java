package io.springknowledge.pipeline;

import io.springknowledge.model.KnowledgeDocument;
import io.springknowledge.model.KnowledgeUnit;

import java.util.ArrayList;
import java.util.List;

public class SimpleDocumentChunker implements DocumentChunker {

    private static final int CHUNK_SIZE = 200;

    @Override
    public List<KnowledgeUnit> chunk(KnowledgeDocument document) {

        List<KnowledgeUnit> units = new ArrayList<>();
        String content = document.getContent();

        int index = 0;
        int counter = 0;

        while (index < content.length()) {

            int end = Math.min(index + CHUNK_SIZE, content.length());

            String chunk = content.substring(index, end);

            units.add(new KnowledgeUnit(
                    document.getId() + "-" + counter,
                    chunk,
                    document.getSource(),
                    "chunk-" + counter
            ));

            index = end;
            counter++;
        }

        return units;
    }
}