package com.messager.repository.conversation;

import com.messager.model.domain.conversation.ConversationKey;
import com.messager.model.domain.conversation.ConversationMany;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ConversationManyToManyRepo extends JpaRepository<ConversationMany, ConversationKey> {

    List<ConversationMany> findConversationManyByConversation_IdConversation(Long idUser);
}
