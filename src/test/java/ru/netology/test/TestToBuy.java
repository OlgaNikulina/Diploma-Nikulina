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
        val requestToBuy = open("http://localhost:8080" , RequestToBuy.class);
        val cardsInfo = DataHelper.getCardsInfoWith41ToBuy();
        val successfullyNotificationPage = requestToBuy.shouldReplenishFormToBuyWithCorrectValues41(cardsInfo);
        successfullyNotificationPage.shouldSuccessfullyNotificationBeVisible();
        DataHelper.shouldSelectFromDBToBuy();
        DataHelper.shouldDeleteFromDBToBuy();
    }

    @Test
    void shouldSendFormWith42Card() throws SQLException {
        val requestToBuy = open("http://localhost:8080" , RequestToBuy.class);
        val cardsInfo = DataHelper.getCardsInfoWith42ToBuy();
        val errorNotificationPage = requestToBuy.shouldReplenishFormToBuyWithCorrectValues42(cardsInfo);
        errorNotificationPage.shouldErrorBeVisible();
        DataHelper.shouldDeleteFromDBToBuy();
    }

    @Test
    void shouldNotSendFormWithEmptyFields() throws SQLException {
        val requestToBuy = open("http://localhost:8080" , RequestToBuy.class);
        val cardsInfo = DataHelper.getCardsInfoWithEmptyFields();
        val errorNotificationPage = requestToBuy.shouldReplenishFormToBuyWithEmptyFields(cardsInfo);
        errorNotificationPage.shouldErrorNotificationBeVisible();
        DataHelper.shouldDeleteFromDBToBuy();
    }

    @Test
    void shouldNotSendFormWithSingleSymbols() throws SQLException {
        val requestToBuy = open("http://localhost:8080" , RequestToBuy.class);
        val cardsInfo = DataHelper.getCardsInfoWithSingleSymbols();
        val errorNotificationPage = requestToBuy.shouldReplenishFormToBuyWithSingleSymbols(cardsInfo);
        errorNotificationPage.shouldErrorNotificationBeVisible();
        DataHelper.shouldDeleteFromDBToBuy();
    }
}
