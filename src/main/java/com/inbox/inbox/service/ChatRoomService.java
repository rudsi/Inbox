package com.inbox.inbox.service;

import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Service;

@Service
public class ChatRoomService {
    private final Set<String> users = ConcurrentHashMap.newKeySet();

    public boolean addUser(String username) {
        return users.add(username);
    }

    public boolean removeUser(String username) {
        return users.remove(username);
    }

    public Set<String> getUsers() {
        return users;
    }
}