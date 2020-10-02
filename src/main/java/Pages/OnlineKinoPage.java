package Pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.ex.ElementNotFound;
import org.openqa.selenium.By;

import java.util.Random;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class OnlineKinoPage extends BasePage {
    private static By genreFilter = By.xpath(".//*[@id='tab-films']//button[@title='Жанры']");
    private static final By genreSeries = By.xpath(".//*[@id='tab-tv-series']//button[@title='Жанры']");
    private static final By genreCartoons = By.xpath(".//*[@id='tab-cartoons']//button[@title='Жанры']");

    private static By genreDropDownMenu = By.xpath(".//*[@id='tab-films']//button[@title='Жанры']" + "/following::div[1]" + "//li");
    private static final By genreDropDownMenuSeries = By.xpath(".//*[@id='tab-tv-series']//button[@title='Жанры']" + "/following::div[1]" + "//li");
    private static final By genreDropDownMenuCartoons = By.xpath(".//*[@id='tab-cartoons']//button[@title='Жанры']" + "/following::div[1]" + "//li");
    private static final By genreFilmDescription = By.xpath("//*[@id='online-cinema']/div[1]//li/*[@class='txt']");
    private static final By nextPage = By.xpath(".//*[@id='online-cinema']//*[@class='p-next']/a");
    private static final By seriesTab = By.xpath(".//*[@data-show='serial']");
    private static final By cartoonTab = By.xpath(".//*[@data-show='animation']");

    public String genreName;
    private ElementsCollection genres;

    public void openDropDownMenu(){
        clickElement(genreFilter);
        genres = getMenuItemsList();
    }

    public void selectAnyItemFromMenu(){
        SelenideElement genreItem = getGenreElementFromDropDown(getRandomGenreNumber(genres));
        genreName = genreItem.getText();
        genreItem.click();
        waitElement();

    }

    private SelenideElement getGenreElementFromDropDown(int number){
        return getMenuItemsList().get(number);
    }

    private ElementsCollection getMenuItemsList(){
        return $$(genreDropDownMenu);
    }

    private int getRandomGenreNumber(ElementsCollection genres){
        Random random = new Random();
        return random.nextInt(genres.size());
    }

    public Boolean isNextPage(){
        try {
            return $(nextPage).isDisplayed();
        }catch(ElementNotFound ex){
            return false;
        }
    }

    public ElementsCollection getFilmsDescription(){
            return $$(genreFilmDescription);
    }

    public void nextPage(){
        clickElement(nextPage);
    }

    public String getGenreName(){
        return genreName;
    }

    public void openSeriesTab(){
        clickElement(seriesTab);
        genreFilter = genreSeries;
        genreDropDownMenu = genreDropDownMenuSeries;
    }

    public void openCartoonTab(){
        clickElement(cartoonTab);
        genreFilter = genreCartoons;
        genreDropDownMenu = genreDropDownMenuCartoons;
    }
}
