package ui;

import javax.annotation.PostConstruct;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("linux")
public class LinuxEchoService implements Service {
    @Override
    public String performAction(String s) {
        return "Linux Echo " + s;
    }

    @PostConstruct
    public void init() {
        System.out.println("Created LinuxEchoService");
    }
}
