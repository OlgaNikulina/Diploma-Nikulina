package ru.netology.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class RequestToBuyInCredit {
    private SelenideElement buyInCredit = $("#root > div > button.button.button_view_extra.button_size_m.button_theme_alfa-on-white > span > span");
    private SelenideElement cardPayment = $("Оплата по карте");
    private SelenideElement cardNumberField = $("[placeholder='0000 0000 0000 0000']");
    private SelenideElement monthField = $("[placeholder='08']");
    private SelenideElement yearField = $("[placeholder='22']");
    private SelenideElement cardHolderField = $("Владелец");
    private SelenideElement cvvField = $("[placeholder='999']");
    private SelenideElement buttonContinue = $("Продолжить");

    public void shouldClickButtonToBuy() {
        buyInCredit.click();
    }

    public void formCardPaymentShouldBeVisible(){
        cardPayment.shouldBe(Condition.visible);
    }

    public void shouldReplenishFormToBuy() {
        cardNumberField.setValue("");
        monthField.setValue("");
        yearField.setValue("");
        cardHolderField.setValue("");
        cvvField.setValue("");
        buttonContinue.click();
    }
}
