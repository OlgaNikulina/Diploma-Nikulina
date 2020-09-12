package ru.netology.page;

import ru.netology.data.DataHelper;

public class RequestToBuy {
    private PaymentForm paymentForm;


    public SuccessfullyNotificationPage shouldReplenishFormToBuyWithSuccess(DataHelper.CardsInfo info) {
        buttonToBuy.click();
        cardNumberField.setValue(info.getCardNumber());
        monthField.setValue(info.getMonth());
        yearField.setValue(info.getYear());
        cardHolderField.setValue(info.getName());
        cvvField.setValue(info.getCvv());
        buttonContinue.click();
        return new SuccessfullyNotificationPage();
    }

    public ErrorNotificationPage shouldReplenishFormToBuyWithError(DataHelper.CardsInfo info) {
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
