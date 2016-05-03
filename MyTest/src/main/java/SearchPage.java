import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Alexey on 03.05.2016.
 */
public class SearchPage {

    final static String pageTitle = "Ноутбуки - выбирайте и покупайте на Яндекс.Маркете";
    By itemProcessor = By.xpath(".//*[@id='TypeOfProcessor']//select[@name='2142398543']/option[contains(.,'Celeron')]");
    By submit = By.xpath(".//input[@value='Подобрать']");
    By listOfPrices = By.xpath(".//div[@class='snippet-card__price i-bem snippet-card__price_js_inited']/span[@class='price']");
    By listOfLaptops = By.xpath("descendant::span[@class='snippet-card__header-text']");

    private final WebDriver driver;

    public SearchPage(WebDriver driver) {
        this.driver = driver;
        Helper.waitPageTitle(driver, pageTitle);
    }

    public SearchPage selectItemOfProcessors() {
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


    public String calculateMinPrice() {
        int index = 0;
        String price = null;
        String laptopName = null;
        List priceList = null;
        List laptopList = null;
        priceList = new ArrayList<Integer>();
        laptopList = new ArrayList<String>();
        Helper.waitPageElement(driver, listOfPrices);
        List<WebElement> allPrices = driver.findElements(listOfPrices);
        Helper.waitPageElement(driver, listOfLaptops);
        List<WebElement> allLaptops = driver.findElements(listOfLaptops);

        for (WebElement element : allPrices) {
            price = element.getText();
            price = price.replaceAll("[^0-9]", "");
            priceList.add(price);
            //System.out.println(price);
        }

        for (WebElement element : allLaptops) {
            laptopName = element.getText();
            laptopList.add(laptopName);
            //System.out.println(laptopName);
        }
        return (String) laptopList.get(priceList.indexOf(Collections.min(priceList)));
    }
}
