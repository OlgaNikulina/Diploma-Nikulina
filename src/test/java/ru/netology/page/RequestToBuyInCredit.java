package ru.netology.page;

import ru.netology.data.DataHelper;

public class RequestToBuyInCredit {

    PaymentForm paymentForm;

    public SuccessfullyNotificationPage shouldReplenishFormToBuyInCreditWithSuccess(DataHelper.CardsInfo info) {
        paymentForm.getBuyInCredit().click();
        paymentForm.getCardNumberFieldInCredit().setValue(info.getCardNumber());
        paymentForm.getMonthFieldInCredit().setValue(info.getMonth());
        paymentForm.getYearFieldInCredit().setValue(info.getYear());
        paymentForm.getCardNumberFieldInCredit().setValue(info.getName());
        paymentForm.getCvvFieldInCredit().setValue(info.getCvv());
        paymentForm.getButtonContinueInCredit().click();
        return new SuccessfullyNotificationPage();
    }

    public ErrorNotificationPage shouldReplenishFormToBuyInCreditWithError(DataHelper.CardsInfo info) {
        paymentForm.getBuyInCredit().click();
        paymentForm.getCardNumberFieldInCredit().setValue(info.getCardNumber());
        paymentForm.getMonthFieldInCredit().setValue(info.getMonth());
        paymentForm.getYearFieldInCredit().setValue(info.getYear());
        paymentForm.getCardNumberFieldInCredit().setValue(info.getName());
        paymentForm.getCvvFieldInCredit().setValue(info.getCvv());
        paymentForm.getButtonContinueInCredit().click();
        return new ErrorNotificationPage();
    }
}
