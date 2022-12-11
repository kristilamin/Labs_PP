package main.window;
import main.gui.BDConnection;
import main.user.AppUser;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class AllUsersWindow extends JDialog{
    private JPanel mainPanel;
    private JLabel allUsersLabel = new JLabel("All Users");
    private JButton goBackButton = new JButton("Go back");
    public AllUsersWindow(JFrame parent){
        super (parent);
        setTitle("All Users");
        setContentPane(mainPanel);
        setMinimumSize(new Dimension(600, 500));
        setModal(true);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        Container container = this.getContentPane();
        container.setLayout(new GridLayout(10, 1));
        allUsersLabel.setFont(new Font("Palace Script MT", Font.BOLD, 50));
        allUsersLabel.setForeground(Color.BLACK);
        allUsersLabel.setHorizontalAlignment(JLabel.CENTER);
        container.add(allUsersLabel);
        try {
            BDConnection user = new BDConnection();
            String query = "select * from appuser order by appuserid";
            Statement statement = (Statement) user.getConnection().createStatement();
            statement.executeQuery(query);
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                JLabel label = new JLabel();
                AppUser appUser = new AppUser(resultSet.getInt(1), resultSet.getString(2), resultSet.getInt(4));
                label.setText(appUser.toString());
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