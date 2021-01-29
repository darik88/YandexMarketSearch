import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class YandexMarketPage extends PageObject {

    private By electronicsButton = By.xpath("//span[text()='Электроника']");

    public YandexMarketPage(WebDriver driver) {
        super(driver);
    }

    public String getTitle() {
        String title = driver.getTitle();
        return title;
    }

    public ElectronicsPage goToElectronicsPage() {
        driver.findElement(electronicsButton).click();
        return new ElectronicsPage(driver);
    }

}
