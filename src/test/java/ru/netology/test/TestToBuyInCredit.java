package ru.netology.test;

import lombok.val;
import org.junit.jupiter.api.Test;
import ru.netology.data.DataHelper;
import ru.netology.page.RequestToBuyInCredit;

import static com.codeborne.selenide.Selenide.open;

public class TestToBuyInCredit {
    @Test
    void shouldSendFormWith41Card() {
        val requestToBuyInCredit = open("http://localhost:8080", RequestToBuyInCredit.class);
        val cardsInfo = DataHelper.getCardsInfoWith41();
        val successfullyNotificationPage = requestToBuyInCredit.shouldReplenishFormToBuyInCreditWithCorrectValues(cardsInfo);
        successfullyNotificationPage.shouldSuccessfullyNotificationBeVisible();
    }

    @Test
    void shouldSendFormWith42Card() {
        val requestToBuyInCredit = open("http://localhost:8080", RequestToBuyInCredit.class);
        val cardsInfo = DataHelper.getCardsInfoWith42();
        val successfullyNotificationPage = requestToBuyInCredit.shouldReplenishFormToBuyInCreditWithCorrectValues(cardsInfo);
        successfullyNotificationPage.shouldSuccessfullyNotificationBeVisible();
    }

    @Test
    void shouldNotSendFormWithEmptyFields() {
        val requestToBuyInCredit = open("http://localhost:8080", RequestToBuyInCredit.class);
        val cardsInfo = DataHelper.getCardsInfoWithEmptyFields();
        val errorNotificationPage = requestToBuyInCredit.shouldReplenishFormToBuyInCreditWithEmptyFields(cardsInfo);
        errorNotificationPage.shouldErrorNotificationBeVisible();
    }

    @Test
    void shouldNotSendFormWithSingleSymbols() {
        val requestToBuyInCredit = open("http://localhost:8080", RequestToBuyInCredit.class);
        val cardsInfo = DataHelper.getCardsInfoWithSingleSymbols();
        val errorNotificationPage = requestToBuyInCredit.shouldReplenishFormToBuyInCreditWithEmptyFields(cardsInfo);
        errorNotificationPage.shouldErrorNotificationBeVisible();
    }
}
