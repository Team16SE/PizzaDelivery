package gui;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Created by Chris on 11/8/2017.
 */
public class PayScreen {
    private JButton cardButton;
    private JPanel panel1;
    private JButton cashButton;
    private JButton printButton;
    private JButton cancelButton;
    private JButton discountButton;

    public PayScreen() {
        cardButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
            }
        });
    }
}
