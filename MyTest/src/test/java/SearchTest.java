import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;
import java.util.TreeMap;

import static org.testng.Assert.fail;

/**
 * Created by Alexey on 04.05.2016.
 */
public class SearchTest {
    private WebDriver driver;
    private StringBuffer verificationErrors = new StringBuffer();
    TreeMap<String, String> mapTitles = null;

    @DataProvider
    public Object[][] testData() {
        return new Object[][]{
                new Object[] {"Celeron"},
                new Object[] {"A10"},
                new Object[] {"Xeon"}
        };
    }

    @BeforeTest
    public void setUp() {
        System.out.println("Create a new instance of the Firefox driver");
        driver = new FirefoxDriver();
        System.out.println("Open the Browser window fullscreen.");
        driver.manage().window().maximize();
    }

    @Test (dataProvider = "testData")
    public void searchByProcessor(String processor)  {
        try {
            HomePage homePage = new HomePage(driver);
            System.out.println(Step.set() + ". Go to the '" + HomePage.homePageAddress + "' address.");
            homePage.goToAddress(HomePage.homePageAddress);
            System.out.println(Step.set() + ". Check the 'HomePage' by unique element '" +HomePage.uniqueElement + "'.");
            homePage.checkPage(HomePage.uniqueElement);
            System.out.println(Step.set() + ". Click the 'Catalog' button.");
            homePage.clickCatalogButton();
            System.out.println(Step.set() + ". Click the 'Notebook' button.");
            homePage.clickNoteBookButton();
            SearchPage searchPage = new SearchPage(driver);
            System.out.println(Step.set() + ". Check the 'SearchPage' by unique element '" +SearchPage.uniqueElement + "'.");
            searchPage.checkPage(SearchPage.uniqueElement);
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
        } catch (Error e) {
            //Capture and append Exceptions/Errors
            verificationErrors.append(e.toString());
        }
    }

    @AfterTest
    public void tearDown() {
        System.out.println("Close the browser.");
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }
}