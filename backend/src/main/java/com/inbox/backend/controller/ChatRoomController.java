package com.inbox.backend.controller;

import com.inbox.backend.service.ChatRoomService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

import javax.annotation.processing.Generated;

@RestController
@RequestMapping("/api/chat")
@CrossOrigin(origins = "http://localhost:3000")
public class ChatRoomController {

    private final ChatRoomService chatRoomService;

    public ChatRoomController(ChatRoomService chatRoomService) {
        this.chatRoomService = chatRoomService;
    }

    
    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody Map<String, String> payload) {
        String roomId = payload.get("roomId");
        String username = payload.get("username");

        if (roomId == null || username == null) {
            return ResponseEntity.badRequest().body("Missing roomId or username");
        }

        chatRoomService.registerUser(roomId, username);
        return ResponseEntity.ok("User " + username + " registered in chat room " + roomId);
    }

    @RequestMapping(value = "/register", method = RequestMethod.OPTIONS)
    public ResponseEntity<?> handlePreflight() {
        return ResponseEntity.ok().build();
    }
}
