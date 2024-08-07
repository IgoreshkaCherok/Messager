package com.messager.repository.message;

import com.messager.model.domain.messages.MessageKey;
import com.messager.model.domain.messages.MessageMany;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageManyRepo extends JpaRepository<MessageMany, MessageKey> {
}
