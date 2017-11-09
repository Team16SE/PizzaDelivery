package gui;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Created by Chris on 11/8/2017.
 */
public class MomAndPopsPizza {
    private JButton custButton;
    private JPanel startScreen;
    private JTextField customerPhoneNumTextField;
    private JButton lookupButton;
    private JButton newCustomerButton;

    public MomAndPopsPizza() {
        custButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
            }
        });
    }
}
