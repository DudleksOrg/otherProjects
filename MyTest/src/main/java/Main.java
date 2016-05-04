import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;

/**
 * Created by Alexey on 03.05.2016.
 */


public class Main {

    private static WebDriver driver = new FirefoxDriver();

    public static void main(String[] args) throws InterruptedException {
        driver.manage().window().maximize();
        System.out.println("1. Open the Browser window fullscreen.");
        driver.manage().window().maximize();
        HomePage homePage = new HomePage(driver);
        System.out.println("2. Click the 'Catalog' button.");
        homePage.clickCatalogButton();
        System.out.println("3. Click the 'Notebook' button.");
        homePage.clickNoteBookButton();
        SearchPage searchPage = new SearchPage(driver);
        System.out.println("4. Select the processor.");
        searchPage.selectItemOfProcessors("Celeron");
        System.out.println("5. Click 'Submit' button.");
        searchPage.clickSubmitButton();
        System.out.println("6. Get the list of prices.");
        List pList = searchPage.getAllPrices(SearchPage.listOfPrices);
        System.out.println("7. Get the list of laptops.");
        List lList = searchPage.getAllLaptops(SearchPage.listOfLaptops);
        System.out.println("8. Calculate a minimum price from the list of notebooks.");
        System.out.println(" ________________________________________________________________________________________________________________");
        System.out.println("| Minimum price from the list of notebooks on the page of search: " + searchPage.calculateMinPrice(lList,pList));
        System.out.println("|________________________________________________________________________________________________________________");
        driver.quit();


    }
}


