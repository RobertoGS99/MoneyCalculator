/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Perseistance.File;

import Model.Currency;
import Persistence.CurrencyLoader;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class WebserviceCurrencyLoader implements CurrencyLoader{
    private final String url;

    public WebserviceCurrencyLoader(String url) {
        this.url = url;
    }
    
    
    @Override
    public ArrayList<Currency> loadAllCurrencies() {
        ArrayList<Currency> arrayList= new ArrayList<Currency>();
        
        return arrayList;
    }
    
}
