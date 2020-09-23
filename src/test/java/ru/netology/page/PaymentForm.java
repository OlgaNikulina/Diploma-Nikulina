package ru.netology.page;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.WebElement;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.*;

public class PaymentForm {
    private SelenideElement buttonToBuy = $((WebElement) exactText("Купить"));
    private SelenideElement cardNumberField = $("[placeholder='0000 0000 0000 0000']");
    private SelenideElement monthField = $("[placeholder='08']");
    private SelenideElement yearField = $("[placeholder='22']");
    private SelenideElement cardHolderField = $x("//*[@type='text' and not(@placeholder)]");
    private SelenideElement cvvField = $("[placeholder='999']");
    private SelenideElement buttonContinue = $$("span.button__text").find(exactText("Продолжить"));
    private SelenideElement buyInCredit = $$("span.button__text").find(exactText("Купить в кредит"));
    private SelenideElement cardNumberFieldInCredit = $("[placeholder='0000 0000 0000 0000']");
    private SelenideElement monthFieldInCredit = $("[placeholder='08']");
    private SelenideElement yearFieldInCredit = $("[placeholder='22']");
    private SelenideElement cardHolderFieldInCredit =  $x("//*[@type='text' and not(@placeholder)]");
    private SelenideElement cvvFieldInCredit = $("[placeholder='999']");
    private SelenideElement buttonContinueInCredit = $$("span.button__text" ).find(exactText("Продолжить" ));

    public SelenideElement getButtonToBuy() {
        return buttonToBuy;
    }

    public SelenideElement getCardNumberField() {
        return cardNumberField;
    }

    public SelenideElement getMonthField() {
        return monthField;
    }

    public SelenideElement getYearField() {
        return yearField;
    }

    public SelenideElement getCardHolderField() {
        return cardHolderField;
    }

    public SelenideElement getCvvField() {
        return cvvField;
    }

    public SelenideElement getButtonContinue() {
        return buttonContinue;
    }

    public SelenideElement getBuyInCredit() {
        return buyInCredit;
    }

    public SelenideElement getCardNumberFieldInCredit() {
        return cardNumberFieldInCredit;
    }

    public SelenideElement getMonthFieldInCredit() {
        return monthFieldInCredit;
    }

    public SelenideElement getYearFieldInCredit() {
        return yearFieldInCredit;
    }

    public SelenideElement getCardHolderFieldInCredit() {
        return cardHolderFieldInCredit;
    }

    public SelenideElement getCvvFieldInCredit() {
        return cvvFieldInCredit;
    }

    public SelenideElement getButtonContinueInCredit() {
        return buttonContinueInCredit;
    }
}
