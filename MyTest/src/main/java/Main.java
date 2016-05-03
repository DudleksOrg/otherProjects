import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by Alexey on 03.05.2016.
 */


public class Main {

    private static WebDriver driver = new FirefoxDriver();

    public static void main(String[] args) throws InterruptedException {
        driver.manage().window().maximize();
        HomePage homePage = new HomePage(driver);
        homePage.clickCatalogButton();
        homePage.clickNoteBookButton();
        SearchPage searchPage = new SearchPage(driver);
        searchPage.selectItemOfProcessors();
        searchPage.clickSubmitButton();
        System.out.println("Minimum price from the list of notebooks on the page of search: " + searchPage.calculateMinPrice());




    }
}


