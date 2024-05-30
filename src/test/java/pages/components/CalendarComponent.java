package pages.components;

import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Tag;

import static com.codeborne.selenide.Selenide.$;

public class CalendarComponent
{
    private final SelenideElement month_m = $("[class=react-datepicker__month-select]");
    private final SelenideElement year_y =$("[class=react-datepicker__year-select]");
    public void setDate(String year, String month, String day)
    {

        month_m.selectOption(month);
        year_y.selectOption(year);
        $(String.format(".react-datepicker__day--0%s:not(.react-datepicker__day--outside-month)", day)).click();
    }
}
