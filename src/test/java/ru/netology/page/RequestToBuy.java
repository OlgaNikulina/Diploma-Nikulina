package ru.netology.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$$;

public class RequestToBuy {
    private SelenideElement buttonToBuy = $$("span.button__text").find(Condition.exactText("Купить"));
    private SelenideElement cardPayment = $$("h3[class]").find(Condition.exactText("Оплата по карте"));
    private SelenideElement cardNumberField = $$("input.input__control").find(Condition.exactText("Номер карты"));
    private SelenideElement monthField = $$("input.input__control").find(Condition.exactText("Месяц"));
    private SelenideElement yearField = $$("input.input__control").find(Condition.exactText("Год"));
    private SelenideElement cardHolderField = $$("input.input__control").find(Condition.exactText("Владелец"));
    private SelenideElement cvvField = $$("input.input__control").find(Condition.exactText("CVC/CVV"));
    private SelenideElement buttonContinue = $$("span.button__text").find(Condition.exactText("Продолжить"));

    public void shouldClickButtonToBuy() {
        buttonToBuy.click();
    }

    public void formCardPaymentShouldBeVisible() {
        cardPayment.shouldBe(Condition.visible);
    }

    public SuccessfullyNotificationPage shouldReplenishFormToBuyWithCorrectValues() {
        cardNumberField.setValue("");
        monthField.setValue("");
        yearField.setValue("");
        cardHolderField.setValue("");
        cvvField.setValue("");
        buttonContinue.click();
        return new SuccessfullyNotificationPage();
    }

    public ErrorNotificationPage shouldReplenishFormToBuyWithEmptyFields() {
        cardNumberField.setValue("");
        monthField.setValue("");
        yearField.setValue("");
        cardHolderField.setValue("");
        cvvField.setValue("");
        buttonContinue.click();
        return new ErrorNotificationPage();
    }

    public ErrorNotificationPage shouldReplenishFormToBuyWithSingleSymbols() {
        cardNumberField.setValue("");
        monthField.setValue("");
        yearField.setValue("");
        cardHolderField.setValue("");
        cvvField.setValue("");
        buttonContinue.click();
        return new ErrorNotificationPage();
    }
}
