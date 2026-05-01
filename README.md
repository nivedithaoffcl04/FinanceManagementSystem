# 💰 Digital Personal Finance Management System

A simple desktop-based application developed using Core Java, Swing, JDBC, and MySQL to manage personal finances efficiently. This system allows users to track income, record expenses, and view overall financial balance in an easy-to-use interface.

---

## 🚀 Features

- Add Income (Salary, Freelance, etc.)
- Add Expense (Food, Travel, Shopping, etc.)
- View Transactions (Income & Expense)
- Calculate Remaining Balance
- Auto-refresh input fields after submission
- User-friendly GUI using Java Swing

---

## 🛠️ Technologies Used

- Java (Core Java)
- Swing (GUI)
- JDBC (Java Database Connectivity)
- MySQL (Database)

---

## 🧱 Project Structure

com.finance  
├── Main.java  
├── Dashboard.java  
├── AddIncome.java  
├── AddExpense.java  
├── ViewTransactions.java  
├── ViewBalance.java  
└── DBConnection.java  

---

## 🗄️ Database Setup

Run the following SQL commands:

CREATE DATABASE finance_db;
USE finance_db;

CREATE TABLE income (
    id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT,
    source VARCHAR(50),
    amount DOUBLE,
    date DATE
);

CREATE TABLE expense (
    id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT,
    category VARCHAR(50),
    amount DOUBLE,
    date DATE
);

---

## ▶️ How to Run

1. Clone the repository  
2. Open in Eclipse IDE  
3. Add MySQL Connector JAR to the project  
4. Update database username & password in DBConnection.java  
5. Run Main.java  

---

## 🧪 Sample Usage

- Add Income → Salary: 5000  
- Add Expense → Food: 200  
- View Balance → Remaining: 4800  

---

## 🎯 Purpose

This project demonstrates Java Swing GUI development, JDBC connectivity, and basic financial management.

---

## 📌 Future Enhancements

- Graphs and charts  
- Delete / Update transactions  
- Dark mode UI  
- Multi-user login system  

---

## 👩‍💻 Author

Your Name
