package ru.netology.page;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import javax.xml.xpath.XPath;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class ErrorNotificationPage {
    private SelenideElement cardNumberFieldSub = $x("//*[@placeholder='0000 0000 0000 0000']/parent::span/following-sibling::span");
    private SelenideElement monthFieldSub = $x("//*[@placeholder='08']/parent::span/following-sibling::span");
    private SelenideElement yearFieldSub = $x("//*[@placeholder='22']/parent::span/following-sibling::span" );
    private SelenideElement cardHolderFieldSub = $x("//*[@type='text' and not(@placeholder)]/parent::span/following-sibling::span" );
    private SelenideElement cvvFieldSub = $x("//*[@placeholder='999']/parent::span/following-sibling::span");
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
