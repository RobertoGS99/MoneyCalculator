/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistence.Rest;

import Model.Currency;
import Model.ExchangeRate;
import Persistence.ExchangeRateLoader;

/**
 *
 * @author Admin
 */
public class RestExchangeRateLoader implements ExchangeRateLoader {

    @Override
    public ExchangeRate get(Currency from, Currency to) {
        double rate = 0.0;
        from.getCode();
        to.getCode();
        //Hacer codigo para obtener el rate que esta en la practica de aula 1.
        return new ExchangeRate(rate, from, to);
    }
    
}
