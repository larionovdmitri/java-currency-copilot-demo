package com.mycompany.app.model;

import org.junit.jupiter.api.*;

import com.mycompany.app.TestUtils;
import com.mycompany.app.domain.CurrencyWrapper;
import com.mycompany.app.models.Payment;
import com.mycompany.app.models.User;
import com.mycompany.app.models.UserManager;
import com.mycompany.app.models.User.Builder;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.util.Map;

public class UserManagerTest {
    private User user;
    private final CurrencyWrapper defaultCurrency = CurrencyWrapper.USD; // Assuming USD is the default currency

    @BeforeEach
    public void setUp() {
        user = new Builder("John", "Doe").nativeCurrency(defaultCurrency).build();
    }

    @Test
    public void canAcceptPaymentByUserId() {
        // Arrange
        Payment payment = new Payment(100.0, defaultCurrency);
        User user = new Builder("John", "Doe").nativeCurrency(defaultCurrency).build();
        String userId = user.getId();
        UserManager manager = new UserManager();
        manager.addUser(user);
        // Act
        boolean result = manager.acceptPaymentToUserById(userId, payment);
        // Assert
        assertTrue(
                result,
                "Payment should be accepted");
    }

    @Test
    void canStateUseNetWorthByCurrency() {
        // Arrange
        User mockUser = TestUtils.createMockUserWithThreeCurrencyBalances();
        UserManager manager = TestUtils.createMockUserManager(mockUser);
        BigDecimal expectedNetWorth = new BigDecimal("157375.0143556");
        BigDecimal tolerance = new BigDecimal("0.001");
        // Act
        BigDecimal netWorth = manager.getNetWorth(mockUser.getId(), CurrencyWrapper.USD);
        BigDecimal difference = expectedNetWorth.subtract(netWorth).abs();
        // Assert
        // Add network and expected variable values into message
        String message = String.format(
                "Net worth should be within the tolerance of the expected value. Expected: %s, Actual: %s",
                expectedNetWorth, netWorth);

        assertTrue(
                difference.compareTo(tolerance) < 0,
                message);

    }
}