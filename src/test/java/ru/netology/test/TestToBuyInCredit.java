package ru.netology.test;

import lombok.val;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.data.DataHelper;
import ru.netology.page.Replenishment;

import java.sql.SQLException;

import static com.codeborne.selenide.Selenide.open;

public class TestToBuyInCredit {


    @Test
    void shouldSendFormWithApprovedCard() throws SQLException {
        val replenishment = open(DataHelper.Localhost.DEV.getUrl(), Replenishment.class);
        val cardsInfo = DataHelper.getCardsInfoWithApprovedCardToBuyInCredit();
        val successfullyNotificationPage = replenishment.shouldReplenishFormToBuyInCreditWithSuccess(cardsInfo);
        successfullyNotificationPage.shouldSuccessfullyNotificationBeVisible();
        String status = "APPROVED";
        String id = "20650ed5-37a9-4648-8132-a173779720ab";
        String credit_id = null;
        Assertions.assertEquals(DataHelper.shouldSelectStatusFromDBToBuyInCredit(), status);
        Assertions.assertEquals(DataHelper.shouldSelectIdFromDBToBuyInCredit(), id);
        Assertions.assertEquals(DataHelper.shouldSelectCredit_idFromDBToBuyInCredit(), credit_id);
        DataHelper.shouldDeleteFromCredit_request_entityToBuyInCredit();
        DataHelper.shouldDeleteFromOrder_entity();
    }

    @Test
    void shouldSendFormWithDeclinedCard() throws SQLException {
        val replenishment = open(DataHelper.Localhost.DEV.getUrl(), Replenishment.class);
        val cardsInfo = DataHelper.getCardsInfoWithDeclinedCArdToBuyInCredit();
        val errorNotificationPage = replenishment.shouldReplenishFormToBuyInCreditWithError(cardsInfo);
        errorNotificationPage.shouldErrorBeVisible();
        String status = "DECLINED";
        String id = "8d378206-83c8-4d28-b78a-1c442b155aa9";
        String credit_id = "0530a9b5-4431-46f0-861f-a8e0e20e9925";
        Assertions.assertEquals(DataHelper.shouldSelectStatusFromDBToBuyInCredit(), status);
        Assertions.assertEquals(DataHelper.shouldSelectIdFromDBToBuyInCredit(), id);
        Assertions.assertEquals(DataHelper.shouldSelectCredit_idFromDBToBuyInCredit(), credit_id);
        DataHelper.shouldDeleteFromCredit_request_entityToBuyInCredit();
        DataHelper.shouldDeleteFromOrder_entity();
    }

    @Test
    void shouldNotSendFormWithEmptyFields() {
        val replenishment = open(DataHelper.Localhost.DEV.getUrl(), Replenishment.class);
        val cardsInfo = DataHelper.getCardsInfoWithEmptyFields();
        val errorNotificationPage = replenishment.shouldReplenishFormToBuyInCreditWithError(cardsInfo);
        errorNotificationPage.shouldErrorNotificationBeVisible();
        DataHelper.shouldDeleteFromCredit_request_entityToBuyInCredit();
        DataHelper.shouldDeleteFromOrder_entity();
    }

    @Test
    void shouldNotSendFormWithSingleSymbols() {
        val replenishment = open(DataHelper.Localhost.DEV.getUrl(), Replenishment.class);
        val cardsInfo = DataHelper.getCardsInfoWithSingleSymbols();
        val errorNotificationPage = replenishment.shouldReplenishFormToBuyInCreditWithError(cardsInfo);
        errorNotificationPage.shouldErrorNotificationBeVisible();
        DataHelper.shouldDeleteFromCredit_request_entityToBuyInCredit();
        DataHelper.shouldDeleteFromOrder_entity();
    }
}
