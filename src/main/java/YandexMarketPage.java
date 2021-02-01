import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class YandexMarketPage extends PageObject {

    private By electronicsButton = By.xpath("//a/span[text()='Электроника']");
    private By infoBlockCloseButton = By.xpath("//button/span[text()='Понятно']");

    public YandexMarketPage(WebDriver driver) {
        super(driver);
    }

    public String getTitle() {
        String title = driver.getTitle();
        return title;
    }

    public ElectronicsPage goToElectronicsPage() {
        driver.findElement(infoBlockCloseButton).click();
        driver.findElement(electronicsButton).click();
        return new ElectronicsPage(driver);
    }

}
