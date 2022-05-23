package ds.anosov;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

/**
 *  - Откройте страницу Selenide в Github
 *  - Перейдите в раздел Wiki проекта
 *  - Убедитесь, что в списке страниц (Pages) есть страница SoftAssertions
 *  - Откройте страницу SoftAssertions, проверьте что внутри есть пример кода для JUnit5
 */

 public class SearchJUnitCodeTest {

     private final static String SEARCH_WORD_SELENIDE = "Selenide";
     private final static String SEARCH_WORD_ASSERTIONS = "Soft assertions";
     private final static String SEARCH_WORD_JUNIT5 = "Using JUnit5 extend test class:";

     @BeforeAll
     static void setUp() {
        Configuration.browserSize = "1920x1080";
        open("https://github.com/");
    }

    @Test
    public void searchCodeJUnitTest() {
    $("[data-test-selector=nav-search-input]").setValue(SEARCH_WORD_SELENIDE).pressEnter();
    $("ul.repo-list li").$("a").click();
    $("#wiki-tab").click();
    $("#wiki-body").shouldHave(text(SEARCH_WORD_ASSERTIONS));
    $(byText(SEARCH_WORD_ASSERTIONS)).click();
    $(".markdown-body").shouldHave(text(SEARCH_WORD_JUNIT5));

    }

}
