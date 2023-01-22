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

        String FirstName = "Petr";
        String LastName = "Cherkasov";
        String UserEmail = "petr_cherkasov@mail.ru";
        String Gender = "Male";
        String MobileNumber = "9876543210";
        String MonthOfBirth = "June";
        String YearOfBirth = "1980";
        String DayOfBirth = "18";
        String Subject_1 = "English";
        String Subject_2 = "Computer Science";
        String CurrentAddress = "Silicon Valley";
        String State = "Rajasthan";
        String City = "Jaipur";

        open("/automation-practice-form");
        $(".main-header").shouldHave(text("Practice Form"));
        $("#firstName").setValue(FirstName);
        $("#lastName").setValue(LastName);
        $("#userEmail").setValue(UserEmail);
        $(byText(Gender)).click();
        $("#userNumber").setValue(MobileNumber);
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption(MonthOfBirth);
        $(".react-datepicker__year-select").selectOption(YearOfBirth);
        $(byText(DayOfBirth)).click();
        $("#subjectsInput").setValue(Subject_1).pressEnter();
        $("#subjectsInput").setValue(Subject_2).pressEnter();
        $(byText("Reading")).click();
        $(byText("Music")).click();
        $("#uploadPicture").uploadFile(new File("src/test/resources/photo.jpg"));
        $("#currentAddress").setValue(CurrentAddress);
        $("#react-select-3-input").setValue(State).pressEnter();
        $("#react-select-4-input").setValue(City).pressEnter();
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        $("#submit").click();
        $(".modal-content").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").shouldHave(text(FirstName + " " + LastName), (text(UserEmail)), (text(Gender)),
                (text(MobileNumber)), (text(DayOfBirth + " " + MonthOfBirth + "," + YearOfBirth)),
                (text(Subject_1 + "," + " " + Subject_2)), (text("Reading, Music")), (text("photo.jpg")),
                (text(CurrentAddress)), (text(State + " " + City)));

    }
}
