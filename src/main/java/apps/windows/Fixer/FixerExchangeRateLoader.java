package apps.windows.Fixer;

import architecture.model.Currency;
import architecture.model.ExchangeRate;
import architecture.persistence.ExchangeRateLoader;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

public class FixerExchangeRateLoader implements ExchangeRateLoader {

    private Currency baseCurrency;

    @Override
    public ExchangeRate load(Currency from, Currency to,  Date date) {

        this.baseCurrency = createBaseCurrency();

        try {
            ExchangeRate fromBaseExchangeRate = toExchangeRate(baseCurrency, from, getJsonExchangeRate(baseCurrency, from, date), date);
            System.out.println("YES");
            ExchangeRate toBaseExchangeRate = toExchangeRate(baseCurrency, to, getJsonExchangeRate(baseCurrency, to, date), date);
            System.out.println("YES");
            return new ExchangeRate(from, to, fromBaseExchangeRate.rate()/toBaseExchangeRate.rate(), date);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private Currency createBaseCurrency() {
        return new Currency("EUR", "EUR");
    }


    private ExchangeRate toExchangeRate(Currency from, Currency to, String json, Date date) {
        Map<String, JsonElement> rate = new Gson().fromJson(json, JsonObject.class).get("rates").getAsJsonObject().asMap();
        return new ExchangeRate(from, to, rate.get(to.getCode()).getAsDouble(), date);
    }

    private String getJsonExchangeRate(Currency from, Currency to, Date date) throws IOException {
        URL url = new URL("http://data.fixer.io/api/" + toAPIFormatDate(date) + "?access_key=" +
                FixerAPI.key + "&base=" + from.getCode() + "&symbols=" + to.getCode());
        try (InputStream is = url.openStream()) {
            return new String(is.readAllBytes());
        }


    }

    private String toAPIFormatDate(Date date) {
        if (date != null) {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            return formatter.format(date);
        }
        return null;

    }
}
