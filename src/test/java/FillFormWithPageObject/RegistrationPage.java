package FillFormWithPageObject;

import com.codeborne.selenide.SelenideElement;
import components.CalendarComponent;
import components.CheckResultComponent;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage
{
    private SelenideElement setFirstName = $("[id=firstName]");
    private SelenideElement setLastName = $("[id=lastName]");

    private SelenideElement setEmail = $("[id=userEmail]");
    private  SelenideElement chooseCheckbox = $("label[class=custom-control-label]");
    private SelenideElement setMobileNum = $("[id=userNumber]");
    private SelenideElement chooseDatePicker = $("[id=dateOfBirthInput]");
    private  SelenideElement SubjectFormOpen = $("[id=subjectsContainer]");
    private SelenideElement SetSubject = $("[id=subjectsInput]");
    private SelenideElement selectHobbie = $("#hobbiesWrapper");
    private SelenideElement uploadPicture = $("[id=uploadPicture]");
    private  SelenideElement setAddress = $("[id=currentAddress]");
    private SelenideElement selectState = $("[id=react-select-3-input]");
    private SelenideElement selectCity = $("[id=react-select-4-input]");
    private SelenideElement submitForm = $("[id=submit]");
    CalendarComponent component = new CalendarComponent();
    CheckResultComponent checkResultComponent = new CheckResultComponent();

    public RegistrationPage OpenPage()
    {
        open("/automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        return this;
    }
    public RegistrationPage SetFirstName(String FirstName)
    {
        setFirstName.setValue(FirstName);
        return this;
    }
    public RegistrationPage SetLastName(String LastName)
    {
        setLastName.setValue(LastName);
        return this;
    }
    public RegistrationPage SetEmail(String email)
    {
        setEmail.setValue(email).pressEnter();
        return this;
    }
    public RegistrationPage ChooseGender()
    {
        chooseCheckbox.click();
        return this;
    }
    public RegistrationPage SetPhoneNumber(String number)
    {
        setMobileNum.setValue(number);
        return this;
    }
    public RegistrationPage SetDateOfBirth(String year, String month)
    {
        chooseDatePicker.click();
        component.SetDate(year,month);
        return this;

    }
    public  RegistrationPage CheckResults(String key, String value)
    {
        checkResultComponent.CheckResult(key,value);
        return this;
    }
    public RegistrationPage SetSubject(String subject)
    {
        SubjectFormOpen.click();
        SetSubject.setValue(subject).pressEnter();
        return this;
    }
    public RegistrationPage SelectHobbies(String hobbie)
    {
        selectHobbie.$(byText(hobbie)).click();
        return this;
    }
    public RegistrationPage UploadPicture(String pictureName)
    {
        uploadPicture.uploadFromClasspath(pictureName);
        return this;
    }
    public RegistrationPage SetAddress(String address)
    {
        setAddress.setValue(address);
        return this;
    }
    public RegistrationPage SelectStateAndCity(String state, String city)
    {
        selectState.setValue(state).pressEnter();
        selectCity.setValue(city).pressEnter();
        return this;
    }
    public RegistrationPage SubmitForm()
    {
        submitForm.click();
        return this;
    }
}
