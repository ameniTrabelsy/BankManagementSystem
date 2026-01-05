package bank.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class mini extends JFrame implements ActionListener {
    String pin;
    JButton button;

    mini(String pin) {
        this.pin = pin;
        this.getContentPane().setBackground(new Color(255, 204, 204));
        this.setSize(400, 600);
        this.setLocation(20, 20);
        this.setLayout((LayoutManager)null);
        JLabel l1 = new JLabel();
        l1.setBounds(20, 140, 400, 200);
        this.add(l1);
        JLabel l2 = new JLabel("TechCoder A.V");
        l2.setFont(new Font("System", 1, 15));
        l2.setBounds(150, 20, 200, 20);
        this.add(l2);
        JLabel l3 = new JLabel();
        l3.setBounds(20, 80, 300, 40);
        this.add(l3);
        JLabel l4 = new JLabel();
        l4.setBounds(20, 400, 300, 40);
        this.add(l4);

        try {
            Con c = new Con();
            ResultSet rs = c.statement.executeQuery("select * from login where pin = '" + pin + "'");

            while(rs.next()) {
                String var10001 = rs.getString("card_number").substring(0, 4);
                l3.setText("Card Number: " + var10001 + "XXXXXXXX" + rs.getString("card_number").substring(12));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            int balance = 0;
            Con c = new Con();
            ResultSet rs = c.statement.executeQuery("select * from bank where pin = '" + pin + "'");

            while(rs.next()) {
                String var13 = l1.getText();
                l1.setText(var13 + "<html>" + rs.getString("date") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("type") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("amount") + "<br><br><html>");
                if (rs.getString("type").equals("Deposit")) {
                    balance += Integer.parseInt(rs.getString("amount"));
                } else {
                    balance -= Integer.parseInt(rs.getString("amount"));
                }
            }

            l4.setText("Your Total Balance is DT " + balance);
        } catch (Exception e) {
            e.printStackTrace();
        }

        this.button = new JButton("Exist");
        this.button.setBounds(20, 500, 100, 25);
        this.button.addActionListener(this);
        this.button.setBackground(Color.BLACK);
        this.button.setForeground(Color.WHITE);
        this.add(this.button);
        this.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        this.setVisible(false);
    }

    public static void main(String[] args) {
        new mini("");
    }
}
