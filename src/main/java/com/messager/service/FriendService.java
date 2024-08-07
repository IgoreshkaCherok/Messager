package com.messager.service;

import com.messager.model.domain.friend.Friend;

import java.util.List;

public interface FriendService {

    List<Friend> listFriend(Long idUser);

    String addFriend(Long idUser, Long idSigned);

    String deleteFriend(Long idUser, Long idSigned);
}
