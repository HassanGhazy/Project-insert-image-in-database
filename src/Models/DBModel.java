/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.postgresql.ds.PGSimpleDataSource;
import java.sql.Array;
import javafx.scene.image.Image;
import javax.swing.ImageIcon;

/**
 *
 * @author Abdallah
 */
public class DBModel {
    //here our queries method
    private DBModel(){
        schemaConnect("uni-largeSpace");
    }
     private static DBModel dbmodel = null;
     Connection con = null;
     
     
    public static DBModel getModel()
    {
        if (dbmodel == null)
        {
            dbmodel = new DBModel();
        }
        return dbmodel;
    }
    
    public void connect(){
        PGSimpleDataSource source = new PGSimpleDataSource();
        source.setServerName("localhost");
        source.setDatabaseName("Uni1");
        source.setUser("postgres");
        source.setPassword("has.sam123456789");
        
        try {
            con = source.getConnection();
            System.out.println("Connected to database");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage()); 
            //Logger.getLogger(App2.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public int isIdValid(String std_id) throws SQLException{
        //fist let's check if the its a valid ID
        PreparedStatement ps1 = con.prepareStatement("SELECT name FROM student where id = (?) ;");
        ps1.setString(1, std_id);
        ResultSet rs = ps1.executeQuery();
        if (rs.next())
            return 1;
        
        //it's not a Valid ID
        return 0; //insert failed
        
    }
          
    
    public void insertPhoto(String path, String std_id) throws SQLException, IOException{
        File file = new File(path);
        try (FileInputStream fis = new FileInputStream(file)) {
            PreparedStatement ps2 = con.prepareStatement("update student set std_pic = (?) where id = (?);");
            ps2.setString(2, std_id);
            ps2.setBinaryStream(1, fis, file.length());
            ps2.executeUpdate();
        }
            
         
    }
    
    public Image getPhoto(String std_id) throws SQLException{
        
        Image img = null;
        PreparedStatement ps = con.prepareStatement("SELECT std_pic FROM student where id = (?) ;");
        ps.setString(1, std_id);
        ResultSet rs = ps.executeQuery();
        if (rs != null) {
            while (rs.next()) {
                byte[]  imgBytes = rs.getBytes(1);
                img = new Image(new ByteArrayInputStream(imgBytes));
            }
            rs.close();
        }
        ps.close();
        return img;
    }
    
    
    public void schemaConnect(String schema){
        String sql = "set search_path to '"+ schema + "'";
        Statement s1 = null;
        try {
            connect();
            s1 = con.createStatement();
            s1.execute(sql);
            System.out.println("Connected to schema "+ schema);
        } catch (SQLException ex) {
        }finally{
            try {
                s1.close();
            } catch (SQLException ex) {
            }
        
        }
        
       }

    private void closeEverything() {
        try {
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(DBModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void exit() {
        closeEverything();
        System.out.println("Exiting... \nBye!");
        System.exit(0);
    }
    
}
