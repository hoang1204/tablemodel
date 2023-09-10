/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package database_tablemodel;
import java.sql.*;
/**
 *
 * @author macbookairm1
 */
public class connect_database {
    Connection connection;
    public void connect(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test1", "root", "");
        }catch(ClassNotFoundException | SQLException e ){
            e.printStackTrace();
             
        }
    }
    public ResultSet getAllData(){
        ResultSet rs = null;
        String sql = "SELECT * from sinhvien";
        try{
            if (connection != null){
                Statement st = connection.createStatement();
                rs = st.executeQuery(sql);
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        
        
        return rs;
    }
    public void showData(ResultSet rs){
         try {
            while (rs.next()) {
                System.out.print("id: " + rs.getInt("id") + " - Ho ten: " + rs.getString("ten") + " - Gioi tinh: " + rs.getString("gioitinh") + "\n");

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public ResultSet getOneRow(String id){
        ResultSet rs = null;
        String sql = "SELECT * FROM sinhvien WHERE id=" + id;
        try{
            Statement st = connection.createStatement();
            rs = st.executeQuery(sql);
        }catch(SQLException e){
            e.printStackTrace();
        }
        
        
        return rs;
        
    }
    public void insertSql(String ten,String gioiTinh){
        String sql = "INSERT INTO sinhvien(ten,gioitinh) values(?,?)";
        try{
            PreparedStatement pr = connection.prepareStatement(sql);
          
            pr.setString(1, ten);
            pr.setString(2, gioiTinh);
            int n = pr.executeUpdate();
            if (n>0){
                System.out.print("THEM THANH CONG");
            }else{
                System.out.print("THEM THAT BAI");
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }
}
