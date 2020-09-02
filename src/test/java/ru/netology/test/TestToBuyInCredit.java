package ru.netology.test;

import lombok.val;
import org.junit.jupiter.api.Assertions;
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
        String status = "APPROVED";
        String id = "7e47d111-350a-47cb-a0a4-27c9e4529217";
        String credit_id = "988e48b8-9fc2-4450-9b32-22daec703e80";
        Assertions.assertEquals(DataHelper.shouldSelectStatusFromDBToBuyInCredit(), status);
        Assertions.assertEquals(DataHelper.shouldSelectIdFromDBToBuyInCredit(), id);
        Assertions.assertEquals(DataHelper.shouldSelectCredit_idFromDBToBuyInCredit(), credit_id);
        DataHelper.shouldDeleteFromDBToBuyInCredit();
    }

    @Test
    void shouldSendFormWithDeclinedCard() throws SQLException {
        val requestToBuyInCredit = open("http://localhost:8080", RequestToBuyInCredit.class);
        val cardsInfo = DataHelper.getCardsInfoWithDeclinedCArdToBuyInCredit();
        val errorNotificationPage = requestToBuyInCredit.shouldReplenishFormToBuyInCreditWithError(cardsInfo);
        errorNotificationPage.shouldErrorBeVisible();
        String status = "DECLINED";
        String id = "8d378206-83c8-4d28-b78a-1c442b155aa9";
        String credit_id = "0530a9b5-4431-46f0-861f-a8e0e20e9925";
        Assertions.assertEquals(DataHelper.shouldSelectStatusFromDBToBuyInCredit(), status);
        Assertions.assertEquals(DataHelper.shouldSelectIdFromDBToBuyInCredit(), id);
        Assertions.assertEquals(DataHelper.shouldSelectCredit_idFromDBToBuyInCredit(), credit_id);
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
