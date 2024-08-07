package com.messager.repository.message;

import com.messager.model.domain.messages.Message;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MessageRepo extends JpaRepository<Message, Long> {
    List<Message> findMessageByIdConversationAndIdUserSend(Long idConversation, Long idUser);
}
