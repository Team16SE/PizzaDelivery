import java.text.NumberFormat;
import java.util.ArrayList;

public class Pizza
{
    private char size;
    private String crust;
    private ArrayList<String> toppings = new ArrayList<>();
    private int topCount;
    private double cost;

    public Pizza(char size, String crust, ArrayList<String> toppings, int topCount, double cost)
    {
        this.size = size;
        this.crust = crust;
        this.topCount = topCount;
        this.cost = cost;
        this.toppings.addAll(toppings);
    }

    public void finalizeCost()
    {
        double temp1 = 0;
        double temp2;

        if(size == 'S')
        {
            temp1 = 10.00;
        }
        else if(size == 'M')
        {
            temp1 = 12.00;
        }
        else if(size == 'L')
        {
            temp1 = 14.00;
        }
        else
        {
            System.out.println("Error: pizza size is NULL");
        }

        temp2 = topCount * 0.75;

        setCost(temp1 + temp2);
    }

    public char getSize()
    {
        return size;
    }

    public String getCrust()
    {
        return crust;
    }

    public ArrayList<String> getToppings()
    {
        return toppings;
    }

    public int getTopCount()
    {
        return topCount;
    }

    public double getCost()
    {
        return cost;
    }

    public void setSize(char size)
    {
        this.size = size;
    }

    public void setCrust(String crust)
    {
        this.crust = crust;
    }

    public void setToppings(ArrayList<String> toppings)
    {
        this.toppings.addAll(toppings);
    }

    public void setTopCount(int topCount)
    {
        this.topCount = topCount;
    }

    public void setCost(double cost)
    {
        this.cost = cost;
    }

    public String toString(){
        String tops = "";
        for(int i = 0; i < topCount; i++)
            tops = tops + "\t" + toppings.get(i) + "\n";
                return "Pizza: \nSize: " + size  + "\nCrust: " + crust + "\nToppings: \n" + tops;
    }

    public String costToString(){
        NumberFormat currencyFormat = NumberFormat.getCurrencyInstance();
        return "\nPizza Cost:\n" + currencyFormat.format(cost) + "\n";
    }
}
