import javax.swing.*;
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

        Customer cust = new Customer();
        Pizza pza = new Pizza();
        Beverage bev = new Beverage();
        Order ord = new Order();

        ss.getNewCustomerButton().addMouseListener(new MouseAdapter()
        {
            @Override
            public void mouseClicked(MouseEvent e)
            {
                super.mouseClicked(e);
                guiFrame.getContentPane().removeAll();
                guiFrame.getContentPane().add(custInfoScreen);
                guiFrame.revalidate();
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
