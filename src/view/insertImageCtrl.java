/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;



import Models.DBModel;
import Models.Navigation;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;

/**
 *
 * @author HAS
 */
public class insertImageCtrl implements Initializable {
    Navigation nav = new Navigation();
    DBModel db = DBModel.getModel();
    @FXML
    private TextField idStd;
    @FXML
    private TextField insert;
    @FXML
    private AnchorPane rootPane;
    @FXML
    private Label labe;
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }

    @FXML
    private void onbrowse(ActionEvent event) {
        FileChooser fc = new FileChooser();
        fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("png image", "*.png"));
        File out = fc.showOpenDialog(null);
        insert.setText(out.getAbsolutePath());
    }

    @FXML
    private void onback(ActionEvent event) {
        nav.navto(rootPane, nav.fxmlMain);
    }

    @FXML
    private void onsubmit(ActionEvent event) {
        try {
            db.insertPhoto(insert.getText(), idStd.getText());
            labe.setText("The image has submit");
        } catch (SQLException ex) {
            Logger.getLogger(insertImageCtrl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(insertImageCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
