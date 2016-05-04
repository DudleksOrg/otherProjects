import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.TreeMap;

/**
 * Created by Alexey on 03.05.2016.
 */


public class Main {
    private static  String processor = "Celeron";
    private static WebDriver driver = new FirefoxDriver();
    TreeMap<String, String> mapTitles = null;

    public static void main(String[] args) throws InterruptedException, UnsupportedEncodingException {
        driver.manage().window().maximize();

        HomePage homePage = new HomePage(driver);
        System.out.println(Step.set() + ". Go to the '" + HomePage.homePageAddress + "' address.");
        homePage.goToAddress(HomePage.homePageAddress);
        System.out.println(Step.set() + ". Click the 'Catalog' button.");
        homePage.clickCatalogButton();
        System.out.println(Step.set() + ". Click the 'Notebook' button.");
        homePage.clickNoteBookButton();
        SearchPage searchPage = new SearchPage(driver);
        System.out.println(Step.set() + ". Select the '"+ processor +"' processor.");
        searchPage.selectItemOfProcessors(processor);
        System.out.println(Step.set() + ". Click 'Submit' button.");
        searchPage.clickSubmitButton();
        System.out.println(Step.set() + ". Get the list of prices.");
        List pList = searchPage.getAllPrices(SearchPage.listOfPrices);
        System.out.println(Step.set() + ". Get the list of laptops.");
        List lList = searchPage.getAllLaptops(SearchPage.listOfLaptops);
        System.out.println(Step.set() + ". Calculate a minimum price from the list of notebooks.");
        System.out.println(" ________________________________________________________________________________________________________________");
        System.out.println("| Minimum price from the list of notebooks on the page of search: " + searchPage.calculateMinPrice(lList, pList));
        System.out.println("|________________________________________________________________________________________________________________");
        Step.nullify();
        driver.quit();
    }
}


