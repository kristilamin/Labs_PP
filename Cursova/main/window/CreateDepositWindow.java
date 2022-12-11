package main.window;
import main.gui.BDConnection;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class CreateDepositWindow extends JDialog{
    private JTextField depositNameTextField;
    private JTextField percentTextField;
    private JTextField moneyTextField;
    private JTextField termTextField;
    private JTextField bankIdTextField;
    private JButton OKButton;
    private JButton goBackButton;
    private JPanel mainPanel;
    private  static final String insertNewDeposit = "insert into deposit values(?,?,?,?,?,?)";
    private  static final String insertNewProfit = "insert into profit values(?,?,?,?,?)";
    public CreateDepositWindow(JFrame parent) {
        super (parent);
        setTitle("Create Deposit");
        setContentPane(mainPanel);
        setMinimumSize(new Dimension(600, 500));
        setModal(true);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        OKButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (depositNameTextField.getText().isEmpty() || percentTextField.getText().isEmpty() || moneyTextField.getText().isEmpty() || termTextField.getText().isEmpty() || bankIdTextField.getText().isEmpty()){
                    dispose();
                    JOptionPane.showMessageDialog(null,"Please, enter all fields.","Try again", JOptionPane.ERROR_MESSAGE);
                }
                boolean check = false;
                try {
                    BDConnection user = new BDConnection();
                    Statement statement = user.getConnection().createStatement();
                    ResultSet resultSet = statement.executeQuery("select * from bank");
                    while (true) {
                        if(!resultSet.next()) break;
                        if (resultSet.getInt(1) == Integer.parseInt(bankIdTextField.getText())) {
                            String query = "select * from deposit where depositid = (select max(depositid) from deposit)";
                            resultSet = statement.executeQuery(query);
                            PreparedStatement preparedStatement = user.getConnection().prepareStatement(insertNewDeposit);
                            if(!resultSet.next())
                                preparedStatement.setInt(1,1);
                            else
                                preparedStatement.setInt(1,(resultSet.getInt(1) + 1));
                            preparedStatement.setString(2, depositNameTextField.getText());
                            preparedStatement.setInt(3, Integer.parseInt(percentTextField.getText()));
                            preparedStatement.setInt(4, Integer.parseInt(moneyTextField.getText()));
                            preparedStatement.setInt(5, Integer.parseInt(termTextField.getText()));
                            preparedStatement.setInt(6, Integer.parseInt(bankIdTextField.getText()));
                            preparedStatement.execute();
                            query = "select * from profit where profitid = (select max(profitid) from profit)";
                            resultSet = statement.executeQuery(query);
                            preparedStatement = user.getConnection().prepareStatement(insertNewProfit);
                            if(!resultSet.next()){
                                preparedStatement.setInt(1,1);
                                preparedStatement.setInt(2, 1);
                            }
                            else{
                                preparedStatement.setInt(1,(resultSet.getInt(1) + 1));
                                preparedStatement.setInt(2,(resultSet.getInt(1) + 1));
                            }
                            preparedStatement.setInt(3, Integer.parseInt(percentTextField.getText()) * Integer.parseInt(moneyTextField.getText()) / 100 + Integer.parseInt(moneyTextField.getText()));
                            preparedStatement.setInt(4, (Integer.parseInt(percentTextField.getText()) / 3 * Integer.parseInt(termTextField.getText())/12) * Integer.parseInt(moneyTextField.getText())/100 + Integer.parseInt(moneyTextField.getText()));
                            preparedStatement.setInt(5,  Integer.parseInt(percentTextField.getText()) * (Integer.parseInt(moneyTextField.getText()) + 5000 ) / 100 + Integer.parseInt(moneyTextField.getText()));
                            preparedStatement.execute();
                            dispose();
                            JOptionPane.showMessageDialog(null,"Deposit created successfully.", "Message", JOptionPane.PLAIN_MESSAGE);
                            check = true;
                            break;
                        }
                    }
                    if(!check){
                        dispose();
                        JOptionPane.showMessageDialog(null, "Please, enter other Bank ID.", "Try again", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
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