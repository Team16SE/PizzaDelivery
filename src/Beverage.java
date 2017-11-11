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

    public Beverage()
    {
        return;
    }

    public void finalizeCost()
    {
        if(size == 's')
        {
            cost = 1.00;
        }
        else if(size == 'm')
        {
            cost = 2.00;
        }
        else if(size == 'l')
        {
            cost = 3.00;
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
}
