/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View.Swing;

import Model.Currency;
import Model.Money;
import View.MoneyDialog;
import java.awt.Component;
import java.awt.PopupMenu;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;

/**
 *
 * @author Admin
 */
public class SwingMoneyDialog extends JPanel implements MoneyDialog{
    
    private final List<Currency> currencies; 
    
    private Double amount;
    private Currency from;
    private Currency to;

    public SwingMoneyDialog(List<Currency> currencies) {
        this.currencies = currencies;
        this.add(amount());
        this.add(currencyFrom());
        this.add(currencyTo());    
    }
    
    @Override
    public Money getMoneyFrom() {   
        return new Money(amount,from);
    }

    @Override
    public Currency getCurrencyTo() {
        return to;
    }

    private Component amount() {
        JTextField textField = new JTextField("");
        
        textField.getDocument().addDocumentListener( amountChanged());
        
        return textField;
    }

    private Component currencyFrom() {
        JComboBox combo = new JComboBox(nameOf(currencies));
        combo.addItemListener(currencyFromChanged());
        to = currencies.get(combo.getSelectedIndex());
        
        return combo;
    }

    private Component currencyTo() {
        JComboBox combo = new JComboBox();
        combo.addItemListener(currencyToChanged());
        
        
        return combo;
    }
    
    private Object[] nameOf(List<Currency> currencies){
        ArrayList <String> names = new ArrayList<String>();
        names.clear();
        
        for (Currency currency : currencies) {
            names.add(currency.getName());
            
        }
        return names.toArray();
    }

    private DocumentListener amountChanged() {
        
        return new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                processAmountChanged(e.getDocument());
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                processAmountChanged(e.getDocument());            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                processAmountChanged(e.getDocument());            }

            private void processAmountChanged(Document document) {
                try{
                    String text = document.getText(0, document.getLength());
                }catch (BadLocationException ex){
                    
                }catch (NumberFormatException ex){
                    
                }
                   
            }
        };
    }

    private ItemListener currencyFromChanged() {
        return new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                
                JComboBox comboBox = (JComboBox) e.getSource();
                from = currencies.get(comboBox.getSelectedIndex());
            }
        };
    }

    private ItemListener currencyToChanged() {
        //copiar y pegar
        return null;
    }
    
}
