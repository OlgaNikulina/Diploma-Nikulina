package ru.netology.test;

import lombok.val;
import org.junit.jupiter.api.Test;
import ru.netology.data.DataHelper;
import ru.netology.page.RequestToBuyInCredit;

import java.sql.SQLException;

import static com.codeborne.selenide.Selenide.open;

public class TestToBuyInCredit {
    @Test
    void shouldSendFormWithApprovedCard() throws SQLException {
        val requestToBuyInCredit = open("http://localhost:8080", RequestToBuyInCredit.class);
        val cardsInfo = DataHelper.getCardsInfoWithApprovedCardToBuyInCredit();
        val successfullyNotificationPage = requestToBuyInCredit.shouldReplenishFormToBuyInCreditWithSuccess(cardsInfo);
        successfullyNotificationPage.shouldSuccessfullyNotificationBeVisible();
        DataHelper.shouldSelectFromDBToBuyInCredit();
        DataHelper.shouldDeleteFromDBToBuyInCredit();

    }

    @Test
    void shouldSendFormWithDeclinedCard() throws SQLException {
        val requestToBuyInCredit = open("http://localhost:8080", RequestToBuyInCredit.class);
        val cardsInfo = DataHelper.getCardsInfoWithDeclinedCArdToBuyInCredit();
        val errorNotificationPage = requestToBuyInCredit.shouldReplenishFormToBuyInCreditWithError(cardsInfo);
        errorNotificationPage.shouldErrorBeVisible();
        DataHelper.shouldSelectFromDBToBuyInCredit();
        DataHelper.shouldDeleteFromDBToBuyInCredit();
    }

    @Test
    void shouldNotSendFormWithEmptyFields() {
        val requestToBuyInCredit = open("http://localhost:8080", RequestToBuyInCredit.class);
        val cardsInfo = DataHelper.getCardsInfoWithEmptyFields();
        val errorNotificationPage = requestToBuyInCredit.shouldReplenishFormToBuyInCreditWithError(cardsInfo);
        errorNotificationPage.shouldErrorNotificationBeVisible();
        DataHelper.shouldDeleteFromDBToBuyInCredit();
    }

    @Test
    void shouldNotSendFormWithSingleSymbols() {
        val requestToBuyInCredit = open("http://localhost:8080", RequestToBuyInCredit.class);
        val cardsInfo = DataHelper.getCardsInfoWithSingleSymbols();
        val errorNotificationPage = requestToBuyInCredit.shouldReplenishFormToBuyInCreditWithError(cardsInfo);
        errorNotificationPage.shouldErrorNotificationBeVisible();
        DataHelper.shouldDeleteFromDBToBuyInCredit();
    }
}
