package main.window;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class AdminOptionsWindow extends JDialog{
    private JButton seeAllUsersButton;
    private JButton seeExistedBanksButton;
    private JButton seeExistedDepositsButton;
    private JButton createBankButton;
    private JButton createDepositButton;
    private JButton deleteDepositButton;
    private JButton findDepositButton;
    private JButton sortDepositsButton;
    private JButton logOutButton;
    private JPanel mainPanel;
    public AdminOptionsWindow(JFrame parent) {
        super (parent);
        setTitle("Admin Options");
        setContentPane(mainPanel);
        setMinimumSize(new Dimension(600, 500));
        setModal(true);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        seeAllUsersButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AllUsersWindow(null);
            }
        });
        seeExistedBanksButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ExistedBanksWindow(null);
            }
        });
        seeExistedDepositsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ExistedDepositsWindow(null);
            }
        });
        createBankButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new CreateBankWindow(null);
            }
        });
        createDepositButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new CreateDepositWindow(null);
            }
        });
        deleteDepositButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new DeleteDepositWindow(null);
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