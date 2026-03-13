package io.springknowledge.model;

public class KnowledgeUnit {

    private String id;
    private String content;
    private String source;
    private String section;

    public KnowledgeUnit(String id, String content, String source, String section) {
        this.id = id;
        this.content = content;
        this.source = source;
        this.section = section;
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

    public String getSection() {
        return section;
    }
}