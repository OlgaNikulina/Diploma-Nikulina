package ru.netology.page;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$$;

public class SuccessfullyNotificationPage {
    private SelenideElement successfullyNotification = $$("div.notification__title").find(exactText("[Успешно]"));

    public void shouldSuccessfullyNotificationBeVisible() {
        successfullyNotification.waitUntil(visible, 15000);
    }
}
