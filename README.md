# SpringKnowledge

**SpringKnowledge** is a framework for building **knowledge-powered AI applications in Spring Boot**.

It provides a structured abstraction layer for **Retrieval-Augmented Generation (RAG)** systems, enabling developers to integrate **knowledge retrieval, contextual reasoning, and AI-powered responses** into their applications while leveraging **Spring AI** for model and vector-store infrastructure.

SpringKnowledge focuses on **knowledge architecture**, not AI infrastructure.

---

# Why SpringKnowledge?

Developers building AI-powered services often need to combine multiple components:

* Embedding models
* Vector databases
* Retrieval pipelines
* Prompt construction
* Context assembly
* Citation tracking

Even when using Spring AI, developers frequently end up writing repetitive **RAG glue code** across services.

SpringKnowledge solves this problem by introducing **structured knowledge abstractions** and standardized retrieval pipelines, allowing developers to focus on **knowledge and questions**, rather than infrastructure wiring.

---

# Architecture

SpringKnowledge sits **on top of Spring AI** and complements it.

```
Application
     ↓
SpringKnowledge
     ↓
Spring AI
     ↓
LLM / Embeddings / Vector Store
```

### Responsibilities

**Spring AI**

* Model integrations
* Embedding generation
* Vector database integration
* Prompt execution

**SpringKnowledge**

* Knowledge modeling
* Knowledge ingestion
* Retrieval orchestration
* Context construction
* Citation generation

---

# Core Concepts

## KnowledgeUnit

A **KnowledgeUnit** represents the smallest meaningful piece of information.

Examples include:

* a Quran verse
* a Bible verse
* a legal clause
* a paragraph from documentation
* an API function description
* a policy statement

Example:

```java
KnowledgeUnit unit = new KnowledgeUnit(
    "1",
    "Patience is praised as a virtue.",
    "ExampleDoc",
    "Section 1"
);
```

---

## KnowledgeRepository

The **KnowledgeRepository** is responsible for storing and retrieving knowledge.

It abstracts the underlying vector database or storage mechanism.

Example usage:

```java
List<KnowledgeUnit> results =
        repository.search("What does the document say about patience?", 5);
```

Possible implementations may use:

* Qdrant
* Pinecone
* PostgreSQL + pgvector
* Elasticsearch
* in-memory embeddings

---

## KnowledgeService

The **KnowledgeService** provides the main API for applications.

Example usage:

```java
KnowledgeAnswer answer =
        knowledgeService.ask("What is patience?");
```

Internally, SpringKnowledge handles:

* retrieval
* prompt construction
* context assembly
* LLM invocation
* source citation tracking

---

# Example Usage

Example Spring Boot controller:

```java
@RestController
class KnowledgeController {

    private final KnowledgeService knowledgeService;

    public KnowledgeController(KnowledgeService knowledgeService) {
        this.knowledgeService = knowledgeService;
    }

    @PostMapping("/ask")
    public KnowledgeAnswer ask(@RequestBody String question) {
        return knowledgeService.ask(question);
    }
}
```

SpringKnowledge manages the retrieval pipeline automatically.

---

# Project Modules

```
springknowledge
│
├── springknowledge-core
│   Core domain models and framework abstractions
│
├── springknowledge-autoconfigure
│   Spring Boot auto-configuration
│
├── springknowledge-starter
│   Starter dependency for applications
│
└── springknowledge-example
    Example Spring Boot application
```

---

# Design Principles

SpringKnowledge follows several architectural principles:

### Knowledge-first design

Applications operate on **knowledge units**, not raw documents.

### Separation of concerns

AI infrastructure remains the responsibility of Spring AI.

### Spring-native developer experience

SpringKnowledge integrates naturally with:

* Spring Boot
* dependency injection
* auto-configuration
* starter dependencies

### Extensibility

Developers can extend the framework by adding:

* new knowledge sources
* custom retrieval strategies
* custom vector stores
* custom prompt templates

---

# Getting Started (Planned)

SpringKnowledge will provide a starter dependency:

```xml
<dependency>
  <groupId>io.springknowledge</groupId>
  <artifactId>springknowledge-starter</artifactId>
</dependency>
```

After adding the dependency, developers will be able to:

1. ingest knowledge
2. query knowledge
3. receive grounded AI answers with citations

---

# Roadmap

Planned features include:

* Knowledge ingestion pipelines
* Source citation generation
* Multi-source knowledge engines
* Retrieval strategy plugins
* Structured prompt templates
* Support for multiple vector stores
* Integration with Spring AI agents

---

# Project Status

SpringKnowledge is currently in **early development**.

The project is actively evolving and contributions are welcome.

---

# Contributing

Contributions are welcome.

Please open issues or pull requests to:

* report bugs
* propose features
* improve documentation
* extend integrations

---

# License

This project is licensed under the **Apache License 2.0**.

---

# Vision

SpringKnowledge aims to provide a **structured, extensible framework for knowledge-driven AI systems in the Spring ecosystem**, enabling developers to build intelligent applications powered by structured knowledge retrieval and reasoning.
