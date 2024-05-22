package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import pages.components.CalendarComponent;
import pages.components.TableResultComponent;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {

    private SelenideElement SetFirstName = $("[id=firstName]");
    private SelenideElement SetLastName = $("[id=lastName]");

    private SelenideElement SetEmail = $("[id=userEmail]");
    private SelenideElement ChooseCheckbox = $("label[class=custom-control-label]");
    private SelenideElement SetMobileNum = $("[id=userNumber]");
    private SelenideElement ChooseDatePicker = $("[id=dateOfBirthInput]");
    private SelenideElement SubjectFormOpen = $("[id=subjectsContainer]");
    private SelenideElement SetSubject = $("[id=subjectsInput]");
    private SelenideElement SelectHobbie = $("#hobbiesWrapper");
    private SelenideElement UploadPicture = $("[id=uploadPicture]");
    private SelenideElement SetAddress = $("[id=currentAddress]");
    private SelenideElement SelectState = $("[id=react-select-3-input]");
    private SelenideElement selectCity = $("[id=react-select-4-input]");
    private SelenideElement SubmitForm = $("[id=submit]");
    CalendarComponent component = new CalendarComponent();
    TableResultComponent checkResultComponent = new TableResultComponent();

    @Step("Открываем страницу Practice Form")
    public RegistrationPage openPage() {
        open("/automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        return this;
    }

    @Step("Вводим Имя пользователя {FirstName}")
    public RegistrationPage setFirstName(String FirstName) {
        SetFirstName.setValue(FirstName);
        return this;
    }

    @Step("Вводим Фамилию пользователя {LastName}")
    public RegistrationPage setLastName(String LastName) {
        SetLastName.setValue(LastName);
        return this;
    }

    @Step("Вводим Email {email}")
    public RegistrationPage setEmail(String email) {
        SetEmail.setValue(email).pressEnter();
        return this;
    }

    @Step("Выбор гендера ")
    public RegistrationPage chooseGender() {
        ChooseCheckbox.click();
        return this;
    }

    @Step("Вводим номер телефона {number}")
    public RegistrationPage setPhoneNumber(String number) {
        SetMobileNum.setValue(number);
        return this;
    }

    @Step("Вводим Дату Рождения {day} {month} {year}")
    public RegistrationPage setDateOfBirth(String year, String month, String day) {
        ChooseDatePicker.click();
        component.setDate(year, month, day);
        return this;

    }

    @Step("Проверяем результаты:  {key} {value}")
    public RegistrationPage checkResults(String key, String value) {
        checkResultComponent.CheckResult(key, value);
        return this;
    }

    @Step("Выбираем предпочтения пользователя {subject}")
    public RegistrationPage setSubject(String subject) {
        SubjectFormOpen.click();
        SetSubject.setValue(subject).pressEnter();
        return this;
    }

    @Step("Выбираем хобби пользователя {hobbie}")
    public RegistrationPage selectHobbies(String hobbie) {
        SelectHobbie.$(byText(hobbie)).click();
        return this;
    }

    @Step("Загружаем картинку {pictureName}")
    public RegistrationPage uploadPicture(String pictureName) {
        UploadPicture.uploadFromClasspath(pictureName);
        return this;
    }

    @Step("Вводим адрес пользователя {address}")
    public RegistrationPage setAddress(String address) {
        SetAddress.setValue(address);
        return this;
    }

    @Step("Вводим штат {state} и город {city}")
    public RegistrationPage selectStateAndCity(String state, String city) {
        SelectState.setValue(state).pressEnter();
        selectCity.setValue(city).pressEnter();
        return this;
    }

    @Step("Сохраняем форму")
    public RegistrationPage submitForm() {
        SubmitForm.click();
        return this;
    }
}
