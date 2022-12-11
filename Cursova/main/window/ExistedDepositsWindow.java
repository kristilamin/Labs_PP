package main.window;
import main.deposit.Deposit;
import main.gui.BDConnection;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class ExistedDepositsWindow extends JDialog{
    private JPanel mainPanel;
    JLabel existedDepositsLabel = new JLabel("Existing Deposits");
    JButton goBackButton = new JButton("Go back");
    public ExistedDepositsWindow(JFrame parent) {
        super(parent);
        setTitle("Existing Deposits");
        setContentPane(mainPanel);
        setMinimumSize(new Dimension(600, 500));
        setModal(true);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        Container container = this.getContentPane();
        container.setLayout(new GridLayout(14, 1));
        existedDepositsLabel.setFont(new Font("Palace Script MT", Font.BOLD, 45));
        existedDepositsLabel.setForeground(Color.BLACK);
        existedDepositsLabel.setHorizontalAlignment(JLabel.CENTER);
        container.add(existedDepositsLabel);
        try {
            BDConnection user = new BDConnection();
            String query = "select * from deposit order by depositid";
            Statement statement = user.getConnection().createStatement();
            statement.executeQuery(query);
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                JLabel label = new JLabel();
                Deposit deposit = new Deposit(resultSet.getInt(1),resultSet.getString(2),resultSet.getInt(3),resultSet.getInt(4),resultSet.getInt(5),resultSet.getInt(6));
                label.setText(deposit.toString());
                label.setFont(new Font("Times New Roman", Font.BOLD, 16));
                label.setForeground(Color.BLACK);
                container.add(label);
            }
            goBackButton.setFont(new Font("Times New Roman", Font.BOLD, 18));
            goBackButton.setForeground(Color.WHITE);
            goBackButton.setBackground(new Color(238,172,167));
            container.add(goBackButton);
        } catch (SQLException exception) {
            throw new RuntimeException(exception);
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