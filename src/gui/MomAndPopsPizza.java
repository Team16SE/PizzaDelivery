package gui;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class MomAndPopsPizza
{
    private JButton custButton;
    private JPanel startScreen;
    private JTextField customerPhoneNumTextField;
    private JButton lookupButton;
    private JButton newCustomerButton;

    public JButton getLookupButton()
   {
       return lookupButton;
   }

   public JButton getNewCustomerButton()
   {
       return newCustomerButton;
   }

   public JPanel getStartScreen()
   {
       return startScreen;
   }

   public JTextField getCustomerPhoneNumTextField()
   {
       return customerPhoneNumTextField;
   }
}
