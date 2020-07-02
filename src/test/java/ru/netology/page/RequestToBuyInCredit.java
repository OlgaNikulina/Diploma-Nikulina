package ru.netology.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$$;

public class RequestToBuyInCredit {
    private SelenideElement buyInCredit = $$("span.button__text").find(Condition.exactText("Купить в кредит"));
    private SelenideElement cardPayment = $$("h3[class]").find(Condition.exactText("Оплата по карте"));
    private SelenideElement cardNumberField = $$("input.input__control").find(Condition.exactText("Номер карты"));
    private SelenideElement monthField = $$("input.input__control").find(Condition.exactText("Месяц"));
    private SelenideElement yearField = $$("input.input__control").find(Condition.exactText("Год"));
    private SelenideElement cardHolderField = $$("input.input__control").find(Condition.exactText("Владелец"));
    private SelenideElement cvvField = $$("input.input__control").find(Condition.exactText("CVC/CVV"));
    private SelenideElement buttonContinue = $$("span.button__text").find(Condition.exactText("Продолжить"));

    public void shouldClickButtonToBuy() {
        buyInCredit.click();
    }

    public void formCardPaymentShouldBeVisible() {
        cardPayment.shouldBe(Condition.visible);
    }

    public void shouldReplenishFormToBuyInCreditWithCorrectValues() {
        cardNumberField.setValue("");
        monthField.setValue("");
        yearField.setValue("");
        cardHolderField.setValue("");
        cvvField.setValue("");
        buttonContinue.click();
    }

    public ErrorNotificationPage shouldReplenishFormToBuyInCreditWithEmptyFields() {
        cardNumberField.setValue("");
        monthField.setValue("");
        yearField.setValue("");
        cardHolderField.setValue("");
        cvvField.setValue("");
        buttonContinue.click();
        return new ErrorNotificationPage();
    }

    public ErrorNotificationPage shouldReplenishFormToBuyInCreditWithSingleSymbols() {
        cardNumberField.setValue("");
        monthField.setValue("");
        yearField.setValue("");
        cardHolderField.setValue("");
        cvvField.setValue("");
        buttonContinue.click();
        return new ErrorNotificationPage();
    }
}
