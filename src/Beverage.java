public class Beverage
{
    private char size;
    private double cost;
    private String name;
    private int bevID;

    public Beverage(char size, double cost, String name, int bevID)
    {
        this.size = size;
        this.cost = cost;
        this.name = name;
        this.bevID = bevID;
    }

    void finalizeCost()
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

    char getSize()
    {
        return size;
    }

    double getCost()
    {
        return cost;
    }

    String getName()
    {
        return name;
    }

    int getID()
    {
        return bevID;
    }

    void setSize(char size)
    {
        this.size = size;
    }

    void setCost(double cost)
    {
        this.cost = cost;
    }

    void setName(String name)
    {
        this.name = name;
    }

    void setID(int bevID)
    {
        this.bevID = bevID;
    }
}
