package sample;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import Prog2.*;

public class Controller {

    @FXML
    private TextField fName;
    @FXML
    private TextField lName;
    @FXML
    private TextField numCredits;
    @FXML
    private RadioButton inStateRadio;
    @FXML
    private RadioButton outStateRadio;
    @FXML
    private RadioButton internationalRadio;
    @FXML
    private CheckBox funding;
    @FXML
    private CheckBox triStateStu;
    @FXML
    private CheckBox exchangeStu;
    @FXML
    private TextField fundingBox;
    @FXML
    private Button add;
    @FXML
    private Button remove;
    @FXML
    private Button Print;
    @FXML
    private TextArea outputArea;



    @FXML
    void inStateClick(MouseEvent mouseEvent) {
        funding.setDisable(false);
        triStateStu.setDisable(true);
        exchangeStu.setDisable(true);
    }

    @FXML
    void outStateClick(MouseEvent mouseEvent) {
        funding.setDisable(true);
        triStateStu.setDisable(false);
        exchangeStu.setDisable(true);
        fundingBox.setDisable(true);
    }

    @FXML
    void internationalClick(MouseEvent mouseEvent) {
        funding.setDisable(true);
        triStateStu.setDisable(true);
        exchangeStu.setDisable(false);
        fundingBox.setDisable(true);
    }

    @FXML
    void fundingClick(MouseEvent mouseEvent) {
        fundingBox.setDisable(!fundingBox.isDisabled());
    }


    public void addClick(MouseEvent mouseEvent) {

    }

    public void removeClick(MouseEvent mouseEvent) {
    }

    public void printClick(MouseEvent mouseEvent) {
    }
}
