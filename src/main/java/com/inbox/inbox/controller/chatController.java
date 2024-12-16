package com.inbox.inbox.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;

import com.inbox.inbox.model.ChatMessage;

public class chatController {

    @MessageMapping("/chat.send")
    @SendTo("/topic/public")
    public ChatMessage sendMessage(ChatMessage message) {
        if (message.getType() == ChatMessage.MessageType.JOIN) {
            message.setContent(message.getSender() + " joined the chat");
        } else if (message.getType() == ChatMessage.MessageType.LEAVE) {
            message.setContent(message.getSender() + " left the chat");
        }
        return message;
    }

}
