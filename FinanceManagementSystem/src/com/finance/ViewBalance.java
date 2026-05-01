package com.finance;

import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class ViewBalance extends JFrame {

    public ViewBalance(int userId){

        setTitle("Balance Summary");
        setSize(350,250);
        setLocationRelativeTo(null);
        setLayout(null);

        JLabel title = new JLabel("Balance Summary");
        title.setFont(new Font("Arial", Font.BOLD, 16));
        title.setBounds(90, 10, 200, 30);
        add(title);

        JLabel l1 = new JLabel("Total Income:");
        JLabel l2 = new JLabel("Total Expense:");
        JLabel l3 = new JLabel("Remaining:");

        JLabel v1 = new JLabel();
        JLabel v2 = new JLabel();
        JLabel v3 = new JLabel();

        l1.setBounds(30, 60, 150, 25);
        v1.setBounds(180, 60, 150, 25);

        l2.setBounds(30, 90, 150, 25);
        v2.setBounds(180, 90, 150, 25);

        l3.setBounds(30, 120, 150, 25);
        v3.setBounds(180, 120, 150, 25);

        add(l1); add(v1);
        add(l2); add(v2);
        add(l3); add(v3);

        try {
            Connection con = DBConnection.getConnection();

            PreparedStatement ps1 = con.prepareStatement(
                "SELECT SUM(amount) FROM income WHERE user_id=?"
            );
            ps1.setInt(1, userId);
            ResultSet r1 = ps1.executeQuery();

            double income = 0;
            if(r1.next()) income = r1.getDouble(1);

            PreparedStatement ps2 = con.prepareStatement(
                "SELECT SUM(amount) FROM expense WHERE user_id=?"
            );
            ps2.setInt(1, userId);
            ResultSet r2 = ps2.executeQuery();

            double expense = 0;
            if(r2.next()) expense = r2.getDouble(1);

            double balance = income - expense;

            v1.setText(String.valueOf(income));
            v2.setText(String.valueOf(expense));
            v3.setText(String.valueOf(balance));

        } catch(Exception e){
            e.printStackTrace();
        }

        setVisible(true);
    }
}