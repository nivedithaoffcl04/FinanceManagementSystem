package com.finance;

import javax.swing.*;
import java.sql.*;

public class ViewTransactions extends JFrame {

    public ViewTransactions(int userId){

        setTitle("Transactions");
        setSize(400,400);
        setLocationRelativeTo(null);

        JTextArea area = new JTextArea();
        add(new JScrollPane(area));

        try {
            Connection con = DBConnection.getConnection();

            PreparedStatement ps1 = con.prepareStatement(
                "SELECT * FROM income WHERE user_id=?"
            );
            ps1.setInt(1, userId);
            ResultSet r1 = ps1.executeQuery();

            area.append("---- INCOME ----\n");
            while(r1.next()){
                area.append(r1.getString("source")+" : "+r1.getDouble("amount")+"\n");
            }

            PreparedStatement ps2 = con.prepareStatement(
                "SELECT * FROM expense WHERE user_id=?"
            );
            ps2.setInt(1, userId);
            ResultSet r2 = ps2.executeQuery();

            area.append("\n---- EXPENSE ----\n");
            while(r2.next()){
                area.append(r2.getString("category")+" : "+r2.getDouble("amount")+"\n");
            }

        } catch(Exception e){
            e.printStackTrace();
        }

        setVisible(true);
    }
}