/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import Models.DBModel;
import Models.Navigation;
import java.awt.event.ActionEvent;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

/**
 *
 * @author HAS
 */
public class showImageCtrl implements Initializable {

    Navigation nav = new Navigation();
    DBModel db = DBModel.getModel();

    @FXML
    private AnchorPane rootPane;
    @FXML
    private TextField idStd;
    @FXML
    private ImageView stdImg;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }

    @FXML
    private void onShow(javafx.event.ActionEvent event) throws SQLException {
        Image img = db.getPhoto(idStd.getText());
        if (img != null) {
            stdImg.setImage(img);
            stdImg.setFitHeight(180);
            stdImg.setFitWidth(150);
        } else {

        }
    }

    @FXML
    private void onBack(javafx.event.ActionEvent event) {
        nav.navto(rootPane, nav.fxmlMain);
    }
}
