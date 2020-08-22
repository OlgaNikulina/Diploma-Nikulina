package ru.netology.test;

import com.mysql.cj.x.protobuf.MysqlxDatatypes;
import lombok.val;
import org.apache.http.util.Asserts;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;
import ru.netology.data.DataHelper;
import ru.netology.page.RequestToBuy;

import java.sql.SQLException;
import java.util.Objects;

import static com.codeborne.selenide.Selenide.open;

public class TestToBuy {
    @Test
    void shouldSendFormWithApprovedCard() throws SQLException {
        val requestToBuy = open("http://localhost:8080", RequestToBuy.class);
        val cardsInfo = DataHelper.getCardsInfoWithApprovedCardToBuy();
        val successfullyNotificationPage = requestToBuy.shouldReplenishFormToBuyWithSuccess(cardsInfo);
        successfullyNotificationPage.shouldSuccessfullyNotificationBeVisible();
        String status = "APPROVED";
        String id = "a146f524-7da3-47d4-8ab4-1b262d46fdfd";
        String payment_id = "3f1e3be1-e7e8-40a4-b188-85a77cbdf26b";
        Objects.equals(DataHelper.shouldSelectFromDBToBuy(status), status);
        Assertions.assertEquals(DataHelper.shouldSelectFromDBToBuy(), status);
        Assertions.assertEquals(DataHelper.shouldSelectFromDBToBuy(), id);
        Assertions.assertEquals(DataHelper.shouldSelectFromDBToBuy(), payment_id);
        DataHelper.shouldDeleteFromDBToBuy();
    }

    @Test
    void shouldSendFormWithDeclinedCard() throws SQLException {
        val requestToBuy = open("http://localhost:8080", RequestToBuy.class);
        val cardsInfo = DataHelper.getCardsInfoWithDeclinedCardToBuy();
        val errorNotificationPage = requestToBuy.shouldReplenishFormToBuyWithError(cardsInfo);
        errorNotificationPage.shouldErrorBeVisible();
        DataHelper.shouldSelectFromDBToBuy();
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
