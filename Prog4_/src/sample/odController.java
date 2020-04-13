package sample;

/**
 * This class defines the properties and methods of a Controller that will interact with the secondary Gui. It contains
 * methods that are used to process input given by the user on the second fxml (orderDetails.fxml)
 *
 * @author  Akaash Patel, Yanheng Zhang
 */


import back.Pizza;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import java.io.IOException;


import static sample.Main.pizzaList;

public class odController {

    private int totalCost;
    @FXML
    private AnchorPane rootPane;
    @FXML
    private TextArea orderArea;
    @FXML
    private TextField totalField;
    @FXML
    private Button goBack;
    @FXML
    private Button clearOrder;

    /**
     * method that is run when this controller is initialized. Displays full order details in orderArea
     * and displays the total cost in totalField
     */
    @FXML
    public void initialize(){
        for (Pizza p : pizzaList){
            orderArea.appendText(p.toString()+"\n");
            totalCost += p.pizzaPrice();
        }
        totalField.appendText(String.valueOf(totalCost));
    }

    /**
     * Handles clicking the clear order button. Clears the entire order from pizzaList and GUI displays.
     * @param mouseEvent Event to be handled
     */
    public void clearOrderClicked(MouseEvent mouseEvent) {
        pizzaList.clear();
        totalField.clear();
        orderArea.clear();
        orderArea.appendText("Order Cleared!\n");
    }

    /**
     * Handles clicking the back button. Returns user to the primary order screen.
     * @param mouseEvent Event to be handled
     * @throws IOException Upon unsuccessful load of Resource
     */
    public void backClicked(MouseEvent mouseEvent) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("sample.fxml"));
        rootPane.getChildren().setAll(pane);
    }
}