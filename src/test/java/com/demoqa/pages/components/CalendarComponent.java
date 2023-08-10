package com.demoqa.pages.components;

import static com.codeborne.selenide.Selenide.$;

public class CalendarComponent {
    public void setDate(String day, String month, String year) {
        $("select.react-datepicker__year-select").click();
        $("select.react-datepicker__year-select").selectOption(year);
        $("select.react-datepicker__month-select").click();
        $("select.react-datepicker__month-select").selectOption(month);
        $("div.react-datepicker__day--0" + day).click();
    }
}
