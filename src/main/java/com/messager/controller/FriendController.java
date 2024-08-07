package com.messager.controller;

import com.messager.model.domain.friend.Friend;
import com.messager.service.FriendService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user/{idUser}/friend")
@RequiredArgsConstructor
public class FriendController {
    private final FriendService friendService;

    @GetMapping("")
    public List<Friend> getFriends(@PathVariable Long idUser) {
        return friendService.listFriend(idUser);
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public String addFriend(@PathVariable Long idUser, @RequestParam(name = "friendId") String idSigned) {
        return friendService.addFriend(idUser, Long.valueOf(idSigned));
    }

    @DeleteMapping("")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public String removeFriend(@PathVariable Long idUser, @RequestParam(name = "friendId") Long idSigned) {
        return friendService.deleteFriend(idUser, idSigned);
    }

}
