package bank.management.system;

import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Image;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class Signup extends JFrame implements ActionListener {
    JRadioButton r1;
    JRadioButton r2;
    JRadioButton m1;
    JRadioButton m2;
    JRadioButton m3;
    JButton next;
    JTextField textName;
    JTextField textFname;
    JTextField textEmail;
    JTextField textMs;
    JTextField textAdd;
    JTextField textCity;
    JTextField textPin;
    JTextField textState;
    JDateChooser dateChooser;
    Random ran = new Random();
    long first4;
    String first;

    Signup() {
        super("APPLICATION FORM");
        this.first4 = this.ran.nextLong() % 9000L + 1000L;
        this.first = " " + Math.abs(this.first4);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/batiment-banque_773186-1504-removebg-preview.png"));
        Image i2 = i1.getImage().getScaledInstance(100, 100, 1);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(25, 10, 100, 100);
        this.add(image);
        JLabel label1 = new JLabel("APPLICATION FORM NO" + this.first);
        label1.setBounds(160, 20, 600, 40);
        label1.setFont(new Font("Ralway", 1, 38));
        this.add(label1);
        JLabel label2 = new JLabel("Page 1");
        label2.setFont(new Font("Ralway", 1, 22));
        label2.setBounds(330, 70, 600, 30);
        this.add(label2);
        JLabel label3 = new JLabel("Personal Details");
        label3.setFont(new Font("Ralway", 1, 22));
        label3.setBounds(290, 90, 600, 30);
        this.add(label3);
        JLabel labelName = new JLabel("Name :");
        labelName.setFont(new Font("Raleway", 1, 20));
        labelName.setBounds(100, 190, 100, 30);
        this.add(labelName);
        this.textName = new JTextField();
        this.textName.setFont(new Font("Raleway", 1, 14));
        this.textName.setBounds(300, 190, 400, 30);
        this.add(this.textName);
        JLabel labelfName = new JLabel("Father's Name :");
        labelfName.setFont(new Font("Raleway", 1, 20));
        labelfName.setBounds(100, 240, 200, 30);
        this.add(labelfName);
        this.textFname = new JTextField();
        this.textFname.setFont(new Font("Raleway", 1, 14));
        this.textFname.setBounds(300, 240, 400, 30);
        this.add(this.textFname);
        JLabel DOB = new JLabel("Date Of Birth :");
        DOB.setFont(new Font("Raleway", 1, 20));
        DOB.setBounds(100, 340, 200, 30);
        this.add(DOB);
        this.dateChooser = new JDateChooser();
        this.dateChooser.setForeground(new Color(105, 105, 150));
        this.dateChooser.setBounds(300, 340, 400, 30);
        this.add(this.dateChooser);
        JLabel labelG = new JLabel("Gender :");
        labelG.setFont(new Font("Raleway", 1, 20));
        labelG.setBounds(100, 290, 200, 30);
        this.add(labelG);
        this.r1 = new JRadioButton("Male");
        this.r1.setFont(new Font("Raleway", 1, 14));
        this.r1.setBackground(new Color(222, 255, 228));
        this.r1.setBounds(300, 290, 60, 30);
        this.add(this.r1);
        this.r2 = new JRadioButton("Female");
        this.r2.setFont(new Font("Raleway", 1, 14));
        this.r2.setBackground(new Color(222, 255, 228));
        this.r2.setBounds(450, 290, 90, 30);
        this.add(this.r2);
        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(this.r1);
        buttonGroup.add(this.r2);
        JLabel labelEmail = new JLabel("Email address :");
        labelEmail.setFont(new Font("Raleway", 1, 20));
        labelEmail.setBounds(100, 390, 200, 30);
        this.add(labelEmail);
        this.textEmail = new JTextField();
        this.textEmail.setFont(new Font("Raleway", 1, 14));
        this.textEmail.setBounds(300, 390, 400, 30);
        this.add(this.textEmail);
        JLabel labelMs = new JLabel("Marital Status :");
        labelMs.setFont(new Font("Raleway", 1, 20));
        labelMs.setBounds(100, 440, 200, 30);
        this.add(labelMs);
        this.m1 = new JRadioButton("Married");
        this.m1.setBounds(300, 440, 100, 30);
        this.m1.setBackground(new Color(222, 255, 228));
        this.m1.setFont(new Font("Raleway", 1, 14));
        this.add(this.m1);
        this.m2 = new JRadioButton("Unmarried");
        this.m2.setBounds(450, 440, 100, 30);
        this.m2.setBackground(new Color(222, 255, 228));
        this.m2.setFont(new Font("Raleway", 1, 14));
        this.add(this.m2);
        this.m3 = new JRadioButton("Other");
        this.m3.setBounds(630, 440, 100, 30);
        this.m3.setBackground(new Color(222, 255, 228));
        this.m3.setFont(new Font("Raleway", 1, 14));
        this.add(this.m3);
        ButtonGroup buttonGroup1 = new ButtonGroup();
        buttonGroup1.add(this.m1);
        buttonGroup1.add(this.m2);
        buttonGroup1.add(this.m3);
        JLabel labelAdd = new JLabel("Address :");
        labelAdd.setFont(new Font("Raleway", 1, 20));
        labelAdd.setBounds(100, 490, 200, 30);
        this.add(labelAdd);
        this.textAdd = new JTextField();
        this.textAdd.setFont(new Font("Raleway", 1, 14));
        this.textAdd.setBounds(300, 490, 400, 30);
        this.add(this.textAdd);
        JLabel labelCity = new JLabel("City :");
        labelCity.setFont(new Font("Raleway", 1, 20));
        labelCity.setBounds(100, 540, 200, 30);
        this.add(labelCity);
        this.textCity = new JTextField();
        this.textCity.setFont(new Font("Raleway", 1, 14));
        this.textCity.setBounds(300, 540, 400, 30);
        this.add(this.textCity);
        JLabel labelPin = new JLabel("Pin Code :");
        labelPin.setFont(new Font("Raleway", 1, 20));
        labelPin.setBounds(100, 590, 200, 30);
        this.add(labelPin);
        this.textPin = new JTextField();
        this.textPin.setFont(new Font("Raleway", 1, 14));
        this.textPin.setBounds(300, 590, 400, 30);
        this.add(this.textPin);
        JLabel labelState = new JLabel("State :");
        labelState.setFont(new Font("Raleway", 1, 20));
        labelState.setBounds(100, 640, 200, 30);
        this.add(labelState);
        this.textState = new JTextField();
        this.textState.setFont(new Font("Raleway", 1, 14));
        this.textState.setBounds(300, 640, 400, 30);
        this.add(this.textState);
        this.next = new JButton("Next");
        this.next.setFont(new Font("Raleway", 1, 20));
        this.next.setBackground(Color.black);
        this.next.setForeground(Color.white);
        this.next.setBounds(640, 670, 80, 30);
        this.next.addActionListener(this);
        this.add(this.next);
        this.getContentPane().setBackground(new Color(222, 255, 228));
        this.setLayout((LayoutManager)null);
        this.setSize(850, 800);
        this.setLocation(360, 40);
        this.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        String formno = this.first;
        String name = this.textName.getText();
        String fname = this.textFname.getText();
        String dob = ((JTextField)this.dateChooser.getDateEditor().getUiComponent()).getText();
        String gender = null;
        if (this.r1.isSelected()) {
            gender = "Male";
        } else if (this.r2.isSelected()) {
            gender = "Female";
        }

        String email = this.textEmail.getText();
        String marital = null;
        if (this.m1.isSelected()) {
            marital = "Married";
        } else if (this.m2.isSelected()) {
            marital = "Unmarried";
        } else if (this.m3.isSelected()) {
            marital = "Other";
        }

        String address = this.textAdd.getText();
        String city = this.textCity.getText();
        String pincode = this.textPin.getText();
        String state = this.textState.getText();

        try {
            if (this.textName.getText().equals("")) {
                JOptionPane.showMessageDialog((Component)null, "Fill all the fields");
            } else {
                Con con1 = new Con();
                String q = "insert into signup values('" + formno + "', '" + name + "','" + fname + "','" + dob + "','" + gender + "','" + email + "','" + marital + "','" + address + "','" + city + "','" + pincode + "','" + state + "')";
                con1.statement.executeUpdate(q);
                new Signup2(formno);
                this.setVisible(false);
            }
        } catch (Exception E) {
            E.printStackTrace();
        }

    }

    public static void main(String[] args) {
        new Signup();
    }
}
