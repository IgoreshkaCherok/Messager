package com.messager.repository;

import com.messager.model.domain.friend.Friend;
import com.messager.model.domain.friend.FriendKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FriendsRepo extends JpaRepository<Friend, FriendKey> {
    List<Friend> findByFriendKeyIdUserIs(Long idUser);

    List<Friend> findByFriendKeyIdSignedIs(Long idSigned);
}

