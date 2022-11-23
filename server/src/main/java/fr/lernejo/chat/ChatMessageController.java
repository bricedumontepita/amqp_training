package fr.lernejo.chat;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/message")
public class ChatMessageController {
    private ChatMessageRepository chatMessageRepository;

    public ChatMessageController(ChatMessageRepository chatMessageRepository) {
        this.chatMessageRepository = chatMessageRepository;
    }

    @GetMapping
    public Iterable<String> getList() {
        return chatMessageRepository.getLastTenMessages();
    }
}
