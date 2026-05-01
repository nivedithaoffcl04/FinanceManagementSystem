package com.finance;

import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class AddIncome extends JFrame {

    JTextField sourceField, amountField;
    int userId;

    public AddIncome(int userId) {
        this.userId = userId;

        setTitle("Add Income");
        setSize(350, 250);
        setLocationRelativeTo(null);
        setLayout(null);

        JLabel title = new JLabel("Add Income");
        title.setFont(new Font("Arial", Font.BOLD, 16));
        title.setBounds(120, 10, 150, 30);
        add(title);

        JLabel l1 = new JLabel("Source:");
        JLabel l2 = new JLabel("Amount:");

        sourceField = new JTextField();
        amountField = new JTextField();

        l1.setBounds(30, 60, 100, 25);
        sourceField.setBounds(120, 60, 150, 25);

        l2.setBounds(30, 100, 100, 25);
        amountField.setBounds(120, 100, 150, 25);

        JButton btn = new JButton("Add");
        btn.setBounds(110, 150, 100, 30);

        add(l1); add(sourceField);
        add(l2); add(amountField);
        add(btn);

        btn.addActionListener(e -> addIncome());

        setVisible(true);
    }

    void addIncome() {
        try {
            Connection con = DBConnection.getConnection();

            PreparedStatement ps = con.prepareStatement(
                "INSERT INTO income(user_id, source, amount, date) VALUES(?,?,?,CURDATE())"
            );

            ps.setInt(1, userId);
            ps.setString(2, sourceField.getText());
            ps.setDouble(3, Double.parseDouble(amountField.getText()));

            ps.executeUpdate();

            JOptionPane.showMessageDialog(this, "Income Added!");

            sourceField.setText("");
            amountField.setText("");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}