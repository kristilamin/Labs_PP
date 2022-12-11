package main.window;
import main.bank.Bank;
import main.gui.BDConnection;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class ExistedBanksWindow extends JDialog {
    private JPanel mainPanel;
    private JLabel existedBanksLabel = new JLabel("Existing Banks");
    private JButton goBackButton = new JButton("Go back");
    public ExistedBanksWindow(JFrame parent){
        super (parent);
        setTitle("Existing Banks");
        setContentPane(mainPanel);
        setMinimumSize(new Dimension(600, 500));
        setModal(true);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        Container container = this.getContentPane();
        container.setLayout(new GridLayout(10, 1));
        existedBanksLabel.setFont(new Font("Palace Script MT", Font.BOLD, 50));
        existedBanksLabel.setForeground(Color.BLACK);
        existedBanksLabel.setHorizontalAlignment(JLabel.CENTER);
        container.add(existedBanksLabel);
        try {
            BDConnection user = new BDConnection();
            String query = "select * from bank order by bankid";
            Statement statement = user.getConnection().createStatement();
            statement.executeQuery(query);
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                JLabel label = new JLabel();
                Bank bank = new Bank(resultSet.getInt(1),resultSet.getString(2));
                label.setText(bank.toString());
                label.setFont(new Font("Times New Roman", Font.BOLD, 16));
                label.setForeground(Color.BLACK);
                container.add(label);
            }
            goBackButton.setFont(new Font("Times New Roman", Font.BOLD, 18));
            goBackButton.setForeground(Color.WHITE);
            goBackButton.setBackground(new Color(238,172,167));
            container.add(goBackButton);
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