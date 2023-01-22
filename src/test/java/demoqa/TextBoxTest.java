package demoqa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TextBoxTest {

    @BeforeAll
    static void beforeAll(){
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
    }

    @Test
    void feelFormTest() {

        String UserName = "Yoll";
        String currentAddress = "Moscow, Prospekt Mira 109";
        String permanentAddress = "Himki, Beregovaya 6";

        open("/text-box");
        $(".main-header").shouldHave(text("Text Box"));
        $("#userName").setValue(UserName);
        $("#userEmail").setValue("yoll@mail.ru");
        $("#currentAddress").setValue(currentAddress);
        $("#permanentAddress").setValue(permanentAddress);
        $("#submit").click();
        $("#output").shouldBe(visible);
        $("#output #name").shouldHave(text(UserName));
        $("#output #email").shouldHave(text("yoll@mail.ru"));
        $("#output #currentAddress").shouldHave(text(currentAddress));
        $("#output #permanentAddress").shouldHave(text(permanentAddress));

        $(".react-datepicker__day--005:not(.react-datepicker__day--outside-month)").click(); // выбирает локатор, в котором есть только первая часть (css selector not)
    }
}
