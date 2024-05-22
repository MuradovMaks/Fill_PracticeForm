package tests;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Tag;
import pages.RegistrationPage;
import org.junit.jupiter.api.Test;
@Tag("PracticeForm")
public class PracticeFormTest extends BaseTest {

    RegistrationPage registrationPage = new RegistrationPage();


    @Test
    void PracticeForm() {
        registrationPage.openPage()
                .setFirstName("Maxim")
                .setLastName("Muradov")
                .setEmail("koreantech620@mail.ru")
                .chooseGender()
                .setPhoneNumber("79836025158")
                .setDateOfBirth("2000", "April","30")
                .setSubject("English")
                .setSubject("Maths")
                .selectHobbies("Sports")
                .uploadPicture("D.jpg")
                .setAddress("Lenina 25")
                .selectStateAndCity("NCR", "Delhi")
                .submitForm()
                .checkResults("Student Name", "Maxim Muradov")
                .checkResults("Student Email", "koreantech620@mail.ru")
                .checkResults("Gender", "Male")
                .checkResults("Mobile", "7983602515")
                .checkResults("Date of Birth", "30 April,2000")
                .checkResults("Subjects", "English, Maths")
                .checkResults("Hobbies", "Sports")
                .checkResults("Picture", "D.jpg")
                .checkResults("Address", "Lenina 25")
                .checkResults("State and City", "NCR Delhi");
    }

    @Test
    public void FillPracticeFormWithMinData() {
        registrationPage.openPage()
                .setFirstName("Maxim")
                .setLastName("Muradov")
                .chooseGender()
                .setPhoneNumber("79836025158")
                .submitForm()
                .checkResults("Student Name", "Maxim Muradov")
                .checkResults("Gender", "Male")
                .checkResults("Mobile", "7983602515");
    }


    @Test
    @Disabled
    public void NegativeFillPracticeFormWithMinData() {
        registrationPage.openPage()
                .setFirstName(" ")
                .setLastName("Sergeev")
                .chooseGender()
                .setPhoneNumber("79836025158")
                .submitForm()
                .checkResults("Student Name", "Maxim Muradov")
                .checkResults("Gender", "Male")
                .checkResults("Mobile", "7983602515");
    }
}