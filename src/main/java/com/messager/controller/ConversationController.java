package com.messager.controller;

import com.messager.model.domain.conversation.Conversation;
import com.messager.model.domain.messages.Message;
import com.messager.model.domain.conversation.ConversationKey;
import com.messager.model.domain.conversation.ConversationMany;
import com.messager.service.ConversationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/conversation/{userId}")
@RequiredArgsConstructor
public class ConversationController {
    private final ConversationService conversationService;

    @GetMapping("")
    public List<ConversationMany> getConversations(@PathVariable Long userId) {
        return conversationService.conversationList(userId);
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public ConversationMany createConversation(@PathVariable Long userId, @RequestBody Map<String, String> body) {
        Conversation conversation = new Conversation();
        conversation.setNameConversation(body.get("nameConversation"));
        Long idAssigner = Long.valueOf(body.get("idUserAssigner"));
        ConversationMany conversationMany = new ConversationMany();
        ConversationKey conversationKey = new ConversationKey();
        return conversationService.createdConversation(userId, conversation, conversationMany, conversationKey, idAssigner);
    }

    @PostMapping("conversationId/{conversationId}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Message createMessage(@PathVariable Long conversationId, @RequestBody Message message) {
        Long idUser = message.getIdUserSend();
        return conversationService.createMessage(message, idUser, conversationId);
    }

    @PatchMapping("/conversationId/{conversationId}")
    @ResponseStatus(HttpStatus.OK)
    public Conversation updateConversation(@PathVariable Long conversationId, @RequestBody Conversation conversation) {
        return conversationService.updateConversation(conversationId, conversation);
    }

    @DeleteMapping("")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public List<Conversation> deleteConversation(@PathVariable Long userId, @RequestBody Map<String, Long> body) {
        Long conversationId = body.get("conversationId");
        Long idAssigner = body.get("idAssigner");
        return conversationService.deleteConversation(userId, conversationId, idAssigner);
    }

    @GetMapping("conversationId/{conversationId}/messages")
    public List<Message> listMessage(@PathVariable Long userId, @PathVariable Long conversationId) {
        return conversationService.listMessageUser(userId, conversationId);
    }
}
