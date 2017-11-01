import java.util.ArrayList;

public class Order
{
    private int orderID;
    private double totalCost;
    private Customer cust;
    private ArrayList<Pizza> pizzas;
    private ArrayList<Beverage> bevs;
    private boolean delivery;

    public Order(int orderID, double totalCost, Customer cust, ArrayList<Pizza> pizzas, ArrayList<Beverage> bevs, boolean delivery)
    {
        this.orderID = orderID;
        this.totalCost = totalCost;
        this.cust = cust;
        this.delivery = delivery;

        for(int i = 0; i < pizzas.size(); i++)
        {
            this.pizzas.set(i, pizzas.get(i));
        }

        for(int j = 0; j < bevs.size(); j++)
        {
            this.bevs.set(j, bevs.get(j));
        }
    }

    public int getOrderID()
    {
        return orderID;
    }

    public double getTotalCost()
    {
        return totalCost;
    }

    public Customer getCust()
    {
        return cust;
    }

    public ArrayList<Pizza> getPizzas()
    {
        return pizzas;
    }

    public ArrayList<Beverage> getBevs()
    {
        return bevs;
    }

    public boolean getDelivery()
    {
        return delivery;
    }

    public void setOrderID(int orderID)
    {
        this.orderID = orderID;
    }

    public void setTotalCost(double totalCost)
    {
        this.totalCost = totalCost;
    }

    public void setCust(Customer cust)
    {
        this.cust = cust;
    }

    public void setPizzas(ArrayList<Pizza> pizzas)
    {
        for(int i = 0; i < pizzas.size(); i++)
        {
            this.pizzas.set(i, pizzas.get(i));
        }
    }

    public void setBevs(ArrayList<Beverage> bevs)
    {
        for(int j = 0; j < bevs.size(); j++)
        {
            this.bevs.set(j, bevs.get(j));
        }
    }

    public void setDelivery(boolean delivery)
    {
        this.delivery = delivery;
    }
}
