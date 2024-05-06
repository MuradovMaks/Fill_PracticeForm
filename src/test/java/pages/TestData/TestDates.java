package pages.TestData;
import com.github.javafaker.Faker;
import java.security.SecureRandom;
import java.util.concurrent.ThreadLocalRandom;

public class TestDates
{
    Faker faker = new Faker();

    public String FirstName = faker.name().firstName();
    public String LastName = faker.name().lastName();
    public String UserEmail = faker.internet().emailAddress();
    public String UserMobilePhone = randomString(10);
    public String UserSex = getRandomGender();

    public String UserAddress = faker.address().streetAddress();
    public String UserSubject = getRandomSubjects();
    public String UserState = getRandomState();
    public String UserCity = getRandomCity();
    public String UserHobbie = getRandomHobbies();
    public String PictureName = "D.jpg";
    public String UserBirthMonth = getRandomMonth();
    public String UserBirthYear = String.format("%s",getRandomint(1980,2020));
    public String UserBirthDay = String.format("%s",getRandomint(10,30));


    String randomString(int len){
        String AB = "0123456789";
        SecureRandom rnd = new SecureRandom();
        StringBuilder sb = new StringBuilder(len);
        for(int i = 0; i < len; i++)
            sb.append(AB.charAt(rnd.nextInt(AB.length())));
        return sb.toString();
    }


    public String getRandomMonth()
    {
        String[]months = {"December","January","February","March","April","May","June","July","August","September","October","November"};
        return getIndforArray(months);
    }
    public String getRandomHobbies()
    {
        String[] array = {"Sports","Reading","Music"};
        return getIndforArray(array);
    }
    public String getRandomSubjects()
    {
        String[]array = {"Maths","Chemistry","English", "Computer Science"};
        return getIndforArray(array);
    }
    public String getRandomState()
    {
        String[]array = {"NCR","Uttar Pradesh","Haryana", "Rajasthan"};
        return getIndforArray(array);
    }
    public String getRandomGender()
    {
        String[]array = {"Male","Female","Other"};
        return getIndforArray(array);
    }

    public String getRandomCity()
    {
        String arrayState = UserState;
        String[]NCRarray = {"Delhi","Gurgaon","Noida"};
        String[]Uttararray = {"Agra","Lucknow","Merrut"};
        String[]Haryanaarray = {"Karnal","Panipat"};
        String[]Rajasthanarray = {"Jaipur","Jaiselmer"};

        if (arrayState == "NCR")
        {
            return getIndforArray(NCRarray);
        }
        if (arrayState == "Uttar Pradesh")
        {
            return getIndforArray(Uttararray);
        }
        if (arrayState == "Haryana")
        {
            return getIndforArray(Haryanaarray);
        }
        if (arrayState == "Rajasthan")
        {
            return getIndforArray(Rajasthanarray);
        }
        else return "";
    }
    public String getIndforArray(String[]array)
    {
        int index = getRandomint(0 , array.length - 1);
        return array[index];
    }
    public int getRandomint(int min , int max)
    {
        return ThreadLocalRandom.current().nextInt(min, max+1);
    }
}

