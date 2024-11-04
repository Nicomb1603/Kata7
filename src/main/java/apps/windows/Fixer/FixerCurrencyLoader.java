package apps.windows.Fixer;

import architecture.model.Currency;
import com.google.gson.JsonElement;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class FixerCurrencyLoader implements architecture.persistence.CurrencyLoader {

    @Override
    public List<Currency> loadCurrencies(){
        List<Currency> currencies = new ArrayList<Currency>();
        try{
            currencies = toList(loadJSON());
        }catch(IOException e){
            return Collections.emptyList();
        }
        return currencies;
    }

    private List<Currency> toList(String json){
        List<Currency> currencies = new ArrayList<>();
        Map<String, JsonElement> symbols = new Gson().fromJson(json, JsonObject.class).get("symbols").getAsJsonObject().asMap();
        for(String symbol : symbols.keySet())
            currencies.add(new Currency(symbols.get(symbol).getAsString(), symbol));
        return currencies;
    }

    private String loadJSON() throws IOException {
        URL url = new URL("http://data.fixer.io/api/symbols?access_key=" + FixerAPI.key);
        try (InputStream is = url.openStream()) {
            return new String(is.readAllBytes());
        }
    }


}
