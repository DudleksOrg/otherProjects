
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

import java.util.List;

import static org.testng.Assert.*;

/**
 * Created by Alexey on 04.05.2016.
 */
public class SearchTest {
    private WebDriver driver;
    private StringBuffer verificationErrors = new StringBuffer();

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
    public void search(String processor) {
        try {
            HomePage homePage = new HomePage(driver);
            System.out.println("1. Click the 'Catalog' button.");
            homePage.clickCatalogButton();
            System.out.println("2. Click the 'Notebook' button.");
            homePage.clickNoteBookButton();
            SearchPage searchPage = new SearchPage(driver);
            System.out.println("3. Select the '"+ processor +"' processor.");
            searchPage.selectItemOfProcessors(processor);
            System.out.println("4. Click 'Submit' button.");
            searchPage.clickSubmitButton();
            System.out.println("5. Get the list of prices.");
            List pList = searchPage.getAllPrices(SearchPage.listOfPrices);
            System.out.println("6. Get the list of laptops.");
            List lList = searchPage.getAllLaptops(SearchPage.listOfLaptops);
            System.out.println("7. Calculate a minimum price from the list of notebooks.");
            System.out.println(" ________________________________________________________________________________________________________________");
            System.out.println("| Minimum price from the list of notebooks on the page of search: " + searchPage.calculateMinPrice(lList, pList));
            System.out.println("|________________________________________________________________________________________________________________");

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