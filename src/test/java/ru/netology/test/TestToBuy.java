package ru.netology.test;

import lombok.val;
import org.junit.jupiter.api.Test;
import ru.netology.data.DataHelper;
import ru.netology.page.RequestToBuy;

import java.sql.SQLException;

import static com.codeborne.selenide.Selenide.open;

public class TestToBuy {
    @Test
    void shouldSendFormWith41Card() throws SQLException {
        val requestToBuy = open("http://localhost:8080", RequestToBuy.class);
        val cardsInfo = DataHelper.getCardsInfoWith41();
        val successfullyNotificationPage = requestToBuy.shouldReplenishFormToBuyWithCorrectValues(cardsInfo);
        successfullyNotificationPage.shouldSuccessfullyNotificationBeVisible();
    }

    @Test
    void shouldSendFormWith42Card() throws SQLException {
        val requestToBuy = open("http://localhost:8080", RequestToBuy.class);
        val cardsInfo = DataHelper.getCardsInfoWith42();
        val errorNotificationPage = requestToBuy.shouldReplenishFormToBuyWithCorrectValues(cardsInfo);
        errorNotificationPage
    }

    @Test
    void shouldNotSendFormWithEmptyFields() {
        val requestToBuy = open("http://localhost:8080", RequestToBuy.class);
        val cardsInfo = DataHelper.getCardsInfoWithEmptyFields();
        val errorNotificationPage = requestToBuy.shouldReplenishFormToBuyWithEmptyFields(cardsInfo);
        errorNotificationPage.shouldErrorNotificationBeVisible();
    }

    @Test
    void shouldNotSendFormWithSingleSymbols() {
        val requestToBuy = open("http://localhost:8080", RequestToBuy.class);
        val cardsInfo = DataHelper.getCardsInfoWithSingleSymbols();
        val errorNotificationPage = requestToBuy.shouldReplenishFormToBuyWithSingleSymbols(cardsInfo);
        errorNotificationPage.shouldErrorNotificationBeVisible();
    }
}
