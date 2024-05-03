package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;
import pages.components.TableResultComponent;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage
{
    private SelenideElement SetFirstName = $("[id=firstName]");
    private SelenideElement SetLastName = $("[id=lastName]");

    private SelenideElement SetEmail = $("[id=userEmail]");
    private  SelenideElement ChooseCheckbox = $("label[class=custom-control-label]");
    private SelenideElement SetMobileNum = $("[id=userNumber]");
    private SelenideElement ChooseDatePicker = $("[id=dateOfBirthInput]");
    private  SelenideElement SubjectFormOpen = $("[id=subjectsContainer]");
    private SelenideElement SetSubject = $("[id=subjectsInput]");
    private SelenideElement SelectHobbie = $("#hobbiesWrapper");
    private SelenideElement UploadPicture = $("[id=uploadPicture]");
    private  SelenideElement SetAddress = $("[id=currentAddress]");
    private SelenideElement SelectState = $("[id=react-select-3-input]");
    private SelenideElement selectCity = $("[id=react-select-4-input]");
    private SelenideElement SubmitForm = $("[id=submit]");
    CalendarComponent component = new CalendarComponent();
    TableResultComponent checkResultComponent = new TableResultComponent();

    public RegistrationPage openPage()
    {
        open("/automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        return this;
    }
    public RegistrationPage setFirstName(String FirstName)
    {
        SetFirstName.setValue(FirstName);
        return this;
    }
    public RegistrationPage setLastName(String LastName)
    {
        SetLastName.setValue(LastName);
        return this;
    }
    public RegistrationPage setEmail(String email)
    {
        SetEmail.setValue(email).pressEnter();
        return this;
    }
    public RegistrationPage chooseGender()
    {
        ChooseCheckbox.click();
        return this;
    }
    public RegistrationPage setPhoneNumber(String number)
    {
        SetMobileNum.setValue(number);
        return this;
    }
    public RegistrationPage setDateOfBirth(String year, String month, String day)
    {
        ChooseDatePicker.click();
        component.setDate(year,month,day);
        return this;

    }
    public  RegistrationPage checkResults(String key, String value)
    {
        checkResultComponent.CheckResult(key,value);
        return this;
    }
    public RegistrationPage setSubject(String subject)
    {
        SubjectFormOpen.click();
        SetSubject.setValue(subject).pressEnter();
        return this;
    }
    public RegistrationPage selectHobbies(String hobbie)
    {
        SelectHobbie.$(byText(hobbie)).click();
        return this;
    }
    public RegistrationPage uploadPicture(String pictureName)
    {
        UploadPicture.uploadFromClasspath(pictureName);
        return this;
    }
    public RegistrationPage setAddress(String address)
    {
        SetAddress.setValue(address);
        return this;
    }
    public RegistrationPage selectStateAndCity(String state, String city)
    {
        SelectState.setValue(state).pressEnter();
        selectCity.setValue(city).pressEnter();
        return this;
    }
    public RegistrationPage submitForm()
    {
        SubmitForm.click();
        return this;
    }
}
