package main.window;
import main.gui.BDConnection;
import main.user.AppUser;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class ChangeMyDepositWindow extends JDialog{
    private JPanel mainPanel;
    private JButton OKButton;
    private JButton goBackButton;
    private JTextField depositIDTextField;
    public ChangeMyDepositWindow(JFrame parent, AppUser appUser) {
        super (parent);
        setTitle("Change Deposit");
        setContentPane(mainPanel);
        setMinimumSize(new Dimension(600, 500));
        setModal(true);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        OKButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean check = false;
                try {
                    BDConnection user = new BDConnection();
                    String query = "update appuser set depositid = " + depositIDTextField.getText() + " where appuserid = " + appUser.getAppuserid();
                    Statement statement = user.getConnection().createStatement();
                    ResultSet resultSet = statement.executeQuery("select * from deposit");
                    while (true) {
                        if(!resultSet.next()) break;
                        if (resultSet.getInt(1) == Integer.parseInt(depositIDTextField.getText())) {
                            statement.executeUpdate(query);
                            dispose();
                            JOptionPane.showMessageDialog(null,"Deposit changed successfully.", "Message", JOptionPane.PLAIN_MESSAGE);
                            check = true;
                            break;
                        }
                    }
                    if(!check){
                        dispose();
                        JOptionPane.showMessageDialog(null, "Please, enter other Deposit ID.", "Try again", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (Exception exception) {
                    throw new RuntimeException(exception);
                }
            }
        });
        goBackButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        setVisible(true);
    }
}