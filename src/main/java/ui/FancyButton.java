package ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.swing.*;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.beans.factory.annotation.Value;

@Configurable
public class FancyButton extends JButton implements ActionListener {
    private static final long serialVersionUID = -664761807515225732L;

    @Inject
    private Service service;

    @Value("${fancyTitle:Fancy Button}")
    private String buttonTitle;

    @PostConstruct
    public void init() {
        setText(buttonTitle);
        addActionListener(this);
        System.out.println("Created FancyButton");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("FancyButton " + service.performAction(buttonTitle) + " clicked");
    }
}
