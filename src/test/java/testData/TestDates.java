package testData;
import com.github.javafaker.Faker;
import java.security.SecureRandom;
import java.util.concurrent.ThreadLocalRandom;

public class TestDates
{
    Faker faker = new Faker();

    public String FirstName = faker.name().firstName();
    public String LastName = faker.name().lastName();
    public String UserEmail = faker.internet().emailAddress();
    public String UserMobilePhone = faker.phoneNumber().subscriberNumber(10);
    public String UserSex = getRandomGender();

    public String UserAddress = faker.address().streetAddress();
    public String UserSubject = getRandomSubjects();
    public String UserState = getRandomState();
    public String UserCity = getRandomCity();
    public String UserHobbie = getRandomHobbies();
    public String PictureName = "D.jpg";
    public String UserBirthMonth = getRandomMonth();
    public String UserBirthYear = String.format("%s",faker.number().numberBetween(1980,2020));
    public String UserBirthDay = String.format("%s",faker.number().numberBetween(1,28));



    public String getRandomMonth()
    {
        UserBirthMonth =faker.options().option("December","January","February","March","April","May","June","July","August","September","October","November");
        return UserBirthMonth;
    }
    public String getRandomHobbies()
    {
        UserHobbie = faker.options().option("Sports","Reading","Music");
        return UserHobbie;
    }
    public String getRandomSubjects()
    {
        UserSubject =faker.options().option("Maths","Chemistry","English", "Computer Science");
        return UserSubject;
    }
    public String getRandomState()
    {
        UserState = faker.options().option("NCR","Uttar Pradesh","Haryana", "Rajasthan");
        return UserState;
    }
    public String getRandomGender()
    {
        UserSex = faker.options().option("Male","Female","Other");
        return UserSex;
    }

    public String getRandomCity()
    {

        if (UserState.equals( "NCR"))
        {
            UserCity = faker.options().option("Delhi","Gurgaon","Noida");
        }
        if (UserState.equals("Uttar Pradesh"))
        {
            UserCity = faker.options().option("Agra","Lucknow","Merrut");
        }
        if (UserState.equals("Haryana"))
        {
            UserCity = faker.options().option("Karnal","Panipat");
        }
        if (UserState.equals("Rajasthan"))
        {
            UserCity = faker.options().option("Jaipur","Jaiselmer");
        }
        return UserCity;
    }
}

