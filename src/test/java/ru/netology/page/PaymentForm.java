package ru.netology.page;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.*;

public class PaymentForm {
    private SelenideElement buttonToBuy = $$("span.button__text").find(exactText("Купить"));
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
}
