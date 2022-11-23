package fr.lernejo.chat;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public class ChatMessageRepository {

    private List<String> list = new ArrayList<String>();

    void addChatMessage(String message) {
        list.add(message);
        if (list.size() > 10) {
            list.remove(0);
        }
    }

    List<String> getLastTenMessages() {
        return list;
    }
}
