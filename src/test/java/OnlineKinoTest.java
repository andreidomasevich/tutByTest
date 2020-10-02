import Pages.AfishaPage;
import Pages.HomePage;
import Pages.OnlineKinoPage;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.ex.ElementNotFound;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


import java.io.IOException;

public class OnlineKinoTest extends BaseTest{
    HomePage homePage;
    AfishaPage afishaPage;
    OnlineKinoPage onlineKinoPage;

    OnlineKinoTest() throws IOException {
        homePage = new HomePage();
        afishaPage = new AfishaPage();
        onlineKinoPage = new OnlineKinoPage();
    }

    @BeforeTest
    public void setUp(){
        openHomePage();
        homePage.goToAfishaPage();
        afishaPage.goToOnlineKinoPage();
    }

    @Test(priority = 1)
    public void checkGenreInFilms() {
        checkGenreDescription();
    }

    @Test(priority = 2)
    public void checkGenreInSeries() {
        onlineKinoPage.openSeriesTab();
        checkGenreDescription();
    }

    @Test(priority = 3)
    public void checkGenreInCartoons() {
        onlineKinoPage.openCartoonTab();
        checkGenreDescription();
    }

    private void checkGenreDescription(){
        onlineKinoPage.openDropDownMenu();
        onlineKinoPage.selectAnyItemFromMenu();
        String genreName = onlineKinoPage.getGenreName();
        try{
            do{
                ElementsCollection filmsDescription = onlineKinoPage.getFilmsDescription();
                for(int i = 0; i < filmsDescription.size(); i ++){
                        Assert.assertTrue(filmsDescription.get(i).getText().contains(genreName));
                    }
                    onlineKinoPage.nextPage();
                }while(onlineKinoPage.isNextPage());
            }catch(ElementNotFound ex){
        }
    }
}
