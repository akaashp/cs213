package back;

/**
 * This class defines the properties and methods of Deluxe, a subclass of Pizza. Deluxe implements pizzaPrice()
 * to return price for pizza and overrides the toString method to return additional class-specific information
 *
 * @author  Akaash Patel, Yanheng Zhang
 */

public class Deluxe extends Pizza {
    public static final int SML_DELUXE_PRICE = 14;
    public static final int MED_DELUXE_PRICE = 16;
    public static final int LRG_DELUXE_PRICE = 18;

    /**
     * Constructor for Deluxe pizza
     * @param size Size of Deluxe pizza
     */
    public Deluxe(String size){
        super("deluxe", size);
    }

    /**
     * Returns price of Deluxe pizza
     * @return Int, using one of the three static variables
     */
    public int pizzaPrice(){
        if (size.equals("small")){
            return SML_DELUXE_PRICE;
        }
        else if (size.equals("medium")){
            return MED_DELUXE_PRICE;
        }
        else {
            return LRG_DELUXE_PRICE;
        }
    }

    /**
     * Overrides toString of parent class Pizza, calling the super method and adding price value to the end
     * of the return value
     * @return String representation of Deluxe pizza
     */
    public String toString(){
        return super.toString() + " " + this.pizzaPrice();
    }

}