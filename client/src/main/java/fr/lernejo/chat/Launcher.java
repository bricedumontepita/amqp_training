
package fr.lernejo.chat;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Scanner;

@SpringBootApplication
public class Launcher {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(Launcher.class);

        try {
            var rabbitTemplate = context.getBean(RabbitTemplate.class);

            Scanner sc = new Scanner(System.in);
            Boolean tmp = true;
            while (tmp) {
                String str = sc.nextLine();
                if (str == "q" || str.equals("q")) {
                    tmp = false;
                } else {
                    rabbitTemplate.convertAndSend("", "chat_messages", str);
                }
            }
        } finally {
            context.close();
        }
    }
}
