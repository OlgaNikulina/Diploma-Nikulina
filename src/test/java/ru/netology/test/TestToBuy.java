package ru.netology.test;

import lombok.val;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.data.DataHelper;
import ru.netology.page.RequestToBuy;

import java.sql.SQLException;

import static com.codeborne.selenide.Selenide.open;

public class TestToBuy {
    @Test
    void shouldSendFormWithApprovedCard() throws SQLException {
        val requestToBuy = open("http://localhost:8080", RequestToBuy.class);
        val cardsInfo = DataHelper.getCardsInfoWithApprovedCardToBuy();
        val successfullyNotificationPage = requestToBuy.shouldReplenishFormToBuyWithSuccess(cardsInfo);
        successfullyNotificationPage.shouldSuccessfullyNotificationBeVisible();
        String status = "APPROVED";
        String id = "00cef50f-eb03-4234-8f9c-e0eafd7b768d";
        String payment_id = "a85051a2-b541-4376-a758-c666a9dcf29a";
        Assertions.assertEquals(DataHelper.shouldSelectStatusFromDBToBuy(), status);
        Assertions.assertEquals(DataHelper.shouldSelectIdFromDBToBuy(), id);
        Assertions.assertEquals(DataHelper.shouldSelectPayment_IdFromDBToBuy(), payment_id);
        DataHelper.shouldDeleteFromDBToBuy();
    }

    @Test
    void shouldSendFormWithDeclinedCard() throws SQLException {
        val requestToBuy = open("http://localhost:8080", RequestToBuy.class);
        val cardsInfo = DataHelper.getCardsInfoWithDeclinedCardToBuy();
        val errorNotificationPage = requestToBuy.shouldReplenishFormToBuyWithError(cardsInfo);
        errorNotificationPage.shouldErrorBeVisible();
        String status = "DECLINED";
        String id = "57032656-f3ee-400e-be72-bc992790640f";
        String payment_id = "4d3bff25-2c5a-4a2c-88b9-ef2deb6e3d0c";
        Assertions.assertEquals(DataHelper.shouldSelectStatusFromDBToBuy(), status);
        Assertions.assertEquals(DataHelper.shouldSelectIdFromDBToBuy(), id);
        Assertions.assertEquals(DataHelper.shouldSelectPayment_IdFromDBToBuy(), payment_id);
        DataHelper.shouldDeleteFromDBToBuy();
    }

    @Test
    void shouldNotSendFormWithEmptyFields() {
        val requestToBuy = open("http://localhost:8080", RequestToBuy.class);
        val cardsInfo = DataHelper.getCardsInfoWithEmptyFields();
        val errorNotificationPage = requestToBuy.shouldReplenishFormToBuyWithError(cardsInfo);
        errorNotificationPage.shouldErrorNotificationBeVisible();
        DataHelper.shouldDeleteFromDBToBuy();
    }

    @Test
    void shouldNotSendFormWithSingleSymbols() {
        val requestToBuy = open("http://localhost:8080", RequestToBuy.class);
        val cardsInfo = DataHelper.getCardsInfoWithSingleSymbols();
        val errorNotificationPage = requestToBuy.shouldReplenishFormToBuyWithError(cardsInfo);
        errorNotificationPage.shouldErrorNotificationBeVisible();
        DataHelper.shouldDeleteFromDBToBuy();
    }
}
