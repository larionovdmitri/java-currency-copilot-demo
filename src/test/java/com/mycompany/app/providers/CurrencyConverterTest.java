package com.mycompany.app.providers;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;

import com.mycompany.app.TestUtils;
import com.mycompany.app.domain.CurrencyWrapper;
import com.mycompany.app.models.CurrencyPair;
import com.mycompany.app.models.User;

public class CurrencyConverterTest {

    @Test
    public void testConvert() {
        // Arrange
        CurrencyConverter currencyConverter = TestUtils.createMockCurrencyConverter();
        User user = TestUtils.createMockUser();
        CurrencyWrapper userNativeCurrency = user.getNativeCurrency();
        CurrencyWrapper targetCurrency = CurrencyWrapper.BTC;
        double amount = 60000;
        double expectedAmount = 0.861336;
        BigDecimal dollars = BigDecimal.valueOf(amount);
        CurrencyPair currencyPair = new CurrencyPair(userNativeCurrency, targetCurrency);

        // Act
        BigDecimal bitcoins = currencyConverter.convert(dollars, currencyPair);
        double actual = bitcoins.doubleValue();

        // Assert
        assertEquals(
                expectedAmount, actual, 0,
                "USD to Bitcoin conversion failed.");
    }

}
