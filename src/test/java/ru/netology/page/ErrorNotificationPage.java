package ru.netology.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class ErrorNotificationPage {
    private SelenideElement cardNumberFieldSub = $("div > form > fieldset > div:nth-child(1) > span > span > span.input__sub" );
    private SelenideElement monthFieldSub = $("div > form > fieldset > div:nth-child(2) > span > span:nth-child(1) > span > span > span.input__sub");
    private SelenideElement yearFieldSub = $("div > form > fieldset > div:nth-child(2) > span > span:nth-child(2) > span > span > span.input__sub" );
    private SelenideElement cardHolderFieldSub = $("div > form > fieldset > div:nth-child(3) > span > span:nth-child(1) > span > span > span.input__sub" );
    private SelenideElement cvvFieldSub = $("div > form > fieldset > div:nth-child(3) > span > span:nth-child(2) > span > span > span.input__sub" );
    private SelenideElement errorNotification = $$("div.notification__title" ).find(exactText("Ошибка" ));

    public void shouldErrorNotificationBeVisible() {
        cardNumberFieldSub.shouldBe(visible);
        monthFieldSub.shouldBe(visible);
        yearFieldSub.shouldBe(visible);
        cardHolderFieldSub.shouldBe(visible);
        cvvFieldSub.shouldBe(visible);
    }

    public void shouldErrorBeVisible() {
        errorNotification.waitUntil(visible, 15000);
    }
}
