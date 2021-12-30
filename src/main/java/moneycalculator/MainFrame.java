
package moneycalculator;

import Control.Command;
import Model.Currency;
import View.Swing.SwingMoneyDialog;
import View.Swing.SwingMoneyDisplay;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class MainFrame extends JFrame {
    
    
    private SwingMoneyDialog moneyDialog;
    private SwingMoneyDisplay moneyDisplay;
    private List<Currency> currencies;
    
    private final Map<String,Command> commands = new HashMap<String, Command>();
    
    
    public MainFrame(List<Currency> currencies) {
        this.currencies = currencies;
        this.setTitle("My Money Claculator");
        this.setSize(400, 400);
        this.add(MoneyDialog(), BorderLayout.NORTH);
        this.add(MoneyDisplay(), BorderLayout.CENTER);
        this.add(toolbar(), BorderLayout.SOUTH);
        this.setVisible(true);
    }
    
    public void add(Command command){
        commands.put(command.getName(),command);
        
    }
    
    
    private Component MoneyDialog() {
        SwingMoneyDialog swingMoneyDialog = new SwingMoneyDialog(currencies);
        moneyDialog = swingMoneyDialog;
        return swingMoneyDialog;
    }

    private Component MoneyDisplay() {
        SwingMoneyDisplay swingMoneyDisplay = new SwingMoneyDisplay();
        moneyDisplay = swingMoneyDisplay;
        return swingMoneyDisplay;
    }

    private Component toolbar() {
        JPanel jPanel = new JPanel();
        jPanel.add(calculateButton());
        return jPanel;
    }

    public SwingMoneyDialog getMoneyDialog() {
        return moneyDialog;
    }

    public SwingMoneyDisplay getMoneyDisplay() {
        return moneyDisplay;
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
                Command get = commands.get("Calculate");
                get.execute();
            }
        };
    }

    
    
    
    
}
