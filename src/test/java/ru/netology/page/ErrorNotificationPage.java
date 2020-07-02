package ru.netology.page;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$$;

public class ErrorNotificationPage {
    private SelenideElement errorNotification = $$("div.notification__title").find(exactText("[Ошибка]"));

    public void shouldSuccessfullyNotificationBeVisible() {
        errorNotification.waitUntil(visible, 15000);
    }
}
