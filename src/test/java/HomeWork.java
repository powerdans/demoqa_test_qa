import org.junit.jupiter.api.Test;


import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class HomeWork {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1600x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
        Configuration.holdBrowserOpen = true;

    }

    @Test
    void fillFormTest() {
        open("/automation-practice-form");
        $("#firstName").setValue("Alisa");
        $("#lastName").setValue("Igorevna");
        $("#userEmail").setValue("alex222@egorov.com");
        $("[for='gender-radio-2']").click();
        $("#userNumber").setValue("754237867831");
        $(".react-datepicker-wrapper").click();
        $(".react-datepicker__month-select").click();
        $(".react-datepicker__month-select").selectOption("September");
        $(".react-datepicker__year-select").selectOption("2019");
        $(".react-datepicker__day--028:not(.react-datepicker__day--outside-month)").click();
        $("#subjectsInput").setValue("English").pressEnter();
        $("[for='hobbies-checkbox-1']").click();
        $("#uploadPicture").uploadFromClasspath("scrin.png");
        $("#currentAddress").setValue("g.Maxachkola ul. rambler d.11. kv.14");
        $("[id=react-select-3-input]").setValue("NCR").pressEnter();
        $("[id=react-select-4-input]").setValue("Noida").pressEnter();

        $("#submit").pressEnter();

        $(".table-responsive").$(byText("Student Name")).parent().shouldHave(text("Alisa Igorevna?"));
        $(".table-responsive").$(byText("Student Email")).parent().shouldHave(text("alex222@egorov.com?"));
        $(".table-responsive").$(byText("Gender")).parent().shouldHave(text("Female?"));
        $(".table-responsive").$(byText("Mobile")).parent().shouldHave(text("7542378678?"));
        $(".table-responsive").$(byText("Date of Birth")).parent().shouldHave(text("28 September,2019?"));
        $(".table-responsive").$(byText("Subjects")).parent().shouldHave(text("English?"));
        $(".table-responsive").$(byText("Picturel")).parent().shouldHave(text("scrin.png?"));
        $(".table-responsive").$(byText("Address")).parent().shouldHave(text("g.Maxachkola ul. rambler d.11. kv.14?"));
        $(".table-responsive").$(byText("State and City")).parent().shouldHave(text("NCR Noida?"));

    }
}






