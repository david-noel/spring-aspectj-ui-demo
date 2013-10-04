package ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.swing.*;

import org.springframework.beans.factory.annotation.Value;

public class ManualButton extends JButton implements ActionListener {

    @Inject
    private Service service;

    @Value("${manualTitle:Manual Button}")
    private String buttonTitle;

    @PostConstruct
    public void init() {
        setText(buttonTitle);
        addActionListener(this);
        System.out.println("Created ManualButton");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("ManualButton " + service.performAction(buttonTitle) + " clicked");
    }
}
