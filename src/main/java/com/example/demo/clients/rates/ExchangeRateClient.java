package com.example.demo.clients.rates;

import com.posadskiy.currencyconverter.CurrencyConverter;
import com.posadskiy.currencyconverter.config.ConfigBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class ExchangeRateClient {

    @Value( "${currencyLayer.apiKey}" )
    private String currencyLayerApiKey;

    public BigDecimal getExchangeRate(String baseCurrency, String quoteCurrency) {

        if (baseCurrency.equals(quoteCurrency)){
            return BigDecimal.ONE;
        }
        CurrencyConverter converter = new CurrencyConverter(
                new ConfigBuilder()
                        .currencyLayerApiKey(currencyLayerApiKey)
//                        .currencyConverterApiApiKey(CURRENCY_CONVERTER_API_API_KEY)   
                        .build()
        );

        return BigDecimal.valueOf(converter.rate(baseCurrency, quoteCurrency));
    }
}
