package pages.components;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Tag;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
@Tag("PracticeForm")
public class TableResultComponent
{
    private final SelenideElement TableResponse =  $("[class=table-responsive]");
    public void CheckResult(String key, String value)
    {
        TableResponse.$(byText(key)).parent().shouldHave(Condition.text(value));
    }
}
