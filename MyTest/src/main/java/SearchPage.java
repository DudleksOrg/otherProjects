import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Alexey on 03.05.2016.
 */
public class SearchPage {

    final static String pageTitle = "searchpage.title";
    final static By submit = By.xpath(".//form[@name='hand-select']//input[@type='submit']");
    final static By listOfPrices = By.xpath(".//div[@class='snippet-card__price i-bem snippet-card__price_js_inited']/span[@class='price']");
    final static By listOfLaptops = By.xpath("descendant::span[@class='snippet-card__header-text']");
    final static By uniqueElement = By.xpath(".//table[@class='l-page l-page_layout_64-32']");

    private final WebDriver driver;

    public SearchPage(WebDriver driver) {
        this.driver = driver;

    }

    public SearchPage checkPage(By by) {
        Helper.waitPageElement(driver, by);
        return this;
    }

    public SearchPage checkPageTitle(String title) {
        Helper.waitPageTitle(driver, title);
        return this;
    }

    public SearchPage selectItemOfProcessors(String name) {
        By itemProcessor = By.xpath(".//*[@id='TypeOfProcessor']//select[@name='2142398543']/option[contains(.,'" + name + "')]");
        Helper.waitPageElement(driver, itemProcessor);
        WebElement option = driver.findElement(itemProcessor);
        option.click();
        return this;
    }

    public SearchPage clickSubmitButton() {
        Helper.waitPageElement(driver, submit);
        driver.findElement(submit).click();
        return this;
    }

    public List getAllPrices(By by) {
        String price = null;
        List priceList = null;
        priceList = new ArrayList<Integer>();

        Helper.waitPageElement(driver, by);
        List<WebElement> allPrices = driver.findElements(by);

        for (WebElement element : allPrices) {
            price = element.getText();
            price = price.replaceAll("[^0-9]", "");
            priceList.add(price);
            //System.out.println(price);
        }

        return priceList;
    }

    public List getAllLaptops(By by) {
        String laptopName = null;
        List laptopList = null;
        laptopList = new ArrayList<String>();

        Helper.waitPageElement(driver, by);
        List<WebElement> allLaptops = driver.findElements(by);

        for (WebElement element : allLaptops) {
            laptopName = element.getText();
            laptopList.add(laptopName);
            //System.out.println(laptopName);
        }

        return laptopList;
    }

    public String calculateMinPrice(List list, List list2) {
        return (String) list.get(list2.indexOf(Collections.min(list2)));
    }
}
