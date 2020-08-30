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
        String id = "00cef50f-eb03-4234-8f9c-e0eafd7b768d";
        String payment_id = "a85051a2-b541-4376-a758-c666a9dcf29a";
        Assertions.assertEquals(DataHelper.shouldSelectStatusFromDBToBuyInCredit(), status);
        Assertions.assertEquals(DataHelper.shouldSelectIdFromDBToBuyInCredit(), id);
        Assertions.assertEquals(DataHelper.shouldSelectCredit_idFromDBToBuyInCredit(), payment_id);
        DataHelper.shouldDeleteFromDBToBuyInCredit();
    }

    @Test
    void shouldSendFormWithDeclinedCard() throws SQLException {
        val requestToBuyInCredit = open("http://localhost:8080", RequestToBuyInCredit.class);
        val cardsInfo = DataHelper.getCardsInfoWithDeclinedCArdToBuyInCredit();
        val errorNotificationPage = requestToBuyInCredit.shouldReplenishFormToBuyInCreditWithError(cardsInfo);
        errorNotificationPage.shouldErrorBeVisible();
        String status = "APPROVED";
        String id = "00cef50f-eb03-4234-8f9c-e0eafd7b768d";
        String payment_id = "a85051a2-b541-4376-a758-c666a9dcf29a";
        Assertions.assertEquals(DataHelper.shouldSelectStatusFromDBToBuyInCredit(), status);
        Assertions.assertEquals(DataHelper.shouldSelectIdFromDBToBuyInCredit(), id);
        Assertions.assertEquals(DataHelper.shouldSelectCredit_idFromDBToBuyInCredit(), payment_id);
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
