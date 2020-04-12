package sample;

/**
 * This class defines the properties and methods of a Controller that will interact with the Gui. It contains
 * methods that are used to process input given by the user.
 *
 * @author  Akaash Patel, Yanheng Zhang
 */

import back.Pizza;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;


public class Controller {

    ObservableList<String> defaultToppings = FXCollections.observableArrayList("Beef", "Cheese", "Chicken", "Green Pepper",
            "Ham", "Mushroom", "Onion", "Pepperoni", "Pineapple", "Sausage");
    ObservableList<String> remainingToppings = FXCollections.observableArrayList("Beef", "Cheese", "Chicken", "Green Pepper",
            "Ham", "Mushroom", "Onion", "Pepperoni", "Pineapple", "Sausage");
    ObservableList<String> toppingsSelectedList = FXCollections.observableArrayList();


    @FXML
    private ListView<String> Toppings;
    @FXML
    private ListView<String> ToppingsSelected;

    @FXML
    private Button addTop;
    @FXML
    private Button removeTop;
    @FXML
    private Button clearSel;
    @FXML
    private Button addToOrder;
    @FXML
    private Button showOrder;

    @FXML
    public void initialize(){
        Toppings.setItems(defaultToppings);

    }

    public void AddTopClicked(MouseEvent mouseEvent) {
        String tempTop = Toppings.getSelectionModel().getSelectedItem();
        if (tempTop == null) return;
        remainingToppings.remove(tempTop);
        Toppings.setItems(remainingToppings);
        toppingsSelectedList.add(tempTop);
        ToppingsSelected.setItems(toppingsSelectedList);
    }

    public void removeTopClicked(MouseEvent mouseEvent) {
        String tempTop = ToppingsSelected.getSelectionModel().getSelectedItem();
        if (tempTop == null) return;
        toppingsSelectedList.remove(tempTop);
        ToppingsSelected.setItems(toppingsSelectedList);
        remainingToppings.add(tempTop);
        Toppings.setItems(remainingToppings);
    }

    public void clearSelClicked(MouseEvent mouseEvent) {
        remainingToppings.addAll(toppingsSelectedList);
        toppingsSelectedList.clear();
        ToppingsSelected.setItems(toppingsSelectedList);
    }

    public void addToOrderClicked(MouseEvent mouseEvent) {


    }

    public void showOrderClicked(MouseEvent mouseEvent) {

    }
}
