package com.messager.service.impl;

import com.messager.model.domain.messages.Message;
import com.messager.model.domain.conversation.Conversation;
import com.messager.model.domain.conversation.ConversationKey;
import com.messager.model.domain.conversation.ConversationMany;
import com.messager.repository.UserRepo;
import com.messager.repository.conversation.ConversationManyToManyRepo;
import com.messager.repository.conversation.ConversationRepo;
import com.messager.repository.message.MessageManyRepo;
import com.messager.repository.message.MessageRepo;
import com.messager.service.ConversationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
@Service
public class ConversationServiceImpl implements ConversationService {

    private final ConversationRepo conversationRepo;
    private final ConversationManyToManyRepo conversationManyToManyRepo;
    private final UserRepo userRepo;
    private final MessageRepo messageRepo;
    private final MessageManyRepo messageManyRepo;

    @Override
    public List<ConversationMany> conversationList(Long idUser) {
        return conversationManyToManyRepo.findConversationManyByConversation_IdConversation(idUser);
    }

    @Override
    public ConversationMany createdConversation(Long idUserReporter, Conversation conversation, ConversationMany conversationMany, ConversationKey conversationKey, Long idAssigner) {
        conversationRepo.save(conversation);
        Long idConversation = conversation.getIdConversation();
        conversationKey.setIdConversation(idConversation);
        conversationMany.setConversation(conversation);
        for (int i = 0; i < 2; ++i) {
            conversationMany.setUser(userRepo.findByIdUserIs(idAssigner));
            conversationKey.setIdUser(idAssigner);
            conversationMany.setConversationKey(conversationKey);
            conversationManyToManyRepo.save(conversationMany);
        }
        conversationKey.setIdUser(idUserReporter);
        conversationMany.setUser(userRepo.findByIdUserIs(idUserReporter));
        conversationMany.setUserReporter(true);
        conversationMany.setConversationKey(conversationKey);
        return conversationManyToManyRepo.save(conversationMany);
    }

    @Override
    public Message createMessage(Message message, Long idUser, Long conversationId) {
        message.setIdConversation(conversationId);
        message.setTimestamp(Timestamp.valueOf(LocalDateTime.now()));
        message.setIdUserSend(idUser);
        return messageRepo.save(message);
    }


    @Override
    public List<Message> listMessageUser(Long userId, Long conversationId) {
        return messageRepo.findMessageByIdConversationAndIdUserSend(conversationId, userId);
    }

    @Override
    public Conversation updateConversation(Long idConversation, Conversation conversation) {
        conversation.setIdConversation(idConversation);
        return conversationRepo.save(conversation);
    }

    @Override
    public List<Conversation> deleteConversation(Long userId, Long conversationId, Long idAssigner) {
        ConversationMany conversationMany = new ConversationMany();
        ConversationKey conversationKey = new ConversationKey();
        conversationKey.setIdConversation(conversationId);
        conversationKey.setIdUser(userId);
        conversationMany.setConversationKey(conversationKey);
        conversationManyToManyRepo.delete(conversationMany);
        conversationKey.setIdUser(idAssigner);
        conversationManyToManyRepo.delete(conversationMany);
        Conversation conversation = new Conversation();
        conversation.setIdConversation(conversationId);
        conversationRepo.delete(conversation);
        return conversationRepo.findAll();
    }
}
