package pages.components;

import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Tag;

import static com.codeborne.selenide.Selenide.$;
@Tag("PracticeForm")
public class CalendarComponent
{
    private final SelenideElement Month = $("[class=react-datepicker__month-select]");
    private final SelenideElement Year =$("[class=react-datepicker__year-select]");
    public void setDate(String year, String month, String day)
    {

        Month.selectOption(month);
        Year.selectOption(year);
        $(String.format(".react-datepicker__day--0%s:not(.react-datepicker__day--outside-month)", day)).click();
    }
}
