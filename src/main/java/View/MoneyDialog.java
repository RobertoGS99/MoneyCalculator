/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Model.Currency;
import Model.Money;

/**
 *
 * @author Admin
 */
public interface MoneyDialog {
    
    public Money getMoneyFrom();
    public Currency getCurrencyTo();
    
}
