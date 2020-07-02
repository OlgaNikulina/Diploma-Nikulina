package ru.netology.page;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$$;

public class MainPage {
    private SelenideElement heading = $$("h2[class]").find(exactText("Путешествие дня"));

    public void shouldVisibleMainPage() {
        heading.shouldBe(visible);
    }
}
