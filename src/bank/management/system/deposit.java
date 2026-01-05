package bank.management.system;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Image;
import java.awt.LayoutManager;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class deposit extends JFrame implements ActionListener {
    String pin;
    TextField textField;
    JButton b1;
    JButton b2;

    deposit(String pin) {
        this.pin = pin;
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/ensemble-distributeur-automatique-billets-realiste-isole-distributeur-automatique-billets-banque-atm-fente-pour-clavier-interface-pour-carte_320857-1122.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1350, 700, 1);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l3 = new JLabel(i3);
        l3.setBounds(0, 0, 1350, 700);
        this.add(l3);
        JLabel l1 = new JLabel("ENTER AMOUNT YOU WANT TO DEPOSIT");
        l1.setForeground(Color.WHITE);
        l1.setFont(new Font("System", 1, 16));
        l1.setBounds(500, 280, 500, 35);
        l3.add(l1);
        this.textField = new TextField();
        this.textField.setBackground(new Color(65, 125, 128));
        this.textField.setBounds(500, 310, 335, 25);
        this.textField.setFont(new Font("Raleway", 1, 16));
        l3.add(this.textField);
        this.b1 = new JButton("DEPOSIT");
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
        try {
            String amount = this.textField.getText();
            Date date = new Date();
            if (e.getSource() == this.b1) {
                if (this.textField.getText().equals("")) {
                    JOptionPane.showMessageDialog((Component)null, "Please enter the Amount you want to deposit");
                } else {
                    Con c = new Con();
                    c.statement.executeUpdate("insert into bank values ('" + this.pin + "','" + date + "','Deposit','" + amount + "')");
                    JOptionPane.showMessageDialog((Component)null, "DT. " + amount + "Deposited Successfully");
                    this.setVisible(false);
                    new main_Class(this.pin);
                }
            } else if (e.getSource() == this.b2) {
                this.setVisible(false);
                new main_Class(this.pin);
            }
        } catch (Exception E) {
            E.printStackTrace();
        }

    }

    public static void main(String[] args) {
        new deposit("");
    }
}
