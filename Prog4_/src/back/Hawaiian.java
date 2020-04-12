package back;

/**
 * This class defines the properties and methods of Hawaiian, a subclass of Pizza. Hawaiian implements pizzaPrice()
 * to return price for pizza and overrides the toString method to return additional class-specific information
 *
 * @author  Akaash Patel, Yanheng Zhang
 */

public class Hawaiian extends Pizza {
    public static final int SML_HAWAIIAN_PRICE = 8;
    public static final int MED_HAWAIIAN_PRICE = 10;
    public static final int LRG_HAWAIIAN_PRICE = 12;

    /**
     * Constructor for Hawaiian pizza
     * @param size Size of Hawaiian pizza
     */
    public Hawaiian(String size){
        super("hawaiian", size);
    }

    /**
     * Returns price of Hawaiian pizza
     * @return Int, using one of the three static variables
     */
    public int pizzaPrice(){
        if (size.equals("small")){
            return SML_HAWAIIAN_PRICE;
        }
        else if (size.equals("medium")){
            return MED_HAWAIIAN_PRICE;
        }
        else {
            return LRG_HAWAIIAN_PRICE;
        }
    }

    /**
     * Overrides toString of parent class Pizza, calling the super method and adding price value to the end
     * of the return value
     * @return String representation of Hawaiian pizza
     */
    public String toString(){
        return super.toString() + " " + this.pizzaPrice();
    }

}