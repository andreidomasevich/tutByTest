package Pages;

import org.openqa.selenium.By;

public class HomePage extends BasePage{

    private static final By afishaMenuItem = By.xpath(".//*[@id='mainmenu']//*[@title='Афиша']");

    public void goToAfishaPage(){
        clickElement(afishaMenuItem);
    }

}
