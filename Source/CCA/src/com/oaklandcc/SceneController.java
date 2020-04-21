/*  
    Sa'd Arshad
    Saima Sabri
    Jordan Akmon
    Jacob Einstein
 */ 

package com.oaklandcc;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.Scanner;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;

public class SceneController implements Initializable {

    @FXML
    private ToggleGroup identity;
    @FXML
    private Slider slidThree;
    @FXML
    private Slider slidOne;
    @FXML
    private Slider slidTwo;
    @FXML
    private RadioButton maleBtn;
    @FXML
    private RadioButton femaleBtn;
    @FXML
    private RadioButton otherBtn;
    @FXML
    private ImageView displayImg;
    @FXML
    private ComboBox<String> classSelect;
    @FXML
    private TextField charName;
    
    ObservableList classes;
    
    private Image male;
    private Image female;
    private Image other;
    private Image maleKnight;
    private Image femaleKnight;
    private Image maleBeastmaster;
    private Image femaleBeastmaster;
    private Image maleMonk;
    private Image femaleMonk;
    private Image maleWizard;
    private Image femaleWizard;
    private Image maleDemonHunter;
    private Image femaleDemonHunter;
    private Image otherKnight;
    private Image otherBeastmaster;
    private Image otherMonk;
    private Image otherWizard;
    private Image otherDemonHunter;
    private Image blankImg;
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        classes = FXCollections.observableArrayList();
        classes.addAll("Warrior", "Beastmaster", "Monk", "Wizard", "Demon Hunter");
        classSelect.setItems(classes);
        
        male = new Image("./images/male.png");
        female = new Image("./images/female.png");
        other = new Image("./images/other.png");
        blankImg = new Image("./images/blankSpace.png");
        displayImg.setImage(blankImg);
        
        charName.addEventFilter(KeyEvent.KEY_TYPED, maxLength(10));
        
    }

    public EventHandler<KeyEvent> maxLength(final Integer i) {
        return new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent arg0) {
                TextField charName = (TextField) arg0.getSource();
                if(charName.getText().length() >= i) {
                    arg0.consume();
                }
            }
            
        };
    }

    @FXML
    private void maleChar(MouseEvent event) {   //sets the male picture when the male button is clicked
        classSelect.getSelectionModel().clearSelection();
        displayImg.setImage(male);
        
    }

    @FXML
    private void femChar(MouseEvent event) {    //sets the female picture when the female button is clicked
        classSelect.getSelectionModel().clearSelection();
        displayImg.setImage(female);
    }

    @FXML
    private void otherChar(MouseEvent event) {  //sets the other picture when the other button is clicked
        classSelect.getSelectionModel().clearSelection();
        displayImg.setImage(other);
    }

    @FXML
    private void selected(ActionEvent event) {  //sets the combobox array value and picture to the corresponding combination of radio button presses
        maleKnight = new Image("./images/maleKnight.png");
        femaleKnight = new Image("./images/femaleKnight.png");
        otherKnight = new Image("./images/otherWarrior.png");
        maleBeastmaster = new Image("./images/maleBeastMaster.png");
        femaleBeastmaster = new Image("./images/femaleBeastMaster.png");
        otherBeastmaster = new Image("./images/otherBeastmaster.png");
        maleMonk = new Image("./images/maleMonk.png");
        femaleMonk = new Image("./images/femaleMonk.png");
        otherMonk = new Image("./images/otherMonk.png");
        maleWizard = new Image("./images/maleWizard.png");
        femaleWizard = new Image("./images/femaleWizard.png");
        otherWizard = new Image("./images/otherWizard.png");
        maleDemonHunter = new Image("./images/maleDemonHunter.png");
        femaleDemonHunter = new Image("./images/femaleDemonHunter.png");
        otherDemonHunter = new Image("./images/otherDemonHunter.png");
                
        int selectedIndex = classSelect.getSelectionModel().getSelectedIndex();
        
        if(maleBtn.isSelected() && selectedIndex == 0) {
            displayImg.setImage(maleKnight);
        }
        if(femaleBtn.isSelected() && selectedIndex == 0) {
            displayImg.setImage(femaleKnight);
        }
        if(otherBtn.isSelected() && selectedIndex == 0) {
            displayImg.setImage(otherKnight);
        }
        if(maleBtn.isSelected() && selectedIndex == 1) {
            displayImg.setImage(maleBeastmaster);
        }
        if(femaleBtn.isSelected() && selectedIndex == 1) {
            displayImg.setImage(femaleBeastmaster);
        }
        if(otherBtn.isSelected() && selectedIndex == 1) {
            displayImg.setImage(otherBeastmaster);
        }
        if(maleBtn.isSelected() && selectedIndex == 2) {
            displayImg.setImage(maleMonk);
        }
        if(femaleBtn.isSelected() && selectedIndex == 2) {
            displayImg.setImage(femaleMonk);
        }
        if(otherBtn.isSelected() && selectedIndex == 2) {
            displayImg.setImage(otherMonk);
        }
        if(maleBtn.isSelected() && selectedIndex == 3) {
            displayImg.setImage(maleWizard);
        }
        if(femaleBtn.isSelected() && selectedIndex == 3) {
            displayImg.setImage(femaleWizard);
        }
        if(otherBtn.isSelected() && selectedIndex == 3) {
            displayImg.setImage(otherWizard);
        }
        if(maleBtn.isSelected() && selectedIndex == 4) {
            displayImg.setImage(maleDemonHunter);
        }
        if(femaleBtn.isSelected() && selectedIndex == 4) {
            displayImg.setImage(femaleDemonHunter);
        }
        if(otherBtn.isSelected() && selectedIndex == 4) {
            displayImg.setImage(otherDemonHunter);
        }
    }

    @FXML
    private void exitActionHandler(ActionEvent event) {     //Exits the program
        Platform.exit();
    }

    @FXML
    private void resetActionHandler(ActionEvent event) {    //resets all the values of 
        blankImg = new Image("./images/blankSpace.png");
        
        classSelect.getSelectionModel().clearSelection();
        maleBtn.setSelected(false);
        femaleBtn.setSelected(false);
        otherBtn.setSelected(false);
        charName.clear();
        slidOne.setValue(0.0);
        slidTwo.setValue(0.0);
        slidThree.setValue(0.0);
        displayImg.setImage(blankImg);
    }

    @FXML
    private void loadChar(ActionEvent event) {      //loads character data from a *.char file 
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open a file!");
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("character name", "*.char"));
        File file = fileChooser.showOpenDialog(null);
        
        try {
            try (Scanner infile = new Scanner(file)) {
                String input;
                while(infile.hasNext()) {
                    input = infile.nextLine();
                    if(input.equals("Male")) {
                        maleBtn.setSelected(true);
                    }
                    if (input.equals("Female")) {
                        femaleBtn.setSelected(true);
                    }
                    if(input.equals("Other")) {
                        otherBtn.setSelected(true);
                    }
                    else{
                        
                    }
                    
                    if(input.equals("Warrior")) {
                        classSelect.setValue("Warrior");
                    }
                    if(input.equals("Beastmaster")) {
                        classSelect.setValue("Beastmaster");
                    }
                    if(input.equals("Monk")) {
                        classSelect.setValue("Monk");
                    }
                    if(input.equals("Wizard")) {
                        classSelect.setValue("Wizard");
                    }
                    if(input.equals("Demon Hunter")) {
                        classSelect.setValue("Demon Hunter");
                    }
                    else {
                        
                    }
                    
                    if(input.contains("1:")) {
                        String text = input.replaceAll("1:", "");
                        double value = Double.parseDouble(text);
                        slidOne.setValue(value);
                    }
                    
                    else {
                        
                    }
                    
                    if(input.contains("2:")) {
                        String text = input.replaceAll("2:", "");
                        double value = Double.parseDouble(text);
                        slidTwo.setValue(value);
                    }
                    
                    else {
                        
                    }
                    
                    if(input.contains("3:")) {
                        String text = input.replaceAll("3:", "");
                        double value = Double.parseDouble(text);
                        slidThree.setValue(value);
                    }
                    
                    else {
                        
                    }
                    
                    if(input.contains("name:")) {
                        String text = input.replaceAll("name:", "");
                        charName.setText(text);
                    }
                    
                }
            }
        }
        
        catch(FileNotFoundException | NumberFormatException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @FXML
    private void saveChar(ActionEvent event) {  //saves character data as a *.char file extension
        
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Save Confirmation");
        alert.setContentText("Are you sure you want to save this character?");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK){
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Save this file");
            fileChooser.setInitialFileName(charName.getText());
            fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("character name", "*.char"));
            File file = fileChooser.showSaveDialog(null);
            
            try {
                
                try (FileWriter fileWriter = new FileWriter(file)) {
                    if(maleBtn.isSelected()) {
                        fileWriter.write("Male");
                    }
                    if(femaleBtn.isSelected()) {
                        fileWriter.write("Female");
                    }
                    if(otherBtn.isSelected()) {
                        fileWriter.write("Other");
                    }
                    else{
                        
                    }
                    
                    fileWriter.write("\n");
                    if(classSelect.getSelectionModel().getSelectedIndex() == 0) {
                        fileWriter.write("Warrior");
                    }
                    if(classSelect.getSelectionModel().getSelectedIndex() == 1) {
                        fileWriter.write("Beastmaster");
                    }
                    if(classSelect.getSelectionModel().getSelectedIndex() == 2) {
                        fileWriter.write("Monk");
                    }
                    if(classSelect.getSelectionModel().getSelectedIndex() == 3) {
                        fileWriter.write("Wizard");
                    }
                    if(classSelect.getSelectionModel().getSelectedIndex() == 4) {
                        fileWriter.write("Demon Hunter");
                    }
                    else {
                        
                    }
                    
                    fileWriter.write("\n");
                    fileWriter.write("1:");
                    fileWriter.write(String.valueOf(slidOne.getValue()));
                    
                    fileWriter.write("\n");
                    fileWriter.write("2:");
                    fileWriter.write(String.valueOf(slidTwo.getValue()));
                    
                    fileWriter.write("\n");
                    fileWriter.write("3:");
                    fileWriter.write(String.valueOf(slidThree.getValue()));
                    
                    fileWriter.write("\n");
                    fileWriter.write("name:");
                    if(charName != null){
                        fileWriter.write(charName.getText());
                    }
                    else {
                        
                    }
                }
            }
            
            catch (IOException e){
                
            }
        } 
        else {
            // ... user chose CANCEL or closed the dialog
        }
    }
    
}
