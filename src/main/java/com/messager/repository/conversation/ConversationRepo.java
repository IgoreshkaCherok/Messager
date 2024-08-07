package com.messager.repository.conversation;

import com.messager.model.domain.conversation.Conversation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ConversationRepo extends JpaRepository<Conversation, Long> {
}

