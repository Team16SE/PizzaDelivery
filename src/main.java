import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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
