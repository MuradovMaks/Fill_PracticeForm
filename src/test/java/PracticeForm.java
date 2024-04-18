import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.commands.SelectOptionByTextOrIndex;
import com.codeborne.selenide.selector.ByText;
import netscape.javascript.JSObject;
import org.apache.commons.exec.OS;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.idealized.Javascript;

import javax.tools.StandardJavaFileManager;
import java.io.File;

import static com.codeborne.selenide.Selenide.*;

public class PracticeForm
{
    @BeforeEach
    void SetUp()
    {
        Configuration.pageLoadStrategy = "eager";
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";

    }


    @Test
    void PracticeForm()
    {




        open("/automation-practice-form");
        $("[id=firstName]").setValue("Maxim");
        $("[id=lastName]").setValue("Muradov");
        $("[id=userEmail]").setValue("koreantech620@mail.ru").pressEnter();
        $("label[class=custom-control-label]").click();

        $("[id=userNumber]").setValue("79836025158");
        $("[id=dateOfBirthInput]").click();
        //$(".react-datepicker__year-select").click();
        $("[class=react-datepicker__year-select]>[value='2000']").click();
        //$("[class=react-datepicker__month-select]").click();
        $("[class=react-datepicker__month-select]>[value='3']").click();
        //$("[class=react-datepicker__day react-datepicker__day--025]").click();
        $(".react-datepicker__month .react-datepicker__day--024").click();

        $("[id=subjectsContainer]").click();
        $("[id=subjectsInput]").setValue("English").pressEnter();
        $("[id=subjectsInput]").setValue("Maths").pressEnter();
        $("#hobbiesWrapper > div.col-md-9.col-sm-12 > div:nth-child(1) > label").click();
        //$("[id=uploadPicture]").doubleClick();
        File file = new File("C:\\Users\\Murad\\IdeaProjects\\Fill_PracticeForm\\src\\test\\resources\\D.jpg");
        $("[id=uploadPicture]").uploadFile(file);
        $("[id=currentAddress]").click();
        $("[id=currentAddress]").setValue("Lenina 25");
        $("[id=react-select-3-input]").setValue("NCR").pressEnter();
        $("[id=react-select-4-input]").setValue("Delhi").pressEnter();
        $("[id=submit]").submit();
        $("[class=table-responsive]").shouldHave(Condition.text("Maxim Muradov"));
        $("[class=table-responsive]").shouldHave(Condition.text("koreantech620@mail.ru"));
        $("[class=table-responsive]").shouldHave(Condition.text("24 April,2000"));
        $("[class=table-responsive]").shouldHave(Condition.text("Male"));
        $("[class=table-responsive]").shouldHave(Condition.text("7983602515"));
        $("[class=table-responsive]").shouldHave(Condition.text("English"));
        $("[class=table-responsive]").shouldHave(Condition.text("Maths"));
        $("[class=table-responsive]").shouldHave(Condition.text("Sports"));
        $("[class=table-responsive]").shouldHave(Condition.text("D.jpg"));
        $("[class=table-responsive]").shouldHave(Condition.text("Lenina 25"));
        $("[class=table-responsive]").shouldHave(Condition.text("NCR Delhi"));
        $("#closeLargeModal").click();
    }
}