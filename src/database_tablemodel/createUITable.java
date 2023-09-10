/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package database_tablemodel;


import java.awt.BorderLayout;
import java.awt.*;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author macbookairm1
 */
public class createUITable extends JFrame implements ActionListener{
    JTable table;
    JButton btnAdd, btnUpdate;
    JTextField edtTen,edtGioitinh;
    //JLabel lbTen,lbGioiTinh;
    JPanel panel,panelSouth;
    connect_database _conn;
    tabelmodel _tb;
    JOptionPane message;
    createUITable(tabelmodel tb,connect_database conn) {
        //parameters
        _conn = conn;
        _tb = tb;
        //panel
        panelSouth = new JPanel(new GridLayout(2,1));
        panel = new JPanel();
        panel.setLayout(new FlowLayout());
        //button
        btnUpdate = new JButton("Cap nhat");
        btnAdd = new JButton("Them");
        //textfield
        edtTen = new JTextField("",20 );
        edtGioitinh = new JTextField(20);
        
        panelSouth.add(btnAdd);
        panelSouth.add(btnUpdate);
        panel.add(edtTen);
        panel.add(edtGioitinh);
        //add vao actionlistener
        btnAdd.addActionListener(this);
        btnUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               tb.fireTableDataChanged();
        //JOptionPane.showMessageDialog(this, "Them thanh cong");
            }
        });
                
         
        this.add(panel,BorderLayout.CENTER);
        this.add(panelSouth,BorderLayout.SOUTH);
        table = new JTable(tb);
        JScrollPane scroll = new JScrollPane(table);
        scroll.setPreferredSize(table.getPreferredSize());
        this.add(scroll,BorderLayout.NORTH);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(400, 300);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       {
        _conn.insertSql(edtTen.getText(), edtGioitinh.getText());
        JOptionPane.showMessageDialog(this, "Them thanh cong");
        }
                
    }
    
}
