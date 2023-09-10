/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package database_tablemodel;
import java.sql.*;
import java.util.Vector;
import javax.swing.table.AbstractTableModel;
/**
 *
 * @author macbookairm1
 */
public class tabelmodel extends AbstractTableModel{
    int colcount;
    Vector table = new Vector();
    tabelmodel(ResultSet rs){
        try{
            ResultSetMetaData rsm = rs.getMetaData();
            colcount = rsm.getColumnCount();
            while(rs.next()){
                Vector row=new Vector();
                for(int i=1;i<=colcount;i++)
                 {
                     row.addElement(rs.getObject(i));
                }
                table.addElement(row);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public int getRowCount() {
         return table.size();
    }

    @Override
    public int getColumnCount() {
        return colcount;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
       Vector row = (Vector) table.get(rowIndex);
    return row.get(columnIndex);
    }
}
