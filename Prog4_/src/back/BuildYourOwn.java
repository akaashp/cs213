package back; /**
 * This class defines the properties and methods of BuildYourOwn, a subclass of Pizza. BuildYourOwn implements
 * pizzaPrice()to return price for pizza and overrides the toString method to return additional class-specific
 * information
 *
 * @author  Akaash Patel, Yanheng Zhang
 */

import java.util.ArrayList;

public class BuildYourOwn extends Pizza {
    public static final int SML_BYO_PRICE = 5;
    public static final int MED_BYO_PRICE = 7;
    public static final int LRG_BYO_PRICE = 9;
    public static final int PRICE_PER_TOPPING = 2;

    /**
     * Constructor for BuildYourOwn pizza
     * @param size Size of Hawaiian pizza
     */
    public BuildYourOwn(String size, ArrayList<String> toppings){
        super("Build Your Own", size, toppings);
    }

    /**
     * Returns price of BuildYourOwn pizza
     * @return Int, using one of the three static variables and price per topping multiplied by size of topping list
     */
    public int pizzaPrice(){
        if (size.equals("small")){
            return SML_BYO_PRICE + toppings.size() * PRICE_PER_TOPPING;
        }
        else if (size.equals("medium")){
            return MED_BYO_PRICE + toppings.size() * PRICE_PER_TOPPING;
        }
        else {
            return LRG_BYO_PRICE + toppings.size() * PRICE_PER_TOPPING;
        }
    }

    /**
     * Overrides toString of parent class Pizza, calling the super method and adding price value to the end
     * of the return value
     * @return String representation of BuildYourOwn pizza
     */
    public String toString(){
        return super.toString() + "\n" + this.pizzaPrice();
    }

    public void addTopping(String s){
        toppings.add(s);

    }

}