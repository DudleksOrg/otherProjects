import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by Alexey on 03.05.2016.
 */
public class HomePage {
    final static String pageTitle = "Яндекс.Маркет — покупки в тысячах проверенных магазинов";
    final static String homePageAddress = "https://market.yandex.ru/";
    By catalogLocator = By.xpath(".//*[@id='index-headline-id-tab-1']/span[1]");
    By notebookLocator = By.xpath(".//*[@class='catalog-simple__list']/a[contains(., 'Ноутбуки')]");

    private final WebDriver driver;

    public HomePage(WebDriver driver) {
        driver.get(homePageAddress);
        this.driver = driver;
        //Helper.waitPageTitle(driver, pageTitle);
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




}
