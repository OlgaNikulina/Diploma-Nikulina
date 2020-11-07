package ru.netology.test;

import lombok.val;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.data.DataHelper;
import ru.netology.page.Replenishment;

import java.sql.SQLException;

import static com.codeborne.selenide.Selenide.open;

public class TestToBuy {

    String approvedStatus = "APPROVED";
    String declinedStatus = "DECLINED";


    @Test
    void shouldSendFormWithApprovedCard() throws SQLException {
        val replenishment = open(DataHelper.Localhost.DEV.getUrl(), Replenishment.class);
        val cardsInfo = DataHelper.getCardsInfoWithApprovedCardToBuy();
        val successfullyNotificationPage = replenishment.shouldReplenishFormToBuyWithSuccess(cardsInfo);
        successfullyNotificationPage.shouldSuccessfullyNotificationBeVisible();
        String id = "0968cd26-b715-497e-a39c-b0b1e3bcc5f9";
        String payment_id = "31a2a064-6392-431d-bc56-e693d7b08871";
        Assertions.assertEquals(DataHelper.shouldSelectStatusFromDBToBuy(), approvedStatus);
        Assertions.assertEquals(DataHelper.shouldSelectIdFromDBToBuy(), id);
        Assertions.assertEquals(DataHelper.shouldSelectPayment_IdFromDBToBuy(), payment_id);
        DataHelper.shouldDeleteFromPayment_entityToBuy();
        DataHelper.shouldDeleteFromOrder_entity();
    }

    @Test
    void shouldSendFormWithDeclinedCard() throws SQLException {
        val replenishment = open(DataHelper.Localhost.DEV.getUrl(), Replenishment.class);
        val cardsInfo = DataHelper.getCardsInfoWithDeclinedCardToBuy();
        val errorNotificationPage = replenishment.shouldReplenishFormToBuyWithError(cardsInfo);
        errorNotificationPage.shouldErrorBeVisible();
        String id = "4d15edd3-b2aa-4d8f-91ce-2d9711787222";
        String payment_id = "572d4a83-ce4f-45df-a375-eec20445d30a";
        Assertions.assertEquals(DataHelper.shouldSelectStatusFromDBToBuy(), declinedStatus);
        Assertions.assertEquals(DataHelper.shouldSelectIdFromDBToBuy(), id);
        Assertions.assertEquals(DataHelper.shouldSelectPayment_IdFromDBToBuy(), payment_id);
        DataHelper.shouldDeleteFromPayment_entityToBuy();
        DataHelper.shouldDeleteFromOrder_entity();
    }

    @Test
    void shouldNotSendFormWithEmptyFields() {
        val replenishment = open(DataHelper.Localhost.DEV.getUrl(), Replenishment.class);
        val cardsInfo = DataHelper.getCardsInfoWithEmptyFields();
        val errorNotificationPage = replenishment.shouldReplenishFormToBuyWithError(cardsInfo);
        errorNotificationPage.shouldErrorNotificationBeVisible();
        DataHelper.shouldDeleteFromPayment_entityToBuy();
        DataHelper.shouldDeleteFromOrder_entity();
    }

    @Test
    void shouldNotSendFormWithSingleSymbols() {
        val replenishment = open(DataHelper.Localhost.DEV.getUrl(), Replenishment.class);
        val cardsInfo = DataHelper.getCardsInfoWithSingleSymbols();
        val errorNotificationPage = replenishment.shouldReplenishFormToBuyWithError(cardsInfo);
        errorNotificationPage.shouldErrorNotificationBeVisible();
        DataHelper.shouldDeleteFromPayment_entityToBuy();
        DataHelper.shouldDeleteFromOrder_entity();
    }
}
