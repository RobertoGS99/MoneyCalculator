package moneycalculator;

import Model.Currency;
import Perseistance.File.FileCurrencyLoader;
import Perseistance.File.WebserviceCurrencyLoader;
import java.util.ArrayList;

public class MoneyCalculator {
    public static void main(String[] args) {
        FileCurrencyLoader fileCurrencyLoader = new FileCurrencyLoader("C:\\Users\\Roberto GS\\Desktop\\IS2\\MoneyCalculator\\src\\main\\java\\currencies.txt");
        WebserviceCurrencyLoader webserviceCurrencyLoader = new WebserviceCurrencyLoader("..");
        MainFrame mainFrame = new MainFrame(fileCurrencyLoader.loadAllCurrencies());
        ArrayList<Currency> loadAllCurrencies = fileCurrencyLoader.loadAllCurrencies();
       
    }
}
