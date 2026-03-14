package io.springknowledge.loader;

import io.springknowledge.model.KnowledgeDocument;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class MarkdownDocumentLoader implements DocumentLoader {

    @Override
    public List<KnowledgeDocument> load(String source) {

        try {

            String content = Files.readString(Path.of(source));

            KnowledgeDocument document =
                    new KnowledgeDocument(source, content, "markdown");

            return List.of(document);

        } catch (IOException e) {

            throw new RuntimeException("Failed to load markdown file", e);

        }
    }
}