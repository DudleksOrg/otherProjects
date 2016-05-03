
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

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

        };
    }

    @BeforeTest
    public void setUp() {
        // Create a new instance of the Firefox driver
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void search() {
        try {
            driver.manage().window().maximize();
            HomePage homePage = new HomePage(driver);
            homePage.clickCatalogButton();
            homePage.clickNoteBookButton();
            SearchPage searchPage = new SearchPage(driver);
            searchPage.selectItemOfProcessors();
            searchPage.clickSubmitButton();
            System.out.println("-----------------------------------------------------------------------------------------------------------");
            System.out.println(">>> Minimum price from the list of notebooks on the page of search: " + searchPage.calculateMinPrice());
            System.out.println("-----------------------------------------------------------------------------------------------------------");

        } catch (Error e) {
            //Capture and append Exceptions/Errors
            verificationErrors.append(e.toString());
        }
    }

    @AfterTest
    public void tearDown() {
        //Close the browser
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }
}