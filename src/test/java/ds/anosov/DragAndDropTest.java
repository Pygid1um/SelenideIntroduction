package ds.anosov;

import org.junit.jupiter.api.BeforeAll;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

/**
 * - Откройте сайт
 *  - Перенесите прямоугольник А на место В
 *  - Проверьте, что прямоугольники действительно поменялись
 */

public class DragAndDropTest {

    @BeforeAll
    static void setUp() {
        Configuration.baseUrl = "https://the-internet.herokuapp.com/";
        Configuration.browserSize = "1920x1080";
        Configuration.holdBrowserOpen = true;
    }

    @Test
    public void dragAndDrop() {
        open("drag_and_drop");
        $("#column-a").dragAndDropTo("#column-b");
        $("#column-a").shouldHave(text("B"));
        $("#column-b").shouldHave(text("A"));
    }
}
