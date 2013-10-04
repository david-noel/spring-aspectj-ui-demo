package ui;

import java.awt.*;

import javax.annotation.PostConstruct;
import javax.swing.*;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ManagedBeanDialog extends JDialog {
    private static final long serialVersionUID = -4370027310119686919L;

    @Value("${dialogTitle:defaultTitle}")
    private String dialogTitle;

    @PostConstruct
    public void init() {
        setTitle(dialogTitle);

        ManualButton mButton = Application.wire(new ManualButton());
        FancyButton fButton = new FancyButton();
        //Application.wire(fButton);
        JPanel p = new JPanel();
        p.setLayout(new BorderLayout());
        add(mButton, BorderLayout.NORTH);
        add(fButton, BorderLayout.SOUTH);
        pack();
        setVisible(true);
    }
}
