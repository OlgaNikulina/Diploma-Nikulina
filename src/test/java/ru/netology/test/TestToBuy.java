package ru.netology.test;

import lombok.val;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.data.DataHelper;
import ru.netology.page.RequestToBuy;

import javax.xml.transform.sax.SAXResult;
import java.sql.SQLException;

import static com.codeborne.selenide.Selenide.open;

public class TestToBuy {

    public enum Localhost {

        DEV("http://localhost:8080");

        private final String url;

        Localhost(String url) {
            this.url = url;
        }

        public String getUrl() {
            return url;
        }
    }

    @Test
    void shouldSendFormWithApprovedCard() throws SQLException {
        val requestToBuy = open(Localhost.DEV.getUrl(), RequestToBuy.class);
        val cardsInfo = DataHelper.getCardsInfoWithApprovedCardToBuy();
        val successfullyNotificationPage = requestToBuy.shouldReplenishFormToBuyWithSuccess(cardsInfo);
        successfullyNotificationPage.shouldSuccessfullyNotificationBeVisible();
        String status = "APPROVED";
        String id = "101c7e58-fac0-4529-8b68-a99a960b56a8";
        String payment_id = "7d6db491-dd76-4628-b6b4-3fb1472e3d05";
        Assertions.assertEquals(DataHelper.shouldSelectStatusFromDBToBuy(), status);
        Assertions.assertEquals(DataHelper.shouldSelectIdFromDBToBuy(), id);
        Assertions.assertEquals(DataHelper.shouldSelectPayment_IdFromDBToBuy(), payment_id);
        DataHelper.shouldDeleteFromPayment_entityToBuy();
        DataHelper.shouldDeleteFromOrder_entity();
    }

    @Test
    void shouldSendFormWithDeclinedCard() throws SQLException {
        val requestToBuy = open("http://localhost:8080", RequestToBuy.class);
        val cardsInfo = DataHelper.getCardsInfoWithDeclinedCardToBuy();
        val errorNotificationPage = requestToBuy.shouldReplenishFormToBuyWithError(cardsInfo);
        errorNotificationPage.shouldErrorBeVisible();
        String status = "DECLINED";
        String id = "4d15edd3-b2aa-4d8f-91ce-2d9711787222";
        String payment_id = "572d4a83-ce4f-45df-a375-eec20445d30a";
        Assertions.assertEquals(DataHelper.shouldSelectStatusFromDBToBuy(), status);
        Assertions.assertEquals(DataHelper.shouldSelectIdFromDBToBuy(), id);
        Assertions.assertEquals(DataHelper.shouldSelectPayment_IdFromDBToBuy(), payment_id);
        DataHelper.shouldDeleteFromPayment_entityToBuy();
        DataHelper.shouldDeleteFromOrder_entity();

    }

    @Test
    void shouldNotSendFormWithEmptyFields() {
        val requestToBuy = open("http://localhost:8080", RequestToBuy.class);
        val cardsInfo = DataHelper.getCardsInfoWithEmptyFields();
        val errorNotificationPage = requestToBuy.shouldReplenishFormToBuyWithError(cardsInfo);
        errorNotificationPage.shouldErrorNotificationBeVisible();
        DataHelper.shouldDeleteFromPayment_entityToBuy();
        DataHelper.shouldDeleteFromOrder_entity();
    }

    @Test
    void shouldNotSendFormWithSingleSymbols() {
        val requestToBuy = open("http://localhost:8080", RequestToBuy.class);
        val cardsInfo = DataHelper.getCardsInfoWithSingleSymbols();
        val errorNotificationPage = requestToBuy.shouldReplenishFormToBuyWithError(cardsInfo);
        errorNotificationPage.shouldErrorNotificationBeVisible();
        DataHelper.shouldDeleteFromPayment_entityToBuy();
        DataHelper.shouldDeleteFromOrder_entity();
    }
}
