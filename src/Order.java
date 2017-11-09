import java.util.ArrayList;
import java.nio.file.*;
import java.util.List;
import java.util.Arrays;
import java.nio.charset.*;
import java.io.*;

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

    public void logOrder() throws IOException
    {
        ArrayList<String> lines = new ArrayList<>();
        lines.addAll(Arrays.asList("OrderID: " + orderID, "Final Cost: $" + totalCost, "---", "Customer Information: ", "Name: " + cust.getName(), "Address: " + cust.getAddress(), "Charge Type: " + cust.getChargeType(), "Phone Number: " + cust.getPhoneNum()));
        Path logFile = Paths.get("C:\\Users\\Admin\\IdeaProjects\\Project\\PizzaDelivery\\src\\log\\Orders.log");
        Files.write(logFile, lines, Charset.forName("UTF-8"), StandardOpenOption.APPEND);

        lines.clear();

        lines.addAll(Arrays.asList("---", "Pizzas Information: "));
        Files.write(logFile, lines, Charset.forName("UTF-8"), StandardOpenOption.APPEND);
        lines.clear();

        for(int i = 0; i < pizzas.size(); i++)
        {
            lines.addAll(Arrays.asList("Size: " + pizzas.get(i).getSize(), "Crust Type: " + pizzas.get(i).getCrust(), "Pizza Cost: " + Double.toString(pizzas.get(i).getCost()), "Toppings: "));
            Files.write(logFile, lines, Charset.forName("UTF-8"), StandardOpenOption.APPEND);

            lines.clear();
            lines.addAll(pizzas.get(i).getToppings());
            Files.write(logFile, lines, Charset.forName("UTF-8"), StandardOpenOption.APPEND);
        }

        lines.clear();
        lines.addAll(Arrays.asList("---", "Beverage Information: "));
        Files.write(logFile, lines, Charset.forName("UTF-8"), StandardOpenOption.APPEND);

        for(int j = 0; j < bevs.size(); j++)
        {
            lines.clear();
            lines.addAll(Arrays.asList("Size " + Character.toString(bevs.get(j).getSize()), "Name: " + bevs.get(j).getName(), "Cost: " + Double.toString(bevs.get(j).getCost()), "BevID: " + Integer.toString(bevs.get(j).getID())));
            Files.write(logFile, lines, Charset.forName("UTF-8"), StandardOpenOption.APPEND);
        }
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
