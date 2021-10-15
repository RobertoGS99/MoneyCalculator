
package moneycalculator;

import Model.Currency;
import View.Swing.SwingMoneyDialog;
import View.Swing.SwingMoneyDisplay;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.PopupMenu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class MainFrame extends JFrame {
    
    
    private SwingMoneyDialog moneyDialog;
    private SwingMoneyDisplay moneyDisplay;
    private List<Currency> currencies;

    public MainFrame(List<Currency> currencies) {
        this.currencies = currencies;
        this.setTitle("My Money Claculator");
        this.setSize(400, 400);
        this.add(MoneyDialog(), BorderLayout.NORTH);
        this.add(MoneyDisplay(), BorderLayout.NORTH);
        this.add(toolbar(), BorderLayout.CENTER);
    }

    private Component MoneyDialog() {
        SwingMoneyDialog swingMoneyDialog = new SwingMoneyDialog(currencies);
        return swingMoneyDialog;
    }

    private Component MoneyDisplay() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private Component toolbar() {
        JPanel jPanel = new JPanel();
        jPanel.add(calculateButton());
        return jPanel;
    }

    private JButton calculateButton() {
        JButton jButton = new JButton("Calculate!");
        jButton.addActionListener(calculate());
        return jButton;
    }

    private ActionListener calculate() {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //calculo.
            }
        };
    }

    
    
    
    
}
