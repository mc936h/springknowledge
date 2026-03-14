package io.springknowledge.springai.service;

import io.springknowledge.answer.KnowledgeAnswerer;
import org.springframework.ai.chat.client.ChatClient;

public class SpringAiKnowledgeAnswerer implements KnowledgeAnswerer {

    private final ChatClient chatClient;

    public SpringAiKnowledgeAnswerer(ChatClient chatClient) {
        this.chatClient = chatClient;
    }

    @Override
    public String answer(String prompt) {

        return chatClient
                .prompt()
                .user(prompt)
                .call()
                .content();
    }
}