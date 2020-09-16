package ru.netology.page;

import ru.netology.data.DataHelper;

public class RequestToBuy {
    PaymentForm paymentForm;

    public SuccessfullyNotificationPage shouldReplenishFormToBuyWithSuccess(DataHelper.CardsInfo info) {
        paymentForm.getButtonToBuy().click();
        paymentForm.getCardNumberField().setValue(info.getCardNumber());
        paymentForm.getMonthField().setValue(info.getMonth());
        paymentForm.getYearField().setValue(info.getYear());
        paymentForm.getCardHolderField().setValue(info.getName());
        paymentForm.getCvvField().setValue(info.getCvv());
        paymentForm.getButtonContinue().click();
        return new SuccessfullyNotificationPage();
    }

    public ErrorNotificationPage shouldReplenishFormToBuyWithError(DataHelper.CardsInfo info) {
        paymentForm.getButtonToBuy().click();
        paymentForm.getCardNumberField().setValue(info.getCardNumber());
        paymentForm.getMonthField().setValue(info.getMonth());
        paymentForm.getYearField().setValue(info.getYear());
        paymentForm.getCardHolderField().setValue(info.getName());
        paymentForm.getCvvField().setValue(info.getCvv());
        paymentForm.getButtonContinue().click();
        return new ErrorNotificationPage();
    }
}
