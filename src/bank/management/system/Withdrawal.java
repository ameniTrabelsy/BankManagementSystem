package bank.management.system;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Image;
import java.awt.LayoutManager;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Withdrawal extends JFrame implements ActionListener {
    String pin;
    TextField textField;
    JButton b1;
    JButton b2;

    Withdrawal(String pin) {
        this.pin = pin;
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/ensemble-distributeur-automatique-billets-realiste-isole-distributeur-automatique-billets-banque-atm-fente-pour-clavier-interface-pour-carte_320857-1122.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1350, 700, 1);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l3 = new JLabel(i3);
        l3.setBounds(0, 0, 1350, 700);
        this.add(l3);
        JLabel l1 = new JLabel("MAXIMUM WITHDRAWAL IS DT.10.000");
        l1.setForeground(Color.WHITE);
        l1.setFont(new Font("System", 1, 16));
        l1.setBounds(500, 270, 500, 35);
        l3.add(l1);
        JLabel l2 = new JLabel("PLEASE ENTER YOUR AMOUNT");
        l2.setForeground(Color.WHITE);
        l2.setFont(new Font("System", 1, 16));
        l2.setBounds(500, 290, 500, 35);
        l3.add(l2);
        this.textField = new TextField();
        this.textField.setBackground(new Color(65, 125, 128));
        this.textField.setBounds(500, 320, 335, 25);
        this.textField.setFont(new Font("Raleway", 1, 16));
        l3.add(this.textField);
        this.b1 = new JButton("WITHDRAW");
        this.b1.setBounds(810, 390, 120, 20);
        this.b1.setBackground(new Color(65, 125, 128));
        this.b1.setForeground(Color.WHITE);
        this.b1.addActionListener(this);
        l3.add(this.b1);
        this.b2 = new JButton("BACK");
        this.b2.setBounds(810, 415, 120, 20);
        this.b2.setBackground(new Color(65, 125, 128));
        this.b2.setForeground(Color.WHITE);
        this.b2.addActionListener(this);
        l3.add(this.b2);
        this.setLayout((LayoutManager)null);
        this.setSize(1550, 1080);
        this.setLocation(0, 0);
        this.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.b1) {
            try {
                String amount = this.textField.getText();
                Date date = new Date();
                if (this.textField.getText().equals("")) {
                    JOptionPane.showMessageDialog(this, "Please enter the amount you want to withdraw");
                } else {
                    Con c = new Con();
                    ResultSet resultSet = c.statement.executeQuery("select * from bank where pin = '" + this.pin + "'");
                    int balance = 0;

                    while(resultSet.next()) {
                        if (resultSet.getString("type").equals("Deposit")) {
                            balance += Integer.parseInt(resultSet.getString("amount"));
                        } else {
                            balance -= Integer.parseInt(resultSet.getString("amount"));
                        }
                    }

                    if (balance < Integer.parseInt(amount)) {
                        JOptionPane.showMessageDialog((Component)null, "Insuffient balance");
                        return;
                    }

                    c.statement.executeUpdate("insert into bank values('" + this.pin + "','" + date + "','Withdrawl', '" + amount + "')");
                    JOptionPane.showMessageDialog((Component)null, "Debited Successfully");
                    this.setVisible(false);
                    new main_Class(this.pin);
                }
            } catch (Exception var7) {
            }
        } else if (e.getSource() == this.b2) {
            this.setVisible(false);
            new main_Class(this.pin);
        }

    }

    public static void main(String[] args) {
        new Withdrawal("");
    }
}
