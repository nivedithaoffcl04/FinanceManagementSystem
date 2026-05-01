package com.finance;

import javax.swing.*;
import java.awt.*;

public class Dashboard extends JFrame {

    public Dashboard(int userId){

        setTitle("Finance Dashboard");
        setSize(450, 350);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setBackground(new Color(240, 248, 255));
        panel.setLayout(null);
        add(panel);

        JLabel title = new JLabel("Personal Finance Manager");
        title.setFont(new Font("Arial", Font.BOLD, 18));
        title.setBounds(90, 20, 300, 30);
        panel.add(title);

        JButton b1 = createButton("Add Income");
        JButton b2 = createButton("Add Expense");
        JButton b3 = createButton("View Transactions");
        JButton b4 = createButton("View Balance");

        b1.setBounds(100, 70, 220, 35);
        b2.setBounds(100, 120, 220, 35);
        b3.setBounds(100, 170, 220, 35);
        b4.setBounds(100, 220, 220, 35);

        panel.add(b1); panel.add(b2); panel.add(b3); panel.add(b4);

        b1.addActionListener(e -> new AddIncome(userId));
        b2.addActionListener(e -> new AddExpense(userId));
        b3.addActionListener(e -> new ViewTransactions(userId));
        b4.addActionListener(e -> new ViewBalance(userId));

        setVisible(true);
    }

    private JButton createButton(String text){
        JButton btn = new JButton(text);
        btn.setFocusPainted(false);
        btn.setBackground(new Color(70,130,180));
        btn.setForeground(Color.WHITE);
        btn.setFont(new Font("Arial", Font.BOLD, 14));
        return btn;
    }
}