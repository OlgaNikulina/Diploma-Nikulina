package ru.netology.page;

import ru.netology.data.DataHelper;

public class Replenishment {
    PaymentForm paymentForm = new PaymentForm();

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

    public SuccessfullyNotificationPage shouldReplenishFormToBuyInCreditWithSuccess(DataHelper.CardsInfo info) {
        paymentForm.getBuyInCredit().click();
        paymentForm.getCardNumberFieldInCredit().setValue(info.getCardNumber());
        paymentForm.getMonthFieldInCredit().setValue(info.getMonth());
        paymentForm.getYearFieldInCredit().setValue(info.getYear());
        paymentForm.getCardHolderFieldInCredit().setValue(info.getName());
        paymentForm.getCvvFieldInCredit().setValue(info.getCvv());
        paymentForm.getButtonContinueInCredit().click();
        return new SuccessfullyNotificationPage();
    }

    public ErrorNotificationPage shouldReplenishFormToBuyInCreditWithError(DataHelper.CardsInfo info) {
        paymentForm.getBuyInCredit().click();
        paymentForm.getCardNumberFieldInCredit().setValue(info.getCardNumber());
        paymentForm.getMonthFieldInCredit().setValue(info.getMonth());
        paymentForm.getYearFieldInCredit().setValue(info.getYear());
        paymentForm.getCardHolderFieldInCredit().setValue(info.getName());
        paymentForm.getCvvFieldInCredit().setValue(info.getCvv());
        paymentForm.getButtonContinueInCredit().click();
        return new ErrorNotificationPage();
    }
}
