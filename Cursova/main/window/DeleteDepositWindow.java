package main.window;
import main.gui.BDConnection;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class DeleteDepositWindow extends JDialog {
    private JTextField depositIDTextField;
    private JButton OKButton;
    private JButton goBackButton;
    private JPanel mainPanel;
    public DeleteDepositWindow(JFrame parent) {
        super (parent);
        setTitle("Delete Deposit");
        setContentPane(mainPanel);
        setMinimumSize(new Dimension(600, 500));
        setModal (true);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        OKButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (depositIDTextField.getText().isEmpty()){
                    dispose();
                    JOptionPane.showMessageDialog(null,"Please, enter Deposit ID.","Try again", JOptionPane.ERROR_MESSAGE);
                }
                boolean check = false;
                try {
                    BDConnection user = new BDConnection();
                    String query = "delete from profit where depositid = " + depositIDTextField.getText() + "; delete from deposit where depositid = " + depositIDTextField.getText();
                    Statement statement = user.getConnection().createStatement();

                    ResultSet resultSetUser = statement.executeQuery("select * from appuser");
                    while (resultSetUser.next()) {
                        if (resultSetUser.getInt(4) == Integer.parseInt(depositIDTextField.getText())) {
                            dispose();
                            JOptionPane.showMessageDialog(null, "Please, enter other Deposit ID.", "Try again", JOptionPane.ERROR_MESSAGE);
                            return;
                        }
                    }
                    ResultSet resultSetDeposit = statement.executeQuery("select * from deposit");
                    while (true) {
                        if(!resultSetDeposit.next()) break;
                        if (resultSetDeposit.getInt(1) == Integer.parseInt(depositIDTextField.getText()) ) {
                            statement.executeUpdate(query);
                            dispose();
                            JOptionPane.showMessageDialog(null,"Deposit deleted successfully.", "Message", JOptionPane.PLAIN_MESSAGE);
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