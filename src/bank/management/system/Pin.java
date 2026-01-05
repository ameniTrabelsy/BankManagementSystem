package bank.management.system;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Image;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

public class Pin extends JFrame implements ActionListener {
    JButton b1;
    JButton b2;
    JPasswordField p1;
    JPasswordField p2;
    String pin;

    Pin(String pin) {
        this.pin = pin;
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/ensemble-distributeur-automatique-billets-realiste-isole-distributeur-automatique-billets-banque-atm-fente-pour-clavier-interface-pour-carte_320857-1122.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1350, 700, 1);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l3 = new JLabel(i3);
        l3.setBounds(0, 0, 1350, 700);
        this.add(l3);
        JLabel l1 = new JLabel("CHANGE YOUR PIN ");
        l1.setForeground(Color.WHITE);
        l1.setFont(new Font("System", 1, 14));
        l1.setBounds(460, 265, 500, 35);
        l3.add(l1);
        JLabel l2 = new JLabel("New PIN:");
        l2.setForeground(Color.WHITE);
        l2.setFont(new Font("System", 1, 12));
        l2.setBounds(460, 290, 250, 35);
        l3.add(l2);
        this.p1 = new JPasswordField();
        this.p1.setBackground(new Color(65, 125, 128));
        this.p1.setBounds(590, 295, 150, 25);
        this.p1.setFont(new Font("Raleway", 1, 16));
        l3.add(this.p1);
        JLabel label3 = new JLabel("Re-Enter New PIN:");
        label3.setForeground(Color.WHITE);
        label3.setFont(new Font("System", 1, 12));
        label3.setBounds(460, 320, 250, 35);
        l3.add(label3);
        this.p2 = new JPasswordField();
        this.p2.setBackground(new Color(65, 125, 128));
        this.p2.setBounds(590, 322, 150, 25);
        this.p2.setFont(new Font("Raleway", 1, 16));
        l3.add(this.p2);
        this.b1 = new JButton("CHANGE");
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
        this.setSize(1350, 900);
        this.setLayout((LayoutManager)null);
        this.setVisible(true);
        this.setLocation(0, 0);
    }

    public static void main(String[] args) {
        new Pin("");
    }

    public void actionPerformed(ActionEvent e) {
        try {
            String pin1 = this.p1.getText();
            String pin2 = this.p2.getText();
            if (!pin1.equals(pin2)) {
                JOptionPane.showMessageDialog((Component)null, "Entered PIN doesn't match ");
                return;
            }

            if (e.getSource() == this.b1) {
                if (this.p1.getText().equals("")) {
                    JOptionPane.showMessageDialog((Component)null, "Enter New PIN");
                    return;
                }

                if (this.p2.getText().equals("")) {
                    JOptionPane.showMessageDialog((Component)null, "Re-Enter New PIN");
                    return;
                }

                Con c = new Con();
                String q1 = "update bank set pin = '" + pin1 + "' where pin = '" + this.pin + "'";
                String q2 = "update login set pin = '" + pin1 + "' where pin = '" + this.pin + "'";
                String q3 = "update signupthree set pin = '" + pin1 + "' where pin = '" + this.pin + "'";
                c.statement.executeUpdate(q1);
                c.statement.executeUpdate(q2);
                c.statement.executeUpdate(q3);
                JOptionPane.showMessageDialog((Component)null, "PIN has been changed successfully");
                this.setVisible(false);
                new main_Class(this.pin);
            } else if (e.getSource() == this.b2) {
                new main_Class(this.pin);
                this.setVisible(false);
            }
        } catch (Exception E) {
            E.printStackTrace();
        }

    }
}
