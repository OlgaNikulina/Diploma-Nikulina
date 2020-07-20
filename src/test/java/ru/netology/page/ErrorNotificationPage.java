package ru.netology.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$$;

public class ErrorNotificationPage {
    private SelenideElement cardNumberFieldSub = $$("input.input__sub").find(Condition.exactText("Неверный формат"));
    private SelenideElement monthFieldSub = $$("input.input__sub").find(Condition.exactText("Неверный формат"));
    private SelenideElement yearFieldSub = $$("input.input__sub").find(Condition.exactText("Неверный формат"));
    private SelenideElement cardHolderFieldSub = $$("input.input__sub").find(Condition.exactText("Поле обязательно для заполнения"));
    private SelenideElement cvvFieldSub = $$("input.input__sub").find(Condition.exactText("Неверный формат"));
    private SelenideElement errorNotification = $$("div.notification__title").find(exactText("[Ошибка]"));

    public void shouldErrorNotificationBeVisible() {
        cardNumberFieldSub.shouldBe(visible);
        monthFieldSub.shouldBe(visible);
        yearFieldSub.shouldBe(visible);
        cardHolderFieldSub.shouldBe(visible);
        cvvFieldSub.shouldBe(visible);
    }

    public void shouldErrorBeVisible(){
        errorNotification.shouldBe(visible);
    }
}
