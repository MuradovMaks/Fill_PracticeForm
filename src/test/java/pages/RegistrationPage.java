package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import pages.components.CalendarComponent;
import pages.components.TableResultComponent;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {

    private SelenideElement setFirstName = $("[id=firstName]");
    private SelenideElement setLastName = $("[id=lastName]");

    private SelenideElement setEmail = $("[id=userEmail]");
    private SelenideElement chooseCheckbox = $("label[class=custom-control-label]");
    private SelenideElement setMobileNum = $("[id=userNumber]");
    private SelenideElement chooseDatePicker = $("[id=dateOfBirthInput]");
    private SelenideElement subjectFormOpen = $("[id=subjectsContainer]");
    private SelenideElement setSubject = $("[id=subjectsInput]");
    private SelenideElement selectHobbie = $("#hobbiesWrapper");
    private SelenideElement uploadPicture = $("[id=uploadPicture]");
    private SelenideElement setAddress = $("[id=currentAddress]");
    private SelenideElement selectState = $("[id=react-select-3-input]");
    private SelenideElement selectCity = $("[id=react-select-4-input]");
    private SelenideElement submitForm = $("[id=submit]");
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
        setFirstName.setValue(FirstName);
        return this;
    }

    @Step("Вводим Фамилию пользователя {LastName}")
    public RegistrationPage setLastName(String LastName) {
        setLastName.setValue(LastName);
        return this;
    }

    @Step("Вводим Email {email}")
    public RegistrationPage setEmail(String email) {
        setEmail.setValue(email).pressEnter();
        return this;
    }

    @Step("Выбор гендера ")
    public RegistrationPage chooseGender() {
        chooseCheckbox.click();
        return this;
    }

    @Step("Вводим номер телефона {number}")
    public RegistrationPage setPhoneNumber(String number) {
        setMobileNum.setValue(number);
        return this;
    }

    @Step("Вводим Дату Рождения {day} {month} {year}")
    public RegistrationPage setDateOfBirth(String year, String month, String day) {
        chooseDatePicker.click();
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
        subjectFormOpen.click();
        setSubject.setValue(subject).pressEnter();
        return this;
    }

    @Step("Выбираем хобби пользователя {hobbie}")
    public RegistrationPage selectHobbies(String hobbie) {
        selectHobbie.$(byText(hobbie)).click();
        return this;
    }

    @Step("Загружаем картинку {pictureName}")
    public RegistrationPage uploadPicture(String pictureName) {
        uploadPicture.uploadFromClasspath(pictureName);
        return this;
    }

    @Step("Вводим адрес пользователя {address}")
    public RegistrationPage setAddress(String address) {
        setAddress.setValue(address);
        return this;
    }

    @Step("Вводим штат {state} и город {city}")
    public RegistrationPage selectStateAndCity(String state, String city) {
        selectState.setValue(state).pressEnter();
        selectCity.setValue(city).pressEnter();
        return this;
    }

    @Step("Сохраняем форму")
    public RegistrationPage submitForm() {
        submitForm.click();
        return this;
    }
}
