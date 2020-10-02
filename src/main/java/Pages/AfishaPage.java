package Pages;

import org.openqa.selenium.By;

public class AfishaPage extends BasePage{
    private static final By onlineKinoMenuItem = By.xpath(".//*[@class='main_menu']//*[@title='Онлайн-кинотеатры']");

    public void goToOnlineKinoPage(){
        clickElement(onlineKinoMenuItem);
    }

}
