import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ElectronicsPage extends PageObject {

    private By electronicsPageHeader = By.xpath("//h1[text()='Электроника']");
    private By mobilePhonesLink = By.linkText("Мобильные телефоны");

    public ElectronicsPage(WebDriver driver) {
        super(driver);
    }

    public String getPageHeader() {
        return driver.findElement(electronicsPageHeader).getText();
    }

    public MobilePhonesPage goToMobilePhonesPage() {
        driver.findElement(mobilePhonesLink).click();
        return new MobilePhonesPage(driver);
    }


}
