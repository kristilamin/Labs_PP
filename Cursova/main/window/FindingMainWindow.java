package main.window;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class FindingMainWindow extends JDialog{
    private JPanel mainPanel;
    private JButton byNameButton;
    private JButton byPercentButton;
    private JTextField nameTextField;
    private JTextField percentTextField;
    private JButton OKButton;
    private JButton goBackButton;
    private JLabel nameLabel;
    private JLabel percentLabel;
    public FindingMainWindow(JFrame parent) {
        super (parent);
        setTitle("Find Deposit");
        setContentPane(mainPanel);
        setMinimumSize(new Dimension(600, 500));
        setModal(true);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        nameTextField.setVisible(false);
        nameLabel.setVisible(false);
        percentTextField.setVisible(false);
        percentLabel.setVisible(false);
        OKButton.setVisible(false);
        byNameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nameTextField.setVisible(true);
                nameLabel.setVisible(true);
                OKButton.setVisible(true);
            }
        });
        byPercentButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                percentTextField.setVisible(true);
                percentLabel.setVisible(true);
                OKButton.setVisible(true);
            }
        });
        OKButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                if(!nameTextField.getText().isEmpty()){
                    boolean flag = true;
                    new FindByParameterWindow(null, nameTextField, flag);
                }
                if(!percentTextField.getText().isEmpty()){
                    boolean flag = false;
                    new FindByParameterWindow(null, percentTextField, flag);
                }
                if(nameTextField.getText().isEmpty() && percentTextField.getText().isEmpty())
                    JOptionPane.showMessageDialog(null,"Please, enter all fields.","Try again", JOptionPane.ERROR_MESSAGE);
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