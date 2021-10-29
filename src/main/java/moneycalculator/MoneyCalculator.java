package moneycalculator;

import Control.CalculateCommand;
import Model.Currency;
import Perseistance.File.FileCurrencyLoader;
//import Perseistance.File.WebserviceCurrencyLoader;
import Persistence.CurrencyLoader;
import Persistence.ExchangeRateLoader;
import Persistence.Rest.RestExchangeRateLoader;
import java.util.ArrayList;

public class MoneyCalculator {
    public static void main(String[] args) {
        CurrencyLoader fileCurrencyLoader = new FileCurrencyLoader("C:\\Users\\Roberto GS\\Desktop\\IS2\\MoneyCalculator\\src\\main\\java\\currencies.txt");
        ExchangeRateLoader restExchangeRateLoader = new RestExchangeRateLoader();
        //WebserviceCurrencyLoader webserviceCurrencyLoader = new WebserviceCurrencyLoader("..");
        MainFrame mainFrame = new MainFrame(fileCurrencyLoader.loadAllCurrencies());
        ArrayList<Currency> loadAllCurrencies = fileCurrencyLoader.loadAllCurrencies();
        CalculateCommand calculateCommand = new CalculateCommand(mainFrame.getMoneyDialog(),mainFrame.getMoneyDisplay(),restExchangeRateLoader);
        mainFrame.add(calculateCommand);
    }
}
