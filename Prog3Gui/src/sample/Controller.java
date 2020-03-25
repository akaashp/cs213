package sample;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import Prog2.*;

import static sample.Main.sList;

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
        String firstName, lastName;
        int credit;
        if (!fName.getText().equals("")){
            firstName = fName.getText();
        }else{
            outputArea.appendText("Need a first name!\n");
            return;
        }

        if (!lName.getText().equals("")){
            lastName = lName.getText();
        }else{
            outputArea.appendText("Need a last name!\n");
            return;
        }
        //need to check if credits are numeric
        if (!numCredits.getText().equals("")){
            credit = Integer.parseInt(numCredits.getText());
            if (credit<1 || (credit<9 && internationalRadio.isSelected())){
                outputArea.appendText("Invalid number of credits!\n");
                return;
            }
        }else{
            outputArea.appendText("No credits!\n");
            return;
        }


        if (inStateRadio.isSelected()){
            int funds = Integer.parseInt(fundingBox.getText());
            Instate tempStu = new Instate(firstName, lastName, credit, funds);
            if (containsStudent(tempStu)) return;

            sList.add(tempStu);

        }else if (outStateRadio.isSelected()){
            boolean triState = triStateStu.isSelected();
            Outstate tempStu = new Outstate(firstName, lastName, credit, triState);
            if (containsStudent(tempStu)) return;

            sList.add(tempStu);

        }else if (internationalRadio.isSelected()){
            boolean exchange = exchangeStu.isSelected();
            International tempStu = new International(firstName, lastName, credit, exchange);
            if (containsStudent(tempStu)) return;

            sList.add(tempStu);

        }

    }

    private boolean containsStudent(Student s){
        if(sList.contains(s)){
            outputArea.appendText("Duplicate Student!\n");
            return true;
        }
        return false;
    }

    public void removeClick(MouseEvent mouseEvent) {
    }

    public void printClick(MouseEvent mouseEvent) {
    }
}
