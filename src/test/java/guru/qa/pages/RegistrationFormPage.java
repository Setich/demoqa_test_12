package guru.qa.pages;

import com.codeborne.selenide.SelenideElement;
import guru.qa.pages.components.CalendarComponent;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class RegistrationFormPage {
    CalendarComponent calendarComponent = new CalendarComponent();


    /* locators примеры
    SelenideElement firstNameInput = $("#firstName");
    SelenideElement lastNameInput = $("#lastName"); */
    SelenideElement tableData = $(".table-responsive");

    // actions
    public RegistrationFormPage openPage() {
        open("automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");

        return this;
    }

    public RegistrationFormPage setFirstName(String value) {
        $("#firstName").setValue(value);

        return this;
    }

    public RegistrationFormPage setLastName(String value) {
        $("#lastName").setValue(value);

        return this;
    }

    public RegistrationFormPage setUserEmail(String value) {
        $("#userEmail").setValue(value);

        return this;
    }

    public RegistrationFormPage chooseGender(String value) {
        $(byText(value)).click();

        return this;
    }

    public RegistrationFormPage setUserNumber(String value) {
        $("#userNumber").setValue(value);

        return this;
    }

    public RegistrationFormPage chooseBirthDay(String day, String month, String year) {
        $("#dateOfBirthInput").click();
        calendarComponent.setDate(day, month, year);

        return this;
    }

    public RegistrationFormPage setSubjectsInput(String value) {
        $("#subjectsInput").setValue(value).pressEnter();

        return this;
    }

    public RegistrationFormPage chooseHobbie(String value) {
        $(byText(value)).click();

        return this;
    }

    public RegistrationFormPage setUploadPicture(String value) {
        $("#uploadPicture").uploadFromClasspath(value);

        return this;
    }

    public RegistrationFormPage setCurrentAddress(String value) {
        $("#currentAddress").setValue(value);

        return this;
    }

    public RegistrationFormPage selectState(String value) {
        $("#state").click();
        $(byText(value)).click();

        return this;
    }

    public RegistrationFormPage selectCity(String value) {
        $("#city").click();
        $(byText(value)).click();

        return this;
    }

    public RegistrationFormPage pressSubmit() {
        $("#submit").click();

        return this;
    }

    public RegistrationFormPage verifyUserName(String key, String value) {
        tableData.$(byText(key)).parent().
                shouldHave(text(value));

        return this;
    }

    public RegistrationFormPage verifyStudentEmail(String key, String value) {
        tableData.$(byText(key)).parent().
                shouldHave(text(value));

        return this;
    }

    public RegistrationFormPage verifyGender(String key, String value) {
        tableData.$(byText(key)).parent().
                shouldHave(text(value));

        return this;
    }

    public RegistrationFormPage verifyMobile(String key, String value) {
        tableData.$(byText(key)).parent().
                shouldHave(text(value));

        return this;
    }

    public RegistrationFormPage verifyDateOfBirth(String key, String value) {
        tableData.$(byText(key)).parent().
                shouldHave(text(value));

        return this;
    }

    public RegistrationFormPage verifySubjects(String key, String value) {
        tableData.$(byText(key)).parent().
                shouldHave(text(value));

        return this;
    }

    public RegistrationFormPage verifyHobbies(String key, String value) {
        tableData.$(byText(key)).parent().
                shouldHave(text(value));

        return this;
    }

    public RegistrationFormPage verifyPicture(String key, String value) {
        tableData.$(byText(key)).parent().
                shouldHave(text(value));

        return this;
    }

    public RegistrationFormPage verifyAddress(String key, String value) {
        tableData.$(byText(key)).parent().
                shouldHave(text(value));

        return this;
    }

    public RegistrationFormPage verifyStateAndCity(String key, String value) {
        tableData.$(byText(key)).parent().
                shouldHave(text(value));

        return this;
    }
}
