package main.window;
import main.user.AppUser;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class UserOptionsWindow extends JDialog{
    private JPanel mainPanel;
    private JButton myDepositButton;
    private JButton changeMyDepositButton;
    private JButton existedDepositsButton;
    private JButton logOutButton;
    private JButton myProfitButton;
    private JButton findDepositButton;
    private JButton sortDepositsButton;
    public UserOptionsWindow(JFrame parent, AppUser appUser) {
        super (parent);
        setTitle("User Options");
        setContentPane(mainPanel);
        setMinimumSize(new Dimension(600, 500));
        setModal(true);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        myDepositButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new MyDepositWindow(null, appUser);
            }
        });
        myProfitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new MyProfitWindow(null, appUser);
            }
        });
        changeMyDepositButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ChangeMyDepositWindow(null, appUser);
            }
        });
        existedDepositsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ExistedDepositsWindow(null);
            }
        });
        findDepositButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new FindingMainWindow(null);
            }
        });
        sortDepositsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new SortingMainWindow(null);
            }
        });
        logOutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new EntranceWindow(null);
            }
        });
        setVisible(true);
    }
}