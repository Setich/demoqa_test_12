package guru.qa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class PracticeFormTests {

    @BeforeAll
    static void setUp() {
        Configuration.holdBrowserOpen = true;
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com/";
    }

    @Test
    void fillFormTest() {
        open("automation-practice-form");

        $("#firstName").setValue("Aleksey");

        $("#lastName").setValue("Set");

        $("#userEmail").setValue("jaja@mail.ru");

        $(byText("Male")).click();


        $("#userNumber").setValue("0123456789");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("March");
        $(".react-datepicker__year-select").selectOption("1990");
        $("[aria-label$='March 13th, 1990']").click();

        $("#subjectsInput").setValue("Physics").pressEnter();

        $(byText("Music")).click();

        $("#uploadPicture").uploadFromClasspath("img/123.txt");

        $("#currentAddress").setValue("Hello qa.guru");

        $("#state").click();
        $(byText("Rajasthan")).click();

        $("#city").click();
        $(byText("Jaiselmer")).click();

        $("#submit").click();

        $(".table-responsive").shouldHave(text("Student Name Aleksey Set"),
                text("Student Email jaja@mail.ru"), text("Gender Male"), text("Mobile 0123456789"),
                text("Date of Birth 13 March,1990"), text("Subjects Physics"), text("Hobbies Music"),
                text("Picture 123.txt"), text("Address Hello qa.guru"), text("State and City Rajasthan Jaiselmer"));
        $("#closeLargeModal").click();
    }
}


