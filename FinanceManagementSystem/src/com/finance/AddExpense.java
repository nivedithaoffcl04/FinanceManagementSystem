package com.finance;

import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class AddExpense extends JFrame {

    JTextField categoryField, amountField;
    int userId;

    public AddExpense(int userId) {
        this.userId = userId;

        setTitle("Add Expense");
        setSize(350, 250);
        setLocationRelativeTo(null);
        setLayout(null);

        JLabel title = new JLabel("Add Expense");
        title.setFont(new Font("Arial", Font.BOLD, 16));
        title.setBounds(110, 10, 150, 30);
        add(title);

        JLabel l1 = new JLabel("Category:");
        JLabel l2 = new JLabel("Amount:");

        categoryField = new JTextField();
        amountField = new JTextField();

        l1.setBounds(30, 60, 100, 25);
        categoryField.setBounds(120, 60, 150, 25);

        l2.setBounds(30, 100, 100, 25);
        amountField.setBounds(120, 100, 150, 25);

        JButton btn = new JButton("Add");
        btn.setBounds(110, 150, 100, 30);

        add(l1); add(categoryField);
        add(l2); add(amountField);
        add(btn);

        btn.addActionListener(e -> addExpense());

        setVisible(true);
    }

    void addExpense() {
        try {
            Connection con = DBConnection.getConnection();

            PreparedStatement ps = con.prepareStatement(
                "INSERT INTO expense(user_id, category, amount, date) VALUES(?,?,?,CURDATE())"
            );

            ps.setInt(1, userId);
            ps.setString(2, categoryField.getText());
            ps.setDouble(3, Double.parseDouble(amountField.getText()));

            ps.executeUpdate();

            JOptionPane.showMessageDialog(this, "Expense Added!");

            categoryField.setText("");
            amountField.setText("");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}