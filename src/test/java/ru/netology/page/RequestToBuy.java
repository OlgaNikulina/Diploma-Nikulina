package ru.netology.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class RequestToBuy {
    private SelenideElement buttonToBuy = $("#root > div > button:nth-child(3) > span > span");
    private SelenideElement cardPayment = $("Оплата по карте");
    private SelenideElement cardNumberField = $("[placeholder='0000 0000 0000 0000']");
    private SelenideElement monthField = $("[placeholder='08']");
    private SelenideElement yearField = $("[placeholder='22']");
    private SelenideElement cardHolderField = $("Владелец");
    private SelenideElement cvvField = $("[placeholder='999']");
    private SelenideElement buttonContinue = $("Продолжить");

    public void shouldClickButtonToBuy() {
        buttonToBuy.click();
    }

    public void formCardPaymentShouldBeVisible(){
        cardPayment.shouldBe(Condition.visible);
    }

    public void shouldReplenishFormToBuy() {
        buttonToBuy.click();
        cardNumberField.setValue("");
        monthField.setValue("");
        yearField.setValue("");
        cardHolderField.setValue("");
        cvvField.setValue("");
        buttonContinue.click();
    }


}
