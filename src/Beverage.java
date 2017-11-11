import java.text.NumberFormat;

public class Beverage
{
    private char size;
    private double cost;
    private String name;



    public Beverage(char size, double cost, String name)
    {
        this.size = size;
        this.cost = cost;
        this.name = name;
    }

    public void finalizeCost()
    {
        if(size == 'S')
        {
            this.cost = 1.00;
        }
        else if(size == 'M')
        {
            this.cost = 2.00;
        }
        else if(size == 'L')
        {
            this.cost = 3.00;
        }
        else
        {
            System.out.println("Error: bev size is NULL");
        }
    }

    public char getSize()
    {
        return size;
    }

    public double getCost()
    {
        return cost;
    }

    public String getName()
    {
        return name;
    }

    public void setSize(char size)
    {
        this.size = size;
    }

    public void setCost(double cost)
    {
        this.cost = cost;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String toString(){
        return "Beverage: " + name + "\nSize: " + size + "\n";
    }

    public String costToString(){
        NumberFormat currencyFormat = NumberFormat.getCurrencyInstance();

        return "\nBeverage Cost: " + currencyFormat.format(cost) + '\n';
    }
}
