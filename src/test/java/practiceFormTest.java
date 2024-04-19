import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;

public class practiceFormTest {
    @BeforeEach
    void setUp() {
        Configuration.pageLoadStrategy = "eager";
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";


    }


    @Test
    void practiceForm() {
        open("/automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        $("[id=firstName]").setValue("Maxim");
        $("[id=lastName]").setValue("Muradov");
        $("[id=userEmail]").setValue("koreantech620@mail.ru").pressEnter();
        $("label[class=custom-control-label]").click();
        $("[id=userNumber]").setValue("79836025158");
        $("[id=dateOfBirthInput]").click();
        $("[class=react-datepicker__year-select]>[value='2000']").click();
        $("[class=react-datepicker__month-select]>[value='3']").click();
        $(".react-datepicker__month .react-datepicker__day--024").click();
        $("[id=subjectsContainer]").click();
        $("[id=subjectsInput]").setValue("English").pressEnter();
        $("[id=subjectsInput]").setValue("Maths").pressEnter();
        $("#hobbiesWrapper > div.col-md-9.col-sm-12 > div:nth-child(1) > label").click();
        $("[id=uploadPicture]").uploadFromClasspath("D.jpg");
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