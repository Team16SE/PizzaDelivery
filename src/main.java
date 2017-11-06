import java.util.ArrayList;

public class main
{
    public static void main(String[] args)
    {
        //Pizza testing
        ArrayList<String> toppings = new ArrayList<>();
        toppings.add("Pepperoni");
        toppings.add("Sausage");
        toppings.add("Feta");

        Pizza pza = new Pizza('m', "Thin", toppings, 3, 0.00, 1);

        pza.finalizeCost();

        System.out.println();
        System.out.println("Testing Pizza Class");
        System.out.println("---");
        System.out.println("Size: " + pza.getSize());
        System.out.println("Crust: " + pza.getCrust());

        ArrayList<String> tempTops = pza.getToppings();

        for(int i = 0; i < tempTops.size(); i++)
        {
            System.out.println("Toppings: " + tempTops.get(i));
        }

        System.out.println("topCount: " + pza.getTopCount());
        System.out.println("Cost: " + pza.getCost());
        System.out.println("pizzaKey: " + pza.getPizzaKey());
        System.out.println();

        //Beverage testing
        Beverage bev = new Beverage('m', 0.00, "Dr. Pepper", 1);

        bev.finalizeCost();

        System.out.println("Testing Beverage Class");
        System.out.println("---");
        System.out.println("Size: " + bev.getSize());
        System.out.println("Name: " + bev.getName());
        System.out.println("Cost: " + bev.getCost());
        System.out.println("BevID: " + bev.getID());
        System.out.println();

        //Customer testing
        Customer cust = new Customer("6784518664", "John Doe", "123 Fake St.", "MasterCard","Testing.");

        System.out.println("Testing Customer Class");
        System.out.println("---");
        System.out.println("Phone #: " + cust.getPhoneNum());
        System.out.println("Name: " + cust.getName());
        System.out.println("Address: " + cust.getAddress());
        System.out.println("Charge Type: " + cust.getChargeType());
        System.out.println("Special Info: " + cust.getSpecialInfo());
        System.out.println();

        //Order testing
        ArrayList<Pizza> pzas = new ArrayList<>();
        pzas.add(pza);

        ArrayList<Beverage> bevs = new ArrayList<>();
        bevs.add(bev);

        Order ord = new Order(1, 0.00, cust, pzas, bevs, true);
        ord.finalizeCost();

        System.out.println("Testing Order Class");
        System.out.println("---");
        System.out.println("OrderID: " + ord.getOrderID());
        System.out.println("Total cost: " + ord.getTotalCost());

        boolean custPop = false;

        if((ord.getCust()).getPhoneNum().equals("6784518664"))
        {
            custPop = true;
        }

        System.out.println("Customer populated: " + custPop);

        boolean pzaPop = false;

        if((pzas.get(0)).getPizzaKey() == 1)
        {
            pzaPop = true;
        }

        System.out.println("Pizzas populated: " + pzaPop);

        boolean bevPop = false;

        if((bevs.get(0)).getID() == 1)
        {
            bevPop = true;
        }

        System.out.println("Bevs populated: " + bevPop);
        System.out.println("Delivery: " + ord.getDelivery());

        System.out.println();

        System.out.println("Testing complete.");
    }
}
