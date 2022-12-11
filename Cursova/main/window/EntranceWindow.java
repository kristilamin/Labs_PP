package main.window;
import main.gui.*;
import main.user.AppUser;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class EntranceWindow extends JDialog{
    private JTextField loginTextField;
    private JButton signInButton;
    private JButton registerButton;
    private JPanel mainPanel;
    private JPasswordField passwordField;
    public EntranceWindow(JFrame parent) {
        super (parent);
        setTitle("Entrance");
        setContentPane(mainPanel);
        setMinimumSize(new Dimension(600, 500));
        setModal(true);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        signInButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean check = false;
                try {
                    BDConnection user = new BDConnection();
                    String query = "select * from appuser";
                    Statement statement = user.getConnection().createStatement();
                    ResultSet resultSet = statement.executeQuery(query);
                    while (true){
                        if(!resultSet.next()) break;
                        if(resultSet.getString(2).equals(loginTextField.getText()) && resultSet.getString(3).equals(String.valueOf(passwordField.getPassword()))){
                            check = true;
                            dispose();
                            if(loginTextField.getText().equals("Admin"))
                                new AdminOptionsWindow(null);
                            else {
                                AppUser appUser = new AppUser(resultSet.getInt(1), loginTextField.getText(), String.valueOf(passwordField.getPassword()), resultSet.getInt(4));
                                new UserOptionsWindow(null, appUser);
                            }
                            break;
                        }
                    }
                    if(!check)
                        JOptionPane.showMessageDialog(null, "Incorrect login or password.", "Try again", JOptionPane.ERROR_MESSAGE);
                } catch (Exception exception) {
                    throw new RuntimeException(exception);
                }
            }
        });
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new RegistrationWindow(null);
            }
        });
        setVisible(true);
    }
}