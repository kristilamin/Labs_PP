package main.window;
import main.gui.BDConnection;
import main.user.AppUser;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class RegistrationWindow extends JDialog {
    private JTextField loginTextField;
    private JTextField depositIdTextField;
    private JButton registerButton;
    private JButton signInButton;
    private JPanel mainPanel;
    private JPasswordField passwordField;
    private JPasswordField confirmPasswordField;
    private  static final String insertNew = "insert into appuser values(?,?,?,?)";
    public RegistrationWindow(JFrame parent) {
        super (parent);
        setTitle("Registration");
        setContentPane(mainPanel);
        setMinimumSize(new Dimension(600, 500));
        setModal(true);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (loginTextField.getText().isEmpty() || String.valueOf(passwordField.getPassword()).isEmpty() || String.valueOf(confirmPasswordField.getPassword()).isEmpty() || depositIdTextField.getText().isEmpty()){
                    JOptionPane.showMessageDialog(null,"Please, enter all fields.","Try again", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                if(!String.valueOf(passwordField.getPassword()).equals(String.valueOf(confirmPasswordField.getPassword()))){
                    JOptionPane.showMessageDialog(null,"Please, confirm your password.","Try again", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                boolean check = false;
                try {
                    BDConnection user = new BDConnection();
                    Statement statement = user.getConnection().createStatement();
                    ResultSet resultSet = statement.executeQuery("select * from deposit");
                    while (resultSet.next()) {
                        if (resultSet.getInt(1) == Integer.parseInt(depositIdTextField.getText())) {
                            String query = "select * from appuser where appuserid = (select max(appuserid) from appuser)";
                            resultSet = statement.executeQuery(query);
                            PreparedStatement preparedStatement = user.getConnection().prepareStatement(insertNew);
                            if (!resultSet.next())
                                preparedStatement.setInt(1, 1);
                            else
                                preparedStatement.setInt(1, (resultSet.getInt(1) + 1));
                            preparedStatement.setString(2, loginTextField.getText());
                            preparedStatement.setString(3, String.valueOf(passwordField.getPassword()));
                            preparedStatement.setInt(4, Integer.parseInt(depositIdTextField.getText()));
                            preparedStatement.execute();
                            dispose();
                            JOptionPane.showMessageDialog(null, "User registered successfully", "Message", JOptionPane.PLAIN_MESSAGE);
                            AppUser appUser = new AppUser(resultSet.getInt(1) + 1, loginTextField.getText(), String.valueOf(passwordField.getPassword()), Integer.parseInt(depositIdTextField.getText()));
                            new UserOptionsWindow(null, appUser);
                            check = true;
                            break;
                        }
                    }
                    if(!check){
                        JOptionPane.showMessageDialog(null, "Please, enter other Deposit ID.", "Try again", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        signInButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new EntranceWindow(null);
            }
        });
        setVisible(true);
    }
}