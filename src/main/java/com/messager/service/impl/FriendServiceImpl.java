package com.messager.service.impl;

import com.messager.model.domain.friend.Friend;
import com.messager.model.domain.friend.FriendKey;
import com.messager.repository.FriendsRepo;
import com.messager.repository.UserRepo;
import com.messager.service.FriendService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class FriendServiceImpl implements FriendService {

    private final FriendsRepo friendsRepo;
    private final UserRepo userRepo;

    @Override
    public List<Friend> listFriend(Long idUser) {
        return friendsRepo.findByFriendKeyIdUserIs(idUser);
    }

    @Override
    public String addFriend(Long idUser, Long idSigned) {
        userRepo.findById(idUser);
        userRepo.findById(idSigned);
        friendsRepo.findByFriendKeyIdUserIs(idUser);
        friendsRepo.findByFriendKeyIdSignedIs(idSigned);
        FriendKey friend1 = new FriendKey();
        friend1.setIdUser(idUser);
        friend1.setIdSigned(idSigned);
        Friend friend = new Friend();
        friend.setFriendKey(friend1);
        friendsRepo.save(friend);
        return "Добавлен друг с friendId: " + idSigned;
    }

    @Override
    public String deleteFriend(Long idUser, Long idSigned) {
        FriendKey friend = new FriendKey();
        friend.setIdUser(idUser);
        friend.setIdSigned(idSigned);
        friendsRepo.deleteById(friend);
        return "Друг с friendId: " + idSigned + " удален";
    }
}
