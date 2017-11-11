package gui;

import javax.swing.*;

public class NewPizza
{
    private JTextPane orderDetailsTextPane;
    private JPanel panel1;
    private JTextPane costTextPane;
    private JButton completeOrderButton;
    private JButton cancelButton;
    private JCheckBox pepperoniCheckBox;
    private JCheckBox sausageCheckBox;
    private JCheckBox mushroomCheckBox;
    private JCheckBox bellPepperCheckBox;
    private JCheckBox extraCheeseCheckBox;
    private JButton undoButton;
    private JComboBox pizzaSizeBox;
    private JComboBox crustTypeBox;
    private JComboBox drinkTypeBox;
    private JComboBox drinkSizeBox;
    private JButton addSelectionButton;
    private JComboBox comboBox1;

    public JPanel getPanel1()
    {
        return panel1;
    }

    public JTextPane getCostTextPane() {
        return costTextPane;
    }

    public JTextPane getOrderDetailsTextPane() {
        return orderDetailsTextPane;
    }

    public JButton getAddSelectionButton() {
        return addSelectionButton;
    }

    public JButton getUndoButton() {
        return undoButton;
    }

    public JButton getCancelButton() {
        return cancelButton;
    }

    public JButton getCompleteOrderButton() {
        return completeOrderButton;
    }

    public JCheckBox getBellPepperCheckBox() {
        return bellPepperCheckBox;
    }

    public JCheckBox getExtraCheeseCheckBox() {
        return extraCheeseCheckBox;
    }

    public JCheckBox getMushroomCheckBox() {
        return mushroomCheckBox;
    }

    public JCheckBox getPepperoniCheckBox() {
        return pepperoniCheckBox;
    }

    public JCheckBox getSausageCheckBox() {
        return sausageCheckBox;
    }

    public JComboBox getComboBox1() {
        return comboBox1;
    }

    public JComboBox getCrustTypeBox() {
        return crustTypeBox;
    }

    public JComboBox getDrinkSizeBox() {
        return drinkSizeBox;
    }

    public JComboBox getDrinkTypeBox() {
        return drinkTypeBox;
    }

    public JComboBox getPizzaSizeBox() {
        return pizzaSizeBox;
    }


}
