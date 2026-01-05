package bank.management.system;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Image;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class FastCash extends JFrame implements ActionListener {
    JButton b1;
    JButton b2;
    JButton b3;
    JButton b4;
    JButton b5;
    JButton b6;
    JButton b7;
    String pin;

    FastCash(String pin) {
        this.pin = pin;
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/ensemble-distributeur-automatique-billets-realiste-isole-distributeur-automatique-billets-banque-atm-fente-pour-clavier-interface-pour-carte_320857-1122.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1350, 700, 1);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l3 = new JLabel(i3);
        l3.setBounds(0, 0, 1350, 700);
        this.add(l3);
        JLabel label = new JLabel("SELECT WITHDRAWL AMOUNT");
        label.setFont(new Font("System", 1, 28));
        label.setForeground(Color.white);
        label.setBounds(450, 270, 700, 35);
        l3.add(label);
        this.b1 = new JButton("DT. 100");
        this.b1.setForeground(Color.white);
        this.b1.setBackground(new Color(65, 125, 128));
        this.b1.setBounds(415, 333, 125, 20);
        this.b1.addActionListener(this);
        l3.add(this.b1);
        this.b2 = new JButton("DT. 500");
        this.b2.setForeground(Color.white);
        this.b2.setBackground(new Color(65, 125, 128));
        this.b2.setBounds(785, 333, 150, 20);
        this.b2.addActionListener(this);
        l3.add(this.b2);
        this.b3 = new JButton("DT. 1000");
        this.b3.setForeground(Color.white);
        this.b3.setBackground(new Color(65, 125, 128));
        this.b3.setBounds(415, 360, 125, 20);
        this.b3.addActionListener(this);
        l3.add(this.b3);
        this.b4 = new JButton("DT. 2000");
        this.b4.setForeground(Color.white);
        this.b4.setBackground(new Color(65, 125, 128));
        this.b4.setBounds(785, 360, 150, 20);
        this.b4.addActionListener(this);
        l3.add(this.b4);
        this.b5 = new JButton("DT. 5000");
        this.b5.setForeground(Color.white);
        this.b5.setBackground(new Color(65, 125, 128));
        this.b5.setBounds(415, 388, 125, 20);
        this.b5.addActionListener(this);
        l3.add(this.b5);
        this.b6 = new JButton("DT. 10000");
        this.b6.setForeground(Color.white);
        this.b6.setBackground(new Color(65, 125, 128));
        this.b6.setBounds(785, 388, 150, 20);
        this.b6.addActionListener(this);
        l3.add(this.b6);
        this.b7 = new JButton("BACK");
        this.b7.setForeground(Color.white);
        this.b7.setBackground(new Color(65, 125, 128));
        this.b7.setBounds(785, 415, 150, 20);
        this.b7.addActionListener(this);
        l3.add(this.b7);
        this.setLayout((LayoutManager)null);
        this.setSize(1350, 900);
        this.setLocation(0, 0);
        this.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.b7) {
            this.setVisible(false);
            new main_Class(this.pin);
        } else {
            String amount = ((JButton)e.getSource()).getText().substring(4);
            Con c = new Con();
            Date date = new Date();

            try {
                ResultSet resultSet = c.statement.executeQuery("select * from bank where pin='" + this.pin + "'");
                int balance = 0;

                while(resultSet.next()) {
                    if (resultSet.getString("type").equals("Deposit")) {
                        balance += Integer.parseInt(resultSet.getString("amount"));
                    } else {
                        balance -= Integer.parseInt(resultSet.getString("amount"));
                    }
                }

                String num = "17";
                if (e.getSource() != this.b7 && balance < Integer.parseInt(amount)) {
                    JOptionPane.showMessageDialog((Component)null, "Insufficient balance");
                    return;
                }

                c.statement.executeUpdate("insert into bank values('" + this.pin + "','" + date + "','withdraw','" + amount + "')");
                JOptionPane.showMessageDialog((Component)null, "Successfully deposited ");
            } catch (Exception E) {
                E.printStackTrace();
            }

            this.setVisible(false);
            new main_Class(this.pin);
        }

    }

    public static void main(String[] args) {
        new FastCash("");
    }
}
