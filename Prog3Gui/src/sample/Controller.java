package sample;

/**
 * This class defines the properties and methods of a Controller
 *
 * @author  Akaash Patel, Yanheng Zhang
 */

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


    /**
     * Handles the instate checkbox, disabling irrelevant options afterwards
     * @param mouseEvent Event to be handled
     */
    @FXML
    void inStateClick(MouseEvent mouseEvent) {
        funding.setDisable(false);
        triStateStu.setDisable(true);
        exchangeStu.setDisable(true);
    }

    /**
     * Handles the outstate checkbox, disabling irrelevant options afterwards
     * @param mouseEvent Event to be handled
     */
    @FXML
    void outStateClick(MouseEvent mouseEvent) {
        funding.setDisable(true);
        triStateStu.setDisable(false);
        exchangeStu.setDisable(true);
        fundingBox.setDisable(true);
    }

    /**
     * Handles the international checkbox, disabling irrelevant options afterwards
     * @param mouseEvent Event to be handled
     */
    @FXML
    void internationalClick(MouseEvent mouseEvent) {
        funding.setDisable(true);
        triStateStu.setDisable(true);
        exchangeStu.setDisable(false);
        fundingBox.setDisable(true);
    }

    /**
     * Handles the funding checkbox
     * @param mouseEvent Event to be handled
     */
    @FXML
    void fundingClick(MouseEvent mouseEvent) {
        fundingBox.setDisable(!fundingBox.isDisabled());
    }

    /**
     * Handles the add action, adding the input student into sList if valid, displaying error otherwise
     * @param mouseEvent Event to be handled
     */
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

        if (!numCredits.getText().equals("")){
            try {
                credit = Integer.parseInt(numCredits.getText());
            }catch (NumberFormatException nfe){
                outputArea.appendText("Credits must be a number!\n");
                return;
            }
            if (credit<1 || (credit<9 && internationalRadio.isSelected())){
                outputArea.appendText("Invalid number of credits!\n");
                return;
            }
        }else{
            outputArea.appendText("No credits!\n");
            return;
        }


        if (inStateRadio.isSelected()){
            int funds = 0;
            if (funding.isSelected()) {
                try {
                    funds = Integer.parseInt(fundingBox.getText());
                } catch (NumberFormatException nfe) {
                    outputArea.appendText("Funds must be a number!\n");
                    return;
                }
                if (funds < 0) {
                    outputArea.appendText("Funds cannot be negative!\n");
                    return;
                }
            }
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
        outputArea.appendText("Student successfully added!\n");
    }

    private boolean containsStudent(Student s){
        if(sList.contains(s)){
            outputArea.appendText("Duplicate Student!\n");
            return true;
        }
        return false;
    }

    /**
     * Handles the remove action, removing the input student from sList if valid and existent, displaying error
     * otherwise
     * @param mouseEvent Event to be handled
     */
    public void removeClick(MouseEvent mouseEvent) {
        if (sList.isEmpty()){
            outputArea.appendText("Student list is empty!\n");
            return;
        }
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

        if (!numCredits.getText().equals("")){
            try {
                credit = Integer.parseInt(numCredits.getText());
            }catch (NumberFormatException nfe){
                outputArea.appendText("Credits must be a number!\n");
                return;
            }
            if (credit<1 || (credit<9 && internationalRadio.isSelected())){
                outputArea.appendText("Invalid number of credits!\n");
                return;
            }
        }else{
            outputArea.appendText("No credits!\n");
            return;
        }


        if (inStateRadio.isSelected()){
            int funds = 0;
            if (funding.isSelected()) {
                try {
                    funds = Integer.parseInt(fundingBox.getText());
                } catch (NumberFormatException nfe) {
                    outputArea.appendText("Funds must be a number!\n");
                    return;
                }
                if (funds < 0) {
                    outputArea.appendText("Funds cannot be negative!\n");
                    return;
                }
            }
            Instate tempStu = new Instate(firstName, lastName, credit, funds);
            if (sList.contains(tempStu)){
                sList.remove(tempStu);
            }
            else {
                outputArea.appendText("Student not in list!\n");
                return;
            }

        }else if (outStateRadio.isSelected()){
            boolean triState = triStateStu.isSelected();
            Outstate tempStu = new Outstate(firstName, lastName, credit, triState);
            if (sList.contains(tempStu)){
                sList.remove(tempStu);
            }
            else {
                outputArea.appendText("Student not in list!\n");
                return;
            }

        }else if (internationalRadio.isSelected()){
            boolean exchange = exchangeStu.isSelected();
            International tempStu = new International(firstName, lastName, credit, exchange);
            if (sList.contains(tempStu)){
                sList.remove(tempStu);
            }
            else {
                outputArea.appendText("Student not in list!\n");
                return;
            }

        }
        outputArea.appendText("Student successfully removed!\n");
    }

    /**
     * Displays visual representation of student list in output area, with name and tuition due for each student
     * @param mouseEvent Event to be handled
     */
    public void printClick(MouseEvent mouseEvent) {
        if (sList.isEmpty()){
            outputArea.appendText("Student list is empty!\n");
            return;
        }
        else{
            String strList = "";
            for(int i = 0; i <sList.numStudents; i++){
                strList += sList.studentList[i]+ " tuition due: $"+ sList.studentList[i].tuitionDue() + "\n";
            }
            outputArea.appendText(strList+"\n");
            return;
        }
    }
}
