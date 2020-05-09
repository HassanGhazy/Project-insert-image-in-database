/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

/**
 *
 * @author HAS
 */
public class Navigation {
       public final  String fxmlMain="/view/start.fxml";
       public final  String fxmlShowImage="/view/showImage.fxml";
       public final  String fxmlinsertImage="/view/insertImage.fxml";
       
       public void navto(Parent rootpane , String path){
           try {
               Parent root =  FXMLLoader.load(getClass().getResource(path));
               rootpane.getScene().setRoot(root);
           } catch (Exception e) {
           }
           
       }
}
