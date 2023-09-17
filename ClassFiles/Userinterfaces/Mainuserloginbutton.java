package ClassFiles.Userinterfaces;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Anojan
 */

import UserInterface.Login_;
import UserInterface.Display2;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Mainuserloginbutton {
    public void save(){


       String sql = "SELECT * FROM `user` WHERE UserID=? and Passsword=?";
        try{
            Login_ ep = new Login_();
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/fct_smcanteen","root","");
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, ep.txtusername.getText());
            pst.setString(2, ep.txtpassword.getText());
            ResultSet rs = pst.executeQuery();
            if (rs.next()){
                Display2 op = new Display2 ();
                op.setVisible(true);
                op.pack();
                op.setLocale(null);
                op.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                
                op.userid.setText(rs.getString(1));
                op.jLabel3.setText("Accounter's Name: "+rs.getString(2));
                op.inputss.setText(rs.getString(4));
                op.dispose();
                
            }
            else
            {
                ep.txtusername.setText("");
                ep.txtpassword.setText("");
                ep.txtusername.requestFocus();
                JOptionPane.showConfirmDialog(null, "Not Mached UserName & PassWord");
                        
            }

        }catch(Exception ex){
            JOptionPane.showConfirmDialog(null, ex);
        }
        
}
    
    public void rease(){
        Login_ ep = new Login_();
        ep.txtusername.setText("");
        ep.txtpassword.setText("");
        ep.txtusername.requestFocus();
}
    

    public void dispose() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
