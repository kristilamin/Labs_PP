package main.window;
import main.deposit.Deposit;
import main.gui.BDConnection;
import main.user.AppUser;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class MyDepositWindow extends JDialog{
    private JPanel mainPanel;
    private JButton goBackButton;
    private JLabel userLoginLabel;
    private JLabel userDepositLabel;
    public MyDepositWindow(JFrame parent, AppUser appUser) {
        super (parent);
        setTitle("My Deposit");
        setContentPane(mainPanel);
        setMinimumSize(new Dimension(600, 500));
        setModal(true);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        userLoginLabel.setText(appUser.getLogin());
        try {
            BDConnection user = new BDConnection();
            String query = "select * from deposit join appuser on  deposit.depositid = appuser.depositid where appuser.login = '" + appUser.getLogin() + "'";
            Statement statement = user.getConnection().createStatement();
            statement.executeQuery(query);
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                Deposit deposit = new Deposit(resultSet.getInt(1),resultSet.getString(2),resultSet.getInt(3),resultSet.getInt(4),resultSet.getInt(5),resultSet.getInt(6));
                userDepositLabel.setText(deposit.toString());
            }
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
        goBackButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        setVisible(true);
    }
}