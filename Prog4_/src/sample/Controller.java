package sample;

/**
 * This class defines the properties and methods of a Controller that will interact with the Gui. It contains
 * methods that are used to process input given by the user.
 *
 * @author  Akaash Patel, Yanheng Zhang
 */

import back.BuildYourOwn;
import back.Deluxe;
import back.Hawaiian;
import back.Pizza;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import java.io.IOException;
import java.util.ArrayList;
import static sample.Main.pizzaList;


public class Controller {

    ObservableList<String> defaultToppings = FXCollections.observableArrayList("Beef", "Cheese", "Chicken", "Green Pepper",
            "Ham", "Mushroom", "Onion", "Pepperoni", "Pineapple", "Sausage");
    ObservableList<String> remainingToppings = FXCollections.observableArrayList("Beef", "Cheese", "Chicken", "Green Pepper",
            "Ham", "Mushroom", "Onion", "Pepperoni", "Pineapple", "Sausage");
    ObservableList<String> toppingsSelectedList = FXCollections.observableArrayList();
    ObservableList<String> pTypeList = FXCollections.observableArrayList("Build Your Own", "Deluxe", "Hawaiian");
    ObservableList<String> pSizeList = FXCollections.observableArrayList("Small (10\")", "Medium (12\")", "Large (14\")");

    @FXML
    public AnchorPane rootPane;
    @FXML
    private ComboBox<String> pType;
    @FXML
    private  ComboBox<String> pSize;
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
    private ImageView imgView;
    @FXML
    private TextArea outArea;

    /**
     *Method that is run when this controller is initialized, Populates the ImageView, comboboxes, and ListViews
     */
    @FXML
    public void initialize(){
        Toppings.setItems(defaultToppings);
        pType.setItems(pTypeList);
        pSize.setItems(pSizeList);
        pType.setValue("Build Your Own");
        pSize.setValue("Medium (12\")");
        imgView.setImage(new Image("sample/byo.png"));
    }

    /**
     * Handles clicking AddTop button, adds the selected topping given that toppingsSelected <= 6
     * @param mouseEvent Click event to be handled
     */
    public void AddTopClicked(MouseEvent mouseEvent) {
        if (toppingsSelectedList.size() > 5){
            outArea.appendText("Maximum 6 toppings!\n");
            return;
        }

        String tempTop = Toppings.getSelectionModel().getSelectedItem();
        if (tempTop == null) return;
        remainingToppings.remove(tempTop);
        Toppings.setItems(remainingToppings);
        toppingsSelectedList.add(tempTop);
        ToppingsSelected.setItems(toppingsSelectedList);
    }

    /**
     * Handles clicking remove topping button. Removes the selected topping
     * @param mouseEvent
     */
    public void removeTopClicked(MouseEvent mouseEvent) {
        String tempTop = ToppingsSelected.getSelectionModel().getSelectedItem();
        if (tempTop == null) return;
        toppingsSelectedList.remove(tempTop);
        ToppingsSelected.setItems(toppingsSelectedList);
        remainingToppings.add(tempTop);
        Toppings.setItems(remainingToppings);
    }

    /**
     * Handles clicking clear button, Clears the current toppings selected
     * @param mouseEvent
     */
    public void clearSelClicked(MouseEvent mouseEvent) {
        remainingToppings.addAll(toppingsSelectedList);
        toppingsSelectedList.clear();
        ToppingsSelected.setItems(toppingsSelectedList);
    }

    /**
     * Adds the current selection to the order given toppings>1. Adds Pizza of selected type and
     * selected parameters to pizzaList
     * @param mouseEvent Click event to be handled
     */
    public void addToOrderClicked(MouseEvent mouseEvent) {
        String tempType = pType.getSelectionModel().getSelectedItem();
        String tempSize = pSize.getSelectionModel().getSelectedItem();

        if (toppingsSelectedList.size() < 1){
            outArea.appendText("Minimum 1 topping!\n");
            return;
        }
        Pizza tempPizza;
        if (tempType.equals("Hawaiian")){
            tempPizza = new Hawaiian(tempSize);
        }else if(tempType.equals("Deluxe")){
            tempPizza = new Deluxe(tempSize);
        }else{
            ArrayList<String> tempList = new ArrayList<>(toppingsSelectedList);
            tempPizza = new BuildYourOwn(tempSize,tempList);
        }

        pizzaList.add(tempPizza);
        outArea.appendText(tempSize + " " + tempType + " pizza added to order!\n");


    }

    /**
     * Switched the FXML and controller to odController and orderDetails.fxml upon user click
     * @param mouseEvent
     * @throws IOException Upon unsuccessful load of resource
     */
    public void showOrderClicked(MouseEvent mouseEvent) throws IOException {
       AnchorPane pane = FXMLLoader.load(getClass().getResource("orderDetails.fxml"));
       rootPane.getChildren().setAll(pane);
    }

    /**
     * Depending on which pizza type is selected, makes changes to the gui such as disabling adding toppings
     * when a specialty pizza is chosen.
     * @param mouseEvent
     */
    public void typeClicked(ActionEvent mouseEvent) {

        remainingToppings.addAll(toppingsSelectedList);
        toppingsSelectedList.clear();
        ToppingsSelected.setItems(toppingsSelectedList);

        String tempType = pType.getSelectionModel().getSelectedItem();
        if (tempType.equals("Hawaiian")){
            imgView.setImage(new Image("sample/hawaiian.png"));
            remainingToppings.remove("Ham"); remainingToppings.remove("Pineapple");
            Toppings.setItems(remainingToppings);

            toppingsSelectedList.add("Ham"); toppingsSelectedList.add("Pineapple");
            ToppingsSelected.setItems(toppingsSelectedList);

            Toppings.setDisable(true);
            addTop.setDisable(true);
            removeTop.setDisable(true);
            clearSel.setDisable(true);
        }else if (tempType.equals("Deluxe")){
            imgView.setImage(new Image("sample/deluxe.png"));
            remainingToppings.remove("Sausage"); remainingToppings.remove("Pepperoni");
            remainingToppings.remove("Green Pepper"); remainingToppings.remove("Onion");
            remainingToppings.remove("Mushroom");
            Toppings.setItems(remainingToppings);

            toppingsSelectedList.add("Sausage"); toppingsSelectedList.add("Pepperoni");
            toppingsSelectedList.add("Green Pepper"); toppingsSelectedList.add("Onion");
            toppingsSelectedList.add("Mushroom");
            ToppingsSelected.setItems(toppingsSelectedList);

            Toppings.setDisable(true);
            addTop.setDisable(true);
            removeTop.setDisable(true);
            clearSel.setDisable(true);
        }else{
            imgView.setImage(new Image("sample/byo.png"));
            Toppings.setDisable(false);
            addTop.setDisable(false);
            removeTop.setDisable(false);
            clearSel.setDisable(false);

        }
    }
}
