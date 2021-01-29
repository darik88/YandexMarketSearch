import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;

public class YandexPage extends PageObject {

    private By marketButton = By.xpath("//a[@data-id='market']");

    public YandexPage(WebDriver driver) {
        super(driver);
    }

    public String getTitle() {
        return driver.getTitle();
    }

    public YandexMarketPage clickMarketButton() {
        driver.findElement(marketButton).click();
        return new YandexMarketPage(driver);
    }

    public void switchToNextTab() {
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
    }
}
