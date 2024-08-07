package com.messager.service;

import com.messager.model.domain.messages.Message;
import com.messager.model.domain.conversation.Conversation;
import com.messager.model.domain.conversation.ConversationKey;
import com.messager.model.domain.conversation.ConversationMany;

import java.util.List;

public interface ConversationService {
    List<ConversationMany> conversationList(Long userId);

    ConversationMany createdConversation(Long idUser, Conversation conversation, ConversationMany conversationMany, ConversationKey conversationKey, Long idAssigner);

    Conversation updateConversation(Long idConversation, Conversation conversation);

    List<Conversation> deleteConversation(Long userId, Long conversationId, Long idAssigner);

    Message createMessage(Message message, Long idUser, Long conversationId);

    List<Message> listMessageUser(Long userId, Long conversationId);
}
