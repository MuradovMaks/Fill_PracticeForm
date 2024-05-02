package components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class CalendarComponent
{
    public void SetDate(String year, String month)
    {

        $("[class=react-datepicker__month-select]").selectOption(month);
        $("[class=react-datepicker__year-select]").selectOption(year);
        $(".react-datepicker__month .react-datepicker__day--024").click();
    }
}
