package back;

/**
 * The is a JUnit test class intended to find failures in BuildYourOwn relating to the pizzaPrice() method.
 * To test this, all three pizza sizes will be given cases to test each of the lower, higher, and in-between
 * input bounds.
 *
 * @author  Akaash Patel, Yanheng Zhang
 */

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

public class BuildYourOwnTest {

    @Test
    public void pizzaPrice() {
        //tests for three bounds of small pizzas
        ArrayList<String> smlLowerToppings = new ArrayList<String>();
        smlLowerToppings.add("cheese");
        Pizza smlLower = new BuildYourOwn("Small (10\")", smlLowerToppings);
        int smlLowerPrice = smlLower.pizzaPrice();
        assertEquals(7 , smlLowerPrice);

        ArrayList<String> smlMidToppings = new ArrayList<String>(Arrays.asList("cheese", "pepperoni", "onions"));
        Pizza smlMid = new BuildYourOwn("Small (10\")", smlMidToppings);
        int smlMidPrice = smlMid.pizzaPrice();
        assertEquals(11 , smlMidPrice);

        ArrayList<String> smlUpperToppings = new ArrayList<String>(Arrays.asList(
                "cheese", "pepperoni", "onions", "pineapple", "cumin", "sugar"));
        Pizza smlUpper = new BuildYourOwn("Small (10\")", smlUpperToppings);
        int smlUpperPrice = smlUpper.pizzaPrice();
        assertEquals(17 , smlUpperPrice);

        //tests for medium pizzas
        ArrayList<String> medLowerToppings = new ArrayList<String>();
        medLowerToppings.add("cheese");
        Pizza medLower = new BuildYourOwn("Medium (12\")", medLowerToppings);
        int medLowerPrice = medLower.pizzaPrice();
        assertEquals(9 , medLowerPrice);

        ArrayList<String> medMidToppings = new ArrayList<String>(Arrays.asList("cheese", "pepperoni", "onions"));
        Pizza medMid = new BuildYourOwn("Medium (12\")", medMidToppings);
        int medMidPrice = medMid.pizzaPrice();
        assertEquals(13 , medMidPrice);

        ArrayList<String> medUpperToppings = new ArrayList<String>(Arrays.asList(
                "cheese", "pepperoni", "onions", "pineapple", "cumin", "sugar"));
        Pizza medUpper = new BuildYourOwn("Medium (12\")", medUpperToppings);
        int medUpperPrice = medUpper.pizzaPrice();
        assertEquals(19 , medUpperPrice);

        //tests for large pizzas
        ArrayList<String> lrgLowerToppings = new ArrayList<String>();
        lrgLowerToppings.add("cheese");
        Pizza lrgLower = new BuildYourOwn("Large (14\")", lrgLowerToppings);
        int lrgLowerPrice = lrgLower.pizzaPrice();
        assertEquals(11 , lrgLowerPrice);

        ArrayList<String> lrgMidToppings = new ArrayList<String>(Arrays.asList("cheese", "pepperoni", "onions"));
        Pizza lrgMid = new BuildYourOwn("Large (14\")", lrgMidToppings);
        int lrgMidPrice = lrgMid.pizzaPrice();
        assertEquals(15 , lrgMidPrice);

        ArrayList<String> lrgUpperToppings = new ArrayList<String>(Arrays.asList(
                "cheese", "pepperoni", "onions", "pineapple", "cumin", "sugar"));
        Pizza lrgUpper = new BuildYourOwn("Large (14\")", lrgUpperToppings);
        int lrgUpperPrice = lrgUpper.pizzaPrice();
        assertEquals(21 , lrgUpperPrice);
    }
}