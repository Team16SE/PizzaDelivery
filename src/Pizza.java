import java.util.ArrayList;

public class Pizza
{
        private char size;
        private String crust;
        private ArrayList<String> toppings;
        private int topCount;
        private double cost;
        private int pizzaKey;

    public Pizza(char size, String crust, ArrayList<String> toppings, int topCount, double cost, int pizzaKey)
    {
        this.size = size;
        this.crust = crust;
        this.topCount = topCount;
        this.cost = cost;
        this.pizzaKey = pizzaKey;

        for(int i = 0; i < toppings.size(); i++)
        {
            this.toppings.set(i, toppings.get(i));
        }
    }

    public void finalizeCost()
    {
        double temp1 = 0;
        double temp2 = 0;

        if(size == 's')
        {
            temp1 = 10.00;
        }
        else if(size == 'm')
        {
            temp1 = 12.00;
        }
        else if(size == 'l')
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

    public int getPizzaKey()
    {
        return pizzaKey;
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
        for(int i = 0; i < toppings.size(); i++)
        {
            this.toppings.set(i, toppings.get(i));
        }
    }

    public void setTopCount(int topCount)
    {
        this.topCount = topCount;
    }

    public void setCost(double cost)
    {
        this.cost = cost;
    }

    public void setPizzaKey(int pizzaKey)
    {
        this.pizzaKey = pizzaKey;
    }
}
