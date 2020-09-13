/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package diccionariopainkiller;

import static diccionariopainkiller.DBConnection.dbConnect;

/**
 *
 * @author Carlo
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        DBConnection.dbConnect("SELECT * FROM spells", 1, 4);
        
    }


    
}


