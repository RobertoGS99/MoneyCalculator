/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistence;

import Model.Currency;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public interface CurrencyLoader {
    ArrayList<Currency> loadAllCurrencies();
    
    
    
}
