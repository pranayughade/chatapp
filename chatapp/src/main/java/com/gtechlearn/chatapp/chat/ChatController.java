package com.gtechlearn.chatapp.chat;


import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

@Controller  // Marks this class as a WebSocket controller
public class ChatController {


    // Handles messages sent to "/app/chat.sendMessage"
    @MessageMapping("/chat.sendMessage")
    // Sends the response message to all subscribers of "/topic/public"
    @SendTo("/topic/public")
    public ChatMessage sendMessage(
            @Payload ChatMessage chatMessage

    ){
        return chatMessage;
    }





    // Handles messages sent to "/app/chat.addUser"
    @MessageMapping("/chat.addUser")
    // Sends the response message to all subscribers of "/topic/public"
    @SendTo("/topic/public")
    public ChatMessage addUser(
            @Payload ChatMessage chatMessage,
            SimpMessageHeaderAccessor headerAccessor
    ){

        //adds username in websocket session
        headerAccessor.getSessionAttributes().put("username", chatMessage.getSender());
        return chatMessage;
    }

}
