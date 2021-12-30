/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistence.Rest;

import Model.Currency;
import Model.ExchangeRate;
import Persistence.ExchangeRateLoader;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class RestExchangeRateLoader implements ExchangeRateLoader {

    @Override
    public ExchangeRate get(Currency from, Currency to) {
        try {
            //Hacer codigo para obtener el rate que esta en la practica de aula 1.
            return new ExchangeRate(read(from.getCode(),to.getCode()), from, to);
        } catch (IOException ex) {
            System.out.println(""+ex.getMessage());
            return null;
        }
    }

    private double read(String from, String to) throws IOException  {
        //Creo que el unico fallo que tiene es que el token de acceso esta caducado y por lo tanto no puedo obtener
        //la tasa de cambio.
        String url = read(new URL("http://data.fixer.io/api/latest?access_key=4253f876d09cdab1f93d26443336d9de&symbols="+from+","+to));
        return Double.parseDouble(url.substring(url.indexOf(from)+6, url.lastIndexOf(",")));
    }

    private String read(URL url) throws IOException {
        InputStream is = url.openStream();
        byte[] buffer = new byte[4096];
        is.read(buffer);
        int length = is.read(buffer);
        String res = new String(buffer,0,length);
        return res;
    }
    
}
