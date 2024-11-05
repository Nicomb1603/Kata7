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
import java.time.LocalDate;
import java.util.Map;

public class FixerExchangeRateLoader implements ExchangeRateLoader {
    @Override
    public ExchangeRate load(Currency from, Currency to,  LocalDate date) {

        try {
            return toExchangeRate(from, to, getJsonExchangeRate(from, to, date), date);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private ExchangeRate toExchangeRate(Currency from, Currency to, String json, LocalDate date) {
        Map<String, JsonElement> rate = new Gson().fromJson(json, JsonObject.class).get("rates").getAsJsonObject().asMap();
        return new ExchangeRate(from, to, rate.get(to.getCode()).getAsDouble(), date);
    }

    private String getJsonExchangeRate(Currency from, Currency to, LocalDate date) throws IOException {
        URL url = new URL("http://data.fixer.io/api/" + date + "?access_key=" +
                FixerAPI.key + "&base=" + from.getCode() + "&symbols=" + to.getCode());
        try (InputStream is = url.openStream()) {
            return new String(is.readAllBytes());
        }


    }
}
