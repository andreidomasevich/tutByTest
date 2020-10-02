package Pages;

import com.codeborne.selenide.Selenide;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
// PageObject
class BasePage {

    private static final int waitLimit = 1000;
    public void waitElement(){
        Selenide.sleep(waitLimit);
    }

    public void clickElement(By locator){
        $(locator).click();
        waitElement();
    }
}
