package com.inbox.backend.service;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Service
public class ChatRoomService {

     
    private final Map<String, Set<String>> chatRooms = new HashMap<>();

   
    public void registerUser(String roomId, String username) {
        chatRooms.putIfAbsent(roomId, new HashSet<>());
        chatRooms.get(roomId).add(username);
    }

     
    public Set<String> getUsersInRoom(String roomId) {
        return chatRooms.getOrDefault(roomId, new HashSet<>());
    }

     
    public boolean isUserInRoom(String roomId, String username) {
        Set<String> users = chatRooms.get(roomId);
        return users != null && users.contains(username);
    }

    
    public void removeUser(String roomId, String username) {
        Set<String> users = chatRooms.get(roomId);
        if (users != null) {
            users.remove(username);
        }
    }

    
    public void clearRoom(String roomId) {
        chatRooms.remove(roomId);
    }
}