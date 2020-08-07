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
        val cardsInfo = DataHelper.getCardsInfoWith41ToBuyInCredit();
        val successfullyNotificationPage = requestToBuyInCredit.shouldReplenishFormToBuyInCreditWithCorrectValues41(cardsInfo);
        successfullyNotificationPage.shouldSuccessfullyNotificationBeVisible();
        DataHelper.shouldSelectFromDBToBuyInCredit();
        DataHelper.shouldDeleteFromDBToBuyInCredit();

    }

    @Test
    void shouldSendFormWith42Card() throws SQLException {
        val requestToBuyInCredit = open("http://localhost:8080", RequestToBuyInCredit.class);
        val cardsInfo = DataHelper.getCardsInfoWith42ToBuyInCredit();
        val errorNotificationPage = requestToBuyInCredit.shouldReplenishFormToBuyInCreditWithCorrectValues42(cardsInfo);
        errorNotificationPage.shouldErrorBeVisible();
        DataHelper.shouldSelectFromDBToBuyInCredit();
        DataHelper.shouldDeleteFromDBToBuyInCredit();
    }

    @Test
    void shouldNotSendFormWithEmptyFields() {
        val requestToBuyInCredit = open("http://localhost:8080", RequestToBuyInCredit.class);
        val cardsInfo = DataHelper.getCardsInfoWithEmptyFields();
        val errorNotificationPage = requestToBuyInCredit.shouldReplenishFormToBuyInCreditWithEmptyFields(cardsInfo);
        errorNotificationPage.shouldErrorNotificationBeVisible();
        DataHelper.shouldDeleteFromDBToBuyInCredit();
    }

    @Test
    void shouldNotSendFormWithSingleSymbols() {
        val requestToBuyInCredit = open("http://localhost:8080", RequestToBuyInCredit.class);
        val cardsInfo = DataHelper.getCardsInfoWithSingleSymbols();
        val errorNotificationPage = requestToBuyInCredit.shouldReplenishFormToBuyInCreditWithEmptyFields(cardsInfo);
        errorNotificationPage.shouldErrorNotificationBeVisible();
        DataHelper.shouldDeleteFromDBToBuyInCredit();
    }
}
