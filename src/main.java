import javax.swing.*;
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
        Pizza pza = new Pizza('a', "", emptyToppings, 0, 0.00);
        int pzaCount = 0;
        Beverage bev = new Beverage('a', 0.00, "");
        ArrayList<Pizza> pzas = new ArrayList<>();
        ArrayList<Beverage> bevs = new ArrayList<>();
        Order ord = new Order(0, 0.00, cust, pzas, bevs, false);

        StyledDocument dishDoc = np.getOrderDetailsTextPane().getStyledDocument();
        np.getOrderDetailsTextPane().setEditable(false);

        StyledDocument costDoc = np.getCostTextPane().getStyledDocument();
        np.getCostTextPane().setEditable(false);

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

                Path logFile = Paths.get("C:\\Users\\Admin\\IdeaProjects\\Project\\PizzaDelivery\\src\\log\\Orders.log");

                try
                {
                    List<String> lines = Files.readAllLines(logFile);

                    String target = ss.getCustomerPhoneNumTextField().getText();

                    for(int i = 0; i < lines.size(); i++)
                    {
                        if(lines.get(i).equals(target))
                        {
                            cust.setPhoneNum(target);
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
                    char c = np.getPizzaSizeBox().getSelectedItem().toString().charAt(0);

                    pza.setSize(c);
                    pza.setCrust(np.getCrustTypeBox().getSelectedItem().toString());

                    ArrayList<String> tops = new ArrayList<>();

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
                        dishDoc.insertString(dishDoc.getLength(), "\nPizza:\n", null);
                        dishDoc.insertString(dishDoc.getLength(), "Size: " + pza.getSize() + "\n", null);
                        dishDoc.insertString(dishDoc.getLength(), "Crust: " + pza.getCrust() + "\n", null);
                        dishDoc.insertString(dishDoc.getLength(), "Toppings: " + "\n", null);

                        for(int i = 0; i < pza.getTopCount(); i++)
                        {
                            dishDoc.insertString(dishDoc.getLength(), pza.getToppings().get(i) + "\n", null);
                        }

                        costDoc.insertString(costDoc.getLength(), "\nPizza Cost:\n", null);
                        costDoc.insertString(costDoc.getLength(), Double.toString(pza.getCost()), null);
                    }
                    catch(BadLocationException exc)
                    {
                        exc.printStackTrace();
                    }

                    pzas.add(pza);
                }

                if(b.compareTo("N/A") != 0)
                {
                    char sz = np.getDrinkSizeBox().getSelectedItem().toString().charAt(0);

                    bev.setSize(sz);
                    bev.setName(np.getDrinkTypeBox().getSelectedItem().toString());
                    bev.finalizeCost();
                    bevs.add(bev);

                    try
                    {
                        dishDoc.insertString(dishDoc.getLength(), "\n", null);
                        dishDoc.insertString(dishDoc.getLength(), "Drink: " + bev.getName() + "\n", null);
                        dishDoc.insertString(dishDoc.getLength(), "Size: " + bev.getSize() + "\n", null);

                        costDoc.insertString(costDoc.getLength(), "\nBeverage Cost:\n", null);
                        costDoc.insertString(costDoc.getLength(), Double.toString(bev.getCost()), null);
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

                np.getOrderDetailsTextPane().revalidate();
                np.getOrderDetailsTextPane().repaint();

                guiFrame.revalidate();
                guiFrame.repaint();
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
