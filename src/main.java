import javax.swing.*;
import java.text.NumberFormat;
import java.util.ArrayList;
import javax.swing.text.BadLocationException;
import javax.swing.text.StyledDocument;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.nio.file.*;
import java.io.*;
import java.util.List;
import gui.NewCustomer;
import gui.MomAndPopsPizza;
import gui.FinalDetails;
import gui.NewPizza;

public class main extends JFrame
{
    public static void main(String[] args)
    {
        main guiFrame = new main();

        MomAndPopsPizza ss = new MomAndPopsPizza();
        NewCustomer nc = new NewCustomer();
        NewPizza np = new NewPizza();
        FinalDetails fs = new FinalDetails();

        JPanel mainScreen = ss.getStartScreen();
        JPanel custInfoScreen = nc.getPanel1();
        JPanel pizzaScreen = np.getPanel1();
        JPanel detailsScreen = fs.getPanel1();

        guiFrame.getContentPane().add(mainScreen);
        guiFrame.setVisible(true);
        guiFrame.repaint();

        ArrayList<String> emptyToppings = new ArrayList<>();

        Customer cust = new Customer("", "", "", "", "");
        //Pizza pza = new Pizza('a', "", emptyToppings, 0, 0.00);
        int pzaCount = 0;
        Beverage bev = new Beverage('a', 0.00, "");
        ArrayList<Pizza> pzas = new ArrayList<>();
        ArrayList<Beverage> bevs = new ArrayList<>();
        Order ord = new Order(0, 0.00, cust, pzas, bevs, false);

        StyledDocument dishDoc = np.getOrderDetailsTextPane().getStyledDocument();
        np.getOrderDetailsTextPane().setEditable(false);

        StyledDocument costDoc = np.getCostTextPane().getStyledDocument();
        np.getCostTextPane().setEditable(false);

        StyledDocument finalDoc = fs.getFinalDetails().getStyledDocument();
        fs.getFinalDetails().setEditable(false);

        NumberFormat currencyFormat = NumberFormat.getCurrencyInstance();

        ss.getNewCustomerButton().addMouseListener(new MouseAdapter()
        {
            @Override
            public void mouseClicked(MouseEvent e)
            {
                super.mouseClicked(e);
                guiFrame.getContentPane().removeAll();
                guiFrame.getContentPane().add(custInfoScreen);
                guiFrame.revalidate();
                guiFrame.repaint();
            }
        });

        ss.getLookupButton().addMouseListener(new MouseAdapter()
        {
            @Override
            public void mouseClicked(MouseEvent e)
            {
                super.mouseClicked(e);

                Path logFile = Paths.get("src\\Orders.log");

                try
                {
                    List<String> lines = Files.readAllLines(logFile);

                    String target = "Phone Number: " + ss.getCustomerPhoneNumTextField().getText().toString();

                    for(int i = 0; i < lines.size(); i++)
                    {
                        if(lines.get(i).compareTo(target) == 0)
                        {
                            cust.setPhoneNum(target.substring(14));
                            cust.setName(lines.get(i+1));
                            cust.setAddress(lines.get(i+2));
                            cust.setChargeType(lines.get(i+3));
                            cust.setSpecialInfo(lines.get(i+4));
                            break;
                        }
                        else
                            continue;
                    }
                }
                catch(IOException ex)
                {
                    ex.printStackTrace();
                }

                ord.setCust(cust);

                guiFrame.getContentPane().removeAll();
                guiFrame.getContentPane().add(pizzaScreen);
                guiFrame.revalidate();
                guiFrame.repaint();
            }
        });

        nc.getOKButton().addMouseListener(new MouseAdapter()
        {
            @Override
            public void mouseClicked(MouseEvent e)
            {
                super.mouseClicked(e);

                cust.setAddress(nc.getCustomerAddressTextField().getText());
                cust.setName(nc.getCustomerNameTextField().getText());
                cust.setPhoneNum(nc.getCustomerPhoneNumberTextField().getText());
                cust.setChargeType(nc.getCustomerChargeTypeTextField().getText());
                cust.setSpecialInfo(nc.getCustomerSpecialInfoTextField().getText());
                ord.setCust(cust);

                guiFrame.getContentPane().removeAll();
                guiFrame.getContentPane().add(pizzaScreen);
                guiFrame.revalidate();
                guiFrame.repaint();
            }
        });

        ss.getCustomerPhoneNumTextField().addMouseListener(new MouseAdapter()
        {
            @Override
            public void mouseClicked(MouseEvent e)
            {
                super.mouseClicked(e);

                ss.getCustomerPhoneNumTextField().setText("");
            }
        });

        nc.getCustomerNameTextField().addMouseListener(new MouseAdapter()
        {
            @Override
            public void mouseClicked(MouseEvent e)
            {
                super.mouseClicked(e);

                nc.getCustomerNameTextField().setText("");
            }
        });

        nc.getCustomerPhoneNumberTextField().addMouseListener(new MouseAdapter()
        {
            @Override
            public void mouseClicked(MouseEvent e)
            {
                super.mouseClicked(e);

                nc.getCustomerPhoneNumberTextField().setText("");
            }
        });

        nc.getCustomerChargeTypeTextField().addMouseListener(new MouseAdapter()
        {
            @Override
            public void mouseClicked(MouseEvent e)
            {
                super.mouseClicked(e);

                nc.getCustomerChargeTypeTextField().setText("");
            }
        });

        nc.getCustomerAddressTextField().addMouseListener(new MouseAdapter()
        {
            @Override
            public void mouseClicked(MouseEvent e)
            {
                super.mouseClicked(e);

                nc.getCustomerAddressTextField().setText("");
            }
        });

        nc.getCustomerSpecialInfoTextField().addMouseListener(new MouseAdapter()
        {
            @Override
            public void mouseClicked(MouseEvent e)
            {
                super.mouseClicked(e);

                nc.getCustomerSpecialInfoTextField().setText("");
            }
        });

        np.getAddSelectionButton().addMouseListener(new MouseAdapter()
        {
            @Override
            public void mouseClicked(MouseEvent e)
            {
                super.mouseClicked(e);


                String a = np.getPizzaSizeBox().getSelectedItem().toString();
                String b = np.getDrinkSizeBox().getSelectedItem().toString();

                if(a.compareTo("N/A") != 0)
                {
                    Pizza pza = new Pizza('a', "", emptyToppings, 0, 0.00);
                    char c = np.getPizzaSizeBox().getSelectedItem().toString().charAt(0);

                    pza.setSize(c);
                    pza.setCrust(np.getCrustTypeBox().getSelectedItem().toString());

                    ArrayList<String> tops = new ArrayList<>();
                    tops.clear();

                    int topCount = 0;

                    if(np.getBellPepperCheckBox().isSelected())
                    {
                        tops.add("Bell Peppers");
                        topCount++;
                    }
                    if(np.getExtraCheeseCheckBox().isSelected())
                    {
                        tops.add("Extra Cheese");
                        topCount++;
                    }
                    if(np.getMushroomCheckBox().isSelected())
                    {
                        tops.add("Mushrooms");
                        topCount++;
                    }
                    if(np.getPepperoniCheckBox().isSelected())
                    {
                        tops.add("Pepperoni");
                        topCount++;
                    }
                    if(np.getSausageCheckBox().isSelected())
                    {
                        tops.add("Sausage");
                        topCount++;
                    }

                    pza.setToppings(tops);
                    pza.setTopCount(topCount);
                    pza.finalizeCost();


                    try
                    {
                        dishDoc.insertString(dishDoc.getLength(), pza.toString(), null);

                        costDoc.insertString(costDoc.getLength(), pza.costToString(), null);
                    }
                    catch(BadLocationException exc)
                    {
                        exc.printStackTrace();
                    }
                    ord.setTotalCost(ord.getTotalCost() + pza.getCost());
                    pzas.add(pza);
                }

                if(b.compareTo("N/A") != 0)
                {
                    Beverage bev = new Beverage('a', 0.00, "");
                    char sz = np.getDrinkSizeBox().getSelectedItem().toString().charAt(0);

                    bev.setSize(sz);
                    bev.setName(np.getDrinkTypeBox().getSelectedItem().toString());
                    bev.finalizeCost();
                    ord.setTotalCost(ord.getTotalCost() + bev.getCost());
                    bevs.add(bev);

                    try
                    {
                        dishDoc.insertString(dishDoc.getLength(), bev.toString(), null);
                        costDoc.insertString(costDoc.getLength(), bev.costToString(), null);
                    }
                    catch(BadLocationException exc)
                    {
                        exc.printStackTrace();
                    }
                }

                np.getCrustTypeBox().setSelectedIndex(0);
                np.getPizzaSizeBox().setSelectedIndex(0);
                np.getSausageCheckBox().setSelected(false);
                np.getPepperoniCheckBox().setSelected(false);
                np.getMushroomCheckBox().setSelected(false);
                np.getExtraCheeseCheckBox().setSelected(false);
                np.getBellPepperCheckBox().setSelected(false);
                np.getDrinkSizeBox().setSelectedIndex(0);
                np.getDrinkTypeBox().setSelectedIndex(0);
                np.setTotalField(currencyFormat.format(ord.getTotalCost()));

                np.getOrderDetailsTextPane().revalidate();
                np.getOrderDetailsTextPane().repaint();

                guiFrame.revalidate();
                guiFrame.repaint();
            }
        });

        np.getUndoButton().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                try {
                    boolean hasUndone = false;
                    if (bevs.size() > 0) {
                        if (dishDoc.getText(dishDoc.getLength() - (bevs.get(bevs.size() - 1).toString().length()),
                                3).matches("Bev")) {

                            dishDoc.remove(dishDoc.getLength() - (bevs.get(bevs.size() - 1).toString().length()),
                                    bevs.get(bevs.size() - 1).toString().length());

                            ord.setTotalCost(ord.getTotalCost() - bevs.get(bevs.size() - 1).getCost());
                            np.setTotalField(currencyFormat.format(ord.getTotalCost()));


                            costDoc.remove(costDoc.getLength() - (bevs.get(bevs.size() - 1).costToString().length()),
                                    (bevs.get(bevs.size() - 1).costToString().length()));

                            bevs.remove(bevs.size() - 1);

                            hasUndone =true;
                        }
                    }
                    if (pzas.size() > 0 && !hasUndone) {
                        if (dishDoc.getText(dishDoc.getLength() - (pzas.get(pzas.size() - 1).toString().length()),
                                3).matches("Piz")) {

                            dishDoc.remove(dishDoc.getLength() - (pzas.get(pzas.size() - 1).toString().length()),
                                    pzas.get(pzas.size() - 1).toString().length());

                            ord.setTotalCost(ord.getTotalCost() - pzas.get(pzas.size() - 1).getCost());
                            np.setTotalField(currencyFormat.format(ord.getTotalCost()));

                            costDoc.remove(costDoc.getLength() - (pzas.get(pzas.size() - 1).costToString().length()),
                                    (pzas.get(pzas.size() - 1).costToString().length()));

                            pzas.remove(pzas.size() - 1);
                        }
                    }

                } catch(BadLocationException exc)
                {
                    exc.printStackTrace();
                }
            }
        });

        np.getCompleteOrderButton().addMouseListener(new MouseAdapter()
        {
            @Override
            public void mouseClicked(MouseEvent e)
            {
                super.mouseClicked(e);

                ord.setBevs(bevs);
                ord.setPizzas(pzas);
                ord.finalizeCost();
                ord.setOrderID(1);
                ord.setDelivery(false);

                try
                {
                    finalDoc.insertString(finalDoc.getLength(), "Customer Information:" + "\n", null);
                    finalDoc.insertString(finalDoc.getLength(), "Phone Number: " + ord.getCust().getPhoneNum() + "\n", null);
                    finalDoc.insertString(finalDoc.getLength(), "Name: " + ord.getCust().getName() + "\n", null);
                    finalDoc.insertString(finalDoc.getLength(), "Address: " + ord.getCust().getAddress() + "\n", null);
                    finalDoc.insertString(finalDoc.getLength(), "Charge Type: " + ord.getCust().getChargeType() + "\n", null);
                    finalDoc.insertString(finalDoc.getLength(), "Special Info: " + ord.getCust().getSpecialInfo() + "\n", null);

                    finalDoc.insertString(finalDoc.getLength(), "Dishes Information:" + "\n", null);

                    for(int i = 0; i < ord.getPizzas().size(); i++)
                    {
                        finalDoc.insertString(finalDoc.getLength(), ord.getPizzas().get(i).toString() + "\n", null);
                        finalDoc.insertString(finalDoc.getLength(),ord.getPizzas().get(i).costToString() + "\n", null);
                    }

                    finalDoc.insertString(finalDoc.getLength(), "Beverage Information:" + "\n", null);
                    for(int i = 0; i < ord.getBevs().size(); i++)
                    {
                        finalDoc.insertString(finalDoc.getLength(), ord.getBevs().get(i).toString() + "\n", null);
                        finalDoc.insertString(finalDoc.getLength(), ord.getBevs().get(i).costToString() + "\n", null);
                    }

                    finalDoc.insertString(finalDoc.getLength(), "Total Cost: " + currencyFormat.format(ord.getTotalCost()) + "\n", null);

                    if(np.getDeliveryRadioButton().isSelected())
                    {
                        ord.setDelivery(true);
                        finalDoc.insertString(finalDoc.getLength(), "For Delivery", null);
                    }
                    else
                    {
                        ord.setDelivery(false);
                        finalDoc.insertString(finalDoc.getLength(), "For Pickup", null);
                    }
                }
                catch(BadLocationException except)
                {
                    except.printStackTrace();
                }

                guiFrame.getContentPane().removeAll();
                guiFrame.getContentPane().add(detailsScreen);
                guiFrame.revalidate();
                guiFrame.repaint();
            }
        });

        fs.getCompleteOrderButton().addMouseListener(new MouseAdapter()
        {
            @Override
            public void mouseClicked(MouseEvent e)
            {
                super.mouseClicked(e);

                try
                {
                    ord.logOrder();
                }
                catch(IOException excp)
                {
                    excp.printStackTrace();
                }

                guiFrame.dispose();
            }
        });
    }

    public main()
    {
        super("Pizza Delivery");

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        pack();
        setSize(screenSize);
        setResizable(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
