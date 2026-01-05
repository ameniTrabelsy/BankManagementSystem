package bank.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class BalanceEnquriy extends JFrame implements ActionListener {
    String pin;
    JLabel l2;
    JButton b1;

    BalanceEnquriy(String pin) {
        this.pin = pin;
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/ensemble-distributeur-automatique-billets-realiste-isole-distributeur-automatique-billets-banque-atm-fente-pour-clavier-interface-pour-carte_320857-1122.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1350, 700, 1);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l3 = new JLabel(i3);
        l3.setBounds(0, 0, 1350, 700);
        this.add(l3);
        JLabel l1 = new JLabel("Your current balance is DT");
        l1.setForeground(Color.WHITE);
        l1.setFont(new Font("System", 1, 16));
        l1.setBounds(500, 270, 500, 35);
        l3.add(l1);
        this.l2 = new JLabel();
        this.l2.setForeground(Color.WHITE);
        this.l2.setFont(new Font("System", 1, 16));
        this.l2.setBounds(500, 290, 500, 35);
        l3.add(this.l2);
        this.b1 = new JButton("Back");
        this.b1.setBounds(810, 390, 120, 20);
        this.b1.setBackground(new Color(65, 125, 128));
        this.b1.setForeground(Color.WHITE);
        this.b1.addActionListener(this);
        l3.add(this.b1);
        int balance = 0;

        try {
            Con c = new Con();
            ResultSet resultSet = c.statement.executeQuery("select * from bank where pin ='" + pin + "'");

            while(resultSet.next()) {
                if (resultSet.getString("type").equals("Deposit")) {
                    balance += Integer.parseInt(resultSet.getString("amount"));
                } else {
                    balance -= Integer.parseInt(resultSet.getString("amount"));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        this.l2.setText("" + balance);
        this.setLayout((LayoutManager)null);
        this.setVisible(true);
        this.setSize(1350, 900);
        this.setLocation(0, 0);
    }

    public void actionPerformed(ActionEvent e) {
        this.setVisible(false);
        new main_Class(this.pin);
    }

    public static void main(String[] args) {
        new BalanceEnquriy("");
    }
}
