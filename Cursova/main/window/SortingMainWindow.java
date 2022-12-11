package main.window;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class SortingMainWindow extends JDialog{
    private JPanel mainPanel;
    private JButton goBackButton;
    private JButton percentButton;
    private JButton moneyButton;
    public SortingMainWindow(JFrame parent) {
        super (parent);
        setTitle("Sort Deposits");
        setContentPane(mainPanel);
        setMinimumSize(new Dimension(600, 500));
        setModal(true);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        percentButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean flag = true;
                new SortByParameterWindow(null, flag);
            }
        });
        moneyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean flag = false;
                new SortByParameterWindow(null, flag);
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
