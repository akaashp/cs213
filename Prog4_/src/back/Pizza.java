package back;
/**
 * This class defines the properties and methods of Pizza, an abstract class with properties including
 * style, size, and toppings. Methods are constructing a pizza with or without toppings, and for returning
 * Pizza properties in String form.
 *
 * @author  Akaash Patel, Yanheng Zhang
 */

import java.util.ArrayList;

public abstract class Pizza {
    protected String style;
    protected String size;
    protected ArrayList<String> toppings;

    /**
     * Constructor for Pizza with toppings
     * @param style Style of the pizza; Deluxe, Hawaiian, or Build-Your-Own
     * @param size Size of the pizza; small (10"), medium (12"), or large (14")
     * @param toppings Toppings requested on pizza, up to 10
     */
    public Pizza(String style, String size, ArrayList<String> toppings){
        this.style = style;
        this.size = size;
        this.toppings = toppings;
    }

    /**
     * Constructor for Pizza without toppings (speciality pizzas).
     * @param style Style of the pizza; Deluxe or Hawaiian
     * @param size Size of the pizza; small (10"), medium (12"), or large (14")
     */
    public Pizza(String style, String size){
        this.style = style;
        this.size = size;
    }

    public abstract int pizzaPrice();

    /**
     * Returns String representation of Pizza.
     * @return String containing style, size, and toppings
     */
    public String toString(){
        String ret = style + " " + size + " ";
        for (int i = 0; i<toppings.size(); i++){
            ret += toppings.get(i);
        }
        return ret.substring(0, ret.length()-1);
    }
}