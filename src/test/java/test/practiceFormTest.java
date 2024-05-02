package test;

import FillFormWithPageObject.BaseTest;
import FillFormWithPageObject.RegistrationPage;
import org.junit.jupiter.api.Test;

public class practiceFormTest extends BaseTest {

    RegistrationPage registrationPage = new RegistrationPage();


    @Test
    void practiceForm() {
        registrationPage.OpenPage()
                .SetFirstName("Maxim")
                .SetLastName("Muradov")
                .SetEmail("koreantech620@mail.ru")
                .ChooseGender()
                .SetPhoneNumber("79836025158")
                .SetDateOfBirth("2000", "April")
                .SetSubject("English")
                .SetSubject("Maths")
                .SelectHobbies("Sports")
                .UploadPicture("D.jpg")
                .SetAddress("Lenina 25")
                .SelectStateAndCity("NCR", "Delhi")
                .SubmitForm()
                .CheckResults("Student Name", "Maxim Muradov")
                .CheckResults("Student Email", "koreantech620@mail.ru")
                .CheckResults("Gender", "Male")
                .CheckResults("Mobile", "7983602515")
                .CheckResults("Date of Birth", "24 April,2000")
                .CheckResults("Subjects", "English, Maths")
                .CheckResults("Hobbies", "Sports")
                .CheckResults("Picture", "D.jpg")
                .CheckResults("Address", "Lenina 25")
                .CheckResults("State and City", "NCR Delhi");
    }

    @Test
    public void FillPracticeFormWithMinData() {
        registrationPage.OpenPage()
                .SetFirstName("Maxim")
                .SetLastName("Muradov")
                .ChooseGender()
                .SetPhoneNumber("79836025158")
                .SubmitForm()
                .CheckResults("Student Name", "Maxim Muradov")
                .CheckResults("Gender", "Male")
                .CheckResults("Mobile", "7983602515");
    }

    @Test
    public void NegativeFillPracticeFormWithMinData() {
        registrationPage.OpenPage()
                .SetFirstName(" ")
                .SetLastName("Sergeev")
                .ChooseGender()
                .SetPhoneNumber("79836025158")
                .SubmitForm()
                .CheckResults("Student Name", "Maxim Muradov")
                .CheckResults("Gender", "Male")
                .CheckResults("Mobile", "7983602515");
    }
}