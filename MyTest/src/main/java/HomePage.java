import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by Alexey on 03.05.2016.
 */
public class HomePage {
    final static String pageTitle = "homepage.title";
    final static String homePageAddress = "https://market.yandex.ru/";
    By catalogLocator = By.xpath(".//*[@id='index-headline-id-tab-1']/span[1]");
    By notebookLocator = By.xpath(".//a[@href='/catalogmodels.xml?hid=91013&CAT_ID=432460&nid=54544&track=from_cat_categories']");
    final static By uniqueElement = By.xpath(".//div[@class='headline headline_theme_banner']");

    private final WebDriver driver;


    public HomePage(WebDriver driver) {
        this.driver = driver;
        Helper.waitForLoad(driver);
    }


    public HomePage checkPage(By by) {
        Helper.waitPageElement(driver, by);
        return this;
    }

    public HomePage clickCatalogButton() {
        Helper.waitPageElement(driver, catalogLocator);
        driver.findElement(catalogLocator).click();
        return this;
    }

    public HomePage clickNoteBookButton() {
        Helper.waitPageElement(driver, notebookLocator);
        driver.findElement(notebookLocator).click();
        return this;
    }

    public HomePage checkPageTitle(String title) {
        Helper.waitPageTitle(driver, title);
        return this;
    }

    public HomePage goToAddress(String url) {
        driver.get(url);
        return this;
    }


}
