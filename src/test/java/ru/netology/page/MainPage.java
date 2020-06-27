package ru.netology.page;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class MainPage {
    private SelenideElement mainPage = $("div.App_appContainer__3jRx1");

    public void shouldVisibleMainPage() {
        mainPage.shouldBe(visible);
    }
}
