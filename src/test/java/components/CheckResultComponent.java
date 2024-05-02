package components;

import com.codeborne.selenide.Condition;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class CheckResultComponent
{
    public void CheckResult(String key, String value)
    {
        $("[class=table-responsive]").$(byText(key)).parent().shouldHave(Condition.text(value));
    }
}
