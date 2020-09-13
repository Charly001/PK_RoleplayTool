/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package diccionariopainkiller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Carlo
 */
public class DBConnection {
    
        public static void dbConnect(String sqlQuery, int starterColumn, int finalColumn){
        try {
            //Conectando a la BD y realizando la consulta
            Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/pk?serverTimezone=UTC", "root", "");
            Statement s = c.createStatement();
            ResultSet rs = s.executeQuery(sqlQuery);
            
            //Estableciendo el minimo y maximo de columnas posibles
            ResultSetMetaData rsmd = rs.getMetaData();
            if(finalColumn>rsmd.getColumnCount() || finalColumn<=0 || finalColumn<=starterColumn){
                finalColumn = rsmd.getColumnCount();
            }
            if(starterColumn>rsmd.getColumnCount() || starterColumn>=finalColumn || starterColumn==0 ){
                starterColumn = 1;    
            }
            
            //Recorriendo el contenido del resulset
            while(rs.next()){
                for(int i=starterColumn; i<=finalColumn ;i++){
                    System.out.print(rs.getString(i) + " ");
                }
                System.out.println("\n");
            }
            s.close();
            c.close();
        } catch (SQLException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//Metodo para conectar a la bdd
}
