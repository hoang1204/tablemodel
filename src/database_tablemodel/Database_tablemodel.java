/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package database_tablemodel;

/**
 *
 * @author macbookairm1
 */
public class Database_tablemodel {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        connect_database cn = new connect_database();
        cn.connect();
        cn.showData(cn.getAllData());
        //cn.insertSql( "Nguyen Van H", "Nam");
        tabelmodel tb = new tabelmodel(cn.getAllData());
        createUITable cr = new createUITable(tb,cn);
    }
    
}
