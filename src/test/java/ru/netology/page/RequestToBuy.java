package ru.netology.page;

import com.codeborne.selenide.SelenideElement;
import ru.netology.data.DataHelper;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class RequestToBuy {
    private SelenideElement buttonToBuy = $$("span.button__text").find(exactText("Купить"));
    private SelenideElement cardNumberField = $("[placeholder='0000 0000 0000 0000']");
    private SelenideElement monthField = $("[placeholder='08']");
    private SelenideElement yearField = $("[placeholder='22']");
    private SelenideElement cardHolderField = $("<span class=\"input__top\">Владелец</span>");
    private SelenideElement cvvField = $("[placeholder='999']");
    private SelenideElement buttonContinue = $$("span.button__text").find(exactText("Продолжить"));

    public SuccessfullyNotificationPage shouldReplenishFormToBuyWithCorrectValues(DataHelper.CardsInfo info) {
        buttonToBuy.click();
        cardNumberField.setValue(info.getCardNumber());
        monthField.setValue(info.getMonth());
        yearField.setValue(info.getYear());
        cardHolderField.setValue(info.getName());
        cvvField.setValue(info.getCvv());
        buttonContinue.click();
        return new SuccessfullyNotificationPage();
    }

    public ErrorNotificationPage shouldReplenishFormToBuyWithEmptyFields(DataHelper.CardsInfo info) {
        buttonToBuy.click();
        cardNumberField.setValue(info.getCardNumber());
        monthField.setValue(info.getMonth());
        yearField.setValue(info.getYear());
        cardHolderField.setValue(info.getName());
        cvvField.setValue(info.getCvv());
        buttonContinue.click();
        return new ErrorNotificationPage();
    }

    public ErrorNotificationPage shouldReplenishFormToBuyWithSingleSymbols(DataHelper.CardsInfo info) {
        buttonToBuy.click();
        cardNumberField.setValue(info.getCardNumber());
        monthField.setValue(info.getMonth());
        yearField.setValue(info.getYear());
        cardHolderField.setValue(info.getName());
        cvvField.setValue(info.getCvv());
        buttonContinue.click();
        return new ErrorNotificationPage();
    }
}
