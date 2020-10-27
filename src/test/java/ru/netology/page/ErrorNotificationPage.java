package ru.netology.page;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import javax.xml.xpath.XPath;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class ErrorNotificationPage {
    private SelenideElement cardNumberFieldSub2 = $("div:nth-child(1) > span > span > span.input__sub" );
    private SelenideElement cardNumberFieldSub = $(By.xpath("[@class='email']/..//following-sibling::span.input__sub"));
    private SelenideElement cardNumberFieldSub1 = $("[placeholder='0000 0000 0000 0000'] .input__sub");
    private SelenideElement monthFieldSub = $("div:nth-child(2) > span > span:nth-child(1) > span > span > span.input__sub");
    private SelenideElement yearFieldSub = $("div:nth-child(2) > span > span:nth-child(2) > span > span > span.input__sub" );
    private SelenideElement cardHolderFieldSub = $("div > form > fieldset > div:nth-child(3) > span > span:nth-child(1) > span > span > span.input__sub" );
    private SelenideElement cvvFieldSub = $("div:nth-child(3) > span > span:nth-child(2) > span > span > span.input__sub" );
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
