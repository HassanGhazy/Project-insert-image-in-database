/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import Models.Navigation;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author HAS
 */
public class startCtrl implements Initializable {

    
    Navigation nav = new Navigation ();

    @FXML
    private AnchorPane rootPane;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void changeStd(ActionEvent event) {
    nav.navto(rootPane, nav.fxmlShowImage);
    }

    @FXML
    private void showButton(ActionEvent event) {
        nav.navto(rootPane, nav.fxmlinsertImage);
    }
    
}
