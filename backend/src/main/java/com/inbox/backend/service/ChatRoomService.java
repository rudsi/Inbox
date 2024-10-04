package com.inbox.backend.service;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Service
public class ChatRoomService {

    // Store users in chat rooms
    private final Map<String, Set<String>> chatRooms = new HashMap<>();

    // Register a user in a chat room
    public void registerUser(String roomId, String username) {
        chatRooms.putIfAbsent(roomId, new HashSet<>());
        chatRooms.get(roomId).add(username);
    }

    // Get all users in a chat room
    public Set<String> getUsersInRoom(String roomId) {
        return chatRooms.getOrDefault(roomId, new HashSet<>());
    }

    // Check if a user is in a specific room
    public boolean isUserInRoom(String roomId, String username) {
        Set<String> users = chatRooms.get(roomId);
        return users != null && users.contains(username);
    }

    // Remove a user from a chat room
    public void removeUser(String roomId, String username) {
        Set<String> users = chatRooms.get(roomId);
        if (users != null) {
            users.remove(username);
        }
    }

    // Clear all users from a chat room
    public void clearRoom(String roomId) {
        chatRooms.remove(roomId);
    }
}