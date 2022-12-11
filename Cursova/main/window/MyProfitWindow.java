package main.window;
import main.deposit.Profit;
import main.gui.BDConnection;
import main.user.AppUser;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class MyProfitWindow extends JDialog {
    private JPanel mainPanel;
    private JLabel userLoginLabel;
    private JLabel profitLabel;
    private JButton goBackButton;
    public MyProfitWindow(JFrame parent, AppUser appUser) {
        super (parent);
        setTitle("My Profit");
        setContentPane(mainPanel);
        setMinimumSize(new Dimension(600, 500));
        setModal(true);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        userLoginLabel.setText(appUser.getLogin());
        try {
            BDConnection user = new BDConnection();
            String query = "select * from profit join deposit on profit.depositid = deposit.depositid join appuser on  deposit.depositid = appuser.depositid where appuser.login = '" + appUser.getLogin() + "'";
            Statement statement = user.getConnection().createStatement();
            statement.executeQuery(query);
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                Profit profit = new Profit(resultSet.getInt(1),resultSet.getInt(2),resultSet.getInt(3),resultSet.getInt(4),resultSet.getInt(5));
                profitLabel.setText(profit.toString());
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