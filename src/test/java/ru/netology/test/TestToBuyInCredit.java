package ru.netology.test;

import lombok.val;
import org.junit.jupiter.api.Test;
import ru.netology.data.DataHelper;
import ru.netology.page.RequestToBuyInCredit;

import java.sql.SQLException;

import static com.codeborne.selenide.Selenide.open;

public class TestToBuyInCredit {
    @Test
    void shouldSendFormWith41Card() throws SQLException {
        val requestToBuyInCredit = open("http://localhost:8080", RequestToBuyInCredit.class);
        val cardsInfo = DataHelper.getCardsInfoWith41();
        val successfullyNotificationPage = requestToBuyInCredit.shouldReplenishFormToBuyInCreditWithCorrectValues41(cardsInfo);
        successfullyNotificationPage.shouldSuccessfullyNotificationBeVisible();
        DataHelper.shouldDeleteFromDB();

    }

    @Test
    void shouldSendFormWith42Card() throws SQLException {
        val requestToBuyInCredit = open("http://localhost:8080", RequestToBuyInCredit.class);
        val cardsInfo = DataHelper.getCardsInfoWith42();
        val errorNotificationPage = requestToBuyInCredit.shouldReplenishFormToBuyInCreditWithCorrectValues42(cardsInfo);
        errorNotificationPage.shouldErrorBeVisible();
        DataHelper.shouldDeleteFromDB();
    }

    @Test
    void shouldNotSendFormWithEmptyFields() throws SQLException {
        val requestToBuyInCredit = open("http://localhost:8080", RequestToBuyInCredit.class);
        val cardsInfo = DataHelper.getCardsInfoWithEmptyFields();
        val errorNotificationPage = requestToBuyInCredit.shouldReplenishFormToBuyInCreditWithEmptyFields(cardsInfo);
        errorNotificationPage.shouldErrorNotificationBeVisible();
        DataHelper.shouldDeleteFromDB();
    }

    @Test
    void shouldNotSendFormWithSingleSymbols() throws SQLException {
        val requestToBuyInCredit = open("http://localhost:8080", RequestToBuyInCredit.class);
        val cardsInfo = DataHelper.getCardsInfoWithSingleSymbols();
        val errorNotificationPage = requestToBuyInCredit.shouldReplenishFormToBuyInCreditWithEmptyFields(cardsInfo);
        errorNotificationPage.shouldErrorNotificationBeVisible();
        DataHelper.shouldDeleteFromDB();
    }
}
