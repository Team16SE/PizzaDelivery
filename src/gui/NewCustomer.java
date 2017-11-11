package gui;

import javax.swing.*;

public class NewCustomer
{
    private JTextField customerNameTextField;
    private JPanel panel1;
    private JTextField customerPhoneNumberTextField;
    private JTextField customerAddressTextField;
    private JTextField customerChargeTypeTextField;
    private JTextField customerSpecialInfoTextField;
    private JButton OKButton;
    private JButton cancelButton;

    public JPanel getPanel1()
    {
        return panel1;
    }

    public JButton getOKButton()
    {
        return OKButton;
    }

    public JButton getCancelButton()
    {
        return cancelButton;
    }

    public JTextField getCustomerNameTextField()
    {
        return customerNameTextField;
    }

    public JTextField getCustomerAddressTextField()
    {
        return customerAddressTextField;
    }

    public JTextField getCustomerPhoneNumberTextField()
    {
        return customerPhoneNumberTextField;
    }

    public JTextField getCustomerChargeTypeTextField()
    {
        return customerChargeTypeTextField;
    }

    public JTextField getCustomerSpecialInfoTextField()
    {
        return customerSpecialInfoTextField;
    }
}
