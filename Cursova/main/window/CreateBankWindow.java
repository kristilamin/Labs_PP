package main.window;
import main.gui.BDConnection;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class CreateBankWindow extends JDialog{
    private JTextField bankNameTextField;
    private JButton OKButton;
    private JButton goBackButton;
    private JPanel mainPanel;
    private  static final String insertNew = "insert into bank values(?,?)";
    public CreateBankWindow(JFrame parent) {
        super (parent);
        setTitle("Create Bank");
        setContentPane(mainPanel);
        setMinimumSize(new Dimension(600, 500));
        setModal(true);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        OKButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (bankNameTextField.getText().isEmpty()){
                    dispose();
                    JOptionPane.showMessageDialog(null,"Please, enter Bank Name.","Try again", JOptionPane.ERROR_MESSAGE);
                }
                try {
                    BDConnection user = new BDConnection();
                    Statement statement = user.getConnection().createStatement();
                    String query = "select * from bank where bankid = (select max(bankid) from bank)";
                    ResultSet resultSet = statement.executeQuery(query);
                    PreparedStatement preparedStatement = user.getConnection().prepareStatement(insertNew);
                    if(!resultSet.next())
                        preparedStatement.setInt(1,1);
                    else
                        preparedStatement.setInt(1,(resultSet.getInt(1) + 1));
                    preparedStatement.setString(2, bankNameTextField.getText());
                    preparedStatement.execute();
                    dispose();
                    JOptionPane.showMessageDialog(null,"Bank created successfully.", "Message", JOptionPane.PLAIN_MESSAGE);
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