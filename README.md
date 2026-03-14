![Java](https://img.shields.io/badge/Java-21-blue)
![Spring Boot](https://img.shields.io/badge/SpringBoot-3.3-green)
![License](https://img.shields.io/badge/license-MIT-yellow)

# SpringKnowledge

SpringKnowledge is a lightweight framework for building
Retrieval-Augmented Generation (RAG) systems in Spring Boot
applications.

It provides a structured knowledge architecture that enables developers
to ingest documents, retrieve relevant information, and generate answers
using Large Language Models (LLMs).

SpringKnowledge focuses on knowledge infrastructure rather than AI model
infrastructure.

------------------------------------------------------------------------

# Overview

Modern AI applications often need to answer questions based on private
knowledge such as documentation, internal systems, or domain knowledge.

Retrieval-Augmented Generation (RAG) solves this by:

1.  Ingesting documents\
2.  Breaking them into chunks\
3.  Retrieving relevant chunks\
4.  Sending them to an LLM as context

SpringKnowledge provides a clean, modular implementation of this
pipeline for Spring Boot applications.

------------------------------------------------------------------------

# Features

Current features:

-   Document ingestion\
-   Markdown knowledge loading\
-   Document chunking\
-   Knowledge storage\
-   Knowledge retrieval\
-   Context assembly\
-   LLM answer generation\
-   Spring Boot starter auto-configuration\
-   Example RAG application

Currently supported LLM provider:

-   OpenAI via Spring AI

Planned features:

-   Ollama support\
-   Vector embeddings\
-   Vector search\
-   Hybrid retrieval\
-   Additional document loaders

------------------------------------------------------------------------

# Architecture

SpringKnowledge implements a modular knowledge pipeline.

DocumentLoader\
↓\
DocumentChunker\
↓\
KnowledgeRepository\
↓\
KnowledgeRetriever\
↓\
ContextAssembler\
↓\
KnowledgeAnswerer\
↓\
LLM

Each stage of the pipeline is designed to be replaceable and extensible.

------------------------------------------------------------------------

# Core Components

**DocumentLoader**\
Loads documents from sources such as markdown files.

**DocumentChunker**\
Splits documents into smaller chunks suitable for retrieval.

**KnowledgeRepository**\
Stores knowledge units generated during ingestion.

**KnowledgeRetriever**\
Retrieves relevant knowledge units for a query.

**ContextAssembler**\
Builds the context sent to the LLM.

**KnowledgeAnswerer**\
Generates answers using an LLM.

**KnowledgeService**\
High-level service for ingestion and querying.

------------------------------------------------------------------------

# Project Structure

springknowledge\
├── springknowledge-core\
├── springknowledge-spring-ai\
├── springknowledge-autoconfigure\
├── springknowledge-starter\
└── springknowledge-example

------------------------------------------------------------------------

## springknowledge-core

Contains the core framework abstractions including:

-   KnowledgeUnit\
-   KnowledgeRepository\
-   KnowledgeRetriever\
-   ContextAssembler\
-   KnowledgeService\
-   Document loading utilities\
-   Chunking logic

This module has no AI provider dependencies.

------------------------------------------------------------------------

## springknowledge-spring-ai

Integration with Spring AI.

Provides:

-   LLM communication\
-   ChatClient usage\
-   OpenAI integration

------------------------------------------------------------------------

## springknowledge-autoconfigure

Spring Boot auto configuration.

This module provides automatic bean configuration when the starter
dependency is included.

------------------------------------------------------------------------

## springknowledge-starter

Convenience dependency that includes:

-   Core framework\
-   Spring AI integration\
-   Auto configuration

This is the dependency applications should use.

------------------------------------------------------------------------

## springknowledge-example

Example Spring Boot application demonstrating:

-   Document ingestion\
-   Knowledge chunking\
-   Question answering\
-   End-to-end RAG pipeline execution

------------------------------------------------------------------------

# Getting Started

## 1. Clone the repository

git clone https://github.com/mc936h/springknowledge.git\
cd springknowledge

------------------------------------------------------------------------

## 2. Build the project

mvn clean install

------------------------------------------------------------------------

## 3. Configure OpenAI

Add your OpenAI API key to application.yml

spring: ai: openai: api-key: YOUR_API_KEY

------------------------------------------------------------------------

## 4. Run the example application

cd springknowledge-example\
mvn spring-boot:run

------------------------------------------------------------------------

# Example Output

=== SpringKnowledge RAG Test Starting ===

Ingested 29 chunks from markdown\
README.md loaded and ingested.

Question: SpringKnowledge?

=== AI Answer ===\
SpringKnowledge is a platform that focuses on knowledge architecture
rather than AI infrastructure.

=== SpringKnowledge RAG Test Finished ===

------------------------------------------------------------------------

# Example Usage

Example usage inside a Spring Boot application:

knowledgeService.ingest(unit);

List`<KnowledgeUnit>`{=html} results =
knowledgeService.search("SpringKnowledge", 5);

String answer = knowledgeService.ask("What is SpringKnowledge?");

------------------------------------------------------------------------

# Current Limitations

SpringKnowledge currently implements a naïve RAG architecture.

Limitations include:

-   Keyword-based retrieval\
-   No vector embeddings\
-   No vector search\
-   OpenAI-only LLM support

These limitations will be addressed in future releases.

------------------------------------------------------------------------

# Roadmap

Planned improvements include:

-   Embedding-based retrieval\
-   Vector database integration\
-   Ollama local model support\
-   Hybrid retrieval\
-   Query rewriting\
-   Reranking\
-   Additional document loaders

------------------------------------------------------------------------

# Philosophy

SpringKnowledge separates knowledge architecture from model
infrastructure.

The framework focuses on:

-   clean modular design\
-   Spring-native integration\
-   extensible knowledge pipelines

This allows developers to build AI-powered services using familiar
Spring Boot patterns.

------------------------------------------------------------------------

# License

MIT License
