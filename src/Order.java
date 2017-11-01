import java.util.ArrayList;

public class Order
{
    private int orderID;
    private double totalCost;
    private Customer cust;
    private ArrayList<Pizza> pizzas = new ArrayList<>();
    private ArrayList<Beverage> bevs = new ArrayList<>();
    private boolean delivery;

    public Order(int orderID, double totalCost, Customer cust, ArrayList<Pizza> pizzas, ArrayList<Beverage> bevs, boolean delivery)
    {
        this.orderID = orderID;
        this.totalCost = totalCost;
        this.cust = cust;
        this.delivery = delivery;
        this.pizzas.addAll(pizzas);
        this.bevs.addAll(bevs);
    }

    public void finalizeCost()
    {
        double pizzaTotal = 0.00;
        double bevTotal = 0.00;

        for(int i = 0; i < pizzas.size(); i++)
        {
            pizzaTotal += (pizzas.get(i)).getCost();
        }

        for(int j = 0; j < bevs.size(); j++)
        {
            bevTotal += (bevs.get(j)).getCost();
        }

        totalCost = bevTotal + pizzaTotal;
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
        this.pizzas.addAll(pizzas);
    }

    public void setBevs(ArrayList<Beverage> bevs)
    {
        this.bevs.addAll(bevs);
    }

    public void setDelivery(boolean delivery)
    {
        this.delivery = delivery;
    }
}
