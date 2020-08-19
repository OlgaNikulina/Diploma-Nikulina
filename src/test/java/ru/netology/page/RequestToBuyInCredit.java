package ru.netology.page;

import com.codeborne.selenide.SelenideElement;
import ru.netology.data.DataHelper;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.*;

public class RequestToBuyInCredit {
    private SelenideElement buyInCredit = $$("span.button__text").find(exactText("Купить в кредит"));
    private SelenideElement cardNumberField = $("[placeholder='0000 0000 0000 0000']");
    private SelenideElement monthField = $("[placeholder='08']");
    private SelenideElement yearField = $("[placeholder='22']");
    private SelenideElement cardHolderField =  $x("//*[@type='text' and not(@placeholder)]");
    private SelenideElement cvvField = $("[placeholder='999']");
    private SelenideElement buttonContinue = $$("span.button__text" ).find(exactText("Продолжить" ));

    public SuccessfullyNotificationPage shouldReplenishFormToBuyInCreditWithSuccess(DataHelper.CardsInfo info) {
        buyInCredit.click();
        cardNumberField.setValue(info.getCardNumber());
        monthField.setValue(info.getMonth());
        yearField.setValue(info.getYear());
        cardHolderField.setValue(info.getName());
        cvvField.setValue(info.getCvv());
        buttonContinue.click();
        buttonContinue.click();
        return new SuccessfullyNotificationPage();
    }

    public ErrorNotificationPage shouldReplenishFormToBuyInCreditWithError(DataHelper.CardsInfo info) {
        buyInCredit.click();
        cardNumberField.setValue(info.getCardNumber());
        monthField.setValue(info.getMonth());
        yearField.setValue(info.getYear());
        cardHolderField.setValue(info.getName());
        cvvField.setValue(info.getCvv());
        buttonContinue.click();
        buttonContinue.click();
        return new ErrorNotificationPage();
    }
}
