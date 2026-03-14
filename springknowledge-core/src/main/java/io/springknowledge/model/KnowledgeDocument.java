package io.springknowledge.model;

public class KnowledgeDocument {

    private String id;
    private String content;
    private String source;

    public KnowledgeDocument(String id, String content, String source) {
        this.id = id;
        this.content = content;
        this.source = source;
    }

    public String getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public String getSource() {
        return source;
    }
}