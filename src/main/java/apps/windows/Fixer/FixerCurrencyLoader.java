package apps.windows.Fixer;

import architecture.model.Currency;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FixerCurrencyLoader implements architecture.persistence.CurrencyLoader {

    @Override
    public List<Currency> loadCurrencies(){
        List<Currency> currencies = new ArrayList<Currency>();
        try{
            String prueba = loadJSON();
            System.out.println(prueba);
        }catch(IOException e){
            return Collections.emptyList();
        }
        return currencies;
    }



    private String loadJSON() throws IOException {
        URL url = new URL("http://data.fixer.io/api/symbols?access_key=" + FixerAPI.key);
        try (InputStream is = url.openStream()) {
            return new String(is.readAllBytes());
        }
    }


}
