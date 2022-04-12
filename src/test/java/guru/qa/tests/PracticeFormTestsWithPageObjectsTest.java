package guru.qa.tests;

import com.codeborne.selenide.Configuration;
import com.github.javafaker.Faker;
import guru.qa.pages.RegistrationFormPage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import javax.swing.*;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static java.lang.String.format;

public class PracticeFormTestsWithPageObjectsTest {

    RegistrationFormPage registrationFormPage = new RegistrationFormPage();
    Faker faker = new Faker();

    String firsName = faker.name().firstName(),
            lastName = faker.name().lastName(),
            email = faker.internet().emailAddress(),
            userNumber = faker.numerify("1234567891"),
            currentAddress = faker.address().streetAddress(),
            gender = "Male", day = "13", month = "March",
            year = "1990", subject = "Physics",
            hobbie = "Music", uploadPicture = "img/123.txt",
            state = "Rajasthan", city = "Jaiselmer",
            expectedFullName = format("%s %s", firsName, lastName),
            expectedDateofBirth = format("%s %s,%s", day, month, year),
            expectedStateAndCity = format("%s %s", state, city),
            expectedImg = "123.txt";

    @BeforeAll
    static void setUp() {
        Configuration.holdBrowserOpen = true;
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com/";
    }

    @Test
    void fillFormTest() {

        registrationFormPage.openPage()
                .setFirstName(firsName)
                .setLastName(lastName)
                .setUserEmail(email)
                .chooseGender(gender)
                .setUserNumber(userNumber)
                .chooseBirthDay(day, month, year)
                .setSubjectsInput(subject)
                .chooseHobbie(hobbie)
                .setUploadPicture(uploadPicture)
                .setCurrentAddress(currentAddress)
                .selectState(state)
                .selectCity(city)
                .pressSubmit()

                //verify
                .verifyUserName("Student Name", expectedFullName)
                .verifyStudentEmail("Student Email", email)
                .verifyGender("Gender", gender)
                .verifyMobile("Mobile", userNumber)
                .verifyDateOfBirth("Date of Birth", expectedDateofBirth)
                .verifySubjects("Subjects", subject)
                .verifyHobbies("Hobbies", hobbie)
                .verifyPicture("Picture", expectedImg)
                .verifyAddress("Address", currentAddress)
                .verifyStateAndCity("State and City", expectedStateAndCity);

    }
}


