/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View.Swing;

import Model.Money;
import View.MoneyDisplay;
import java.awt.Component;
import java.awt.PopupMenu;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Admin
 */
public class SwingMoneyDisplay extends JPanel implements MoneyDisplay {
    private Money money;
    
    @Override
    public void display(Money money) {
        this.money = money;
        this.add(amoutn());
        this.add(currency());
        this.updateUI();
        
    }

    private Component amoutn() {
        return new JLabel(String.valueOf(money.getAmount()));
        
    }

    private Component currency() {
        return new JLabel(String.valueOf(money.getCurrency().getSymbol()));
    }
    
}
