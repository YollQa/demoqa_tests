package demoqa;


import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationFormTest {

    @BeforeAll
    static void beforeAll(){
        Configuration.baseUrl = "https://demoqa.com";
    }


    @Test
    void fillRegistrationForm(){

        String firstName = "Petr";
        String lastName = "Cherkasov";
        String userEmail = "petr_cherkasov@mail.ru";
        String gender = "Male";
        String mobileNumber = "9876543210";
        String monthOfBirth = "June";
        String yearOfBirth = "1980";
        String dayOfBirth = "18";
        String subject_1 = "English";
        String subject_2 = "Computer Science";
        String currentAddress = "Silicon Valley";
        String state = "Rajasthan";
        String city = "Jaipur";

        open("/automation-practice-form");
        $(".main-header").shouldHave(text("Practice Form"));
        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(userEmail);
        $("#genterWrapper").$(byText(gender)).click();
        $("#userNumber").setValue(mobileNumber);
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption(monthOfBirth);
        $(".react-datepicker__year-select").selectOption(yearOfBirth);
        $(byText(dayOfBirth)).click();
        $("#subjectsInput").setValue(subject_1).pressEnter();
        $("#subjectsInput").setValue(subject_2).pressEnter();
        $(byText("Reading")).click();
        $(byText("Music")).click();
        $("#uploadPicture").uploadFile(new File("src/test/resources/photo.jpg"));
        $("#currentAddress").setValue(currentAddress);
        $("#react-select-3-input").setValue(state).pressEnter();
        $("#react-select-4-input").setValue(city).pressEnter();
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        $("#submit").click();
        $(".modal-content").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").shouldHave(text(firstName + " " + lastName), (text(userEmail)), (text(gender)),
                (text(mobileNumber)), (text(dayOfBirth + " " + monthOfBirth + "," + yearOfBirth)),
                (text(subject_1 + "," + " " + subject_2)), (text("Reading, Music")), (text("photo.jpg")),
                (text(currentAddress)), (text(state + " " + city)));

    }
}
