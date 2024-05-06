package tests;

import pages.RegistrationPage;
import org.junit.jupiter.api.Test;
import testData.TestDates;


public class PracticeFormTest extends BaseTest {

    TestDates testDates = new TestDates();
    RegistrationPage registrationPage = new RegistrationPage();



    @Test
    void practiceFormTest() {
        registrationPage.openPage()
                .setFirstName(testDates.FirstName)
                .setLastName(testDates.LastName)
                .setEmail(testDates.UserEmail)
                .chooseGender(testDates.UserSex)
                .setPhoneNumber(testDates.UserMobilePhone)
                .setDateOfBirth(testDates.UserBirthYear, testDates.UserBirthMonth, testDates.UserBirthDay)
                .setSubject(testDates.UserSubject)
                .selectHobbies(testDates.UserHobbie)
                .uploadPicture(testDates.PictureName)
                .setAddress(testDates.UserAddress)
                .selectStateAndCity(testDates.UserState,testDates.UserCity)
                .submitForm()
                .checkResults("Student Name", testDates.FirstName + " " + testDates.LastName)
                .checkResults("Student Email", testDates.UserEmail)
                .checkResults("Gender", testDates.UserSex)
                .checkResults("Mobile", testDates.UserMobilePhone)
                .checkResults("Date of Birth", String.format("%s %s,%s",testDates.UserBirthDay,testDates.UserBirthMonth,testDates.UserBirthYear))
                .checkResults("Subjects", testDates.UserSubject)
                .checkResults("Hobbies", testDates.UserHobbie)
                .checkResults("Picture", testDates.PictureName)
                .checkResults("Address", testDates.UserAddress)
                .checkResults("State and City", String.format("%s %s",testDates.UserState,testDates.UserCity));
    }
}