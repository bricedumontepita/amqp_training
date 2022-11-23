package fr.lernejo;

import org.springframework.stereotype.Component;

@Component
public class ChatMessageListener {

    private ChatMessageRepository chatMessageRepository;

    public ChatMessageListener(ChatMessageRepository chatMessageRepository) {
        this.chatMessageRepository = chatMessageRepository;
    }

    public void onMessage(String msg) {
        chatMessageRepository.addChatMessage(msg);
    }
}
