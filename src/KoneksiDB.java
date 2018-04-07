

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Fajar
 */
import java.sql.*;
import java.sql.SQLException;
public class KoneksiDB {
Connection conn ;
public static Connection ConnectDB() throws SQLException {
try {
 //ORACLE
// Class.forName("oracle.jdbc.driver.OracleDriver");
// Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","hr","hr");

//SQLite
//JFileChooser jChooser = new JFileChooser();
//jChooser.showOpenDialog(null);
//jChooser.setMultiSelectionEnabled(false);
//File file = jChooser.getSelectedFile();
//Class.forName("org.sqlite.JDBC");
//Connection conn = DriverManager.getConnection("jdbc:sqlite:"+jChooser.getSelectedFile().toString());


//MySQL
//String x = JOptionPane.showInputDialog("Masukkan Nama Host");
Class.forName("com.mysql.jdbc.Driver");
Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/pkl","root","");

return conn;
}
catch (ClassNotFoundException | SQLException ex){
System.out.println(ex);
return null;
}

} 
}
