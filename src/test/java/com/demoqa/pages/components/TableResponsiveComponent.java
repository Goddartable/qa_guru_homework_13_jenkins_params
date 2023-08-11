package com.demoqa.pages.components;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
public class TableResponsiveComponent {
    public void checkForm(String parentElement, String textElement) {
        $(".table-responsive").$(byText(parentElement)).parent().shouldHave(text(textElement));
    }
}
